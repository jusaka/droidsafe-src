package org.xml.sax;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface Locator {


    
    public abstract String getPublicId ();


    
    public abstract String getSystemId ();


    
    public abstract int getLineNumber ();


    
    public abstract int getColumnNumber ();

}
