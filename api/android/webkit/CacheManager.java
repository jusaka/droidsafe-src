package android.webkit;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.net.http.AndroidHttpClient;
import android.net.http.Headers;
import android.os.FileUtils;
import android.util.Log;

import com.android.org.bouncycastle.crypto.Digest;
import com.android.org.bouncycastle.crypto.digests.SHA1Digest;






public final class CacheManager {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.526 -0400", hash_original_method = "A0B4DD756EBE924AE07FCEE8B62EE3BB", hash_generated_method = "A0B4DD756EBE924AE07FCEE8B62EE3BB")
    public CacheManager ()
    {
        //Synthesized constructor
    }


    static void init(Context context) {
        if (JniUtil.useChromiumHttpStack()) {
            mBaseDir = new File(context.getCacheDir(), "webviewCacheChromiumStaging");
            if (!mBaseDir.exists()) {
                mBaseDir.mkdirs();
            }
            return;
        }
        mDataBase = WebViewDatabase.getInstance(context.getApplicationContext());
        mBaseDir = new File(context.getCacheDir(), "webviewCache");
        if (createCacheDirectory() && mClearCacheOnInit) {
            removeAllCacheFiles();
            mClearCacheOnInit = false;
        }
    }

    
    @DSModeled(DSC.BAN)
    static private boolean createCacheDirectory() {
        assert !JniUtil.useChromiumHttpStack();
        if (!mBaseDir.exists()) {
            if(!mBaseDir.mkdirs()) {
                Log.w(LOGTAG, "Unable to create webviewCache directory");
                return false;
            }
            FileUtils.setPermissions(
                    mBaseDir.toString(),
                    FileUtils.S_IRWXU | FileUtils.S_IRWXG,
                    -1, -1);
            WebViewWorker.getHandler().sendEmptyMessage(
                    WebViewWorker.MSG_CLEAR_CACHE);
            return true;
        }
        return false;
    }

    
    @DSModeled(DSC.SAFE)
    @Deprecated
    public static File getCacheFileBaseDir() {
        return mBaseDir;
    }

    
    static void setCacheDisabled(boolean disabled) {
        assert !JniUtil.useChromiumHttpStack();
        if (disabled == mDisabled) {
            return;
        }
        mDisabled = disabled;
        if (mDisabled) {
            removeAllCacheFiles();
        }
    }

    
    @DSModeled(DSC.SAFE)
    @Deprecated
    public static boolean cacheDisabled() {
        return mDisabled;
    }

    
    static boolean enableTransaction() {
        assert !JniUtil.useChromiumHttpStack();
        if (++mRefCount == 1) {
            mDataBase.startCacheTransaction();
            return true;
        }
        return false;
    }

    
    static boolean disableTransaction() {
        assert !JniUtil.useChromiumHttpStack();
        if (--mRefCount == 0) {
            mDataBase.endCacheTransaction();
            return true;
        }
        return false;
    }

    
    static boolean startTransaction() {
        assert !JniUtil.useChromiumHttpStack();
        return mDataBase.startCacheTransaction();
    }

    
    static boolean endTransaction() {
        assert !JniUtil.useChromiumHttpStack();
        boolean ret = mDataBase.endCacheTransaction();
        if (++mTrimCacheCount >= TRIM_CACHE_INTERVAL) {
            mTrimCacheCount = 0;
            trimCacheIfNeeded();
        }
        return ret;
    }

    
    @DSModeled(DSC.SAFE)
    @Deprecated
    public static boolean startCacheTransaction() {
        return false;
    }

    
    @DSModeled(DSC.SAFE)
    @Deprecated
    public static boolean endCacheTransaction() {
        return false;
    }

    
    @Deprecated
    public static CacheResult getCacheFile(String url,
            Map<String, String> headers) {
        return getCacheFile(url, 0, headers);
    }

    
    static CacheResult getCacheFile(String url, long postIdentifier,
            Map<String, String> headers) {
        if (mDisabled) {
            return null;
        }
        if (JniUtil.useChromiumHttpStack()) {
            CacheResult result = nativeGetCacheResult(url);
            if (result == null) {
                return null;
            }
            File src = new File(mBaseDir, result.localPath);
            try {
                result.inStream = new FileInputStream(src);
            } catch (FileNotFoundException e) {
                Log.v(LOGTAG, "getCacheFile(): Failed to open file: " + e);
                return null;
            }
            return result;
        }
        String databaseKey = getDatabaseKey(url, postIdentifier);
        CacheResult result = mDataBase.getCache(databaseKey);
        if (result == null) {
            return null;
        }
        if (result.contentLength == 0) {
            if (!isCachableRedirect(result.httpStatusCode)) {
                mDataBase.removeCache(databaseKey);
                return null;
            }
        } else {
            File src = new File(mBaseDir, result.localPath);
            try {
                result.inStream = new FileInputStream(src);
            } catch (FileNotFoundException e) {
                mDataBase.removeCache(databaseKey);
                return null;
            }
        }
        if (headers != null && result.expires >= 0
                && result.expires <= System.currentTimeMillis()) {
            if (result.lastModified == null && result.etag == null) {
                return null;
            }
            if (result.etag != null) {
                headers.put(HEADER_KEY_IFNONEMATCH, result.etag);
            }
            if (result.lastModified != null) {
                headers.put(HEADER_KEY_IFMODIFIEDSINCE, result.lastModified);
            }
        }
        if (DebugFlags.CACHE_MANAGER) {
            Log.v(LOGTAG, "getCacheFile for url " + url);
        }
        return result;
    }

    
    @DSModeled(DSC.BAN)
    @Deprecated
    public static CacheResult createCacheFile(String url, int statusCode,
            Headers headers, String mimeType, boolean forceCache) {
        if (JniUtil.useChromiumHttpStack()) {
            return null;
        }
        return createCacheFile(url, statusCode, headers, mimeType, 0,
                forceCache);
    }

    
    static CacheResult createCacheFile(String url, int statusCode,
            Headers headers, String mimeType, long postIdentifier,
            boolean forceCache) {
        assert !JniUtil.useChromiumHttpStack();
        if (!forceCache && mDisabled) {
            return null;
        }
        String databaseKey = getDatabaseKey(url, postIdentifier);
        if (statusCode == 303) {
            mDataBase.removeCache(databaseKey);
            return null;
        }
        if (isCachableRedirect(statusCode) && !headers.getSetCookie().isEmpty()) {
            mDataBase.removeCache(databaseKey);
            return null;
        }
        CacheResult ret = parseHeaders(statusCode, headers, mimeType);
        if (ret == null) {
            mDataBase.removeCache(databaseKey);
        } else {
            setupFiles(databaseKey, ret);
            try {
                ret.outStream = new FileOutputStream(ret.outFile);
            } catch (FileNotFoundException e) {
                if (createCacheDirectory()) {
                    try {
                        ret.outStream = new FileOutputStream(ret.outFile);
                    } catch  (FileNotFoundException e2) {
                        return null;
                    }
                } else {
                    return null;
                }
            }
            ret.mimeType = mimeType;
        }
        return ret;
    }

    
    @Deprecated
    public static void saveCacheFile(String url, CacheResult cacheRet) {
        saveCacheFile(url, 0, cacheRet);
    }

    
    static void saveCacheFile(String url, long postIdentifier,
            CacheResult cacheRet) {
        try {
            cacheRet.outStream.close();
        } catch (IOException e) {
            return;
        }
        if (JniUtil.useChromiumHttpStack()) {
            assert false;
        }
        if (!cacheRet.outFile.exists()) {
            return;
        }
        boolean redirect = isCachableRedirect(cacheRet.httpStatusCode);
        if (redirect) {
            cacheRet.contentLength = 0;
            cacheRet.localPath = "";
        }
        if ((redirect || cacheRet.contentLength == 0)
                && !cacheRet.outFile.delete()) {
            Log.e(LOGTAG, cacheRet.outFile.getPath() + " delete failed.");
        }
        if (cacheRet.contentLength == 0) {
            return;
        }
        mDataBase.addCache(getDatabaseKey(url, postIdentifier), cacheRet);
        if (DebugFlags.CACHE_MANAGER) {
            Log.v(LOGTAG, "saveCacheFile for url " + url);
        }
    }

    
    static boolean cleanupCacheFile(CacheResult cacheRet) {
        assert !JniUtil.useChromiumHttpStack();
        try {
            cacheRet.outStream.close();
        } catch (IOException e) {
            return false;
        }
        return cacheRet.outFile.delete();
    }

    
    static boolean removeAllCacheFiles() {
        if (mBaseDir == null) {
            assert !JniUtil.useChromiumHttpStack();
            mClearCacheOnInit = true;
            return true;
        }
        if (!JniUtil.useChromiumHttpStack())
            WebViewWorker.getHandler().sendEmptyMessage(WebViewWorker.MSG_CLEAR_CACHE);
        final Runnable clearCache = new Runnable() {
            public void run() {
                try {
                    String[] files = mBaseDir.list();
                    if (files != null) {
                        for (int i = 0; i < files.length; i++) {
                            File f = new File(mBaseDir, files[i]);
                            if (!f.delete()) {
                                Log.e(LOGTAG, f.getPath() + " delete failed.");
                            }
                        }
                    }
                } catch (SecurityException e) {
                }
            }
        };
        new Thread(clearCache).start();
        return true;
    }

    
    static void trimCacheIfNeeded() {
        assert !JniUtil.useChromiumHttpStack();
        if (mDataBase.getCacheTotalSize() > CACHE_THRESHOLD) {
            List<String> pathList = mDataBase.trimCache(CACHE_TRIM_AMOUNT);
            int size = pathList.size();
            for (int i = 0; i < size; i++) {
                File f = new File(mBaseDir, pathList.get(i));
                if (!f.delete()) {
                    Log.e(LOGTAG, f.getPath() + " delete failed.");
                }
            }
            final List<String> fileList = mDataBase.getAllCacheFileNames();
            if (fileList == null) return;
            String[] toDelete = mBaseDir.list(new FilenameFilter() {
                public boolean accept(File dir, String filename) {
                    if (fileList.contains(filename)) {
                        return false;
                    } else {
                        return true;
                    }
                }
            });
            if (toDelete == null) return;
            size = toDelete.length;
            for (int i = 0; i < size; i++) {
                File f = new File(mBaseDir, toDelete[i]);
                if (!f.delete()) {
                    Log.e(LOGTAG, f.getPath() + " delete failed.");
                }
            }
        }
    }

    
    static void clearCache() {
        assert !JniUtil.useChromiumHttpStack();
        mDataBase.clearCache();
    }

    
    @DSModeled(DSC.BAN)
    private static boolean isCachableRedirect(int statusCode) {
        if (statusCode == 301 || statusCode == 302 || statusCode == 307) {
            return true;
        } else {
            return false;
        }
    }

    
    @DSModeled(DSC.BAN)
    private static String getDatabaseKey(String url, long postIdentifier) {
        assert !JniUtil.useChromiumHttpStack();
        if (postIdentifier == 0) return url;
        return postIdentifier + url;
    }

    
    @DSModeled(DSC.BAN)
    @SuppressWarnings("deprecation")
    private static void setupFiles(String url, CacheResult cacheRet) {
        assert !JniUtil.useChromiumHttpStack();
        if (true) {
            int hashCode = url.hashCode();
            StringBuffer ret = new StringBuffer(8);
            appendAsHex(hashCode, ret);
            String path = ret.toString();
            File file = new File(mBaseDir, path);
            if (true) {
                boolean checkOldPath = true;
                while (file.exists()) {
                    if (checkOldPath) {
                        CacheResult oldResult = mDataBase.getCache(url);
                        if (oldResult != null && oldResult.contentLength > 0) {
                            if (path.equals(oldResult.localPath)) {
                                path = oldResult.localPath;
                            } else {
                                path = oldResult.localPath;
                                file = new File(mBaseDir, path);
                            }
                            break;
                        }
                        checkOldPath = false;
                    }
                    ret = new StringBuffer(8);
                    appendAsHex(++hashCode, ret);
                    path = ret.toString();
                    file = new File(mBaseDir, path);
                }
            }
            cacheRet.localPath = path;
            cacheRet.outFile = file;
        } else {
            Digest digest = new SHA1Digest();
            int digestLen = digest.getDigestSize();
            byte[] hash = new byte[digestLen];
            int urlLen = url.length();
            byte[] data = new byte[urlLen];
            url.getBytes(0, urlLen, data, 0);
            digest.update(data, 0, urlLen);
            digest.doFinal(hash, 0);
            StringBuffer result = new StringBuffer(2 * digestLen);
            for (int i = 0; i < digestLen; i = i + 4) {
                int h = (0x00ff & hash[i]) << 24 | (0x00ff & hash[i + 1]) << 16
                        | (0x00ff & hash[i + 2]) << 8 | (0x00ff & hash[i + 3]);
                appendAsHex(h, result);
            }
            cacheRet.localPath = result.toString();
            cacheRet.outFile = new File(mBaseDir, cacheRet.localPath);
        }
    }

    
    @DSModeled(DSC.BAN)
    private static void appendAsHex(int i, StringBuffer ret) {
        assert !JniUtil.useChromiumHttpStack();
        String hex = Integer.toHexString(i);
        switch (hex.length()) {
            case 1:
                ret.append("0000000");
                break;
            case 2:
                ret.append("000000");
                break;
            case 3:
                ret.append("00000");
                break;
            case 4:
                ret.append("0000");
                break;
            case 5:
                ret.append("000");
                break;
            case 6:
                ret.append("00");
                break;
            case 7:
                ret.append("0");
                break;
        }
        ret.append(hex);
    }

    
    @DSModeled(DSC.BAN)
    private static CacheResult parseHeaders(int statusCode, Headers headers,
            String mimeType) {
        assert !JniUtil.useChromiumHttpStack();
        if (headers.getContentLength() > CACHE_MAX_SIZE) return null;
        if (MANIFEST_MIME.equals(mimeType)) return null;
        CacheResult ret = new CacheResult();
        ret.httpStatusCode = statusCode;
        ret.location = headers.getLocation();
        ret.expires = -1;
        ret.expiresString = headers.getExpires();
        if (ret.expiresString != null) {
            try {
                ret.expires = AndroidHttpClient.parseDate(ret.expiresString);
            } catch (IllegalArgumentException ex) {
                if ("-1".equals(ret.expiresString)
                        || "0".equals(ret.expiresString)) {
                    ret.expires = 0;
                } else {
                    Log.e(LOGTAG, "illegal expires: " + ret.expiresString);
                }
            }
        }
        ret.contentdisposition = headers.getContentDisposition();
        ret.crossDomain = headers.getXPermittedCrossDomainPolicies();
        String lastModified = headers.getLastModified();
        if (lastModified != null && lastModified.length() > 0) {
            ret.lastModified = lastModified;
        }
        String etag = headers.getEtag();
        if (etag != null && etag.length() > 0) {
            ret.etag = etag;
        }
        String cacheControl = headers.getCacheControl();
        if (cacheControl != null) {
            String[] controls = cacheControl.toLowerCase().split("[ ,;]");
            boolean noCache = false;
            for (int i = 0; i < controls.length; i++) {
                if (NO_STORE.equals(controls[i])) {
                    return null;
                }
                if (NO_CACHE.equals(controls[i])) {
                    ret.expires = 0;
                    noCache = true;
                } else if (controls[i].startsWith(MAX_AGE) && !noCache) {
                    int separator = controls[i].indexOf('=');
                    if (separator < 0) {
                        separator = controls[i].indexOf(':');
                    }
                    if (separator > 0) {
                        String s = controls[i].substring(separator + 1);
                        try {
                            long sec = Long.parseLong(s);
                            if (sec >= 0) {
                                ret.expires = System.currentTimeMillis() + 1000
                                        * sec;
                            }
                        } catch (NumberFormatException ex) {
                            if ("1d".equals(s)) {
                                ret.expires = System.currentTimeMillis() + 86400000; 
                            } else {
                                Log.e(LOGTAG, "exception in parseHeaders for "
                                        + "max-age:"
                                        + controls[i].substring(separator + 1));
                                ret.expires = 0;
                            }
                        }
                    }
                }
            }
        }
        if (NO_CACHE.equals(headers.getPragma())) {
            ret.expires = 0;
        }
        if (ret.expires == -1) {
            if (ret.httpStatusCode == 301) {
                ret.expires = Long.MAX_VALUE;
            } else if (ret.httpStatusCode == 302 || ret.httpStatusCode == 307) {
                ret.expires = 0;
            } else if (ret.lastModified == null) {
                if (!mimeType.startsWith("text/html")) {
                    ret.expires = System.currentTimeMillis() + 86400000; 
                } else {
                    ret.expires = 0;
                }
            } else {
                long lastmod = System.currentTimeMillis() + 86400000;
                try {
                    lastmod = AndroidHttpClient.parseDate(ret.lastModified);
                } catch (IllegalArgumentException ex) {
                    Log.e(LOGTAG, "illegal lastModified: " + ret.lastModified);
                }
                long difference = System.currentTimeMillis() - lastmod;
                if (difference > 0) {
                    ret.expires = System.currentTimeMillis() + difference / 5;
                } else {
                    ret.expires = lastmod;
                }
            }
        }
        return ret;
    }

    
    @DSModeled(DSC.SAFE)
    private static CacheResult nativeGetCacheResult(String url) {
    	CacheResult ret = new CacheResult();
    	ret.taint.addTaint(url.taint);
    	return ret;
    }

    
    public static class CacheResult {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.532 -0400", hash_original_field = "31BE39A7EEBA2250BD0701D4F35DD278", hash_generated_field = "6C670D782CFBD30F05F5773A857F5BD7")

