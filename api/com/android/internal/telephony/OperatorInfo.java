package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;





public class OperatorInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.564 -0400", hash_original_field = "EBA1AB368B4E5EA262B356E9FEB5DBFF", hash_generated_field = "F0150DE98C56463E8FBA5168FF9D36D5")

    private String operatorAlphaLong;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.564 -0400", hash_original_field = "A5CE4261E3685149463BEBC361CCAE61", hash_generated_field = "DAF789E03D68464206271876E158DD07")

    private String operatorAlphaShort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.564 -0400", hash_original_field = "283D783309AC858AFD001B18F5F912C5", hash_generated_field = "F850CA9B7337FD15ABEEE29EB55D046F")

    private String operatorNumeric;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.564 -0400", hash_original_field = "6EB48CFDD43F97FA1C757559C440D695", hash_generated_field = "8632897B42EA54355D7D05C4187E6C0B")

    private State state = State.UNKNOWN;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.565 -0400", hash_original_method = "4475B64A2C44E2D075CC5ECE1CB355AC", hash_generated_method = "DD36DA18EB148E635450102FC6720221")
      OperatorInfo(String operatorAlphaLong,
                String operatorAlphaShort,
                String operatorNumeric,
                State state) {
        this.operatorAlphaLong = operatorAlphaLong;
        this.operatorAlphaShort = operatorAlphaShort;
        this.operatorNumeric = operatorNumeric;
        this.state = state;
        // ---------- Original Method ----------
        //this.operatorAlphaLong = operatorAlphaLong;
        //this.operatorAlphaShort = operatorAlphaShort;
        //this.operatorNumeric = operatorNumeric;
        //this.state = state;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.565 -0400", hash_original_method = "22D6EAAD8ACDCB5BD2588D137EBB558E", hash_generated_method = "4E2B322581FF7B98591959B7B4F2C6F3")
    public  OperatorInfo(String operatorAlphaLong,
                String operatorAlphaShort,
                String operatorNumeric,
                String stateString) {
        this (operatorAlphaLong, operatorAlphaShort,
                operatorNumeric, rilStateToState(stateString));
        addTaint(stateString.getTaint());
        addTaint(operatorNumeric.getTaint());
        addTaint(operatorAlphaShort.getTaint());
        addTaint(operatorAlphaLong.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.565 -0400", hash_original_method = "B51FA3C3765E71F08A241B1C8BA79C96", hash_generated_method = "C25EE716BAABB1F8B352B40A08706005")
    public String getOperatorAlphaLong() {
String var1B7C97A61CBCC0846D213DF60C49D4F5_752212390 =         operatorAlphaLong;
        var1B7C97A61CBCC0846D213DF60C49D4F5_752212390.addTaint(taint);
        return var1B7C97A61CBCC0846D213DF60C49D4F5_752212390;
        // ---------- Original Method ----------
        //return operatorAlphaLong;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.566 -0400", hash_original_method = "A8269EAEF0CA69A19C2F3D33BBF8152B", hash_generated_method = "519D6817D0CE5F4D97CE621BE864A2D2")
    public String getOperatorAlphaShort() {
String varCD7C131ECB0CB94030B0581F1C3C360A_331548981 =         operatorAlphaShort;
        varCD7C131ECB0CB94030B0581F1C3C360A_331548981.addTaint(taint);
        return varCD7C131ECB0CB94030B0581F1C3C360A_331548981;
        // ---------- Original Method ----------
        //return operatorAlphaShort;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.566 -0400", hash_original_method = "06DBB2F851A1F540C7CE21639E1F11FC", hash_generated_method = "921C933273BF8B06A2CDB6410FC3983B")
    public String getOperatorNumeric() {
String var2910E34F66A87ACEB979401752EFC981_681973430 =         operatorNumeric;
        var2910E34F66A87ACEB979401752EFC981_681973430.addTaint(taint);
        return var2910E34F66A87ACEB979401752EFC981_681973430;
        // ---------- Original Method ----------
        //return operatorNumeric;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.566 -0400", hash_original_method = "83A2E3FFD7B88E291F9EB06E3105AC3A", hash_generated_method = "7AEE7F5EF72B34CCF2700C9A38F44A06")
    public State getState() {
State var37C56C9D63C623261861C16DCFB73F6D_1892963017 =         state;
        var37C56C9D63C623261861C16DCFB73F6D_1892963017.addTaint(taint);
        return var37C56C9D63C623261861C16DCFB73F6D_1892963017;
        // ---------- Original Method ----------
        //return state;
    }

    
    @DSModeled(DSC.BAN)
    private static State rilStateToState(String s) {
        if (s.equals("unknown")) {
            return State.UNKNOWN;
        } else if (s.equals("available")) {
            return State.AVAILABLE;
        } else if (s.equals("current")) {
            return State.CURRENT;
        } else if (s.equals("forbidden")) {
            return State.FORBIDDEN;
        } else {
            throw new RuntimeException(
                "RIL impl error: Invalid network state '" + s + "'");
        }
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.567 -0400", hash_original_method = "3A69A53B1D569DD83E423933B58E91F0", hash_generated_method = "B062EC4DCBAC75F8D31B78F077CE9574")
    public String toString() {
String varDA2EAB669D8286E1B66AAEFC8A7FAD34_1571873580 =         "OperatorInfo " + operatorAlphaLong
                + "/" + operatorAlphaShort
                + "/" + operatorNumeric
                + "/" + state;
        varDA2EAB669D8286E1B66AAEFC8A7FAD34_1571873580.addTaint(taint);
        return varDA2EAB669D8286E1B66AAEFC8A7FAD34_1571873580;
        // ---------- Original Method ----------
        //return "OperatorInfo " + operatorAlphaLong
                //+ "/" + operatorAlphaShort
                //+ "/" + operatorNumeric
                //+ "/" + state;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.568 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "6059816D6E613AE40005E2CBF1A9B7B8")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1500285604 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_382368844 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_382368844;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.568 -0400", hash_original_method = "8E3E997094B6FE23C6A87821AE0A248F", hash_generated_method = "7091B2FA9F94DC2EBEAFD0AE58264B69")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeString(operatorAlphaLong);
        dest.writeString(operatorAlphaShort);
        dest.writeString(operatorNumeric);
        dest.writeSerializable(state);
        // ---------- Original Method ----------
        //dest.writeString(operatorAlphaLong);
        //dest.writeString(operatorAlphaShort);
        //dest.writeString(operatorNumeric);
        //dest.writeSerializable(state);
    }

    
    public enum State {
        UNKNOWN,
        AVAILABLE,
        CURRENT,
        FORBIDDEN;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.569 -0400", hash_original_field = "CE4D84BB5D80D6F1E7F23127D57FA1E7", hash_generated_field = "244DE5599F688C0C7CE39BEE35E6AF81")

    public static final Creator<OperatorInfo> CREATOR =
        new Creator<OperatorInfo>() {
            public OperatorInfo createFromParcel(Parcel in) {
                OperatorInfo opInfo = new OperatorInfo(
                        in.readString(), 
                        in.readString(), 
                        in.readString(), 
                        (State) in.readSerializable()); 
                return opInfo;
            }

            public OperatorInfo[] newArray(int size) {
                return new OperatorInfo[size];
            }
        };
}

