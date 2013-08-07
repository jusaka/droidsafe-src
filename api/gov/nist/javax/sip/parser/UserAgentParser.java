package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.UserAgent;

import java.text.ParseException;





public class UserAgentParser extends HeaderParser {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.461 -0400", hash_original_method = "72C240456E98B58E534CB3630B89C3C4", hash_generated_method = "8E84A0C3F9F84722131501E191D0670E")
    public  UserAgentParser(String userAgent) {
        super(userAgent);
        addTaint(userAgent.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.462 -0400", hash_original_method = "1D2877F696A9DE47D6D871F3024594AA", hash_generated_method = "3CAEFF70DD19529513F3F7832479172C")
    protected  UserAgentParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:39.526 -0400", hash_original_method = "67E8EBD2906BCEC3B5F02757CFDC6836", hash_generated_method = "9BCAC89D0602F69A91979C3242805697")
    public SIPHeader parse() throws ParseException {
        if(debug)        
        dbg_enter("UserAgentParser.parse");
        UserAgent userAgent = new UserAgent();
        try 
        {
            headerName(TokenTypes.USER_AGENT);
            if(this.lexer.lookAhead(0) == '\n')            
            {
            java.text.ParseException var2A78B7EA9E0D9AA1D9EB461A1311D9F5_2128925251 = createParseException("empty header");
            var2A78B7EA9E0D9AA1D9EB461A1311D9F5_2128925251.addTaint(taint);
            throw var2A78B7EA9E0D9AA1D9EB461A1311D9F5_2128925251;
            }
            while
(this.lexer.lookAhead(0) != '\n'
                    && this.lexer.lookAhead(0) != '\0')            
            {
                if(this.lexer.lookAhead(0) == '(')                
                {
                    String comment = this.lexer.comment();
                    userAgent.addProductToken('(' + comment + ')');
                } //End block
                else
                {
                    this.getLexer().SPorHT();
                    String product = this.lexer.byteStringNoSlash();
                    if(product == null)                    
                    {
                    java.text.ParseException varEC678097075546EF1C4ED9C7745E8ABF_1014225198 = createParseException("Expected product string");
                    varEC678097075546EF1C4ED9C7745E8ABF_1014225198.addTaint(taint);
                    throw varEC678097075546EF1C4ED9C7745E8ABF_1014225198;
                    }
                    StringBuffer productSb = new StringBuffer(product);
                    if(this.lexer.peekNextToken().getTokenType() == TokenTypes.SLASH)                    
                    {
                        this.lexer.match(TokenTypes.SLASH);
                        this.getLexer().SPorHT();
                        String productVersion = this.lexer.byteStringNoSlash();
                        if(productVersion == null)                        
                        {
                        java.text.ParseException var7114B794543F9428E4E38A03383DD4FC_1675090504 = createParseException("Expected product version");
                        var7114B794543F9428E4E38A03383DD4FC_1675090504.addTaint(taint);
                        throw var7114B794543F9428E4E38A03383DD4FC_1675090504;
                        }
                        productSb.append("/");
                        productSb.append(productVersion);
                    } //End block
                    userAgent.addProductToken(productSb.toString());
                } //End block
                this.lexer.SPorHT();
            } //End block
        } //End block
        finally 
        {
            if(debug)            
            dbg_leave("UserAgentParser.parse");
        } //End block
SIPHeader varB90BAE9CF13799DF66AC7440F5DAE3DA_1931726800 =         userAgent;
        varB90BAE9CF13799DF66AC7440F5DAE3DA_1931726800.addTaint(taint);
        return varB90BAE9CF13799DF66AC7440F5DAE3DA_1931726800;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static void main(String args[]) throws ParseException {
        String
      userAgent[] = { "User-Agent: Softphone/Beta1.5 \n", "User-Agent:Nist/Beta1 (beta version) \n", "User-Agent: Nist UA (beta version)\n",
      "User-Agent: Nist1.0/Beta2 Ubi/vers.1.0 (very cool) \n" ,
      "User-Agent: SJphone/1.60.299a/L (SJ Labs)\n",
      "User-Agent: sipXecs/3.5.11 sipXecs/sipxbridge (Linux)\n"};
        for (int i = 0; i < userAgent.length; i++ ) { UserAgentParser parser =
      new UserAgentParser(userAgent[i]); UserAgent ua= (UserAgent)
      parser.parse(); System.out.println("encoded = " + ua.encode()); }
    }

    
}

