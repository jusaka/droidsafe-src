/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2008 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.text.Editable;

class JapanesePhoneNumberFormatter {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.093 -0500", hash_original_method = "45AAE50F2C13E8232A931CE1D4B77E29", hash_generated_method = "16CB798AD9EDD6C0FEAD1F9310F1D7EA")
    
public static void format(Editable text) {
        // Here, "root" means the position of "'":
        // 0'3, 0'90, and +81'-90
        // (dash will be deleted soon, so it is actually +81'90).
        int rootIndex = 1;
        int length = text.length();
        if (length > 3
                && text.subSequence(0, 3).toString().equals("+81")) {
            rootIndex = 3;
        } else if (length < 1 || text.charAt(0) != '0') {
            return;
        }

        CharSequence saved = text.subSequence(0, length);

        // Strip the dashes first, as we're going to add them back
        int i = 0;
        while (i < text.length()) {
            if (text.charAt(i) == '-') {
                text.delete(i, i + 1);
            } else {
                i++;
            }
        }

        length = text.length();
        int dashposition;

        i = rootIndex;
        int base = 0;
        while (i < length) {
            char ch = text.charAt(i);
            if (!Character.isDigit(ch)) {
                text.replace(0, length, saved);
                return;
            }
            short value = FORMAT_MAP[base + ch - '0'];
            if (value < 0) {
                if (value <= -100) {
                    text.replace(0, length, saved);
                    return;
                }
                int dashPos2 = rootIndex + (Math.abs(value) % 10);
                if (length > dashPos2) {
                    text.insert(dashPos2, "-");
                }
                int dashPos1 = rootIndex + (Math.abs(value) / 10);
                if (length > dashPos1) {
                    text.insert(dashPos1, "-");
                }
                break;
            } else {
                base = value;
                i++;
            }
        }

        if (length > 3 && rootIndex == 3) {
            text.insert(rootIndex, "-");
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:49.087 -0500", hash_original_field = "A718B0EA0BB26C2544F499EBA8B47E4F", hash_generated_field = "A41ED4450E04BDA3A5345586D1E8DE2E")

    private static short FORMAT_MAP[] = {
    -100, 10, 220, -15, 410, 530, 1200, 670, 780, 1060,
    -100, -25, 20, 40, 70, 100, 150, 190, 200, 210,
    -36, -100, -100, -35, -35, -35, 30, -100, -100, -100,
    -35, -35, -35, -35, -35, -35, -35, -45, -35, -35,
    -100, -100, -100, -35, -35, -35, -35, 50, -35, 60,
    -35, -35, -45, -35, -45, -35, -35, -45, -35, -35,
    -35, -35, -45, -35, -35, -35, -35, -45, -45, -35,
    -100, -100, -35, -35, -35, 80, 90, -100, -100, -100,
    -35, -35, -35, -35, -35, -35, -45, -45, -35, -35,
    -35, -35, -35, -35, -35, -35, -45, -35, -35, -35,
    -25, -25, -35, -35, 110, 120, 130, -35, 140, -25,
    -35, -25, -35, -35, -35, -35, -35, -45, -25, -35,
    -35, -25, -35, -35, -35, -35, -35, -25, -45, -35,
    -35, -35, -35, -35, -45, -35, -35, -35, -35, -35,
    -35, -35, -35, -35, -35, -35, -45, -45, -35, -35,
    -100, -100, -35, 160, 170, 180, -35, -35, -100, -100,
    -35, -35, -45, -35, -45, -45, -35, -35, -35, -35,
    -35, -35, -35, -35, -35, -35, -35, -35, -45, -35,
    -35, -35, -35, -35, -45, -45, -45, -35, -45, -35,
    -25, -25, -35, -35, -35, -35, -35, -25, -35, -35,
    -25, -25, -35, -35, -35, -35, -35, -35, -25, -25,
    -25, -35, -35, -35, -35, -35, -25, -35, -35, -25,
    -100, -100, 230, 250, 260, 270, 320, 340, 360, 390,
    -35, -25, -25, 240, -35, -35, -35, -25, -35, -35,
    -25, -35, -35, -35, -25, -25, -25, -25, -25, -25,
    -25, -25, -25, -35, -35, -35, -25, -35, -35, -25,
    -35, -35, -35, -35, -35, -25, -35, -35, -35, -25,
    -35, -25, -25, -25, -35, 280, 290, 300, 310, -35,
    -25, -25, -25, -25, -25, -25, -25, -35, -35, -25,
    -25, -35, -35, -35, -35, -35, -35, -35, -35, -35,
    -25, -25, -35, -35, -35, -25, -25, -25, -25, -25,
    -25, -35, -35, -35, -35, -35, -35, -35, -35, -35,
    -35, -35, -25, -35, 330, -35, -35, -35, -35, -35,
    -25, -35, -35, -35, -35, -35, -25, -25, -25, -25,
    -35, -25, -25, -25, -35, -25, -35, -35, 350, -35,
    -25, -35, -35, -35, -35, -35, -35, -35, -25, -25,
    -35, -25, -35, 370, -35, -35, -25, -35, -35, 380,
    -25, -35, -35, -25, -25, -35, -35, -35, -35, -35,
    -25, -35, -25, -25, -25, -25, -35, -35, -35, -35,
    -25, -35, -25, 400, -35, -35, -35, -35, -25, -35,
    -25, -35, -35, -35, -35, -25, -25, -25, -25, -25,
    -15, -15, 420, 460, -25, -25, 470, 480, 500, 510,
    -15, -25, 430, -25, -25, -25, -25, -25, 440, 450,
    -25, -35, -35, -35, -35, -35, -35, -35, -35, -35,
    -25, -25, -35, -35, -25, -25, -25, -35, -35, -35,
    -15, -25, -15, -15, -15, -15, -15, -25, -25, -15,
    -25, -25, -25, -25, -25, -25, -35, -25, -35, -35,
    -35, -25, -25, -35, -25, -35, -35, -35, -25, -25,
    490, -15, -25, -25, -25, -35, -35, -25, -35, -35,
    -15, -35, -35, -35, -35, -35, -35, -35, -35, -15,
    -35, -25, -25, -25, -25, -25, -25, -25, -25, -25,
    -25, -25, -25, -35, -35, -35, -25, -25, -25, 520,
    -100, -100, -45, -100, -45, -100, -45, -100, -45, -100,
    -26, -100, -25, 540, 580, 590, 600, 610, 630, 640,
    -25, -35, -35, -35, -25, -25, -35, -35, -35, 550,
    -35, -35, -25, -25, -25, -25, 560, 570, -25, -35,
    -35, -35, -35, -35, -25, -25, -25, -25, -25, -25,
    -25, -25, -25, -25, -35, -25, -25, -35, -25, -25,
    -25, -25, -25, -25, -35, -35, -25, -35, -35, -25,
    -35, -35, -25, -35, -35, -35, -35, -35, -35, -25,
    -100, -35, -35, -35, -35, -35, -35, -35, -35, -35,
    -36, -100, -35, -35, -35, -35, 620, -35, -35, -100,
    -35, -35, -35, -35, -35, -35, -35, -35, -35, -45,
    -25, -35, -25, -25, -35, -35, -35, -35, -25, -25,
    -25, -25, -25, -25, -35, -35, -35, 650, -35, 660,
    -35, -35, -35, -35, -45, -35, -35, -35, -35, -45,
    -35, -35, -35, -35, -35, -35, -35, -35, -35, -25,
    -26, -100, 680, 690, 700, -25, 720, 730, -25, 740,
    -25, -35, -25, -25, -25, -35, -25, -25, -25, -25,
    -25, -25, -25, -25, -25, -35, -35, -35, -35, -35,
    -35, -100, -35, -35, -35, -35, 710, -35, -35, -35,
    -35, -35, -35, -35, -35, -35, -35, -35, -45, -35,
    -25, -35, -25, -35, -25, -35, -35, -35, -35, -25,
    -35, -35, -35, -35, -35, -25, -35, -25, -35, -35,
    -35, -35, -25, -25, 750, 760, 770, -35, -35, -35,
    -25, -35, -25, -25, -25, -25, -35, -35, -35, -25,
    -25, -35, -35, -35, -35, -25, -25, -35, -35, -25,
    -25, -35, -35, -35, -35, -35, -25, -25, -35, -35,
    790, -100, 800, 850, 900, 920, 940, 1030, 1040, 1050,
    -36, -26, -26, -26, -26, -26, -26, -26, -26, -26,
    -35, -25, -25, -35, 810, -25, -35, -35, -25, 820,
    -25, -35, -25, -25, -35, -35, -35, -35, -35, -25,
    -25, -35, 830, -35, 840, -35, -25, -35, -35, -25,
    -35, -25, -25, -25, -25, -25, -25, -25, -25, -25,
    -100, -25, -25, -25, -100, -100, -100, -100, -100, -100,
    -25, -25, -35, -35, -35, -35, 860, -35, 870, 880,
    -25, -35, -35, -35, -35, -35, -35, -35, -35, -35,
    -35, -35, -35, -35, -35, -35, -35, -45, -45, -35,
    -100, -100, -100, -100, -100, -100, 890, -100, -100, -100,
    -25, -45, -45, -25, -45, -45, -25, -45, -45, -45,
    -25, -25, -25, -25, -25, -35, -35, 910, -35, -25,
    -35, -35, -35, -35, -35, -35, -35, -45, -35, -35,
    -100, 930, -35, -35, -35, -35, -35, -35, -35, -35,
    -100, -100, -45, -100, -45, -100, -100, -100, -100, -100,
    -25, -25, -25, 950, -25, 970, 990, -35, 1000, 1010,
    -35, -35, -35, -35, -35, -35, 960, -35, -35, -35,
    -45, -45, -45, -45, -45, -45, -35, -45, -45, -45,
    -35, -35, -25, -35, -35, 980, -35, -35, -35, -35,
    -100, -100, -25, -25, -100, -100, -100, -100, -100, -100,
    -25, -35, -35, -35, -35, -35, -35, -35, -35, -35,
    -25, -35, -35, -35, -35, -35, -35, -35, -35, -25,
    -25, -35, -35, -35, -25, -25, -35, -35, -35, 1020,
    -45, -45, -35, -35, -45, -45, -45, -45, -45, -45,
    -25, -25, -25, -25, -25, -35, -25, -35, -25, -35,
    -35, -25, -25, -35, -35, -35, -25, -35, -25, -35,
    -25, -25, -35, -35, -35, -35, -35, -35, -35, -25,
    -26, -100, 1070, 1080, 1090, 1110, 1120, 1130, 1140, 1160,
    -35, -25, -25, -25, -25, -25, -25, -25, -25, -25,
    -35, -25, -25, -25, -25, -25, -25, -25, -25, -25,
    -35, -100, -35, -35, -35, -100, -35, -35, -35, 1100,
    -35, -35, -35, -35, -35, -35, -45, -35, -35, -35,
    -35, -25, -35, -25, -35, -35, -35, -35, -25, -35,
    -25, -25, -25, -25, -35, -35, -35, -35, -35, -35,
    -25, -25, -35, -35, -35, -25, -25, -35, -35, -35,
    1150, -25, -35, -35, -35, -35, -35, -35, -25, -25,
    -35, -35, -45, -35, -35, -35, -35, -35, -35, -35,
    -35, 1170, -25, -35, 1180, -35, 1190, -35, -25, -25,
    -100, -100, -45, -45, -100, -100, -100, -100, -100, -100,
    -25, -35, -35, -35, -35, -35, -35, -25, -25, -35,
    -35, -35, -35, -35, -35, -35, -35, -35, -35, -45,
    -26, -15, -15, -15, -15, -15, -15, -15, -15, -15};
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.094 -0400", hash_original_method = "8633AFAAB867BB1617201EF2E839378D", hash_generated_method = "8633AFAAB867BB1617201EF2E839378D")
    public JapanesePhoneNumberFormatter ()
    {
        //Synthesized constructor
    }
}

