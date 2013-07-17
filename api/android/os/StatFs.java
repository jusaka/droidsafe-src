package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class StatFs {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.592 -0400", hash_original_field = "20E813A614226843849BF2E571A8EBCA", hash_generated_field = "0A3F8EE607897645EB2EE30B6939205B")

    private int mNativeContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.593 -0400", hash_original_method = "B32C82E8AC66960E05928520E920B8ED", hash_generated_method = "CCF55AC3BDE6BEDBB3990853763B6D6F")
    public  StatFs(String path) {
        addTaint(path.getTaint());
        native_setup(path);
        // ---------- Original Method ----------
        //native_setup(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.594 -0400", hash_original_method = "8AF6434E2BA3E41CBFFC05A34FB3A23C", hash_generated_method = "365D4839D30E55588F74FA7A67DD8A90")
    public void restat(String path) {
        addTaint(path.getTaint());
        native_restat(path);
        // ---------- Original Method ----------
        //native_restat(path);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.595 -0400", hash_original_method = "3228EA20CE4FEF9678E1F1862B5AB446", hash_generated_method = "50625AE6DF481AE64B3EB15F7175DFBD")
    @Override
    protected void finalize() {
        native_finalize();
        // ---------- Original Method ----------
        //native_finalize();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.595 -0400", hash_original_method = "69F794FD342F65559C8B48F7A39B3D6D", hash_generated_method = "F5E320A2A2FA694A0599FB81289FA940")
    public int getBlockSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1684545918 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1684545918;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.596 -0400", hash_original_method = "AA8CC1613F4A2D3F7308C06B4F7C4105", hash_generated_method = "8EF365A3C3B25E58E5D2CD64EC1E4668")
    public int getBlockCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_987827494 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_987827494;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.596 -0400", hash_original_method = "F279B1780F1BAD71D18F3CF49F704643", hash_generated_method = "4F913EB88E1030152BED5A17EA612247")
    public int getFreeBlocks() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1852229913 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1852229913;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.596 -0400", hash_original_method = "39AF4947A221201A3EFDFD20EE46EF90", hash_generated_method = "B1DC1A6EB4C416C93E7ADAC11BD260B5")
    public int getAvailableBlocks() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_274395917 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_274395917;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.596 -0400", hash_original_method = "59CA121EFB9D79074525B44E468BE4BE", hash_generated_method = "F00DF08453A08280B8F5BA9830660CEC")
    private void native_restat(String path) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.597 -0400", hash_original_method = "1E41289F3DA4BBE4A138859E5014C4A0", hash_generated_method = "BBFC4EB7D2311CA879BC2E3377EB3DA6")
    private void native_setup(String path) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.597 -0400", hash_original_method = "B81676966F6941B90240D7A24C9E2FD3", hash_generated_method = "3A27293ECCA15B583017AC8E293B284F")
    private void native_finalize() {
    }

    
}

