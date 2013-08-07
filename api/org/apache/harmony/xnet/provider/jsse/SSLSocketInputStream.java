package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;

import javax.net.ssl.SSLException;






public final class SSLSocketInputStream extends InputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.573 -0400", hash_original_field = "2C7B13E600B37D78F94DC218F890F609", hash_generated_field = "282EEB2007797BAF8E0177A8CE143E9E")

    private byte[] buffer = new byte[BUFFER_SIZE];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.573 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.573 -0400", hash_original_field = "7F021A1415B86F2D013B2618FB31AE53", hash_generated_field = "BDD622074D0B9CD7867B17F38BB0017C")

    private int end;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.573 -0400", hash_original_field = "72122CE96BFEC66E2396D2E25225D70A", hash_generated_field = "FC855125850BB72054AAC77176B58208")

    private SSLSocketImpl owner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.573 -0400", hash_original_field = "1A80603325954C59F3C3BAF88C9E5743", hash_generated_field = "6FD517E7C88B49B968357327B10F8730")

    private boolean end_reached = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.574 -0400", hash_original_field = "8A70338F4980F5ECE771FDC59AF6CB2E", hash_generated_field = "ABB2CE89E11F7FB8542D3FE9B7058434")

    protected Adapter dataPoint = new Adapter();
    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.574 -0400", hash_original_method = "2B2DE235A31ECF6D427ED4CC1BA78F0B", hash_generated_method = "E318056FDC005244FC8100AFE22AA9B7")
    protected  SSLSocketInputStream(SSLSocketImpl owner) {
        this.owner = owner;
        // ---------- Original Method ----------
        //this.owner = owner;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.574 -0400", hash_original_method = "A09BD0FC7A641BF0B6392C48D9B80DDB", hash_generated_method = "D50BB51FAE52E72979CFB5B32761475B")
    protected void setEnd() {
        end_reached = true;
        // ---------- Original Method ----------
        //end_reached = true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.575 -0400", hash_original_method = "32329B6D4EFC7F65437C2D09A5400721", hash_generated_method = "C4BACB3691CEA4319D293E738A9A4D2D")
    @Override
    public int available() throws IOException {
        int varB3D1E05571ADC15434805329D40CF53D_552446818 = (end - pos);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2051401588 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2051401588;
        // ---------- Original Method ----------
        //return end - pos;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.575 -0400", hash_original_method = "B0B2FCB9CE6FDF4EA578715FA3754421", hash_generated_method = "94D10BF77244A202799017548290E6EF")
    @Override
    public void close() throws IOException {
        buffer = null;
        // ---------- Original Method ----------
        //buffer = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.575 -0400", hash_original_method = "92F5EAFF00040EF543528D1059933772", hash_generated_method = "608F802D2CF8EB773069D0542D84D209")
    @Override
    public int read() throws IOException {
        if(buffer == null)        
        {
            IOException varE5D4BEED6995D9749210316308C5D88E_222980671 = new IOException("Stream was closed.");
            varE5D4BEED6995D9749210316308C5D88E_222980671.addTaint(taint);
            throw varE5D4BEED6995D9749210316308C5D88E_222980671;
        } //End block
        while
(pos == end)        
        {
            if(end_reached)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_2044937908 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1270678471 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1270678471;
            } //End block
            owner.needAppData();
        } //End block
        int var61269E88D78341AD05E6AECA6FE3A7AC_1641656213 = (buffer[pos++] & 0xFF);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1611245959 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1611245959;
        // ---------- Original Method ----------
        //if (buffer == null) {
            //throw new IOException("Stream was closed.");
        //}
        //while (pos == end) {
            //if (end_reached) {
                //return -1;
            //}
            //owner.needAppData();
        //}
        //return buffer[pos++] & 0xFF;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.576 -0400", hash_original_method = "50426CF7D6642F19D28119E1D947BED8", hash_generated_method = "1B9506CF8F2021D69F3D11F4CF48D7D1")
    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        addTaint(len);
        addTaint(off);
        addTaint(b[0]);
        int read_b;
        int i = 0;
        do {
            {
                if((read_b = read()) == -1)                
                {
                    int var9094914C036467CD32E9F7E210E518F4_712538442 = ((i == 0) ? -1 : i);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1180971921 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1180971921;
                } //End block
                b[off+i] = (byte) read_b;
                i++;
            } //End block
} while ((available() != 0) && (i<len));
        int var865C0C0B4AB0E063E5CAA3387C1A8741_89827058 = (i);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1322065908 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1322065908;
        // ---------- Original Method ----------
        //int read_b;
        //int i = 0;
        //do {
            //if ((read_b = read()) == -1) {
                //return (i == 0) ? -1 : i;
            //}
            //b[off+i] = (byte) read_b;
            //i++;
        //} while ((available() != 0) && (i<len));
        //return i;
    }

    
    private class Adapter implements org.apache.harmony.xnet.provider.jsse.Appendable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.576 -0400", hash_original_method = "740A355E7DE5D3F2D284C3985F05A62D", hash_generated_method = "740A355E7DE5D3F2D284C3985F05A62D")
        public Adapter ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.577 -0400", hash_original_method = "63D6CE2521D05DB3C4B970CFFD748CB7", hash_generated_method = "29A008365284C918B396CED9F6F88AA4")
        public void append(byte[] src) {
            addTaint(src[0]);
            int length = src.length;
            if(BUFFER_SIZE - (end - pos) < length)            
            {
                AlertException var3924DDB77D1D2C149A838A49F3140C93_1633188788 = new AlertException(AlertProtocol.INTERNAL_ERROR,
                        new SSLException("Could not accept income app data."));
                var3924DDB77D1D2C149A838A49F3140C93_1633188788.addTaint(taint);
                throw var3924DDB77D1D2C149A838A49F3140C93_1633188788;
            } //End block
            if(end + length > BUFFER_SIZE)            
            {
                System.arraycopy(buffer, pos, buffer, 0, end-pos);
                end -= pos;
                pos = 0;
            } //End block
            System.arraycopy(src, 0, buffer, end, length);
            end = end + length;
            // ---------- Original Method ----------
            //int length = src.length;
            //if (BUFFER_SIZE - (end - pos) < length) {
                //throw new AlertException(AlertProtocol.INTERNAL_ERROR,
                        //new SSLException("Could not accept income app data."));
            //}
            //if (end + length > BUFFER_SIZE) {
                //System.arraycopy(buffer, pos, buffer, 0, end-pos);
                //end -= pos;
                //pos = 0;
            //}
            //System.arraycopy(src, 0, buffer, end, length);
            //end = end + length;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.578 -0400", hash_original_field = "D587EF8DA1B61B18373BDCDC15F9CE1A", hash_generated_field = "D64401C8A17B13BD371C7D5226CD92C1")

    private static final int BUFFER_SIZE = SSLRecordProtocol.MAX_DATA_LENGTH;
}

