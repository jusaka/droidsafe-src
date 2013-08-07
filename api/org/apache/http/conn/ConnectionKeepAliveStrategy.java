package org.apache.http.conn;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;

public interface ConnectionKeepAliveStrategy {
    
    
    long getKeepAliveDuration(HttpResponse response, HttpContext context);
    
}
