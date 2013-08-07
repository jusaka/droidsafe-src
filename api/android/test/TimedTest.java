package android.test;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) public @interface TimedTest {
    boolean includeDetailedStats() default false;
}
