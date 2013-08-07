package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.List;

import com.android.internal.telephony.Call;
import com.android.internal.telephony.CallStateException;
import com.android.internal.telephony.Connection;
import com.android.internal.telephony.DriverCall;
import com.android.internal.telephony.Phone;






public final class CdmaCall extends Call {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.080 -0400", hash_original_field = "EC0FEA7E6F8E16E3471486B698ED3A9D", hash_generated_field = "2814A276BAC6C190BAEC9128FA3036E9")

    ArrayList<Connection> connections = new ArrayList<Connection>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.080 -0400", hash_original_field = "1A5BE9871FF7E0AB5805D64E8617FA11", hash_generated_field = "B9A7F7508B0B5FA0BFE8695446A61CF7")

    State state = State.IDLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.080 -0400", hash_original_field = "72122CE96BFEC66E2396D2E25225D70A", hash_generated_field = "3927F28CE0F1F17A9255E7EFC415C1BF")

    CdmaCallTracker owner;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.080 -0400", hash_original_method = "D729656758C665C5D95A9ED02FF27E98", hash_generated_method = "9420100303E5D0809E6EDE6F78536020")
      CdmaCall(CdmaCallTracker owner) {
        this.owner = owner;
        // ---------- Original Method ----------
        //this.owner = owner;
    }

    
    static State stateFromDCState(DriverCall.State dcState) {
        switch (dcState) {
            case ACTIVE:        return State.ACTIVE;
            case HOLDING:       return State.HOLDING;
            case DIALING:       return State.DIALING;
            case ALERTING:      return State.ALERTING;
            case INCOMING:      return State.INCOMING;
            case WAITING:       return State.WAITING;
            default:            throw new RuntimeException ("illegal call state:" + dcState);
        }
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.080 -0400", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "614D737B8CBDA53A99A22331B445C19D")
    public void dispose() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.081 -0400", hash_original_method = "DA46D72C53A8C0722B0E4038E55B8A9F", hash_generated_method = "7CAB79B635E0F4A9293F62F48742E6F1")
    public List<Connection> getConnections() {
List<Connection> varD8B91E18CFFE05D77A84C03EDA812BE2_333898000 =         connections;
        varD8B91E18CFFE05D77A84C03EDA812BE2_333898000.addTaint(taint);
        return varD8B91E18CFFE05D77A84C03EDA812BE2_333898000;
        // ---------- Original Method ----------
        //return connections;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.081 -0400", hash_original_method = "83A2E3FFD7B88E291F9EB06E3105AC3A", hash_generated_method = "9A34919E7FCBCEA972F3393C190AFBFA")
    public State getState() {
State var37C56C9D63C623261861C16DCFB73F6D_1111136121 =         state;
        var37C56C9D63C623261861C16DCFB73F6D_1111136121.addTaint(taint);
        return var37C56C9D63C623261861C16DCFB73F6D_1111136121;
        // ---------- Original Method ----------
        //return state;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.081 -0400", hash_original_method = "3D84383237FBED33FD2CE3B737BA6B20", hash_generated_method = "E948FE17A58ECA45D60A2429DE09172D")
    public Phone getPhone() {
Phone var184C3BF9D73535588B22D3939CD1F578_13250576 =         owner.phone;
        var184C3BF9D73535588B22D3939CD1F578_13250576.addTaint(taint);
        return var184C3BF9D73535588B22D3939CD1F578_13250576;
        // ---------- Original Method ----------
        //return owner.phone;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.081 -0400", hash_original_method = "E944BDEAA6C46A001782606E74F9EFB0", hash_generated_method = "CD08C63E4380DCE6B1CAA8146B4C15C9")
    public boolean isMultiparty() {
        boolean var29D4E14E3A46A0A5CCEDD95593D030FA_767816854 = (connections.size() > 1);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_539103410 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_539103410;
        // ---------- Original Method ----------
        //return connections.size() > 1;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.081 -0400", hash_original_method = "BD4623110C086A165B3AF83FA1BCBA34", hash_generated_method = "5E905B16961B21B9CFA064E867BE77FF")
    public void hangup() throws CallStateException {
        owner.hangup(this);
        // ---------- Original Method ----------
        //owner.hangup(this);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.081 -0400", hash_original_method = "A7B99D81B12619E0B5BB79286D622078", hash_generated_method = "FF5F69B8785D54952CE09EEF877389DE")
    public String toString() {
String var03910CD76C0E5BA32DFF47134AABAD32_1641876489 =         state.toString();
        var03910CD76C0E5BA32DFF47134AABAD32_1641876489.addTaint(taint);
        return var03910CD76C0E5BA32DFF47134AABAD32_1641876489;
        // ---------- Original Method ----------
        //return state.toString();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.081 -0400", hash_original_method = "ADEE6A90086841672D212D83F619D5B4", hash_generated_method = "22AAC99E45C90029960E2F69AB5EA92D")
     void attach(Connection conn, DriverCall dc) {
        addTaint(conn.getTaint());
        connections.add(conn);
        state = stateFromDCState (dc.state);
        // ---------- Original Method ----------
        //connections.add(conn);
        //state = stateFromDCState (dc.state);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.081 -0400", hash_original_method = "1D150B86FE35D9DF33C56E5123257F96", hash_generated_method = "F17A54287702BEEEEE53D672240B962B")
     void attachFake(Connection conn, State state) {
        addTaint(conn.getTaint());
        connections.add(conn);
        this.state = state;
        // ---------- Original Method ----------
        //connections.add(conn);
        //this.state = state;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.082 -0400", hash_original_method = "A46A7B47E3DFA1A951D01F8316BDCB63", hash_generated_method = "F67D8A925EEEA797937A43631E35B78D")
     void connectionDisconnected(CdmaConnection conn) {
        addTaint(conn.getTaint());
        if(state != State.DISCONNECTED)        
        {
            boolean hasOnlyDisconnectedConnections = true;
for(int i = 0, s = connections.size();i < s;i ++)
            {
                if(connections.get(i).getState()
                    != State.DISCONNECTED)                
                {
                    hasOnlyDisconnectedConnections = false;
                    break;
                } //End block
            } //End block
            if(hasOnlyDisconnectedConnections)            
            {
                state = State.DISCONNECTED;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (state != State.DISCONNECTED) {
            //boolean hasOnlyDisconnectedConnections = true;
            //for (int i = 0, s = connections.size()  ; i < s; i ++) {
                //if (connections.get(i).getState()
                    //!= State.DISCONNECTED
                //) {
                    //hasOnlyDisconnectedConnections = false;
                    //break;
                //}
            //}
            //if (hasOnlyDisconnectedConnections) {
                //state = State.DISCONNECTED;
            //}
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.082 -0400", hash_original_method = "1EA8F68D5A466EEC41832970B917D4DC", hash_generated_method = "B2350A40156F2BD9101E3397A3AFED70")
     void detach(CdmaConnection conn) {
        addTaint(conn.getTaint());
        connections.remove(conn);
        if(connections.size() == 0)        
        {
            state = State.IDLE;
        } //End block
        // ---------- Original Method ----------
        //connections.remove(conn);
        //if (connections.size() == 0) {
            //state = State.IDLE;
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.082 -0400", hash_original_method = "653CAD94409C4BC1F3DC33028F34238B", hash_generated_method = "902C156DD1E5CC91BAB5D8038F83B5B0")
     boolean update(CdmaConnection conn, DriverCall dc) {
        addTaint(dc.getTaint());
        addTaint(conn.getTaint());
        State newState;
        boolean changed = false;
        newState = stateFromDCState(dc.state);
        if(newState != state)        
        {
            state = newState;
            changed = true;
        } //End block
        boolean var8977DFAC2F8E04CB96E66882235F5ABA_844865314 = (changed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1973321406 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1973321406;
        // ---------- Original Method ----------
        //State newState;
        //boolean changed = false;
        //newState = stateFromDCState(dc.state);
        //if (newState != state) {
            //state = newState;
            //changed = true;
        //}
        //return changed;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.082 -0400", hash_original_method = "1C46465CDA75E6DA5CCE62BB3DA600A6", hash_generated_method = "785C4D2073C1A453AACD5AAD5709617C")
     boolean isFull() {
        boolean var0C9294BE7F8A42493544D3634F51C6C1_1263090488 = (connections.size() == CdmaCallTracker.MAX_CONNECTIONS_PER_CALL);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1128066983 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1128066983;
        // ---------- Original Method ----------
        //return connections.size() == CdmaCallTracker.MAX_CONNECTIONS_PER_CALL;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.082 -0400", hash_original_method = "A6EB616B9F71A14D95ECE60CFCB290DD", hash_generated_method = "BCE23747EA4487F06E6D73081A19303C")
     void onHangupLocal() {
        //DSFIXME:  CODE0009: Possible callback target function detected
for(int i = 0, s = connections.size();i < s;i++)
        {
            CdmaConnection cn = (CdmaConnection)connections.get(i);
            cn.onHangupLocal();
        } //End block
        state = State.DISCONNECTING;
        // ---------- Original Method ----------
        //for (int i = 0, s = connections.size(); i < s; i++) {
            //CdmaConnection cn = (CdmaConnection)connections.get(i);
            //cn.onHangupLocal();
        //}
        //state = State.DISCONNECTING;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.083 -0400", hash_original_method = "C72D64DE5C06A555CE5E29E3236A56AC", hash_generated_method = "521F7300810B1FFBDD639FC4813AC6F5")
     void clearDisconnected() {
for(int i = connections.size() - 1;i >= 0;i--)
        {
            CdmaConnection cn = (CdmaConnection)connections.get(i);
            if(cn.getState() == State.DISCONNECTED)            
            {
                connections.remove(i);
            } //End block
        } //End block
        if(connections.size() == 0)        
        {
            state = State.IDLE;
        } //End block
        // ---------- Original Method ----------
        //for (int i = connections.size() - 1 ; i >= 0 ; i--) {
        //CdmaConnection cn = (CdmaConnection)connections.get(i);
            //if (cn.getState() == State.DISCONNECTED) {
                //connections.remove(i);
            //}
        //}
        //if (connections.size() == 0) {
            //state = State.IDLE;
        //}
    }

    
}

