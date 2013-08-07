package org.apache.http;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Iterator;

public interface TokenIterator extends Iterator {

    
    boolean hasNext()
        ;


    
    String nextToken()
        ;
}
