package android.net.http;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.LinkedList;

import javax.net.ssl.SSLHandshakeException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpVersion;
import org.apache.http.ParseException;
import org.apache.http.ProtocolVersion;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;

import android.content.Context;
import android.os.SystemClock;





abstract class Connection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.939 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

    Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.939 -0400", hash_original_field = "225C165DF2343A8E0EA2245104D03B86", hash_generated_field = "89DB88E2A4BA8B129AFC783A277DC972")

    protected AndroidHttpClientConnection mHttpClientConnection = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.939 -0400", hash_original_field = "1C964C5062DB9515A402EF4BCB049EB0", hash_generated_field = "C93393B13E8B23850F2A2AA31CFA340F")

    protected SslCertificate mCertificate = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.939 -0400", hash_original_field = "AE3E518F8FFDE1F8C00699B4C58E95B5", hash_generated_field = "BB62408D38B8CFFE64423F7A37FB51DF")

    HttpHost mHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.939 -0400", hash_original_field = "97A1B0DF7A8AAEB03A6EC2B31E06308F", hash_generated_field = "7CE1ADB90870C4000E5A95CCB811B5D9")

    private boolean mCanPersist;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.939 -0400", hash_original_field = "FD03AC2C622114C9081EDA77D8B757D2", hash_generated_field = "5A9EBA484956FCBE0111BA8174DA817C")

    private HttpContext mHttpContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.939 -0400", hash_original_field = "41B678864A24EDAE5190D8888B82E287", hash_generated_field = "47B94217572DFA83D4A2A33DD250B38D")

    private int mActive = STATE_NORMAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.939 -0400", hash_original_field = "2E54C55B0E19AE6A5D3D5CB288053E14", hash_generated_field = "537B204D0FD240DD08711E1D73085387")

    RequestFeeder mRequestFeeder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.939 -0400", hash_original_field = "D8259507CE3049C660B2FFFC8043DC4C", hash_generated_field = "29FB82D1D2E75901C37B9EDD1B81BDDE")

    private byte[] mBuf;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.940 -0400", hash_original_method = "5BAB9F531750E6A689F8FF5D2A254CB9", hash_generated_method = "8638DF5D935AC67BE8ACABC50432A630")
    protected  Connection(Context context, HttpHost host,
                         RequestFeeder requestFeeder) {
        mContext = context;
        mHost = host;
        mRequestFeeder = requestFeeder;
        mCanPersist = false;
        mHttpContext = new BasicHttpContext(null);
        // ---------- Original Method ----------
        //mContext = context;
        //mHost = host;
        //mRequestFeeder = requestFeeder;
        //mCanPersist = false;
        //mHttpContext = new BasicHttpContext(null);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.940 -0400", hash_original_method = "9B5E41A5FF20333698838F3F6DF6BCD6", hash_generated_method = "7D49A3145F3247CB6EB2673CEE4CE3E1")
     HttpHost getHost() {
HttpHost varE57614B151242FB69B92E61EEA287D33_1103899882 =         mHost;
        varE57614B151242FB69B92E61EEA287D33_1103899882.addTaint(taint);
        return varE57614B151242FB69B92E61EEA287D33_1103899882;
        // ---------- Original Method ----------
        //return mHost;
    }

    
    @DSModeled(DSC.BAN)
    static Connection getConnection(
            Context context, HttpHost host, HttpHost proxy,
            RequestFeeder requestFeeder) {
        if (host.getSchemeName().equals("http")) {
            return new HttpConnection(context, host, requestFeeder);
        }
        return new HttpsConnection(context, host, proxy, requestFeeder);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.940 -0400", hash_original_method = "7F448377575EC929DDEDD2BF1EB435C4", hash_generated_method = "E9BE344D9B6D69A748715799C3584F79")
     SslCertificate getCertificate() {
SslCertificate varAD9FB3E799180A1D9497E2C35C2EA89C_175967284 =         mCertificate;
        varAD9FB3E799180A1D9497E2C35C2EA89C_175967284.addTaint(taint);
        return varAD9FB3E799180A1D9497E2C35C2EA89C_175967284;
        // ---------- Original Method ----------
        //return mCertificate;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.940 -0400", hash_original_method = "E0AFA64670C1DBA320AD7B4F64C9D703", hash_generated_method = "3B488F91FC8DC4ED1BB3FD8181F0B0DA")
     void cancel() {
        mActive = STATE_CANCEL_REQUESTED;
        closeConnection();
        if(HttpLog.LOGV)        
        HttpLog.v(
            "Connection.cancel(): connection closed " + mHost);
        // ---------- Original Method ----------
        //mActive = STATE_CANCEL_REQUESTED;
        //closeConnection();
        //if (HttpLog.LOGV) HttpLog.v(
            //"Connection.cancel(): connection closed " + mHost);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.943 -0400", hash_original_method = "F5EEA514D7040591FC6D3FB9B4E157ED", hash_generated_method = "90E7FCD9DF8AADBE39E6E7B49FD40632")
     void processRequests(Request firstRequest) {
        addTaint(firstRequest.getTaint());
        Request req = null;
        boolean empty;
        int error = EventHandler.OK;
        Exception exception = null;
        LinkedList<Request> pipe = new LinkedList<Request>();
        int minPipe = MIN_PIPE;
        int maxPipe = MAX_PIPE;
        int state = SEND;
        while
(state != DONE)        
        {
            if(HttpLog.LOGV)            
            HttpLog.v(
                    states[state] + " pipe " + pipe.size());
            if(mActive == STATE_CANCEL_REQUESTED)            
            {
                try 
                {
                    Thread.sleep(100);
                } //End block
                catch (InterruptedException x)
                {
                } //End block
                mActive = STATE_NORMAL;
            } //End block
switch(state){
            case SEND:
            {
                if(pipe.size() == maxPipe)                
                {
                    state = READ;
                    break;
                } //End block
                if(firstRequest == null)                
                {
                    req = mRequestFeeder.getRequest(mHost);
                } //End block
                else
                {
                    req = firstRequest;
                    firstRequest = null;
                } //End block
                if(req == null)                
                {
                    state = DRAIN;
                    break;
                } //End block
                req.setConnection(this);
                if(req.mCancelled)                
                {
                    if(HttpLog.LOGV)                    
                    HttpLog.v(
                                "processRequests(): skipping cancelled request "
                                + req);
                    req.complete();
                    break;
                } //End block
                if(mHttpClientConnection == null ||
                        !mHttpClientConnection.isOpen())                
                {
                    if(!openHttpConnection(req))                    
                    {
                        state = DONE;
                        break;
                    } //End block
                } //End block
                req.mEventHandler.certificate(mCertificate);
                try 
                {
                    req.sendRequest(mHttpClientConnection);
                } //End block
                catch (HttpException e)
                {
                    exception = e;
                    error = EventHandler.ERROR;
                } //End block
                catch (IOException e)
                {
                    exception = e;
                    error = EventHandler.ERROR_IO;
                } //End block
                catch (IllegalStateException e)
                {
                    exception = e;
                    error = EventHandler.ERROR_IO;
                } //End block
                if(exception != null)                
                {
                    if(httpFailure(req, error, exception) &&
                            !req.mCancelled)                    
                    {
                        pipe.addLast(req);
                    } //End block
                    exception = null;
                    state = clearPipe(pipe) ? DONE : SEND;
                    minPipe = maxPipe = 1;
                    break;
                } //End block
                pipe.addLast(req);
                if(!mCanPersist)                
                state = READ;
                break;
            } //End block
            case DRAIN:
            case READ:
            {
                empty = !mRequestFeeder.haveRequest(mHost);
                int pipeSize = pipe.size();
                if(state != DRAIN && pipeSize < minPipe &&
                        !empty && mCanPersist)                
                {
                    state = SEND;
                    break;
                } //End block
                else
                if(pipeSize == 0)                
                {
                    state = empty ? DONE : SEND;
                    break;
                } //End block
                req = (Request)pipe.removeFirst();
                if(HttpLog.LOGV)                
                HttpLog.v(
                            "processRequests() reading " + req);
                try 
                {
                    req.readResponse(mHttpClientConnection);
                } //End block
                catch (ParseException e)
                {
                    exception = e;
                    error = EventHandler.ERROR_IO;
                } //End block
                catch (IOException e)
                {
                    exception = e;
                    error = EventHandler.ERROR_IO;
                } //End block
                catch (IllegalStateException e)
                {
                    exception = e;
                    error = EventHandler.ERROR_IO;
                } //End block
                if(exception != null)                
                {
                    if(httpFailure(req, error, exception) &&
                            !req.mCancelled)                    
                    {
                        req.reset();
                        pipe.addFirst(req);
                    } //End block
                    exception = null;
                    mCanPersist = false;
                } //End block
                if(!mCanPersist)                
                {
                    if(HttpLog.LOGV)                    
                    HttpLog.v(
                                "processRequests(): no persist, closing " +
                                mHost);
                    closeConnection();
                    mHttpContext.removeAttribute(HTTP_CONNECTION);
                    clearPipe(pipe);
                    minPipe = maxPipe = 1;
                    state = SEND;
                } //End block
                break;
            } //End block
}
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.945 -0400", hash_original_method = "3DB5627BDFAF8C06A0CDDAD2458FF1F0", hash_generated_method = "24BB25497F5EBCA77D6462A5DE6D0321")
    private boolean clearPipe(LinkedList<Request> pipe) {
        addTaint(pipe.getTaint());
        boolean empty = true;
        if(HttpLog.LOGV)        
        HttpLog.v(
                "Connection.clearPipe(): clearing pipe " + pipe.size());
        synchronized
(mRequestFeeder)        {
            Request tReq;
            while
(!pipe.isEmpty())            
            {
                tReq = (Request)pipe.removeLast();
                if(HttpLog.LOGV)                
                HttpLog.v(
                        "clearPipe() adding back " + mHost + " " + tReq);
                mRequestFeeder.requeueRequest(tReq);
                empty = false;
            } //End block
            if(empty)            
            empty = !mRequestFeeder.haveRequest(mHost);
        } //End block
        boolean varA2E4822A98337283E39F7B60ACF85EC9_1639956611 = (empty);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1839468934 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1839468934;
        // ---------- Original Method ----------
        //boolean empty = true;
        //if (HttpLog.LOGV) HttpLog.v(
                //"Connection.clearPipe(): clearing pipe " + pipe.size());
        //synchronized (mRequestFeeder) {
            //Request tReq;
            //while (!pipe.isEmpty()) {
                //tReq = (Request)pipe.removeLast();
                //if (HttpLog.LOGV) HttpLog.v(
                        //"clearPipe() adding back " + mHost + " " + tReq);
                //mRequestFeeder.requeueRequest(tReq);
                //empty = false;
            //}
            //if (empty) empty = !mRequestFeeder.haveRequest(mHost);
        //}
        //return empty;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.946 -0400", hash_original_method = "65B4C91B53E686F7A0B5A125142FC3C0", hash_generated_method = "4A298B7ED3BAAF75CA3626CDCA4249AD")
    private boolean openHttpConnection(Request req) {
        long now = SystemClock.uptimeMillis();
        int error = EventHandler.OK;
        Exception exception = null;
        try 
        {
            mCertificate = null;
            mHttpClientConnection = openConnection(req);
            if(mHttpClientConnection != null)            
            {
                mHttpClientConnection.setSocketTimeout(SOCKET_TIMEOUT);
                mHttpContext.setAttribute(HTTP_CONNECTION,
                                          mHttpClientConnection);
            } //End block
            else
            {
                req.mFailCount = RETRY_REQUEST_LIMIT;
                boolean var68934A3E9455FA72420237EB05902327_1290121879 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1773355728 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1773355728;
            } //End block
        } //End block
        catch (UnknownHostException e)
        {
            if(HttpLog.LOGV)            
            HttpLog.v("Failed to open connection");
            error = EventHandler.ERROR_LOOKUP;
            exception = e;
        } //End block
        catch (IllegalArgumentException e)
        {
            if(HttpLog.LOGV)            
            HttpLog.v("Illegal argument exception");
            error = EventHandler.ERROR_CONNECT;
            req.mFailCount = RETRY_REQUEST_LIMIT;
            exception = e;
        } //End block
        catch (SSLConnectionClosedByUserException e)
        {
            req.mFailCount = RETRY_REQUEST_LIMIT;
            boolean var68934A3E9455FA72420237EB05902327_1563680132 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_114035327 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_114035327;
        } //End block
        catch (SSLHandshakeException e)
        {
            req.mFailCount = RETRY_REQUEST_LIMIT;
            if(HttpLog.LOGV)            
            HttpLog.v(
                    "SSL exception performing handshake");
            error = EventHandler.ERROR_FAILED_SSL_HANDSHAKE;
            exception = e;
        } //End block
        catch (IOException e)
        {
            error = EventHandler.ERROR_CONNECT;
            exception = e;
        } //End block
        if(HttpLog.LOGV)        
        {
            long now2 = SystemClock.uptimeMillis();
            HttpLog.v("Connection.openHttpConnection() " +
                      (now2 - now) + " " + mHost);
        } //End block
        if(error == EventHandler.OK)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1845664489 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1632839787 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1632839787;
        } //End block
        else
        {
            if(req.mFailCount < RETRY_REQUEST_LIMIT)            
            {
                mRequestFeeder.requeueRequest(req);
                req.mFailCount++;
            } //End block
            else
            {
                httpFailure(req, error, exception);
            } //End block
            boolean varE165328C5759933C6EEA4282CD40EAB0_748988964 = (error == EventHandler.OK);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_873591810 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_873591810;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.947 -0400", hash_original_method = "6EC91A36E40ABAF43D521C6CD9682246", hash_generated_method = "9CDDCC0FD6CAEAC9EE5871C1C23C9461")
    private boolean httpFailure(Request req, int errorId, Exception e) {
        addTaint(e.getTaint());
        addTaint(errorId);
        addTaint(req.getTaint());
        boolean ret = true;
        if(HttpLog.LOGV)        
        HttpLog.v(
                "httpFailure() ******* " + e + " count " + req.mFailCount +
                " " + mHost + " " + req.getUri());
        if(++req.mFailCount >= RETRY_REQUEST_LIMIT)        
        {
            ret = false;
            String error;
            if(errorId < 0)            
            {
                error = ErrorStrings.getString(errorId, mContext);
            } //End block
            else
            {
                Throwable cause = e.getCause();
                error = cause != null ? cause.toString() : e.getMessage();
            } //End block
            req.mEventHandler.error(errorId, error);
            req.complete();
        } //End block
        closeConnection();
        mHttpContext.removeAttribute(HTTP_CONNECTION);
        boolean var2CB9DF9898E55FD0AD829DC202DDBD1C_268679961 = (ret);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_905555229 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_905555229;
        // ---------- Original Method ----------
        //boolean ret = true;
        //if (HttpLog.LOGV) HttpLog.v(
                //"httpFailure() ******* " + e + " count " + req.mFailCount +
                //" " + mHost + " " + req.getUri());
        //if (++req.mFailCount >= RETRY_REQUEST_LIMIT) {
            //ret = false;
            //String error;
            //if (errorId < 0) {
                //error = ErrorStrings.getString(errorId, mContext);
            //} else {
                //Throwable cause = e.getCause();
                //error = cause != null ? cause.toString() : e.getMessage();
            //}
            //req.mEventHandler.error(errorId, error);
            //req.complete();
        //}
        //closeConnection();
        //mHttpContext.removeAttribute(HTTP_CONNECTION);
        //return ret;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.947 -0400", hash_original_method = "510B2315D285A4B8D2701F50BEED692F", hash_generated_method = "9BDD7AB932705EEF3FFEB26F7C0E804A")
     HttpContext getHttpContext() {
HttpContext var12C73152C7871DEFD35EAD04C5DEFC45_1686996982 =         mHttpContext;
        var12C73152C7871DEFD35EAD04C5DEFC45_1686996982.addTaint(taint);
        return var12C73152C7871DEFD35EAD04C5DEFC45_1686996982;
        // ---------- Original Method ----------
        //return mHttpContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.947 -0400", hash_original_method = "CD663685F32FAE99B1C37BBE4FC5CEFB", hash_generated_method = "C0530AE8D38B07D5A3AB10A36EA482D6")
    private boolean keepAlive(HttpEntity entity,
            ProtocolVersion ver, int connType, final HttpContext context) {
        addTaint(context.getTaint());
        addTaint(connType);
        addTaint(ver.getTaint());
        addTaint(entity.getTaint());
        org.apache.http.HttpConnection conn = (org.apache.http.HttpConnection)
            context.getAttribute(ExecutionContext.HTTP_CONNECTION);
        if(conn != null && !conn.isOpen())        
        {
        boolean var68934A3E9455FA72420237EB05902327_2032160065 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_796674176 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_796674176;
        }
        if(entity != null)        
        {
            if(entity.getContentLength() < 0)            
            {
                if(!entity.isChunked() || ver.lessEquals(HttpVersion.HTTP_1_0))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1510597918 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1234938194 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1234938194;
                } //End block
            } //End block
        } //End block
        if(connType == Headers.CONN_CLOSE)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1329214570 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1279767993 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1279767993;
        } //End block
        else
        if(connType == Headers.CONN_KEEP_ALIVE)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_830562602 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_830956517 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_830956517;
        } //End block
        boolean varD7433EC039027871EB92428F9FFCA1CC_519518697 = (!ver.lessEquals(HttpVersion.HTTP_1_0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1757866028 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1757866028;
        // ---------- Original Method ----------
        //org.apache.http.HttpConnection conn = (org.apache.http.HttpConnection)
            //context.getAttribute(ExecutionContext.HTTP_CONNECTION);
        //if (conn != null && !conn.isOpen())
            //return false;
        //if (entity != null) {
            //if (entity.getContentLength() < 0) {
                //if (!entity.isChunked() || ver.lessEquals(HttpVersion.HTTP_1_0)) {
                    //return false;
                //}
            //}
        //}
        //if (connType == Headers.CONN_CLOSE) {
            //return false;
        //} else if (connType == Headers.CONN_KEEP_ALIVE) {
            //return true;
        //}
        //return !ver.lessEquals(HttpVersion.HTTP_1_0);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.947 -0400", hash_original_method = "30E271C8B4BA77F90D768E6DAD0368A8", hash_generated_method = "4D4E5718D6623C41E8E53EA293E55F7E")
     void setCanPersist(HttpEntity entity, ProtocolVersion ver, int connType) {
        mCanPersist = keepAlive(entity, ver, connType, mHttpContext);
        // ---------- Original Method ----------
        //mCanPersist = keepAlive(entity, ver, connType, mHttpContext);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.948 -0400", hash_original_method = "948404D3184D15107ABD2526F5DFBFE0", hash_generated_method = "C987B1689B3761BB7765A463FADF77BA")
     void setCanPersist(boolean canPersist) {
        mCanPersist = canPersist;
        // ---------- Original Method ----------
        //mCanPersist = canPersist;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.948 -0400", hash_original_method = "5B21A605E2B59BE630988FE4FC055560", hash_generated_method = "58948E82C2ACE81FBD2631863176A413")
     boolean getCanPersist() {
        boolean var97A1B0DF7A8AAEB03A6EC2B31E06308F_358179545 = (mCanPersist);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1427862335 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1427862335;
        // ---------- Original Method ----------
        //return mCanPersist;
    }

    
    @DSModeled(DSC.SAFE)
    abstract String getScheme();

    
    @DSModeled(DSC.SAFE)
    abstract void closeConnection();

    
    @DSModeled(DSC.SAFE)
    abstract AndroidHttpClientConnection openConnection(Request req) throws IOException;

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.948 -0400", hash_original_method = "AD69CA65EB98EE93EFEEFD66CD2BA041", hash_generated_method = "EE64BA2A2506C33419805FE414AE8F16")
    public synchronized String toString() {
String varCB14F0A7BD5D5FF81E804E15C1A5E873_1951521272 =         mHost.toString();
        varCB14F0A7BD5D5FF81E804E15C1A5E873_1951521272.addTaint(taint);
        return varCB14F0A7BD5D5FF81E804E15C1A5E873_1951521272;
        // ---------- Original Method ----------
        //return mHost.toString();
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.948 -0400", hash_original_method = "ED2ED37A31E0A6859AF61C011936FDA1", hash_generated_method = "1C319C0E1FE49E7DFA7F27368C0C48AC")
     byte[] getBuf() {
        if(mBuf == null)        
        mBuf = new byte[8192];
        byte[] varD8259507CE3049C660B2FFFC8043DC4C_1439142523 = (mBuf);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2122115110 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2122115110;
        // ---------- Original Method ----------
        //if (mBuf == null) mBuf = new byte[8192];
        //return mBuf;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.948 -0400", hash_original_field = "DC786437DAF39BC0353D2B9BA7D3C9E6", hash_generated_field = "FD49C956DFAA52CB9AA44D852EDE7E88")

    static final int SOCKET_TIMEOUT = 60000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.948 -0400", hash_original_field = "6BF33435F120264EF42E338D17C72D0B", hash_generated_field = "1685A8AED473B8DB89C64DD70F6B2006")

    private static final int SEND = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.948 -0400", hash_original_field = "E175EC5A2FD87D2B13E08BAB1C961780", hash_generated_field = "22E96ACD2E5356C19B3A4C8936496A0F")

    private static final int READ = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.948 -0400", hash_original_field = "0CB9FCC085D3EC2FCAF62AD99BEB9AC2", hash_generated_field = "5BAF0CAFDC584F3B1861B58546EDCB7E")

    private static final int DRAIN = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.949 -0400", hash_original_field = "709E3C1FBB813E9051103B038B68E183", hash_generated_field = "A0EA7B5A8C185F5C7D5C82DFB7B53A9C")

    private static final int DONE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.949 -0400", hash_original_field = "4890D714BFC35B9367C8CAB211D44263", hash_generated_field = "751D7AEFD8D9F803728738C72D6E6C21")

    private static final String[] states = {"SEND",  "READ", "DRAIN", "DONE"};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.949 -0400", hash_original_field = "56C17BEC69383339D712A34A376816DF", hash_generated_field = "C20BDB569BF441D514B312064089B80D")

    private static int STATE_NORMAL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.949 -0400", hash_original_field = "6DD800274CF5304024380655EE085BEF", hash_generated_field = "4B33F7E13CDE76A475EA8482B52829FC")

    private static int STATE_CANCEL_REQUESTED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.949 -0400", hash_original_field = "9CF6E88AA50B22FBAA17EBC283AD1064", hash_generated_field = "BB46C45CF828AF753F842CF0245407C9")

    private final static int RETRY_REQUEST_LIMIT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.949 -0400", hash_original_field = "8AF7C98381A3955FFE32D244C79CD1BB", hash_generated_field = "8470675918FC5BC85BDE71A8C20A9EED")

    private static final int MIN_PIPE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.949 -0400", hash_original_field = "FBAD8F702AAE93F7E71144CEB6214FFD", hash_generated_field = "5FBC745DF7014C47FBE8E03B5689C9AC")

    private static final int MAX_PIPE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:19.949 -0400", hash_original_field = "315AC7FB13FDA9DD2AF31A202845A2F1", hash_generated_field = "A05D44F0812379A6B6F7EFAA2F4D23B1")

    private static final String HTTP_CONNECTION = "http.connection";
}

