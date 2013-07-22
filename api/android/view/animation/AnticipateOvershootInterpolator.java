package android.view.animation;

// Droidsafe Imports
import static com.android.internal.R.styleable.AnticipateOvershootInterpolator;
import static com.android.internal.R.styleable.AnticipateOvershootInterpolator_extraTension;
import static com.android.internal.R.styleable.AnticipateOvershootInterpolator_tension;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class AnticipateOvershootInterpolator implements Interpolator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.878 -0400", hash_original_field = "BACCDDE44E4D1D72971417472395EF45", hash_generated_field = "D99941F5581612BAF56000DD0A59C563")

    private float mTension;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.878 -0400", hash_original_method = "ADFB7B1CA7D165BA838134D2684973F5", hash_generated_method = "9F5D05CDCB4B5CB1ADE17DC42E2BEF6C")
    @DSModeled(DSC.SAFE)
    public  AnticipateOvershootInterpolator() {
        mTension = 2.0f * 1.5f;
        // ---------- Original Method ----------
        //mTension = 2.0f * 1.5f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.878 -0400", hash_original_method = "D15CF2E61548D6019F2AF4E90A4CFAB6", hash_generated_method = "D99C2C79B93882790F7B932B057E00D6")
    @DSModeled(DSC.SAFE)
    public  AnticipateOvershootInterpolator(float tension) {
        mTension = tension * 1.5f;
        // ---------- Original Method ----------
        //mTension = tension * 1.5f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.878 -0400", hash_original_method = "3EEBC4A7EE7237033C6CB68A91DD57AF", hash_generated_method = "E9CCD84715D8B7DFD848411354DE56BA")
    @DSModeled(DSC.SAFE)
    public  AnticipateOvershootInterpolator(float tension, float extraTension) {
        mTension = tension * extraTension;
        // ---------- Original Method ----------
        //mTension = tension * extraTension;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.879 -0400", hash_original_method = "390B8CC1565A1D66C861EB72B2EF6A9A", hash_generated_method = "EEC6BA372D8E55CDB09764DCF1982E23")
    @DSModeled(DSC.SAFE)
    public  AnticipateOvershootInterpolator(Context context, AttributeSet attrs) {
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        TypedArray a = context.obtainStyledAttributes(attrs, AnticipateOvershootInterpolator);
        mTension = a.getFloat(AnticipateOvershootInterpolator_tension, 2.0f) *
                a.getFloat(AnticipateOvershootInterpolator_extraTension, 1.5f);
        a.recycle();
        // ---------- Original Method ----------
        //TypedArray a = context.obtainStyledAttributes(attrs, AnticipateOvershootInterpolator);
        //mTension = a.getFloat(AnticipateOvershootInterpolator_tension, 2.0f) *
                //a.getFloat(AnticipateOvershootInterpolator_extraTension, 1.5f);
        //a.recycle();
    }

    
    @DSModeled(DSC.SAFE)
    private static float a(float t, float s) {
        return t * t * ((s + 1) * t - s);
    }

    
    @DSModeled(DSC.SAFE)
    private static float o(float t, float s) {
        return t * t * ((s + 1) * t + s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:48.880 -0400", hash_original_method = "2255DD32EB6AB62491E070729AD8FA55", hash_generated_method = "167A604665C79ACE1455720EE15F978B")
    @DSModeled(DSC.SAFE)
    public float getInterpolation(float t) {
        addTaint(t);
        if(t < 0.5f)        
        {
        float varB1923F566B622122C86DC6542A6A8984_220099838 = (0.5f * a(t * 2.0f, mTension));
                float var546ADE640B6EDFBC8A086EF31347E768_2103638165 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2103638165;
        }
        else
        {
        float var988831B3BF6347C5A06C1F1AA6A7D322_1136307446 = (0.5f * (o(t * 2.0f - 2.0f, mTension) + 2.0f));
                float var546ADE640B6EDFBC8A086EF31347E768_525490070 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_525490070;
        }
        // ---------- Original Method ----------
        //if (t < 0.5f) return 0.5f * a(t * 2.0f, mTension);
        //else return 0.5f * (o(t * 2.0f - 2.0f, mTension) + 2.0f);
    }

    
}

