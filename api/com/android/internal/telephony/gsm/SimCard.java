package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.annotations.*;
import com.android.internal.telephony.IccCard;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.PhoneBase;



public final class SimCard extends IccCard {
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.598 -0400", hash_original_method = "9F0A913CCE42D6EF6B4C91409D578CD8", hash_generated_method = "E25EF2305E16493FEED7AFF13A2CBF9E")
      SimCard(GSMPhone phone) {
        super(phone, "GSM", true);
        addTaint(phone.getTaint());
        mPhone.mCM.registerForSIMLockedOrAbsent(mHandler, EVENT_ICC_LOCKED_OR_ABSENT, null);
        mPhone.mCM.registerForOffOrNotAvailable(mHandler, EVENT_RADIO_OFF_OR_NOT_AVAILABLE, null);
        mPhone.mCM.registerForSIMReady(mHandler, EVENT_ICC_READY, null);
        updateStateProperty();
        // ---------- Original Method ----------
        //mPhone.mCM.registerForSIMLockedOrAbsent(mHandler, EVENT_ICC_LOCKED_OR_ABSENT, null);
        //mPhone.mCM.registerForOffOrNotAvailable(mHandler, EVENT_RADIO_OFF_OR_NOT_AVAILABLE, null);
        //mPhone.mCM.registerForSIMReady(mHandler, EVENT_ICC_READY, null);
        //updateStateProperty();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.598 -0400", hash_original_method = "7954DCD4B4ED180767A5CCD973B61DEE", hash_generated_method = "5C360F8FF9E8A587A4CD0F3E42CB25C0")
    public  SimCard(PhoneBase phone, String logTag, Boolean dbg) {
        super(phone, logTag, dbg);
        addTaint(dbg.getTaint());
        addTaint(logTag.getTaint());
        addTaint(phone.getTaint());
        mPhone.mCM.registerForSIMLockedOrAbsent(mHandler, EVENT_ICC_LOCKED_OR_ABSENT, null);
        mPhone.mCM.registerForOffOrNotAvailable(mHandler, EVENT_RADIO_OFF_OR_NOT_AVAILABLE, null);
        mPhone.mCM.registerForSIMReady(mHandler, EVENT_ICC_READY, null);
        updateStateProperty();
        if(mPhone.getLteOnCdmaMode() == Phone.LTE_ON_CDMA_TRUE)        
        {
            mPhone.mCM.registerForIccStatusChanged(mHandler, EVENT_ICC_LOCKED_OR_ABSENT, null);
        } //End block
        // ---------- Original Method ----------
        //mPhone.mCM.registerForSIMLockedOrAbsent(mHandler, EVENT_ICC_LOCKED_OR_ABSENT, null);
        //mPhone.mCM.registerForOffOrNotAvailable(mHandler, EVENT_RADIO_OFF_OR_NOT_AVAILABLE, null);
        //mPhone.mCM.registerForSIMReady(mHandler, EVENT_ICC_READY, null);
        //updateStateProperty();
        //if(mPhone.getLteOnCdmaMode() == Phone.LTE_ON_CDMA_TRUE) {
            //mPhone.mCM.registerForIccStatusChanged(mHandler, EVENT_ICC_LOCKED_OR_ABSENT, null);
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.598 -0400", hash_original_method = "C4D53CA88AF6F553E502BD318EED734B", hash_generated_method = "5448EE44A49A8ECE6650A927624E0BCE")
    @Override
    public void dispose() {
        super.dispose();
        mPhone.mCM.unregisterForSIMLockedOrAbsent(mHandler);
        mPhone.mCM.unregisterForOffOrNotAvailable(mHandler);
        mPhone.mCM.unregisterForSIMReady(mHandler);
        if(mPhone.getLteOnCdmaMode() == Phone.LTE_ON_CDMA_TRUE)        
        {
            mPhone.mCM.unregisterForIccStatusChanged(mHandler);
        } //End block
        // ---------- Original Method ----------
        //super.dispose();
        //mPhone.mCM.unregisterForSIMLockedOrAbsent(mHandler);
        //mPhone.mCM.unregisterForOffOrNotAvailable(mHandler);
        //mPhone.mCM.unregisterForSIMReady(mHandler);
        //if(mPhone.getLteOnCdmaMode() == Phone.LTE_ON_CDMA_TRUE) {
            //mPhone.mCM.unregisterForIccStatusChanged(mHandler);
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.598 -0400", hash_original_method = "9DB5C3DD2D46DFBEACD42980054AFF5F", hash_generated_method = "D4898870D0FE9735CE4BC3DE3168166B")
    @Override
    public String getServiceProviderName() {
String var7F74CA4F27DBD97ED17E538302BDEBEB_491117428 =         mPhone.mIccRecords.getServiceProviderName();
        var7F74CA4F27DBD97ED17E538302BDEBEB_491117428.addTaint(taint);
        return var7F74CA4F27DBD97ED17E538302BDEBEB_491117428;
        // ---------- Original Method ----------
        //return mPhone.mIccRecords.getServiceProviderName();
    }

    
}

