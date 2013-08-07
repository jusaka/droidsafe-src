package gov.nist.javax.sip.header.extensions;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.text.ParseException;

import javax.sip.header.Header;
import javax.sip.header.Parameters;

public interface ReplacesHeader extends Header, Parameters {

    String NAME = "Replaces";
    String getToTag();
    void setToTag(String tag) throws ParseException;
    String getFromTag();
    void setFromTag(String tag) throws ParseException;
    String getCallId();
    void setCallId(String callId) throws ParseException;
}
