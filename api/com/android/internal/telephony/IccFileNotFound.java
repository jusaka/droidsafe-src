package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.annotations.*;


public class IccFileNotFound extends IccException {
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.127 -0400", hash_original_method = "BA14DB7797A45FF6750F5919D632C5BC", hash_generated_method = "882C52828F97856B3C5401A09EB51F77")
      IccFileNotFound() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.127 -0400", hash_original_method = "16B6683D809802DF19583D9BD8B03BDC", hash_generated_method = "3AFD68230A7DFD4E8A5CCCCBCD1A23AF")
      IccFileNotFound(String s) {
        super(s);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.127 -0400", hash_original_method = "0ACB501EED723AE31A87CC247874BF4F", hash_generated_method = "60171A31C9DD4BC6B39A69F85F51F8CC")
      IccFileNotFound(int ef) {
        super("ICC EF Not Found 0x" + Integer.toHexString(ef));
        addTaint(ef);
        // ---------- Original Method ----------
    }

    
}

