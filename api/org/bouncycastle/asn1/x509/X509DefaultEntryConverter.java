package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;

import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.DERUTF8String;





public class X509DefaultEntryConverter extends X509NameEntryConverter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.011 -0400", hash_original_method = "685C200736A0E688088DFBD6E10169A1", hash_generated_method = "685C200736A0E688088DFBD6E10169A1")
    public X509DefaultEntryConverter ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.012 -0400", hash_original_method = "E0075DF75B4E99D6DCA984CA2F76B1C5", hash_generated_method = "BD3DB172304068B8CAA1271FB82D9A00")
    public DERObject getConvertedValue(
        DERObjectIdentifier  oid,
        String               value) {
        addTaint(value.getTaint());
        addTaint(oid.getTaint());
        if(value.length() != 0 && value.charAt(0) == '#')        
        {
            try 
            {
DERObject var46D3AF13FB3CC4643357578E8CC66E2F_651558964 =                 convertHexEncoded(value, 1);
                var46D3AF13FB3CC4643357578E8CC66E2F_651558964.addTaint(taint);
                return var46D3AF13FB3CC4643357578E8CC66E2F_651558964;
            } //End block
            catch (IOException e)
            {
                RuntimeException var6DFFBB33DC6D67FE3709FD741BFDC9CF_2032138082 = new RuntimeException("can't recode value for oid " + oid.getId());
                var6DFFBB33DC6D67FE3709FD741BFDC9CF_2032138082.addTaint(taint);
                throw var6DFFBB33DC6D67FE3709FD741BFDC9CF_2032138082;
            } //End block
        } //End block
        else
        {
            if(value.length() != 0 && value.charAt(0) == '\\')            
            {
                value = value.substring(1);
            } //End block
            if(oid.equals(X509Name.EmailAddress) || oid.equals(X509Name.DC))            
            {
DERObject var33DE795DC3C6B2B339D412A48CEFF243_477280428 =                 new DERIA5String(value);
                var33DE795DC3C6B2B339D412A48CEFF243_477280428.addTaint(taint);
                return var33DE795DC3C6B2B339D412A48CEFF243_477280428;
            } //End block
            else
            if(oid.equals(X509Name.DATE_OF_BIRTH))            
            {
DERObject varA0E9AA915FE5B2238A1C04164293600B_1338311814 =                 new DERGeneralizedTime(value);
                varA0E9AA915FE5B2238A1C04164293600B_1338311814.addTaint(taint);
                return varA0E9AA915FE5B2238A1C04164293600B_1338311814;
            } //End block
            else
            if(oid.equals(X509Name.C) || oid.equals(X509Name.SN) || oid.equals(X509Name.DN_QUALIFIER)
                || oid.equals(X509Name.TELEPHONE_NUMBER))            
            {
DERObject varE4B9BE1D4E9D486AB677DC69399C8BDE_1342889091 =                 new DERPrintableString(value);
                varE4B9BE1D4E9D486AB677DC69399C8BDE_1342889091.addTaint(taint);
                return varE4B9BE1D4E9D486AB677DC69399C8BDE_1342889091;
            } //End block
        } //End block
DERObject var2B1683A8AF4155B42EB4E966D550EB40_1425553594 =         new DERUTF8String(value);
        var2B1683A8AF4155B42EB4E966D550EB40_1425553594.addTaint(taint);
        return var2B1683A8AF4155B42EB4E966D550EB40_1425553594;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

