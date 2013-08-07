package android.net;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;





public class LinkCapabilities implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.038 -0400", hash_original_field = "CC010D636843DF8CC2B8C35E93302C15", hash_generated_field = "6D2F490064193A394308FD52EAD2F213")

    private HashMap<Integer, String> mCapabilities;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.038 -0400", hash_original_method = "8AC97A1FCCB5728EBAB2151990B61507", hash_generated_method = "5CABA04E7070710949FB09D336670A02")
    public  LinkCapabilities() {
        mCapabilities = new HashMap<Integer, String>();
        // ---------- Original Method ----------
        //mCapabilities = new HashMap<Integer, String>();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.039 -0400", hash_original_method = "B89651C5D9CFDB434612BD816E092144", hash_generated_method = "0878ACDF400A9CDAA93315C0D1C4216C")
    public  LinkCapabilities(LinkCapabilities source) {
        if(source != null)        
        {
            mCapabilities = new HashMap<Integer, String>(source.mCapabilities);
        } //End block
        else
        {
            mCapabilities = new HashMap<Integer, String>();
        } //End block
        // ---------- Original Method ----------
        //if (source != null) {
            //mCapabilities = new HashMap<Integer, String>(source.mCapabilities);
        //} else {
            //mCapabilities = new HashMap<Integer, String>();
        //}
    }

    
    @DSModeled(DSC.BAN)
    public static LinkCapabilities createNeedsMap(String applicationRole) {
        if (DBG) log("createNeededCapabilities(applicationRole) EX");
        return new LinkCapabilities();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.040 -0400", hash_original_method = "65569EBD49455AAF0883C4D69A42B604", hash_generated_method = "4F70271EFC86EA6CB157AC698C1F121C")
    public void clear() {
        mCapabilities.clear();
        // ---------- Original Method ----------
        //mCapabilities.clear();
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.040 -0400", hash_original_method = "50DA395E2AF302C1CC5EAE713D0D4EBB", hash_generated_method = "5EFF9843369AC5519FDB09107E6F03FF")
    public boolean isEmpty() {
        boolean var651A9CCC76FF7B6A32F11DFBA25B6C83_188626561 = (mCapabilities.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_366543061 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_366543061;
        // ---------- Original Method ----------
        //return mCapabilities.isEmpty();
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.040 -0400", hash_original_method = "32A53E9BB0DE153D2975EBB6ECC5F512", hash_generated_method = "21FC8CCF37DEC97B6FDED2A1C787CA7A")
    public int size() {
        int var4F37A19B41DACFAB8B445BF9526CFCB2_537096324 = (mCapabilities.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_603658527 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_603658527;
        // ---------- Original Method ----------
        //return mCapabilities.size();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.041 -0400", hash_original_method = "568005AD4EF2A886FBB9B820A5E2167C", hash_generated_method = "80927E46435347FCD88486653D3C325F")
    public String get(int key) {
        addTaint(key);
String var0CDFD3D1516B36DBEF2AEE1E4B24910F_1940263274 =         mCapabilities.get(key);
        var0CDFD3D1516B36DBEF2AEE1E4B24910F_1940263274.addTaint(taint);
        return var0CDFD3D1516B36DBEF2AEE1E4B24910F_1940263274;
        // ---------- Original Method ----------
        //return mCapabilities.get(key);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.041 -0400", hash_original_method = "126A86B00CA0552F526F15B68A83F2ED", hash_generated_method = "407DE26955FB5137BDB572DBA0641A73")
    public void put(int key, String value) {
        addTaint(value.getTaint());
        addTaint(key);
        mCapabilities.put(key, value);
        // ---------- Original Method ----------
        //mCapabilities.put(key, value);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.042 -0400", hash_original_method = "C1A26B01C735E97490E02BBFBAC6A09E", hash_generated_method = "8CA191B6AEF7D69E8E2CFC4F779F5D42")
    public boolean containsKey(int key) {
        addTaint(key);
        boolean varEB30470E087192562821ACDD04ECE7EB_1730931004 = (mCapabilities.containsKey(key));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_425729170 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_425729170;
        // ---------- Original Method ----------
        //return mCapabilities.containsKey(key);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.042 -0400", hash_original_method = "05E28527AC6BDB7F8BDD1968A304DADF", hash_generated_method = "CD2D12EE4DC840B8B062AFC2141AADFB")
    public boolean containsValue(String value) {
        addTaint(value.getTaint());
        boolean varFA8DFDCCE589D8E5B37908244E199570_674230072 = (mCapabilities.containsValue(value));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_340894167 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_340894167;
        // ---------- Original Method ----------
        //return mCapabilities.containsValue(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.043 -0400", hash_original_method = "9F2F3F77DD27B21E35B683D345FC2FEC", hash_generated_method = "6D49FA51E853A7058CFEDA1B1A0B1764")
    public Set<Entry<Integer, String>> entrySet() {
Set<Entry<Integer, String>> varB74657035CAC30102BE4F1FDE7200E78_61839002 =         mCapabilities.entrySet();
        varB74657035CAC30102BE4F1FDE7200E78_61839002.addTaint(taint);
        return varB74657035CAC30102BE4F1FDE7200E78_61839002;
        // ---------- Original Method ----------
        //return mCapabilities.entrySet();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.043 -0400", hash_original_method = "9EFA80A4731E36F41CEC9CDBD3C0FD66", hash_generated_method = "F934E3869A7E3015DEC104CE409DA6AE")
    public Set<Integer> keySet() {
Set<Integer> varEA618452F40CB38732BAA6482DBBF012_1805952249 =         mCapabilities.keySet();
        varEA618452F40CB38732BAA6482DBBF012_1805952249.addTaint(taint);
        return varEA618452F40CB38732BAA6482DBBF012_1805952249;
        // ---------- Original Method ----------
        //return mCapabilities.keySet();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.043 -0400", hash_original_method = "3BC9717E7FFAE02D41102E4F5DA33838", hash_generated_method = "076EB30D330951F6A5284EA40AE353D6")
    public Collection<String> values() {
Collection<String> varA9D5CC32CED998FAD23DBA7A946F0A52_1257548451 =         mCapabilities.values();
        varA9D5CC32CED998FAD23DBA7A946F0A52_1257548451.addTaint(taint);
        return varA9D5CC32CED998FAD23DBA7A946F0A52_1257548451;
        // ---------- Original Method ----------
        //return mCapabilities.values();
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.043 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "82FC49E0AD4BB19E83A5647EA4ABAC03")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1557744946 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_31467561 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_31467561;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.044 -0400", hash_original_method = "A28D232247661B92586D4FEECBA4E0AF", hash_generated_method = "F45776D92DA2E001F9F6A0C06E9D1229")
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        boolean firstTime = true;
for(Entry<Integer, String> entry : mCapabilities.entrySet())
        {
            if(firstTime)            
            {
                firstTime = false;
            } //End block
            else
            {
                sb.append(",");
            } //End block
            sb.append(entry.getKey());
            sb.append(":\"");
            sb.append(entry.getValue());
            sb.append("\"");
String varB81791AD4C0CC7315217B28EB62F0F84_1954671017 =             mCapabilities.toString();
            varB81791AD4C0CC7315217B28EB62F0F84_1954671017.addTaint(taint);
            return varB81791AD4C0CC7315217B28EB62F0F84_1954671017;
        } //End block
String var2460B846747F8B22185AD8BE722266A5_319784191 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_319784191.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_319784191;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder();
        //sb.append("{");
        //boolean firstTime = true;
        //for (Entry<Integer, String> entry : mCapabilities.entrySet()) {
            //if (firstTime) {
                //firstTime = false;
            //} else {
                //sb.append(",");
            //}
            //sb.append(entry.getKey());
            //sb.append(":\"");
            //sb.append(entry.getValue());
            //sb.append("\"");
            //return mCapabilities.toString();
        //}
        //return sb.toString();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.044 -0400", hash_original_method = "76DC40F01B1B28CF1F7E32C3EB72CACA", hash_generated_method = "EEE80439C2F30A8173E08E018B634E5E")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeInt(mCapabilities.size());
for(Entry<Integer, String> entry : mCapabilities.entrySet())
        {
            dest.writeInt(entry.getKey().intValue());
            dest.writeString(entry.getValue());
        } //End block
        // ---------- Original Method ----------
        //dest.writeInt(mCapabilities.size());
        //for (Entry<Integer, String> entry : mCapabilities.entrySet()) {
            //dest.writeInt(entry.getKey().intValue());
            //dest.writeString(entry.getValue());
        //}
    }

    
    @DSModeled(DSC.BAN)
    protected static void log(String s) {
        Log.d(TAG, s);
    }

    
    public static final class Key {
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.045 -0400", hash_original_method = "63943B74C3B7537BF21BF313857C8294", hash_generated_method = "9111A328D08351EAFE3972B5E48A468B")
        private  Key() {
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.045 -0400", hash_original_field = "31D9B8593143FF77B1D3FDBE79892069", hash_generated_field = "55E505A35A68C51C32DD8BDD97ADD9B0")

        public final static int RO_NETWORK_TYPE = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.045 -0400", hash_original_field = "59496ABAFABDA68B9A3521E6069B9843", hash_generated_field = "0AC1B312664003BD34F4455A13DBB769")

        public final static int RW_DESIRED_FWD_BW = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.045 -0400", hash_original_field = "1786A41AFCC43C94754E85F29EC4AFE9", hash_generated_field = "5A7787D9FED23FFC9069D08E91F0338D")

        public final static int RW_REQUIRED_FWD_BW = 3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.045 -0400", hash_original_field = "4159A771D99F93BFB7EB19BBA0A1C069", hash_generated_field = "EADE11CE71524B0FCE546A4CC13C6539")

        public final static int RO_AVAILABLE_FWD_BW = 4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.046 -0400", hash_original_field = "C691AF94B98E7E63B0E0706F0B5618CC", hash_generated_field = "798ECDF7ACC28C0C80BB118D4F98C9EC")

        public final static int RW_DESIRED_REV_BW = 5;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.046 -0400", hash_original_field = "B09901875D028D3F0F9F03962346F827", hash_generated_field = "3BF306EE2F96FDA154DD648A809061BD")

        public final static int RW_REQUIRED_REV_BW = 6;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.046 -0400", hash_original_field = "0DDB381AEE639068E7AAC58CE0E83052", hash_generated_field = "A720D19B3CCA6FE85AE8128876ACAD59")

        public final static int RO_AVAILABLE_REV_BW = 7;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.046 -0400", hash_original_field = "F5C72913DF74CAD9000CCEC5C70F8F77", hash_generated_field = "3F33F0C47B54048BC0FC0B3A88D0EEEB")

        public final static int RW_MAX_ALLOWED_LATENCY = 8;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.046 -0400", hash_original_field = "D03612416093DFEC707AC15E383B3088", hash_generated_field = "3477642B3F38F4F32B7F16C1F5E19DC2")

        public final static int RO_BOUND_INTERFACE = 9;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.046 -0400", hash_original_field = "69D753F6C8B75BB343D44AB1904F7C9E", hash_generated_field = "7C84ACC0DE5244183CCDA7A00856BD83")

        public final static int RO_PHYSICAL_INTERFACE = 10;
    }


    
    public static final class Role {
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.046 -0400", hash_original_method = "B6871343D9E854D112856D815CFF5530", hash_generated_method = "78F599F7713B91E62A6511F5FC9496CD")
        private  Role() {
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.047 -0400", hash_original_field = "9BC1C40E9686713042CC90D9C1CF2549", hash_generated_field = "F63B5D132462C904C78266EF26BFF05F")

        public static final String DEFAULT = "default";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.047 -0400", hash_original_field = "EA7BB0CB41452D90D7D5EDBE2973212D", hash_generated_field = "96A741C4F469B69BA10EEB799EC008A3")

        public static final String BULK_DOWNLOAD = "bulk.download";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.047 -0400", hash_original_field = "1465C6A37B219587B64CDB64D5140CF9", hash_generated_field = "34F02A32AB1949293FE186C9597A3656")

        public static final String BULK_UPLOAD = "bulk.upload";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.047 -0400", hash_original_field = "4369238233371A31849D5B0A186DB1EC", hash_generated_field = "9A988D14E1E791EC8457542EBF469B81")

        public static final String VOIP_24KBPS = "voip.24k";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.047 -0400", hash_original_field = "053A1E02F00A659703BC09867238E7E7", hash_generated_field = "B7A966A9B689435B48F84A7562F005E9")

        public static final String VOIP_32KBPS = "voip.32k";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.047 -0400", hash_original_field = "D6C3D6A3A16E909D238EC7C1BBF95785", hash_generated_field = "0D56ABC4CDA6FD96229C5B44A6DB3E3E")

        public static final String VIDEO_STREAMING_480P = "video.streaming.480p";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.047 -0400", hash_original_field = "ACA5F2ABB47789B99BC9A285FB9603A4", hash_generated_field = "01E2D3B0EF6C11725E1E1DCE9732A07A")

        public static final String VIDEO_STREAMING_720I = "video.streaming.720i";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.047 -0400", hash_original_field = "172B9F5B65B13181CAAA1DF8E25F38BB", hash_generated_field = "2BCCE7D924690F2A06AFF84D40F83D67")

        public static final String VIDEO_CHAT_360P = "video.chat.360p";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.047 -0400", hash_original_field = "F9663989360BDA4185C55D7735D8DD0E", hash_generated_field = "8DECC40EEE8A771AAC08864DDB2E0C94")

        public static final String VIDEO_CHAT_480P = "video.chat.480i";
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.047 -0400", hash_original_field = "21751F54B4817BF046E75DDB1848AC16", hash_generated_field = "EDE6D4D524232007B357204761FD3C7F")

    private static final String TAG = "LinkCapabilities";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.047 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.047 -0400", hash_original_field = "C032CB84B2CEFE05F1B0EAA754FB9455", hash_generated_field = "844C01C5C8649D904242274D94DCF977")

    public static final Creator<LinkCapabilities> CREATOR =
        new Creator<LinkCapabilities>() {
            public LinkCapabilities createFromParcel(Parcel in) {
                LinkCapabilities capabilities = new LinkCapabilities();
                int size = in.readInt();
                while (size-- != 0) {
                    int key = in.readInt();
                    String value = in.readString();
                    capabilities.mCapabilities.put(key, value);
                }
                return capabilities;
            }

            public LinkCapabilities[] newArray(int size) {
                return new LinkCapabilities[size];
            }
        };
    // orphaned legacy method
    public LinkCapabilities createFromParcel(Parcel in) {
                LinkCapabilities capabilities = new LinkCapabilities();
                int size = in.readInt();
                while (size-- != 0) {
                    int key = in.readInt();
                    String value = in.readString();
                    capabilities.mCapabilities.put(key, value);
                }
                return capabilities;
            }
    
    // orphaned legacy method
    public LinkCapabilities[] newArray(int size) {
                return new LinkCapabilities[size];
            }
    
}

