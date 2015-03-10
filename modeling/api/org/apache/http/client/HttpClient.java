/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/client/HttpClient.java $
 * $Revision: 676020 $
 * $Date: 2008-07-11 09:38:49 -0700 (Fri, 11 Jul 2008) $
 *
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.http.client;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

public interface HttpClient {
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.INTERNET)
    HttpParams getParams()
        ;
    
    ClientConnectionManager getConnectionManager()
        ;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.INTERNET)
    @DSSource({DSSourceKind.NETWORK})
    @DSSink({DSSinkKind.NETWORK})
    HttpResponse execute(HttpUriRequest request)
        throws IOException, ClientProtocolException
        ;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.INTERNET)
    @DSSource({DSSourceKind.NETWORK})
    @DSSink({DSSinkKind.NETWORK})
    HttpResponse execute(HttpUriRequest request, HttpContext context)
        throws IOException, ClientProtocolException
        ;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.INTERNET)
    @DSSource({DSSourceKind.NETWORK})
    @DSSink({DSSinkKind.NETWORK})
    HttpResponse execute(HttpHost target, HttpRequest request)
        throws IOException, ClientProtocolException
        ;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.INTERNET)
    @DSSource({DSSourceKind.NETWORK})
    @DSSink({DSSinkKind.NETWORK})
    HttpResponse execute(HttpHost target, HttpRequest request,
                         HttpContext context)
        throws IOException, ClientProtocolException
        ;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.INTERNET)
    @DSSource({DSSourceKind.NETWORK})
    @DSSink({DSSinkKind.NETWORK})
    <T> T execute(
            HttpUriRequest request, 
            ResponseHandler<? extends T> responseHandler)
        throws IOException, ClientProtocolException
        ;
    @DSComment("Abstract Method")
    @DSSpec(DSCat.INTERNET)
    @DSSource({DSSourceKind.NETWORK})   
    @DSSink({DSSinkKind.NETWORK})
    <T> T execute(
            HttpUriRequest request, 
            ResponseHandler<? extends T> responseHandler,
            HttpContext context)
        throws IOException, ClientProtocolException
        ;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.INTERNET)
    @DSSource({DSSourceKind.NETWORK})
    @DSSink({DSSinkKind.NETWORK})
    <T> T execute(
            HttpHost target, 
            HttpRequest request,
            ResponseHandler<? extends T> responseHandler)
        throws IOException, ClientProtocolException
        ;
    @DSComment("Abstract Method")
    @DSSpec(DSCat.INTERNET)
    @DSSource({DSSourceKind.NETWORK})   
    @DSSink({DSSinkKind.NETWORK})
    <T> T execute(
            HttpHost target, 
            HttpRequest request,
            ResponseHandler<? extends T> responseHandler, 
            HttpContext context)
        throws IOException, ClientProtocolException
        ;
    
}
