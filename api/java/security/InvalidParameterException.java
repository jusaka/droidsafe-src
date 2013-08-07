package java.security;

// Droidsafe Imports
import droidsafe.annotations.*;



public class InvalidParameterException extends IllegalArgumentException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.866 -0400", hash_original_method = "A4FEFBD78FD62EF00C6F1D79EDBD5401", hash_generated_method = "5C07804D1F3ED78B3325D5ACF24549E2")
    public  InvalidParameterException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.866 -0400", hash_original_method = "9CA8CE9AC39DC45F96DE6473AB9F71B5", hash_generated_method = "A364D8E4484CEE6C11C8D78768D38217")
    public  InvalidParameterException() {
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.867 -0400", hash_original_field = "FFD2081AF7C75B29A7D796D7F2503C27", hash_generated_field = "C259222F7A4B888F1D08B18CFB6AF521")

    private static final long serialVersionUID = -857968536935667808L;
}

