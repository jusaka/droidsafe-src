package android.text.style;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;





public class TypefaceSpan extends MetricAffectingSpan implements ParcelableSpan {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.347 -0400", hash_original_field = "BAA635101CF6E107BAC89837AE69780A", hash_generated_field = "9590C932BAED724FD12B55F1BADC30FA")

    private String mFamily;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.347 -0400", hash_original_method = "30225DE18E1EF58337803047C2C7576B", hash_generated_method = "4B1F3B13B466F40663FF030C15840841")
    public  TypefaceSpan(String family) {
        mFamily = family;
        // ---------- Original Method ----------
        //mFamily = family;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.348 -0400", hash_original_method = "EBFC14963D531976FE4CEA16F8670D1D", hash_generated_method = "3E595017B09B3F0687BA6DDD205A5770")
    public  TypefaceSpan(Parcel src) {
        mFamily = src.readString();
        // ---------- Original Method ----------
        //mFamily = src.readString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.348 -0400", hash_original_method = "07DD5A556D8AFD5FB18137B3F1261BE3", hash_generated_method = "3215A847AB0EA951139988DFEBB196A2")
    public int getSpanTypeId() {
        int var5493B17675FF4F1EB6820B5F481A8E4C_20104839 = (TextUtils.TYPEFACE_SPAN);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1748146766 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1748146766;
        // ---------- Original Method ----------
        //return TextUtils.TYPEFACE_SPAN;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.348 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "520241B2A50A4DC4F1C9B690BA0A6F6F")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_929947695 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_316944697 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_316944697;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.348 -0400", hash_original_method = "3222DFE1438A7B94741074BF5C471F95", hash_generated_method = "DFCD23DCBCB258207ADEC460D8D85BE3")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeString(mFamily);
        // ---------- Original Method ----------
        //dest.writeString(mFamily);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.348 -0400", hash_original_method = "A22822B6578A7051FA8E71732705B93C", hash_generated_method = "6454FA478CBB59995F96C7287261D974")
    public String getFamily() {
String var7557778AC2C76B4CD57475AB227E6F5A_1462912296 =         mFamily;
        var7557778AC2C76B4CD57475AB227E6F5A_1462912296.addTaint(taint);
        return var7557778AC2C76B4CD57475AB227E6F5A_1462912296;
        // ---------- Original Method ----------
        //return mFamily;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.348 -0400", hash_original_method = "1FF2F211A2A46041B93FC8FF91A72EF9", hash_generated_method = "25E791C093EEE2BA9727E6650E007531")
    @Override
    public void updateDrawState(TextPaint ds) {
        addTaint(ds.getTaint());
        apply(ds, mFamily);
        // ---------- Original Method ----------
        //apply(ds, mFamily);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.348 -0400", hash_original_method = "EDA342B19CEA5F662FF3BE7187A11677", hash_generated_method = "89EE140918D00DEFF7DDBDF2A960305E")
    @Override
    public void updateMeasureState(TextPaint paint) {
        addTaint(paint.getTaint());
        apply(paint, mFamily);
        // ---------- Original Method ----------
        //apply(paint, mFamily);
    }

    
    @DSModeled(DSC.BAN)
    private static void apply(Paint paint, String family) {
        int oldStyle;
        Typeface old = paint.getTypeface();
        if (old == null) {
            oldStyle = 0;
        } else {
            oldStyle = old.getStyle();
        }
        Typeface tf = Typeface.create(family, oldStyle);
        int fake = oldStyle & ~tf.getStyle();
        if ((fake & Typeface.BOLD) != 0) {
            paint.setFakeBoldText(true);
        }
        if ((fake & Typeface.ITALIC) != 0) {
            paint.setTextSkewX(-0.25f);
        }
        paint.setTypeface(tf);
    }

    
}

