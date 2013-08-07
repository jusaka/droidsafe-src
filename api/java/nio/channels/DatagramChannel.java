package java.nio.channels;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.nio.channels.spi.SelectorProvider;





public abstract class DatagramChannel extends AbstractSelectableChannel implements ByteChannel, ScatteringByteChannel, GatheringByteChannel {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.157 -0400", hash_original_method = "CB53873E4EB950556D4A1D46A395181D", hash_generated_method = "3892A14533B0657644D04485F31DC036")
    protected  DatagramChannel(SelectorProvider selectorProvider) {
        super(selectorProvider);
        addTaint(selectorProvider.getTaint());
        // ---------- Original Method ----------
    }

    
    public static DatagramChannel open() throws IOException {
        return SelectorProvider.provider().openDatagramChannel();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.159 -0400", hash_original_method = "389104566E9179427B49B1E6618B4C60", hash_generated_method = "8E5DBF1AC71B290D3D2E29607D31931A")
    @Override
    public final int validOps() {
        int var26420A318B0E3FC748622014FFE9C3B7_1309427201 = ((SelectionKey.OP_READ | SelectionKey.OP_WRITE));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1542479278 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1542479278;
        // ---------- Original Method ----------
        //return (SelectionKey.OP_READ | SelectionKey.OP_WRITE);
    }

    
    @DSModeled(DSC.SAFE)
    public abstract DatagramSocket socket();

    
    @DSModeled(DSC.SAFE)
    public abstract boolean isConnected();

    
    @DSModeled(DSC.SAFE)
    public abstract DatagramChannel connect(SocketAddress address)
            throws IOException;

    
    @DSModeled(DSC.SAFE)
    public abstract DatagramChannel disconnect() throws IOException;

    
    @DSModeled(DSC.SAFE)
    public abstract SocketAddress receive(ByteBuffer target) throws IOException;

    
    @DSModeled(DSC.SAFE)
    public abstract int send(ByteBuffer source, SocketAddress address) throws IOException;

    
    @DSModeled(DSC.SAFE)
    public abstract int read(ByteBuffer target) throws IOException;

    
    public abstract long read(ByteBuffer[] targets, int offset, int length)
            throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.161 -0400", hash_original_method = "27A2349B12D0C34616F4A42E88CDB7C6", hash_generated_method = "5185C2CBAE1EA96D68D622F105712235")
    public synchronized final long read(ByteBuffer[] targets) throws IOException {
        addTaint(targets[0].getTaint());
        long varFE1CA8A4AFFB15DED53509F1AD9D6EED_1345357568 = (read(targets, 0, targets.length));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_986168646 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_986168646;
        // ---------- Original Method ----------
        //return read(targets, 0, targets.length);
    }

    
    @DSModeled(DSC.SAFE)
    public abstract int write(ByteBuffer source) throws IOException;

    
    public abstract long write(ByteBuffer[] sources, int offset, int length)
            throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.162 -0400", hash_original_method = "3D11D927406C5CFD8B6F27A884F1DAA7", hash_generated_method = "EE12C9858F6C1C2038752454B2E4DA06")
    public synchronized final long write(ByteBuffer[] sources) throws IOException {
        addTaint(sources[0].getTaint());
        long varE628A2D924D52EAEBDED640B5A4AC008_711116899 = (write(sources, 0, sources.length));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_469232512 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_469232512;
        // ---------- Original Method ----------
        //return write(sources, 0, sources.length);
    }

    
}

