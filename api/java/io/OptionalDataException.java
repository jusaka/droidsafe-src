package java.io;

// Droidsafe Imports
import droidsafe.annotations.*;



public class OptionalDataException extends ObjectStreamException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.060 -0400", hash_original_field = "2E51B1AB42E8A4A67F3445174BE5191B", hash_generated_field = "A5BD226ED75D266A3BA0CDE2B4165A63")

    public boolean eof;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.060 -0400", hash_original_field = "2FA47F7C65FEC19CC163B195725E3844", hash_generated_field = "1125768121756783FBBAD7831AFCFE31")

    public int length;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.060 -0400", hash_original_method = "C77AFC0EE27E4B45ACE7BE98CCDC7A8A", hash_generated_method = "D7539358F0EC362E989324DB6CBCFA5C")
      OptionalDataException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.060 -0400", hash_original_method = "EE3BF9736C6F166E6F73C7336660246A", hash_generated_method = "409C5B240B5FC4D69D32EC7F464D92F3")
      OptionalDataException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.061 -0400", hash_original_field = "487B1F93BB5FDB5360A13F62F042C461", hash_generated_field = "DDC830DCF3194537EFCDF0B62E5DB379")

    private static final long serialVersionUID = -8011121865681257820L;
}

