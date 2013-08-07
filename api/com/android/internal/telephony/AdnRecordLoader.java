package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.ArrayList;

import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;
import android.util.Log;





public class AdnRecordLoader extends Handler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.725 -0400", hash_original_field = "F7A42FE7211F98AC7A60A285AC3A9E87", hash_generated_field = "4D74BFF297E0DF8FA98FF6D8A8DBA78C")

    PhoneBase phone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.726 -0400", hash_original_field = "FEB78CC258BDC76867354F01C22DBE43", hash_generated_field = "036ADE2862D2A42E9D25EBB639B81422")

    int ef;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.726 -0400", hash_original_field = "D8E3DC447ACBE488908DF601D2648CC9", hash_generated_field = "1F822E6940DDE842720B0C7DA6C46B62")

    int extensionEF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.726 -0400", hash_original_field = "B7D07153F471E6227FBC2A1DBF1B7D46", hash_generated_field = "21A6C1E891AA9C60FA5155604EF98417")

    int pendingExtLoads;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.726 -0400", hash_original_field = "7CD68A12689ED678E4F02DF5FF6F0C49", hash_generated_field = "04812594E45CC9AEFCC2441E721F5447")

    Message userResponse;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.726 -0400", hash_original_field = "1CE8F9C8C598A33E655651C0899EF7BC", hash_generated_field = "247B791A35A84ACFB3A5BD453F069E1B")

    String pin2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.726 -0400", hash_original_field = "94FFE9B9C5894C1D45DFC612B295C53B", hash_generated_field = "23F79AC71281FC94187158A5D1BA833B")

    int recordNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.726 -0400", hash_original_field = "62FEAEB3DF20337E3D35BAB4C7D3C6B1", hash_generated_field = "78DD856F69213B918116896C99742E98")

    ArrayList<AdnRecord> adns;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.726 -0400", hash_original_field = "B4A88417B3D0170D754C647C30B7216A", hash_generated_field = "BCA77D12632DFCDF9A8AEB56A649B3D3")

    Object result;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.727 -0400", hash_original_method = "042ECF1C251BBED01DD567DA5D6FB1BE", hash_generated_method = "6F0F0DBFBFB3D86988DB1CAD42996FED")
    public  AdnRecordLoader(PhoneBase phone) {
        super(phone.getHandler().getLooper());
        this.phone = phone;
        LOG_TAG = phone.getPhoneName();
        // ---------- Original Method ----------
        //this.phone = phone;
        //LOG_TAG = phone.getPhoneName();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.728 -0400", hash_original_method = "E52409147EA4C18E8F78BAF12B808BF8", hash_generated_method = "6EB46D6941E8B29BDE235893777C0E24")
    public void loadFromEF(int ef, int extensionEF, int recordNumber,
                Message response) {
        this.ef = ef;
        this.extensionEF = extensionEF;
        this.recordNumber = recordNumber;
        this.userResponse = response;
        phone.mIccFileHandler.loadEFLinearFixed(
                    ef, recordNumber,
                    obtainMessage(EVENT_ADN_LOAD_DONE));
        // ---------- Original Method ----------
        //this.ef = ef;
        //this.extensionEF = extensionEF;
        //this.recordNumber = recordNumber;
        //this.userResponse = response;
        //phone.mIccFileHandler.loadEFLinearFixed(
                    //ef, recordNumber,
                    //obtainMessage(EVENT_ADN_LOAD_DONE));
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.729 -0400", hash_original_method = "3B75C101082AA8B5F76E21C5AC0D856A", hash_generated_method = "DF4256CB7896A805A14912C7FC61BE58")
    public void loadAllFromEF(int ef, int extensionEF,
                Message response) {
        this.ef = ef;
        this.extensionEF = extensionEF;
        this.userResponse = response;
        phone.mIccFileHandler.loadEFLinearFixedAll(
                    ef,
                    obtainMessage(EVENT_ADN_LOAD_ALL_DONE));
        // ---------- Original Method ----------
        //this.ef = ef;
        //this.extensionEF = extensionEF;
        //this.userResponse = response;
        //phone.mIccFileHandler.loadEFLinearFixedAll(
                    //ef,
                    //obtainMessage(EVENT_ADN_LOAD_ALL_DONE));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.730 -0400", hash_original_method = "A04989E1C9551E085CB246E835FB8373", hash_generated_method = "3EFD12197E50765767820BE5C0393231")
    public void updateEF(AdnRecord adn, int ef, int extensionEF, int recordNumber,
            String pin2, Message response) {
        addTaint(adn.getTaint());
        this.ef = ef;
        this.extensionEF = extensionEF;
        this.recordNumber = recordNumber;
        this.userResponse = response;
        this.pin2 = pin2;
        phone.mIccFileHandler.getEFLinearRecordSize( ef,
            obtainMessage(EVENT_EF_LINEAR_RECORD_SIZE_DONE, adn));
        // ---------- Original Method ----------
        //this.ef = ef;
        //this.extensionEF = extensionEF;
        //this.recordNumber = recordNumber;
        //this.userResponse = response;
        //this.pin2 = pin2;
        //phone.mIccFileHandler.getEFLinearRecordSize( ef,
            //obtainMessage(EVENT_EF_LINEAR_RECORD_SIZE_DONE, adn));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.942 -0400", hash_original_method = "051E5CCA6123D268EF8D870B0A4015BF", hash_generated_method = "D203082359F8A9344CCE49F007948BBA")
    public void handleMessage(Message msg) {
        addTaint(msg.getTaint());
        AsyncResult ar;
        byte data[];
        AdnRecord adn;
        try 
        {
switch(msg.what){
            case EVENT_EF_LINEAR_RECORD_SIZE_DONE:
            ar = (AsyncResult)(msg.obj);
            adn = (AdnRecord)(ar.userObj);
            if(ar.exception != null)            
            {
                RuntimeException varC51911099FA91E04721D7BDC774E1027_1944077781 = new RuntimeException("get EF record size failed",
                                ar.exception);
                varC51911099FA91E04721D7BDC774E1027_1944077781.addTaint(taint);
                throw varC51911099FA91E04721D7BDC774E1027_1944077781;
            } //End block
            int[] recordSize = (int[])ar.result;
            if(recordSize.length != 3 || recordNumber > recordSize[2])            
            {
                RuntimeException var25AD32CD0F9A49CFFCDF53497D016656_1911409385 = new RuntimeException("get wrong EF record size format",
                                ar.exception);
                var25AD32CD0F9A49CFFCDF53497D016656_1911409385.addTaint(taint);
                throw var25AD32CD0F9A49CFFCDF53497D016656_1911409385;
            } //End block
            data = adn.buildAdnString(recordSize[0]);
            if(data == null)            
            {
                RuntimeException var0C054DA902C88BC47446B1BB25D3FD68_697714684 = new RuntimeException("wrong ADN format",
                                ar.exception);
                var0C054DA902C88BC47446B1BB25D3FD68_697714684.addTaint(taint);
                throw var0C054DA902C88BC47446B1BB25D3FD68_697714684;
            } //End block
            phone.mIccFileHandler.updateEFLinearFixed(ef, recordNumber,
                            data, pin2, obtainMessage(EVENT_UPDATE_RECORD_DONE));
            pendingExtLoads = 1;
            break;
            case EVENT_UPDATE_RECORD_DONE:
            ar = (AsyncResult)(msg.obj);
            if(ar.exception != null)            
            {
                RuntimeException var0F83784C75FD467A442A454B10CCC970_948904303 = new RuntimeException("update EF adn record failed",
                                ar.exception);
                var0F83784C75FD467A442A454B10CCC970_948904303.addTaint(taint);
                throw var0F83784C75FD467A442A454B10CCC970_948904303;
            } //End block
            pendingExtLoads = 0;
            result = null;
            break;
            case EVENT_ADN_LOAD_DONE:
            ar = (AsyncResult)(msg.obj);
            data = (byte[])(ar.result);
            if(ar.exception != null)            
            {
                RuntimeException var76F55B79A1D977F13CF67C2A3432F11F_267083500 = new RuntimeException("load failed", ar.exception);
                var76F55B79A1D977F13CF67C2A3432F11F_267083500.addTaint(taint);
                throw var76F55B79A1D977F13CF67C2A3432F11F_267083500;
            } //End block
            if(false)            
            {
                Log.d(LOG_TAG,"ADN EF: 0x"
                            + Integer.toHexString(ef)
                            + ":" + recordNumber
                            + "\n" + IccUtils.bytesToHexString(data));
            } //End block
            adn = new AdnRecord(ef, recordNumber, data);
            result = adn;
            if(adn.hasExtendedRecord())            
            {
                pendingExtLoads = 1;
                phone.mIccFileHandler.loadEFLinearFixed(
                            extensionEF, adn.extRecord,
                            obtainMessage(EVENT_EXT_RECORD_LOAD_DONE, adn));
            } //End block
            break;
            case EVENT_EXT_RECORD_LOAD_DONE:
            ar = (AsyncResult)(msg.obj);
            data = (byte[])(ar.result);
            adn = (AdnRecord)(ar.userObj);
            if(ar.exception != null)            
            {
                RuntimeException var76F55B79A1D977F13CF67C2A3432F11F_2095120782 = new RuntimeException("load failed", ar.exception);
                var76F55B79A1D977F13CF67C2A3432F11F_2095120782.addTaint(taint);
                throw var76F55B79A1D977F13CF67C2A3432F11F_2095120782;
            } //End block
            Log.d(LOG_TAG,"ADN extension EF: 0x"
                        + Integer.toHexString(extensionEF)
                        + ":" + adn.extRecord
                        + "\n" + IccUtils.bytesToHexString(data));
            adn.appendExtRecord(data);
            pendingExtLoads--;
            break;
            case EVENT_ADN_LOAD_ALL_DONE:
            ar = (AsyncResult)(msg.obj);
            ArrayList<byte[]> datas = (ArrayList<byte[]>)(ar.result);
            if(ar.exception != null)            
            {
                RuntimeException var76F55B79A1D977F13CF67C2A3432F11F_859888215 = new RuntimeException("load failed", ar.exception);
                var76F55B79A1D977F13CF67C2A3432F11F_859888215.addTaint(taint);
                throw var76F55B79A1D977F13CF67C2A3432F11F_859888215;
            } //End block
            adns = new ArrayList<AdnRecord>(datas.size());
            result = adns;
            pendingExtLoads = 0;
for(int i = 0, s = datas.size();i < s;i++)
            {
                adn = new AdnRecord(ef, 1 + i, datas.get(i));
                adns.add(adn);
                if(adn.hasExtendedRecord())                
                {
                    pendingExtLoads++;
                    phone.mIccFileHandler.loadEFLinearFixed(
                                extensionEF, adn.extRecord,
                                obtainMessage(EVENT_EXT_RECORD_LOAD_DONE, adn));
                } //End block
            } //End block
            break;
}
        } //End block
        catch (RuntimeException exc)
        {
            if(userResponse != null)            
            {
                AsyncResult.forMessage(userResponse)
                                .exception = exc;
                userResponse.sendToTarget();
                userResponse = null;
            } //End block
            return;
        } //End block
        if(userResponse != null && pendingExtLoads == 0)        
        {
            AsyncResult.forMessage(userResponse).result
                = result;
            userResponse.sendToTarget();
            userResponse = null;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.943 -0400", hash_original_field = "E352FA068E2A15ACE6EF763778B80C2C", hash_generated_field = "17A3362C3349AC144D451B5CA8B78324")

    static String LOG_TAG;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.943 -0400", hash_original_field = "C34EBD8BE313D3F515534EF218F0270F", hash_generated_field = "6C4F2B2823554C1D8FB27E13A8A823B4")

    static final int EVENT_ADN_LOAD_DONE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.943 -0400", hash_original_field = "6BDC27EFB296ABEEC5CB5DDE25669728", hash_generated_field = "E558B4E6E15486F9756108AEB9A85B6E")

    static final int EVENT_EXT_RECORD_LOAD_DONE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.943 -0400", hash_original_field = "D93A812DE5DF1B1B3326089AAE00BD42", hash_generated_field = "877794DC8B76A5511EB8F1B4B7465CD6")

    static final int EVENT_ADN_LOAD_ALL_DONE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.943 -0400", hash_original_field = "7E129EB068D22E1546E4794922C7F231", hash_generated_field = "E3DB2F84D66B5CCEB103F156F258C13F")

    static final int EVENT_EF_LINEAR_RECORD_SIZE_DONE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.943 -0400", hash_original_field = "B3962F33DF711CD7D3C2F19D39D3F6D8", hash_generated_field = "16AB62374737D17C58E4C93E27895A01")

    static final int EVENT_UPDATE_RECORD_DONE = 5;
}

