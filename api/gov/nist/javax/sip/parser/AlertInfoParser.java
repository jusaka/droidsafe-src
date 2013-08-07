package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.javax.sip.address.GenericURI;
import gov.nist.javax.sip.header.AlertInfo;
import gov.nist.javax.sip.header.AlertInfoList;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.SIPHeaderNames;

import java.text.ParseException;





public class AlertInfoParser extends ParametersParser {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.845 -0400", hash_original_method = "D981F7025F52BA8E1CEDC583E21B710C", hash_generated_method = "41BACA132BB4D5A2EA759A0E45FC23E8")
    public  AlertInfoParser(String alertInfo) {
        super(alertInfo);
        addTaint(alertInfo.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.846 -0400", hash_original_method = "FBB9329DBFDB9634284D1CD105BFF940", hash_generated_method = "FD6C3DC5F66F572DD8205BD78C09C230")
    protected  AlertInfoParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:36.847 -0400", hash_original_method = "01178CDB4B591AEEFEAB9C463FFB7ADD", hash_generated_method = "E376944211FEB12AB2E3A04CBC546DD2")
    public SIPHeader parse() throws ParseException {
        if(debug)        
        dbg_enter("AlertInfoParser.parse");
        AlertInfoList list = new AlertInfoList();
        try 
        {
            headerName(TokenTypes.ALERT_INFO);
            while
(lexer.lookAhead(0) != '\n')            
            {
                AlertInfo alertInfo = new AlertInfo();
                alertInfo.setHeaderName(SIPHeaderNames.ALERT_INFO);
                URLParser urlParser;
                GenericURI uri;
                do {
                    {
                        this.lexer.SPorHT();
                        if(this.lexer.lookAhead(0) == '<')                        
                        {
                            this.lexer.match('<');
                            urlParser = new URLParser((Lexer) this.lexer);
                            uri = urlParser.uriReference( true );
                            alertInfo.setAlertInfo(uri);
                            this.lexer.match('>');
                        } //End block
                        else
                        {
                            String alertInfoStr = this.lexer.byteStringNoSemicolon();
                            alertInfo.setAlertInfo(alertInfoStr);
                        } //End block
                        this.lexer.SPorHT();
                        super.parse(alertInfo);
                        list.add(alertInfo);
                        if(lexer.lookAhead(0) == ',')                        
                        {
                            this.lexer.match(',');
                        } //End block
                        else
                        break;
                    } //End block
} while (true);
            } //End block
SIPHeader varED12C351C2E8CA4F85F097DDC7E77B4D_609133084 =             list;
            varED12C351C2E8CA4F85F097DDC7E77B4D_609133084.addTaint(taint);
            return varED12C351C2E8CA4F85F097DDC7E77B4D_609133084;
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("AlertInfoParser.parse");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