        int httpStatusCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.532 -0400", hash_original_field = "C22384F3ABFE57BC648B6E1701C98123", hash_generated_field = "1E697977C6954C6B938DDD0BFFFD6A14")

        long contentLength;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.532 -0400", hash_original_field = "09BCB72D61C0D6D1EFF5336DA6881557", hash_generated_field = "79E45F34FE773E697DAD830A242384A5")

        long expires;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.532 -0400", hash_original_field = "FF92BA01E9F20B21FFFAB5BCA69EAB7C", hash_generated_field = "7815601E56735F19D559F76C33613949")

        String expiresString;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.532 -0400", hash_original_field = "854C6C62527722D75943FE3E6F81914B", hash_generated_field = "1EFCF95FF82C8B86BA07D210605AF3E7")

        String localPath;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.532 -0400", hash_original_field = "56D4CE3ADDD9E0185B21EB938EA5BC79", hash_generated_field = "EFB9BC01C22F5C81858357CDB303A6BA")

        String lastModified;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.532 -0400", hash_original_field = "1872ADE88F3013EDEB33DECD74A4F947", hash_generated_field = "00F25F78CD9C317A5119E7AB2B23712A")

        String etag;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.532 -0400", hash_original_field = "6DAD333C676844FE3B2A53FB6BE02D3A", hash_generated_field = "199378A118748448CD8C8A5B6EE3C464")

