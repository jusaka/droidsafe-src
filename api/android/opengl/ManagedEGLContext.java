package android.opengl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import static javax.microedition.khronos.egl.EGL10.EGL_DEFAULT_DISPLAY;
import static javax.microedition.khronos.egl.EGL10.EGL_NO_DISPLAY;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import android.os.Looper;
import android.util.Log;
import com.google.android.gles_jni.EGLImpl;

public abstract class ManagedEGLContext {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.406 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "5F205B80EE2B67A11B019B523ECA191F")

    EGLContext mContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.407 -0400", hash_original_method = "9D266735F37ADE970716DE5C813A7490", hash_generated_method = "F7B11D8BD9EF7F0A5140DBD6FF57A603")
    public  ManagedEGLContext(EGLContext context) {
        mContext = context;
        synchronized
(sActive)        {
            sActive.add(this);
        } //End block
        // ---------- Original Method ----------
        //mContext = context;
        //synchronized (sActive) {
            //sActive.add(this);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.407 -0400", hash_original_method = "0BA5CAD8B17303B4C3A912EF0F9065A7", hash_generated_method = "267E36C465557AA223C76C57B412ADBC")
    public EGLContext getContext() {
EGLContext var178E2AD52D6FBBB503F908168856B574_2128029169 =         mContext;
        var178E2AD52D6FBBB503F908168856B574_2128029169.addTaint(taint);
        return var178E2AD52D6FBBB503F908168856B574_2128029169;
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.407 -0400", hash_original_method = "3A3C884C8DD72479D5B7016BF0489D57", hash_generated_method = "418519E6B0AAFC40765D5AFF890A67AE")
    public void terminate() {
        execTerminate();
        // ---------- Original Method ----------
        //execTerminate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.407 -0400", hash_original_method = "B8E737E7A559452A0DBE946D6943CE60", hash_generated_method = "B6770F67CF9038CAE7126511421AF7E1")
     void execTerminate() {
        onTerminate(mContext);
        // ---------- Original Method ----------
        //onTerminate(mContext);
    }

    
    public abstract void onTerminate(EGLContext context);

    
    public static boolean doTerminate() {
        ArrayList<ManagedEGLContext> active;
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("Called on wrong thread");
        }
        synchronized (sActive) {
            if (sActive.size() <= 0) {
                return false;
            }
            EGL10 egl = (EGL10) EGLContext.getEGL();
            EGLDisplay display = egl.eglGetDisplay(EGL_DEFAULT_DISPLAY);
            if (display == EGL_NO_DISPLAY) {
                Log.w(TAG, "doTerminate failed: no display");
                return false;
            }
            if (EGLImpl.getInitCount(display) != sActive.size()) {
                Log.w(TAG, "doTerminate failed: EGL count is " + EGLImpl.getInitCount(display)
                        + " but managed count is " + sActive.size());
                return false;
            }
            active = new ArrayList<ManagedEGLContext>(sActive);
            sActive.clear();
        }
        for (int i = 0; i < active.size(); i++) {
            active.get(i).execTerminate();
        }
        return true;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.408 -0400", hash_original_field = "C32C7EFB226A1237656FB484619788F2", hash_generated_field = "AA7820E70BB513EA18D582B7C663D5F7")

    static final String TAG = "ManagedEGLContext";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.408 -0400", hash_original_field = "57EF06F27E8024F8C91B1EE5646F021E", hash_generated_field = "6F26B317B7D1B34F8FDEAC7200D5F188")

    static final ArrayList<ManagedEGLContext> sActive = new ArrayList<ManagedEGLContext>();
}

