package android.content;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.accounts.Account;
import android.os.Bundle;
import android.os.SystemClock;





public class SyncOperation implements Comparable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.581 -0400", hash_original_field = "E268443E43D93DAB7EBEF303BBE9642F", hash_generated_field = "48DCC252B03FBCBEDBDE2E34968668DF")

    public Account account;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.581 -0400", hash_original_field = "C4B6C45B08DE8968EEA91097B03482FE", hash_generated_field = "C83A11803715B792413E3838747138A5")

    public int syncSource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.581 -0400", hash_original_field = "873E9C0B50183B613336EEA1020F4369", hash_generated_field = "FB6B5528A361C1A6848B87F8DAC52043")

    public String authority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.581 -0400", hash_original_field = "577E05B3572C976DAF60C9783F6204CF", hash_generated_field = "2A4062D07AF43598570DB28FDD410734")

    public boolean allowParallelSyncs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.582 -0400", hash_original_field = "27353006CFD751D26221E04A7928034D", hash_generated_field = "360651D25CBD3D75EA270BBFA49C37D4")

    public Bundle extras;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.582 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "9594FABAACFBD659AE1FC0B0C9AAFC8C")

    public String key;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.582 -0400", hash_original_field = "6F9D6D4E401653CC26112A3D37E00CC7", hash_generated_field = "68164F2B36FE066E3756D3D9D1292331")

    public long earliestRunTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.582 -0400", hash_original_field = "7959CC84448D1E4ADCF2D189917AB5F5", hash_generated_field = "510B55928F79538B5EE0DF2AD1627823")

    public boolean expedited;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.582 -0400", hash_original_field = "3E906CFD221D909B8CD8FFA1F5E84248", hash_generated_field = "042CEA90778ADF37345A881ED9FBF28F")

    public SyncStorageEngine.PendingOperation pendingOperation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.582 -0400", hash_original_field = "F22B97418C1435B3B24500AEB4A7110D", hash_generated_field = "350EB491BFFA87FD3A84E6B5B95316CD")

    public Long backoff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.582 -0400", hash_original_field = "77D196B208370F23D20E064B8B1B5DA0", hash_generated_field = "34D6FB90E0771C5EFE225745790D4357")

    public long delayUntil;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.582 -0400", hash_original_field = "CC867130D90FEF804B3067067C71AD2C", hash_generated_field = "1A551681C0C70DD5BB10AF927DDA36A6")

    public long effectiveRunTime;
    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.585 -0400", hash_original_method = "B06968042D7BA4644F7F8CC6E7EA9B45", hash_generated_method = "EA5C5AE95A4E423C6F2798E56A1A23BA")
    public  SyncOperation(Account account, int source, String authority, Bundle extras,
            long delayInMs, long backoff, long delayUntil, boolean allowParallelSyncs) {
        this.account = account;
        this.syncSource = source;
        this.authority = authority;
        this.allowParallelSyncs = allowParallelSyncs;
        this.extras = new Bundle(extras);
        removeFalseExtra(ContentResolver.SYNC_EXTRAS_UPLOAD);
        removeFalseExtra(ContentResolver.SYNC_EXTRAS_MANUAL);
        removeFalseExtra(ContentResolver.SYNC_EXTRAS_IGNORE_SETTINGS);
        removeFalseExtra(ContentResolver.SYNC_EXTRAS_IGNORE_BACKOFF);
        removeFalseExtra(ContentResolver.SYNC_EXTRAS_DO_NOT_RETRY);
        removeFalseExtra(ContentResolver.SYNC_EXTRAS_DISCARD_LOCAL_DELETIONS);
        removeFalseExtra(ContentResolver.SYNC_EXTRAS_EXPEDITED);
        removeFalseExtra(ContentResolver.SYNC_EXTRAS_OVERRIDE_TOO_MANY_DELETIONS);
        this.delayUntil = delayUntil;
        this.backoff = backoff;
        final long now = SystemClock.elapsedRealtime();
        if(delayInMs < 0)        
        {
            this.expedited = true;
            this.earliestRunTime = now;
        } //End block
        else
        {
            this.expedited = false;
            this.earliestRunTime = now + delayInMs;
        } //End block
        updateEffectiveRunTime();
        this.key = toKey();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.589 -0400", hash_original_method = "BE085BAA1CD2B4B4487382D0022F31D7", hash_generated_method = "44AF7038BB0152FE7BD44E3BDEC3C97C")
      SyncOperation(SyncOperation other) {
        this.account = other.account;
        this.syncSource = other.syncSource;
        this.authority = other.authority;
        this.extras = new Bundle(other.extras);
        this.expedited = other.expedited;
        this.earliestRunTime = SystemClock.elapsedRealtime();
        this.backoff = other.backoff;
        this.delayUntil = other.delayUntil;
        this.allowParallelSyncs = other.allowParallelSyncs;
        this.updateEffectiveRunTime();
        this.key = toKey();
        // ---------- Original Method ----------
        //this.account = other.account;
        //this.syncSource = other.syncSource;
        //this.authority = other.authority;
        //this.extras = new Bundle(other.extras);
        //this.expedited = other.expedited;
        //this.earliestRunTime = SystemClock.elapsedRealtime();
        //this.backoff = other.backoff;
        //this.delayUntil = other.delayUntil;
        //this.allowParallelSyncs = other.allowParallelSyncs;
        //this.updateEffectiveRunTime();
        //this.key = toKey();
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.590 -0400", hash_original_method = "432EE1A094EFB9968E7A50DA8ACAC133", hash_generated_method = "0DE4EABB7C7C62CBAB374994494B1064")
    private void removeFalseExtra(String extraName) {
        addTaint(extraName.getTaint());
        if(!extras.getBoolean(extraName, false))        
        {
            extras.remove(extraName);
        } //End block
        // ---------- Original Method ----------
        //if (!extras.getBoolean(extraName, false)) {
            //extras.remove(extraName);
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.591 -0400", hash_original_method = "DD55706005FD16094E01DF90CF28D99E", hash_generated_method = "5B7D04A7FC1AC953DAF37B9A0609DA49")
    public String toString() {
String varA6B8BD37985A60A440C49B7AA6CF67BB_205373090 =         dump(true);
        varA6B8BD37985A60A440C49B7AA6CF67BB_205373090.addTaint(taint);
        return varA6B8BD37985A60A440C49B7AA6CF67BB_205373090;
        // ---------- Original Method ----------
        //return dump(true);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.592 -0400", hash_original_method = "47737E917226B122B7AA0C5B23AFE223", hash_generated_method = "A8666071FB755F36ABE7839940C3D049")
    public String dump(boolean useOneLine) {
        addTaint(useOneLine);
        StringBuilder sb = new StringBuilder();
        sb.append(account.name);
        sb.append(" (" + account.type + ")");
        sb.append(", " + authority);
        sb.append(", ");
        sb.append(SyncStorageEngine.SOURCES[syncSource]);
        sb.append(", earliestRunTime " + earliestRunTime);
        if(expedited)        
        {
            sb.append(", EXPEDITED");
        } //End block
        if(!useOneLine && !extras.keySet().isEmpty())        
        {
            sb.append("\n    ");
            extrasToStringBuilder(extras, sb);
        } //End block
String var2460B846747F8B22185AD8BE722266A5_1423196240 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_1423196240.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_1423196240;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder();
        //sb.append(account.name);
        //sb.append(" (" + account.type + ")");
        //sb.append(", " + authority);
        //sb.append(", ");
        //sb.append(SyncStorageEngine.SOURCES[syncSource]);
        //sb.append(", earliestRunTime " + earliestRunTime);
        //if (expedited) {
            //sb.append(", EXPEDITED");
        //}
        //if (!useOneLine && !extras.keySet().isEmpty()) {
            //sb.append("\n    ");
            //extrasToStringBuilder(extras, sb);
        //}
        //return sb.toString();
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.592 -0400", hash_original_method = "0CBE4B28609593623A1CB97001F0DBD2", hash_generated_method = "7AE8EBB0AD4876AB24651A57539F79B7")
    public boolean isInitialization() {
        boolean var7DDE28B1FD1D777B1D79F3951983CA43_1145230961 = (extras.getBoolean(ContentResolver.SYNC_EXTRAS_INITIALIZE, false));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_118992272 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_118992272;
        // ---------- Original Method ----------
        //return extras.getBoolean(ContentResolver.SYNC_EXTRAS_INITIALIZE, false);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.593 -0400", hash_original_method = "A202EE0B500962365FD241C616148E63", hash_generated_method = "5C6AF6999FF53E908A10C394DBCE56C7")
    public boolean ignoreBackoff() {
        boolean var38DDFF7D7CA52472479FAE474236403E_925857647 = (extras.getBoolean(ContentResolver.SYNC_EXTRAS_IGNORE_BACKOFF, false));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_946866466 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_946866466;
        // ---------- Original Method ----------
        //return extras.getBoolean(ContentResolver.SYNC_EXTRAS_IGNORE_BACKOFF, false);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.593 -0400", hash_original_method = "557BF419234DEC0AF5F90553488D23D9", hash_generated_method = "229ADB5FD29FB703B3B2FD5BC1B1A40E")
    private String toKey() {
        StringBuilder sb = new StringBuilder();
        sb.append("authority: ").append(authority);
        sb.append(" account {name=" + account.name + ", type=" + account.type + "}");
        sb.append(" extras: ");
        extrasToStringBuilder(extras, sb);
String var2460B846747F8B22185AD8BE722266A5_1736535248 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_1736535248.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_1736535248;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder();
        //sb.append("authority: ").append(authority);
        //sb.append(" account {name=" + account.name + ", type=" + account.type + "}");
        //sb.append(" extras: ");
        //extrasToStringBuilder(extras, sb);
        //return sb.toString();
    }

    
    @DSModeled(DSC.BAN)
    public static void extrasToStringBuilder(Bundle bundle, StringBuilder sb) {
        sb.append("[");
        for (String key : bundle.keySet()) {
            sb.append(key).append("=").append(bundle.get(key)).append(" ");
        }
        sb.append("]");
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.594 -0400", hash_original_method = "0B30B519DCD273F2706D3A8819933F53", hash_generated_method = "3470C2C3EB73D929C84713285D0EFEAE")
    public void updateEffectiveRunTime() {
        effectiveRunTime = ignoreBackoff()
                ? earliestRunTime
                : Math.max(
                    Math.max(earliestRunTime, delayUntil),
                    backoff);
        // ---------- Original Method ----------
        //effectiveRunTime = ignoreBackoff()
                //? earliestRunTime
                //: Math.max(
                    //Math.max(earliestRunTime, delayUntil),
                    //backoff);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.595 -0400", hash_original_method = "94E2F05BFAF6BA397C21B12E8FAD132F", hash_generated_method = "66A1BDAC98D95D23D735B39ACC38833D")
    public int compareTo(Object o) {
        addTaint(o.getTaint());
        SyncOperation other = (SyncOperation)o;
        if(expedited != other.expedited)        
        {
            int var80440E4CBF7F6673ABE975925C8046F6_86799952 = (expedited ? -1 : 1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_380548904 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_380548904;
        } //End block
        if(effectiveRunTime == other.effectiveRunTime)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1718914721 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_767708352 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_767708352;
        } //End block
        int var4285BC5F081472817EFC10DE6C29FAC1_873530974 = (effectiveRunTime < other.effectiveRunTime ? -1 : 1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1014052780 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1014052780;
        // ---------- Original Method ----------
        //SyncOperation other = (SyncOperation)o;
        //if (expedited != other.expedited) {
            //return expedited ? -1 : 1;
        //}
        //if (effectiveRunTime == other.effectiveRunTime) {
            //return 0;
        //}
        //return effectiveRunTime < other.effectiveRunTime ? -1 : 1;
    }

    
}

