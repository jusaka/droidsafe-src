package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.math.BigInteger;

import org.bouncycastle.util.Arrays;






public class DEREnumerated extends ASN1Object {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.186 -0400", hash_original_field = "4B3A6218BB3E3A7303E8A171A60FCF92", hash_generated_field = "AB97A4156FC1CC1DAF26375194010FF1")

    byte[] bytes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.187 -0400", hash_original_method = "B36B300F3CB5F32541367868C7626677", hash_generated_method = "E532E052C1FA38D42DFB95732E77D2B4")
    public  DEREnumerated(
        int         value) {
        bytes = BigInteger.valueOf(value).toByteArray();
        // ---------- Original Method ----------
        //bytes = BigInteger.valueOf(value).toByteArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.187 -0400", hash_original_method = "678F1FE65267358F51A86F36E09F17C8", hash_generated_method = "2D794F76CC64ED7BEB779014F7114CE5")
    public  DEREnumerated(
        BigInteger   value) {
        bytes = value.toByteArray();
        // ---------- Original Method ----------
        //bytes = value.toByteArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.188 -0400", hash_original_method = "AD7320D92755415772C23A44F11EC5AC", hash_generated_method = "42B294B3504DA5B568596960B2B8FA33")
    public  DEREnumerated(
        byte[]   bytes) {
        this.bytes = bytes;
        // ---------- Original Method ----------
        //this.bytes = bytes;
    }

    
    @DSModeled(DSC.SPEC)
    public static DEREnumerated getInstance(
        Object  obj) {
        if (obj == null || obj instanceof DEREnumerated)
        {
            return (DEREnumerated)obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    
    public static DEREnumerated getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        DERObject o = obj.getObject();
        if (explicit || o instanceof DEREnumerated)
        {
            return getInstance(o);
        }
        else
        {
            return new DEREnumerated(((ASN1OctetString)o).getOctets());
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.189 -0400", hash_original_method = "9CD9452AB0CD35F4B73E8FBD8DC6F0C8", hash_generated_method = "20CB6A6B4F7DA6ED348B3AA6001F6410")
    public BigInteger getValue() {
BigInteger varE4C146659CDD6B837AD2066CCD33EC90_1851454397 =         new BigInteger(bytes);
        varE4C146659CDD6B837AD2066CCD33EC90_1851454397.addTaint(taint);
        return varE4C146659CDD6B837AD2066CCD33EC90_1851454397;
        // ---------- Original Method ----------
        //return new BigInteger(bytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.189 -0400", hash_original_method = "F1F5D8639E81BFE0F662E5D9DEEDCE8E", hash_generated_method = "8A30D4DA141341743CEA9BBC57C8BE1B")
     void encode(
        DEROutputStream out) throws IOException {
        addTaint(out.getTaint());
        out.writeEncoded(ENUMERATED, bytes);
        // ---------- Original Method ----------
        //out.writeEncoded(ENUMERATED, bytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.190 -0400", hash_original_method = "87F9EE40A630F0723068642FAAE69D4D", hash_generated_method = "A6A96B61C96B69074E126CFF630C7CA2")
     boolean asn1Equals(
        DERObject  o) {
        addTaint(o.getTaint());
        if(!(o instanceof DEREnumerated))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1457254774 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1498813220 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1498813220;
        } //End block
        DEREnumerated other = (DEREnumerated)o;
        boolean varBE5FAAF65272FB3F96FDABF4701C5209_2066018561 = (Arrays.areEqual(this.bytes, other.bytes));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_509664865 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_509664865;
        // ---------- Original Method ----------
        //if (!(o instanceof DEREnumerated))
        //{
            //return false;
        //}
        //DEREnumerated other = (DEREnumerated)o;
        //return Arrays.areEqual(this.bytes, other.bytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.190 -0400", hash_original_method = "ECC4B202736A567045152AD0D498E31B", hash_generated_method = "74C2599E4557752FD4142600B6348157")
    public int hashCode() {
        int var2CDE289E7BF5766320CC430660AA476C_662462332 = (Arrays.hashCode(bytes));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1987785254 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1987785254;
        // ---------- Original Method ----------
        //return Arrays.hashCode(bytes);
    }

    
}