        String mimeType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.532 -0400", hash_original_field = "D5189DE027922F81005951E6EFE0EFD5", hash_generated_field = "4B5743C8685C2D199755623CB9DF3317")

        String location;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.533 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "C7941A2E59CC2DF1A97D47295C728725")

        String encoding;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.533 -0400", hash_original_field = "F24980AD6D5357B4F343994DF24B5BAE", hash_generated_field = "4265D6CD339375A09FEF81E5473D341C")

        String contentdisposition;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.533 -0400", hash_original_field = "DCD4373AC65082967053B1B9BEADFAFF", hash_generated_field = "C13D92B86B5B4AF70043404C40B34ACF")

        String crossDomain;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.533 -0400", hash_original_field = "F62CCA1498B2D705CDB564215019352D", hash_generated_field = "CE67F8E6759E7AA9F0B2D1B1C622FA48")

        InputStream inStream;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.533 -0400", hash_original_field = "5E808B253DC23FAC8AF0D5A2DA6A1AA4", hash_generated_field = "430FBB760F592DD8FEBCE2866E75BC6B")

        OutputStream outStream;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.533 -0400", hash_original_field = "0ACAEB80BC1D14407D481471162043B3", hash_generated_field = "20194DFB6E90B876A72FB28D859C6FC5")

