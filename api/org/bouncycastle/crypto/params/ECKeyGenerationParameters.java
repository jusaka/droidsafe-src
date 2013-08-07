package org.bouncycastle.crypto.params;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.security.SecureRandom;

import org.bouncycastle.crypto.KeyGenerationParameters;






public class ECKeyGenerationParameters extends KeyGenerationParameters {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.085 -0400", hash_original_field = "E493415599EE10166D7B1C21C42971B0", hash_generated_field = "0E984BA2637E301559F63FEE7970E25A")

    private ECDomainParameters domainParams;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.086 -0400", hash_original_method = "8B1957EBD2FBE03865E88F3FCA63A5D4", hash_generated_method = "D8609F05E0DE5788B1008F756A93EC1E")
    public  ECKeyGenerationParameters(
        ECDomainParameters      domainParams,
        SecureRandom            random) {
        super(random, domainParams.getN().bitLength());
        addTaint(random.getTaint());
        this.domainParams = domainParams;
        // ---------- Original Method ----------
        //this.domainParams = domainParams;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.086 -0400", hash_original_method = "40F55F2249A14F0DC46DF54508E5891A", hash_generated_method = "B49F410C009FC2A482ABC5C6BD47A360")
    public ECDomainParameters getDomainParameters() {
ECDomainParameters varFB5FA83EE5A4C33D9E4B0FA79BF6936D_1146893554 =         domainParams;
        varFB5FA83EE5A4C33D9E4B0FA79BF6936D_1146893554.addTaint(taint);
        return varFB5FA83EE5A4C33D9E4B0FA79BF6936D_1146893554;
        // ---------- Original Method ----------
        //return domainParams;
    }

    
}

