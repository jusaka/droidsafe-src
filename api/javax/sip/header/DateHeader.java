package javax.sip.header;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Calendar;

public interface DateHeader extends Header {
    String NAME = "Date";

    Calendar getDate();
    void setDate(Calendar date);
}
