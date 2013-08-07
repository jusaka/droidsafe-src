package org.bouncycastle.crypto.params;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.math.BigInteger;

import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;






public class ECDomainParameters implements ECConstants {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.076 -0400", hash_original_field = "4EFA264F5EF3E1A5C95736E07544EBF0", hash_generated_field = "704A3581F062D90BBFC67E94998B89B2")

    ECCurve curve;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.076 -0400", hash_original_field = "FE4C0F30AA359C41D9F9A5F69C8C4192", hash_generated_field = "9ECAAC80561D5FC0A0D63F92F7BF0E17")

    byte[] seed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.076 -0400", hash_original_field = "DFCF28D0734569A6A693BC8194DE62BF", hash_generated_field = "366E3F687F847EAA0B95F373906832D0")

    ECPoint G;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.076 -0400", hash_original_field = "7B8B965AD4BCA0E41AB51DE7B31363A1", hash_generated_field = "C5269AA669EF1E6636D1450EA530C9C5")

    BigInteger n;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.076 -0400", hash_original_field = "2510C39011C5BE704182423E3A695E91", hash_generated_field = "FF6F1CE798488519FE43D7992CD2DB11")

    BigInteger h;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.077 -0400", hash_original_method = "B7AFA44677648B19BDC10EE7871A7F9A", hash_generated_method = "FF2950DDF6E20BFD4471502BEAEC7ECA")
    public  ECDomainParameters(
        ECCurve     curve,
        ECPoint     G,
        BigInteger  n) {
        this.curve = curve;
        this.G = G;
        this.n = n;
        this.h = ONE;
        this.seed = null;
        // ---------- Original Method ----------
        //this.curve = curve;
        //this.G = G;
        //this.n = n;
        //this.h = ONE;
        //this.seed = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.079 -0400", hash_original_method = "BD2A03126FF30335329E3F095211D4D0", hash_generated_method = "2794A3A18974780E91E41AB4AE622D85")
    public  ECDomainParameters(
        ECCurve     curve,
        ECPoint     G,
        BigInteger  n,
        BigInteger  h) {
        this.curve = curve;
        this.G = G;
        this.n = n;
        this.h = h;
        this.seed = null;
        // ---------- Original Method ----------
        //this.curve = curve;
        //this.G = G;
        //this.n = n;
        //this.h = h;
        //this.seed = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.080 -0400", hash_original_method = "F7FA10DE23B67EFC919789142B22AEA5", hash_generated_method = "2B7B8E69B89F666F5FA73B91884D6E36")
    public  ECDomainParameters(
        ECCurve     curve,
        ECPoint     G,
        BigInteger  n,
        BigInteger  h,
        byte[]      seed) {
        this.curve = curve;
        this.G = G;
        this.n = n;
        this.h = h;
        this.seed = seed;
        // ---------- Original Method ----------
        //this.curve = curve;
        //this.G = G;
        //this.n = n;
        //this.h = h;
        //this.seed = seed;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.081 -0400", hash_original_method = "C3733AEA1B7056ED3896C5DBEA3E645D", hash_generated_method = "BE75DBA0F3C6988E4D2B9632DEE12DF1")
    public ECCurve getCurve() {
ECCurve varCB08C04A7A1DB77E60E6F93B4C766067_911887890 =         curve;
        varCB08C04A7A1DB77E60E6F93B4C766067_911887890.addTaint(taint);
        return varCB08C04A7A1DB77E60E6F93B4C766067_911887890;
        // ---------- Original Method ----------
        //return curve;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.081 -0400", hash_original_method = "ED03A647C1E8B017F749575ECBD102C0", hash_generated_method = "EE8C5A923D9DE7D8F0DBD220AAAFEBA2")
    public ECPoint getG() {
ECPoint varA23D61E1F6C38CCBEE3DB49AA5BE7BF2_525531178 =         G;
        varA23D61E1F6C38CCBEE3DB49AA5BE7BF2_525531178.addTaint(taint);
        return varA23D61E1F6C38CCBEE3DB49AA5BE7BF2_525531178;
        // ---------- Original Method ----------
        //return G;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.081 -0400", hash_original_method = "30674A850FAA3528D3976F32A0E4EE43", hash_generated_method = "C71ACA16845A35725D74928C21F18886")
    public BigInteger getN() {
BigInteger var041154653C812B0D1663EC287BE4C757_1299485590 =         n;
        var041154653C812B0D1663EC287BE4C757_1299485590.addTaint(taint);
        return var041154653C812B0D1663EC287BE4C757_1299485590;
        // ---------- Original Method ----------
        //return n;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.082 -0400", hash_original_method = "A75824F76318CCD34CB8B7E35601A9FC", hash_generated_method = "8C4048C3A0CA1E6BB31F09E13CBA7EAB")
    public BigInteger getH() {
BigInteger var81CECAAA363C2B26C476DE4A79F58961_455018744 =         h;
        var81CECAAA363C2B26C476DE4A79F58961_455018744.addTaint(taint);
        return var81CECAAA363C2B26C476DE4A79F58961_455018744;
        // ---------- Original Method ----------
        //return h;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.082 -0400", hash_original_method = "B051A8408593F9E1275AB818DE8E2A80", hash_generated_method = "90D2913D67C64F592EE8AF58592690BB")
    public byte[] getSeed() {
        byte[] varFE4C0F30AA359C41D9F9A5F69C8C4192_1678103136 = (seed);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_13977842 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_13977842;
        // ---------- Original Method ----------
        //return seed;
    }

    
}