        File outFile;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.533 -0400", hash_original_method = "9AF27DA4AF1967F12C09CBC55DFAD3DC", hash_generated_method = "9AF27DA4AF1967F12C09CBC55DFAD3DC")
        public CacheResult ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.533 -0400", hash_original_method = "DD5A2376D1CE8800456745E0EBB16914", hash_generated_method = "A00AE089E5FC612F50C11C6FFD8F4FAC")
        public int getHttpStatusCode() {
            int var31BE39A7EEBA2250BD0701D4F35DD278_51627811 = (httpStatusCode);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_183020327 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_183020327;
            // ---------- Original Method ----------
            //return httpStatusCode;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.533 -0400", hash_original_method = "043A311B0C55CC2C0E7ED635C15C25FD", hash_generated_method = "904515DA07E051197A1594556F475770")
        public long getContentLength() {
            long varC22384F3ABFE57BC648B6E1701C98123_947620298 = (contentLength);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1044557397 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1044557397;
            // ---------- Original Method ----------
            //return contentLength;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.533 -0400", hash_original_method = "AD502AEBBD528088B1D12F9CAC38CB54", hash_generated_method = "0CF5F594A9E30B5718B42CA77451E0A7")
        public String getLocalPath() {
String var42F44E42C4ADE0B7BBA6346ECBD9F0DB_1254059656 =             localPath;
            var42F44E42C4ADE0B7BBA6346ECBD9F0DB_1254059656.addTaint(taint);
            return var42F44E42C4ADE0B7BBA6346ECBD9F0DB_1254059656;
            // ---------- Original Method ----------
            //return localPath;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.533 -0400", hash_original_method = "4C886ADD26DB3A9818AA89FF03B8C3FC", hash_generated_method = "3C0BCBD9F165D3E80AD2D3E21FE5994B")
        public long getExpires() {
            long var09BCB72D61C0D6D1EFF5336DA6881557_1082070539 = (expires);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1804853292 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1804853292;
            // ---------- Original Method ----------
            //return expires;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.533 -0400", hash_original_method = "EF25E8FEFAF784FE84A0290E2AAD114E", hash_generated_method = "A40C22AEF7B885B78ADCF7B323191D1B")
        public String getExpiresString() {
String varFFAE9AD52B61206B9686FD5ACACDF68E_559064725 =             expiresString;
            varFFAE9AD52B61206B9686FD5ACACDF68E_559064725.addTaint(taint);
            return varFFAE9AD52B61206B9686FD5ACACDF68E_559064725;
            // ---------- Original Method ----------
            //return expiresString;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.533 -0400", hash_original_method = "9BE76A44786245A5C82A387C274361E4", hash_generated_method = "CB0D4FB41A1159427357F157258025E0")
        public String getLastModified() {
String var516C2A6FCD26E1D0D88121A19963AD63_562431399 =             lastModified;
            var516C2A6FCD26E1D0D88121A19963AD63_562431399.addTaint(taint);
            return var516C2A6FCD26E1D0D88121A19963AD63_562431399;
            // ---------- Original Method ----------
            //return lastModified;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.533 -0400", hash_original_method = "C916AEC2FCF91BC5DCA69D0B98CD1013", hash_generated_method = "52A5F95BE10F56AF1769DB2B06B805A2")
        public String getETag() {
String var5EC213F5B8A0028786E3BB0C8E4ED840_710264410 =             etag;
            var5EC213F5B8A0028786E3BB0C8E4ED840_710264410.addTaint(taint);
            return var5EC213F5B8A0028786E3BB0C8E4ED840_710264410;
            // ---------- Original Method ----------
            //return etag;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.533 -0400", hash_original_method = "6CD12CC12FD0AC9D51B06E8F6D96C76B", hash_generated_method = "CD53D9B6DFF2535AB30587306B79BA63")
        public String getMimeType() {
String var31E26FAFE73C53DECDB0A7F1CF57D932_396581949 =             mimeType;
            var31E26FAFE73C53DECDB0A7F1CF57D932_396581949.addTaint(taint);
            return var31E26FAFE73C53DECDB0A7F1CF57D932_396581949;
            // ---------- Original Method ----------
            //return mimeType;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.533 -0400", hash_original_method = "958E0B7EB30F5353747022B831D2FD74", hash_generated_method = "0E62A5A6B5246CE6993C0844AF129CCF")
        public String getLocation() {
String var96C70FF298E5697493B0D776E54760A4_577468301 =             location;
            var96C70FF298E5697493B0D776E54760A4_577468301.addTaint(taint);
            return var96C70FF298E5697493B0D776E54760A4_577468301;
            // ---------- Original Method ----------
            //return location;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.534 -0400", hash_original_method = "ECC6E581C26F132636CDCE9C9A5E5807", hash_generated_method = "3A5D25D8F144D54FF4D8105D8102C0E4")
        public String getEncoding() {
String varE424DD5E6E58EB63E1272B71B5A81966_520136986 =             encoding;
            varE424DD5E6E58EB63E1272B71B5A81966_520136986.addTaint(taint);
            return varE424DD5E6E58EB63E1272B71B5A81966_520136986;
            // ---------- Original Method ----------
            //return encoding;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.534 -0400", hash_original_method = "C0D4D7C4AE17A99630CF9DD48649B988", hash_generated_method = "B44BA85052866FCE0B116E375B5ED72A")
        public String getContentDisposition() {
String var9EB1A3307B3562ED31E222746F3AB26A_1927844883 =             contentdisposition;
            var9EB1A3307B3562ED31E222746F3AB26A_1927844883.addTaint(taint);
            return var9EB1A3307B3562ED31E222746F3AB26A_1927844883;
            // ---------- Original Method ----------
            //return contentdisposition;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.534 -0400", hash_original_method = "3D92385EA50556C1C84606BD9B5473E5", hash_generated_method = "BA5D89C947F3B736A05A62BF94C2ACDC")
        public InputStream getInputStream() {
InputStream varDBF027E1BB3550352743CD41C783F39D_1202635870 =             inStream;
            varDBF027E1BB3550352743CD41C783F39D_1202635870.addTaint(taint);
            return varDBF027E1BB3550352743CD41C783F39D_1202635870;
            // ---------- Original Method ----------
            //return inStream;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.534 -0400", hash_original_method = "B77E86F2D56E5DBE0D55411B47D89551", hash_generated_method = "B9E3FD82430D0AE3731C390DA35F0D30")
        public OutputStream getOutputStream() {
OutputStream var586556CF1CDD9DA081CC8DC911E7A6E6_1341470846 =             outStream;
            var586556CF1CDD9DA081CC8DC911E7A6E6_1341470846.addTaint(taint);
            return var586556CF1CDD9DA081CC8DC911E7A6E6_1341470846;
            // ---------- Original Method ----------
            //return outStream;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.534 -0400", hash_original_method = "B7D827E5771A9B377DDBAC601F400FD6", hash_generated_method = "D50427B4C8F38D7752B90DF293596A71")
        public void setInputStream(InputStream stream) {
            this.inStream = stream;
            // ---------- Original Method ----------
            //this.inStream = stream;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.534 -0400", hash_original_method = "109F4EE072FF4A68A1B686347AFE92DB", hash_generated_method = "7E8E9F5581B45D04B721857DE5AE6090")
        public void setEncoding(String encoding) {
            this.encoding = encoding;
            // ---------- Original Method ----------
            //this.encoding = encoding;
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.534 -0400", hash_original_method = "24FE4CA1135DA21E8B00A4A2D819D5D2", hash_generated_method = "3969089D2E06A5D5A418BB6CA59DBC16")
        public void setContentLength(long contentLength) {
            this.contentLength = contentLength;
            // ---------- Original Method ----------
            //this.contentLength = contentLength;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.534 -0400", hash_original_field = "B66D27ECF66350D8FF23DCBA7089DE52", hash_generated_field = "389C12A8617D8BCC08630F7BA010C0E2")

    private static final String LOGTAG = "cache";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.534 -0400", hash_original_field = "DE9667FB2D01D9FCE38A17C11C2E92CE", hash_generated_field = "05C239D2ED2147F03B62552EFE9672C2")

    static final String HEADER_KEY_IFMODIFIEDSINCE = "if-modified-since";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.534 -0400", hash_original_field = "FF42D3D52DF837140761AB93C6729C1D", hash_generated_field = "74E44E569BB9F45FBC857E67B78E6030")

    static final String HEADER_KEY_IFNONEMATCH = "if-none-match";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.534 -0400", hash_original_field = "ACC53A0E7D2047A668D5472D7489EABD", hash_generated_field = "939B143BA252760FE6A2040085DA20D1")

    private static final String NO_STORE = "no-store";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.534 -0400", hash_original_field = "BD33180106684E2C1B3A35F672990B6E", hash_generated_field = "AE15FEBAB58E4F297E6B247B85A02B60")

    private static final String NO_CACHE = "no-cache";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.534 -0400", hash_original_field = "2D4FDC7F9F47E8939FD8E883ADA3143E", hash_generated_field = "17FDE42B196035B579C4AE0481D84D7C")

    private static final String MAX_AGE = "max-age";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.534 -0400", hash_original_field = "0F1AEE29AF7773C25575936E807BF39C", hash_generated_field = "8EEB13495576D8136145DB9C601F7A1C")

    private static final String MANIFEST_MIME = "text/cache-manifest";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.534 -0400", hash_original_field = "FA5EC069DA7A5DA3BFC15DA670F2BD60", hash_generated_field = "D647BC6BC6F91B30C579B54074B4681D")

    private static long CACHE_THRESHOLD = 6 * 1024 * 1024;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.534 -0400", hash_original_field = "B15C00624A8A0E135A4A36AB8A424085", hash_generated_field = "C7BC04A2C8C224B4992692522B1C9534")

    private static long CACHE_TRIM_AMOUNT = 2 * 1024 * 1024;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.534 -0400", hash_original_field = "359FA27C4198DF5509DA713CEEDEA3C5", hash_generated_field = "955815A71A2F2BF01B99CE38A6328746")

    static long CACHE_MAX_SIZE = (CACHE_THRESHOLD - CACHE_TRIM_AMOUNT) / 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.534 -0400", hash_original_field = "D3D807667F408C606306DFF9C9D6DEB7", hash_generated_field = "065C749395F8EEFD3FA335C42BB42982")

    private static boolean mDisabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.534 -0400", hash_original_field = "DAC8A06C1EDF9825CDAF6DFCD18A7ADC", hash_generated_field = "612C983B5C95EDDDA5D6667269D6C1BD")

    private static int mRefCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.535 -0400", hash_original_field = "1B9B1E0D0A499175F315211C756E6EF5", hash_generated_field = "AF873A801F4AD3AA4F395DD249CF70E1")

    private static int mTrimCacheCount = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.535 -0400", hash_original_field = "5B3A69E2CCF9BF10C33DACC346FE87AD", hash_generated_field = "75DC397F63C8ACC66AC03AE377165A97")

    private static final int TRIM_CACHE_INTERVAL = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.535 -0400", hash_original_field = "C1A3099D37A59968718DB374307A0212", hash_generated_field = "112D7378ACAC09B383FA76ADC4A7A80A")

    private static WebViewDatabase mDataBase;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.535 -0400", hash_original_field = "BD240BC136A080D492A6E7497D54B26C", hash_generated_field = "E5AA5969C86636B06EBA401AAD2DB4DE")

    private static File mBaseDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.535 -0400", hash_original_field = "9482EE7290FD75B68702A7612F864D33", hash_generated_field = "485E2AE6AF65AD3F25A212E1A5B60B89")

    private static boolean mClearCacheOnInit = false;
}

