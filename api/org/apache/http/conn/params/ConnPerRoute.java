package org.apache.http.conn.params;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.apache.http.conn.routing.HttpRoute;

public interface ConnPerRoute {

    int getMaxForRoute(HttpRoute route);
    
}
