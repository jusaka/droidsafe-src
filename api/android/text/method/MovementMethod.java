package android.text.method;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.text.Spannable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;

public interface MovementMethod {
    public void initialize(TextView widget, Spannable text);
    public boolean onKeyDown(TextView widget, Spannable text, int keyCode, KeyEvent event);
    public boolean onKeyUp(TextView widget, Spannable text, int keyCode, KeyEvent event);

    
    public boolean onKeyOther(TextView view, Spannable text, KeyEvent event);

    public void onTakeFocus(TextView widget, Spannable text, int direction);
    public boolean onTrackballEvent(TextView widget, Spannable text, MotionEvent event);
    public boolean onTouchEvent(TextView widget, Spannable text, MotionEvent event);
    public boolean onGenericMotionEvent(TextView widget, Spannable text, MotionEvent event);

    
    public boolean canSelectArbitrarily();
}
