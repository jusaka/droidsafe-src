package org.bouncycastle.asn1.nist;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.sec.SECNamedCurves;
import org.bouncycastle.asn1.sec.SECObjectIdentifiers;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.util.Strings;
import java.util.Enumeration;
import java.util.Hashtable;

public class NISTNamedCurves {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.842 -0400", hash_original_method = "63679769172F8C8B10620B74D01768FE", hash_generated_method = "63679769172F8C8B10620B74D01768FE")
    public NISTNamedCurves ()
    {
        //Synthesized constructor
    }


    static void defineCurve(String name, DERObjectIdentifier oid) {
        objIds.put(name, oid);
        names.put(oid, name);
    }

    
    public static X9ECParameters getByName(
        String  name) {
        DERObjectIdentifier oid = (DERObjectIdentifier)objIds.get(Strings.toUpperCase(name));
        if (oid != null)
        {
            return getByOID(oid);
        }
        return null;
    }

    
    public static X9ECParameters getByOID(
        DERObjectIdentifier  oid) {
        return SECNamedCurves.getByOID(oid);
    }

    
    public static DERObjectIdentifier getOID(
        String  name) {
        return (DERObjectIdentifier)objIds.get(Strings.toUpperCase(name));
    }

    
    public static String getName(
        DERObjectIdentifier  oid) {
        return (String)names.get(oid);
    }

    
    public static Enumeration getNames() {
        return objIds.keys();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.843 -0400", hash_original_field = "09196982C4917B07F992CCE003F1710F", hash_generated_field = "1269679D47B7C172C418131040DC03AA")

    static final Hashtable objIds = new Hashtable();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.843 -0400", hash_original_field = "E70BACFD70C0C66E2A0FC643AF5696C0", hash_generated_field = "734EE0BA6EAA0FCA9CCE9A4B643B3169")

    static final Hashtable names = new Hashtable();
    static {
        defineCurve("B-571", SECObjectIdentifiers.sect571r1);
        defineCurve("B-409", SECObjectIdentifiers.sect409r1);
        defineCurve("B-283", SECObjectIdentifiers.sect283r1);
        defineCurve("B-233", SECObjectIdentifiers.sect233r1);
        defineCurve("B-163", SECObjectIdentifiers.sect163r2);
        defineCurve("P-521", SECObjectIdentifiers.secp521r1);
        defineCurve("P-384", SECObjectIdentifiers.secp384r1);
        defineCurve("P-256", SECObjectIdentifiers.secp256r1);
        defineCurve("P-224", SECObjectIdentifiers.secp224r1);
        defineCurve("P-192", SECObjectIdentifiers.secp192r1);
    }
    
}

