package android.animation;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface TypeEvaluator<T> {

    
    public T evaluate(float fraction, T startValue, T endValue);

}
