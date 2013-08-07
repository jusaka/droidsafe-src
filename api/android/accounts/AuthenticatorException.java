package android.accounts;

// Droidsafe Imports
import droidsafe.annotations.*;


public class AuthenticatorException extends AccountsException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.552 -0400", hash_original_method = "009F01E7B15DCE52B30E4E13B8632466", hash_generated_method = "1A7DAA5D19D8820B9379AC93220517C2")
    public  AuthenticatorException() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.554 -0400", hash_original_method = "46A5D5B214F277AEF0AE05BAEC539569", hash_generated_method = "509877330CE652CF7DE3DFCCB23C34E2")
    public  AuthenticatorException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.556 -0400", hash_original_method = "11AF1A71F6C16BA9750E55ACCBED5AED", hash_generated_method = "899AC24BF80EDA9F45F87EE6B7367D1E")
    public  AuthenticatorException(String message, Throwable cause) {
        super(message, cause);
        addTaint(cause.getTaint());
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:13.558 -0400", hash_original_method = "649380462FDC9062DB3070254FE15E47", hash_generated_method = "F8959822A5B6E06BA3863881DAC91EB0")
    public  AuthenticatorException(Throwable cause) {
        super(cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
}

