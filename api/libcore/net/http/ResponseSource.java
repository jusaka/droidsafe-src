package libcore.net.http;

// Droidsafe Imports
import droidsafe.annotations.*;



enum ResponseSource {
    CACHE,
    CONDITIONAL_CACHE,
    NETWORK;
    @DSModeled(DSC.SAFE)
    public boolean requiresConnection() {
        return this == CONDITIONAL_CACHE || this == NETWORK;
    }
}
