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
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class UnrecoverableKeyException extends UnrecoverableEntryException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.823 -0500", hash_original_field = "7ED3E97A3B57750E79CA26EE09F3FDCB", hash_generated_field = "3ACA87301D5DF7DF8197CF313220208D")

    private static final long serialVersionUID = 7275063078190151277L;

    /**
     * Constructs a new instance of {@code UnrecoverableKeyException} with the
     * given message.
     *
     * @param msg
     *            the detail message for this exception
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.825 -0500", hash_original_method = "E20357D553B788F278F646C0E3221E57", hash_generated_method = "EDF34EBC402ECC16141ECD32A378559F")
    
public UnrecoverableKeyException(String msg) {
        super(msg);
    }

    /**
     * Constructs a new instance of {@code UnrecoverableKeyException}.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:00.828 -0500", hash_original_method = "03224602BAA5F9956174116E90B167DC", hash_generated_method = "4DD50AD9E1C34B354899338FC47058F3")
    
public UnrecoverableKeyException() {
    }
}

