package org.apache.http.auth;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.apache.http.params.HttpParams;

public interface AuthSchemeFactory {    

    AuthScheme newInstance(HttpParams params);

}
