package org.bouncycastle.asn1.sec;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.math.BigInteger;
import java.util.Enumeration;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.util.BigIntegers;






public class ECPrivateKeyStructure extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.143 -0400", hash_original_field = "E068C2DE26D760F20CF10AFC4B87EF0F", hash_generated_field = "37E06257AFCE21CC4EDFE67F34DC271C")

    private ASN1Sequence seq;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.144 -0400", hash_original_method = "D12821E856A648EC440CD525D918157C", hash_generated_method = "045B9F4D1DB3350862A92FABEBA11593")
    public  ECPrivateKeyStructure(
        ASN1Sequence  seq) {
        this.seq = seq;
        // ---------- Original Method ----------
        //this.seq = seq;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.145 -0400", hash_original_method = "722B9EB1887267D3DC7C06AD31EE54C1", hash_generated_method = "A0B081E475FC622EA16DAC1E11181514")
    public  ECPrivateKeyStructure(
        BigInteger  key) {
        addTaint(key.getTaint());
        byte[] bytes = BigIntegers.asUnsignedByteArray(key);
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(new DERInteger(1));
        v.add(new DEROctetString(bytes));
        seq = new DERSequence(v);
        // ---------- Original Method ----------
        //byte[] bytes = BigIntegers.asUnsignedByteArray(key);
        //ASN1EncodableVector v = new ASN1EncodableVector();
        //v.add(new DERInteger(1));
        //v.add(new DEROctetString(bytes));
        //seq = new DERSequence(v);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.146 -0400", hash_original_method = "407D07F6896B0C0E44D96F389E9D6F27", hash_generated_method = "08D4F82FCED89BC125FD88AFB2E58A75")
    public  ECPrivateKeyStructure(
        BigInteger    key,
        ASN1Encodable parameters) {
        this(key, null, parameters);
        addTaint(parameters.getTaint());
        addTaint(key.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.147 -0400", hash_original_method = "C18ECEEFE6A75682B0803E3F34C5782F", hash_generated_method = "4DA7CDFAD747334E28197A165FE9466D")
    public  ECPrivateKeyStructure(
        BigInteger    key,
        DERBitString  publicKey,
        ASN1Encodable parameters) {
        addTaint(parameters.getTaint());
        addTaint(publicKey.getTaint());
        addTaint(key.getTaint());
        byte[] bytes = BigIntegers.asUnsignedByteArray(key);
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(new DERInteger(1));
        v.add(new DEROctetString(bytes));
        if(parameters != null)        
        {
            v.add(new DERTaggedObject(true, 0, parameters));
        } //End block
        if(publicKey != null)        
        {
            v.add(new DERTaggedObject(true, 1, publicKey));
        } //End block
        seq = new DERSequence(v);
        // ---------- Original Method ----------
        //byte[] bytes = BigIntegers.asUnsignedByteArray(key);
        //ASN1EncodableVector v = new ASN1EncodableVector();
        //v.add(new DERInteger(1));
        //v.add(new DEROctetString(bytes));
        //if (parameters != null)
        //{
            //v.add(new DERTaggedObject(true, 0, parameters));
        //}
        //if (publicKey != null)
        //{
            //v.add(new DERTaggedObject(true, 1, publicKey));
        //}
        //seq = new DERSequence(v);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.147 -0400", hash_original_method = "3364DFDFDAE0C599569065625E34DFA6", hash_generated_method = "23750B35A714271DEB60A0F227923AB4")
    public BigInteger getKey() {
        ASN1OctetString octs = (ASN1OctetString)seq.getObjectAt(1);
BigInteger var80DF0B153BA9995164F4B5B25057318A_847397031 =         new BigInteger(1, octs.getOctets());
        var80DF0B153BA9995164F4B5B25057318A_847397031.addTaint(taint);
        return var80DF0B153BA9995164F4B5B25057318A_847397031;
        // ---------- Original Method ----------
        //ASN1OctetString  octs = (ASN1OctetString)seq.getObjectAt(1);
        //return new BigInteger(1, octs.getOctets());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.147 -0400", hash_original_method = "DEBAFCE224E8193448683CCA3427311E", hash_generated_method = "44DA50EAA2E9E8F5EBF12A49BE48930E")
    public DERBitString getPublicKey() {
DERBitString var04EB087ECDC943C1CF143F46DC90A070_1147330686 =         (DERBitString)getObjectInTag(1);
        var04EB087ECDC943C1CF143F46DC90A070_1147330686.addTaint(taint);
        return var04EB087ECDC943C1CF143F46DC90A070_1147330686;
        // ---------- Original Method ----------
        //return (DERBitString)getObjectInTag(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.148 -0400", hash_original_method = "6CC550729D926E5F97154297F8F1FBC7", hash_generated_method = "7558D72C90509260DBDEF10A26EA07B6")
    public ASN1Object getParameters() {
ASN1Object var3FB644C7C242382FECABE32076F66AE1_1196337059 =         getObjectInTag(0);
        var3FB644C7C242382FECABE32076F66AE1_1196337059.addTaint(taint);
        return var3FB644C7C242382FECABE32076F66AE1_1196337059;
        // ---------- Original Method ----------
        //return getObjectInTag(0);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.148 -0400", hash_original_method = "F319A866ECD7F1BB5BF305B540FF9ADA", hash_generated_method = "507B1898144E10069A9211A7BDD3BF8B")
    private ASN1Object getObjectInTag(int tagNo) {
        addTaint(tagNo);
        Enumeration e = seq.getObjects();
        while
(e.hasMoreElements())        
        {
            DEREncodable obj = (DEREncodable)e.nextElement();
            if(obj instanceof ASN1TaggedObject)            
            {
                ASN1TaggedObject tag = (ASN1TaggedObject)obj;
                if(tag.getTagNo() == tagNo)                
                {
ASN1Object var47FA15ACC5922DECF9C16982C8B623FE_1136908436 =                     (ASN1Object)((DEREncodable)tag.getObject()).getDERObject();
                    var47FA15ACC5922DECF9C16982C8B623FE_1136908436.addTaint(taint);
                    return var47FA15ACC5922DECF9C16982C8B623FE_1136908436;
                } //End block
            } //End block
        } //End block
ASN1Object var540C13E9E156B687226421B24F2DF178_1624867693 =         null;
        var540C13E9E156B687226421B24F2DF178_1624867693.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1624867693;
        // ---------- Original Method ----------
        //Enumeration e = seq.getObjects();
        //while (e.hasMoreElements())
        //{
            //DEREncodable obj = (DEREncodable)e.nextElement();
            //if (obj instanceof ASN1TaggedObject)
            //{
                //ASN1TaggedObject tag = (ASN1TaggedObject)obj;
                //if (tag.getTagNo() == tagNo)
                //{
                    //return (ASN1Object)((DEREncodable)tag.getObject()).getDERObject();
                //}
            //}
        //}
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.149 -0400", hash_original_method = "0BE753B103EB5E27F0AD9CE4B67E8D14", hash_generated_method = "16D4C13F677A9C10ADAA79AACD0B48C5")
    public DERObject toASN1Object() {
DERObject var42A78C062640017A329FA085150BC1B8_603030551 =         seq;
        var42A78C062640017A329FA085150BC1B8_603030551.addTaint(taint);
        return var42A78C062640017A329FA085150BC1B8_603030551;
        // ---------- Original Method ----------
        //return seq;
    }

    
}

