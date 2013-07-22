package android.animation;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class FloatEvaluator implements TypeEvaluator<Number> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.524 -0400", hash_original_method = "C987E70D238EF2ACA67A1E1BCA95D64E", hash_generated_method = "C987E70D238EF2ACA67A1E1BCA95D64E")
    @DSModeled(DSC.SAFE)
    public FloatEvaluator ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:14.528 -0400", hash_original_method = "F409EF3C8ADBC3E8580AA402C114DFFB", hash_generated_method = "F2B610F81131966C7180FF7ABF92DA01")
    public Float evaluate(float fraction, Number startValue, Number endValue) {
        addTaint(endValue.getTaint());
        addTaint(startValue.getTaint());
        addTaint(fraction);
        float startFloat = startValue.floatValue();
Float var656FC13B6262E391C84EE64663CF350D_951945748 =         startFloat + fraction * (endValue.floatValue() - startFloat);
        var656FC13B6262E391C84EE64663CF350D_951945748.addTaint(taint);
        return var656FC13B6262E391C84EE64663CF350D_951945748;
        // ---------- Original Method ----------
        //float startFloat = startValue.floatValue();
        //return startFloat + fraction * (endValue.floatValue() - startFloat);
    }

    
}

