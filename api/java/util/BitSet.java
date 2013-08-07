package java.util;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.LongBuffer;

import libcore.io.SizeOf;





public class BitSet implements Serializable, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.079 -0400", hash_original_field = "CC411E6C13670E52124629B8AC83F7D0", hash_generated_field = "487233F7143B18DBA481DB90C8ACD8D3")

    private long[] bits;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.079 -0400", hash_original_field = "B7881959E051E122A93F0F4BB9A45AB8", hash_generated_field = "DC80EF19CD932E16185FEB519D23D494")

    private transient int longCount;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.079 -0400", hash_original_method = "36F48153593A7027DE7089606CF225FB", hash_generated_method = "613602062985992FB8430672E70C7481")
    public  BitSet() {
        this(new long[1]);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.079 -0400", hash_original_method = "12ED281EDA73627C34F706B1E8393C0F", hash_generated_method = "394F00B92810601398B7C1532BA22542")
    public  BitSet(int bitCount) {
        if(bitCount < 0)        
        {
            NegativeArraySizeException var5AE37C69772C7B3670FB23F69A1A89DC_927341977 = new NegativeArraySizeException();
            var5AE37C69772C7B3670FB23F69A1A89DC_927341977.addTaint(taint);
            throw var5AE37C69772C7B3670FB23F69A1A89DC_927341977;
        } //End block
        this.bits = arrayForBits(bitCount);
        this.longCount = 0;
        // ---------- Original Method ----------
        //if (bitCount < 0) {
            //throw new NegativeArraySizeException();
        //}
        //this.bits = arrayForBits(bitCount);
        //this.longCount = 0;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.080 -0400", hash_original_method = "F5397E49D432953D65E6CB2ED1150384", hash_generated_method = "1C0E37C5115CD13FD56B4BE776F6A166")
    private  BitSet(long[] bits) {
        this.bits = bits;
        this.longCount = bits.length;
        shrinkSize();
        // ---------- Original Method ----------
        //this.bits = bits;
        //this.longCount = bits.length;
        //shrinkSize();
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.080 -0400", hash_original_method = "2E0FE194508C45AD5184DCF0A152D7A0", hash_generated_method = "70FD16BD6869BF3839FB328DA0703FD2")
    private void shrinkSize() {
        int i = longCount - 1;
        while
(i >= 0 && bits[i] == 0)        
        {
            --i;
        } //End block
        this.longCount = i + 1;
        // ---------- Original Method ----------
        //int i = longCount - 1;
        //while (i >= 0 && bits[i] == 0) {
            //--i;
        //}
        //this.longCount = i + 1;
    }

    
    @DSModeled(DSC.BAN)
    private static long[] arrayForBits(int bitCount) {
        return new long[(bitCount + 63)/ 64];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.081 -0400", hash_original_method = "C5612661FC3C49DB4DB071789CF210EF", hash_generated_method = "C8384F150A1435918F31BA2B94DD56A1")
    @Override
    public Object clone() {
        try 
        {
            BitSet clone = (BitSet) super.clone();
            clone.bits = bits.clone();
            clone.shrinkSize();
Object var3DE52045BFD3C1BF3742F994ED6139AD_1120750795 =             clone;
            var3DE52045BFD3C1BF3742F994ED6139AD_1120750795.addTaint(taint);
            return var3DE52045BFD3C1BF3742F994ED6139AD_1120750795;
        } //End block
        catch (CloneNotSupportedException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_874126706 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_874126706.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_874126706;
        } //End block
        // ---------- Original Method ----------
        //try {
            //BitSet clone = (BitSet) super.clone();
            //clone.bits = bits.clone();
            //clone.shrinkSize();
            //return clone;
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.082 -0400", hash_original_method = "82791B0EBFB6ED23064857D8180EA65E", hash_generated_method = "77428D4308962C9A44D169D1D407711D")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        if(this == o)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1483309533 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1915493092 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1915493092;
        } //End block
        if(!(o instanceof BitSet))        
        {
            boolean var68934A3E9455FA72420237EB05902327_838435148 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_686646724 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_686646724;
        } //End block
        BitSet lhs = (BitSet) o;
        if(this.longCount != lhs.longCount)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1606163711 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_496347534 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_496347534;
        } //End block
for(int i = 0;i < longCount;++i)
        {
            if(bits[i] != lhs.bits[i])            
            {
                boolean var68934A3E9455FA72420237EB05902327_1319596825 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_883239539 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_883239539;
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_2089215919 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1167225153 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1167225153;
        // ---------- Original Method ----------
        //if (this == o) {
            //return true;
        //}
        //if (!(o instanceof BitSet)) {
            //return false;
        //}
        //BitSet lhs = (BitSet) o;
        //if (this.longCount != lhs.longCount) {
            //return false;
        //}
        //for (int i = 0; i < longCount; ++i) {
            //if (bits[i] != lhs.bits[i]) {
                //return false;
            //}
        //}
        //return true;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.084 -0400", hash_original_method = "FD70AAE85AF9795828FE994C30CD34E8", hash_generated_method = "AE589F6F3C46404803046C74D6F9BFFF")
    private void ensureCapacity(int desiredLongCount) {
        addTaint(desiredLongCount);
        if(desiredLongCount <= bits.length)        
        {
            return;
        } //End block
        int newLength = Math.max(desiredLongCount, bits.length * 2);
        long[] newBits = new long[newLength];
        System.arraycopy(bits, 0, newBits, 0, longCount);
        this.bits = newBits;
        // ---------- Original Method ----------
        //if (desiredLongCount <= bits.length) {
            //return;
        //}
        //int newLength = Math.max(desiredLongCount, bits.length * 2);
        //long[] newBits = new long[newLength];
        //System.arraycopy(bits, 0, newBits, 0, longCount);
        //this.bits = newBits;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.084 -0400", hash_original_method = "4E772724E1A92C93EB62C933BC27FE7C", hash_generated_method = "B982357A63358C3E25375EECCA54C0FE")
    @Override
    public int hashCode() {
        long x = 1234;
for(int i = 0;i < longCount;++i)
        {
            x ^= bits[i] * (i + 1);
        } //End block
        int var2558A56DC9BF87B36CB923A6A0B8F00B_374313014 = ((int) ((x >> 32) ^ x));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2141273675 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2141273675;
        // ---------- Original Method ----------
        //long x = 1234;
        //for (int i = 0; i < longCount; ++i) {
            //x ^= bits[i] * (i + 1);
        //}
        //return (int) ((x >> 32) ^ x);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.085 -0400", hash_original_method = "95B4B3127159370AD2A9AF3A9CB73F00", hash_generated_method = "46FDE7F2D030FCD56FFB676E5274F035")
    public boolean get(int index) {
        addTaint(index);
        if(index < 0)        
        {
            checkIndex(index);
        } //End block
        int arrayIndex = index / 64;
        if(arrayIndex >= longCount)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1966577350 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_564191796 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_564191796;
        } //End block
        boolean var5A78502DB84A14A3EA11D3DBEAB4E494_1938322429 = ((bits[arrayIndex] & (1L << index)) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1328838199 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1328838199;
        // ---------- Original Method ----------
        //if (index < 0) { 
            //checkIndex(index);
        //}
        //int arrayIndex = index / 64;
        //if (arrayIndex >= longCount) {
            //return false;
        //}
        //return (bits[arrayIndex] & (1L << index)) != 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.086 -0400", hash_original_method = "3D2EC51930163E4AB4304E4F9059CB5F", hash_generated_method = "EA0F535ADA82149B32AE468F743BCBA0")
    public void set(int index) {
        if(index < 0)        
        {
            checkIndex(index);
        } //End block
        int arrayIndex = index / 64;
        if(arrayIndex >= bits.length)        
        {
            ensureCapacity(arrayIndex + 1);
        } //End block
        bits[arrayIndex] |= (1L << index);
        longCount = Math.max(longCount, arrayIndex + 1);
        // ---------- Original Method ----------
        //if (index < 0) { 
            //checkIndex(index);
        //}
        //int arrayIndex = index / 64;
        //if (arrayIndex >= bits.length) {
            //ensureCapacity(arrayIndex + 1);
        //}
        //bits[arrayIndex] |= (1L << index);
        //longCount = Math.max(longCount, arrayIndex + 1);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.086 -0400", hash_original_method = "D4755629803CE3870851808B06FB6C2C", hash_generated_method = "97807EF4F5BFCE72FDFD64D91FBB68FB")
    public void clear(int index) {
        if(index < 0)        
        {
            checkIndex(index);
        } //End block
        int arrayIndex = index / 64;
        if(arrayIndex >= longCount)        
        {
            return;
        } //End block
        bits[arrayIndex] &= ~(1L << index);
        shrinkSize();
        // ---------- Original Method ----------
        //if (index < 0) { 
            //checkIndex(index);
        //}
        //int arrayIndex = index / 64;
        //if (arrayIndex >= longCount) {
            //return;
        //}
        //bits[arrayIndex] &= ~(1L << index);
        //shrinkSize();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.087 -0400", hash_original_method = "BA9F6F086346AF8289CA95B11E39C3E4", hash_generated_method = "A22FC6648E60E31C4B07D453E6799BF1")
    public void flip(int index) {
        if(index < 0)        
        {
            checkIndex(index);
        } //End block
        int arrayIndex = index / 64;
        if(arrayIndex >= bits.length)        
        {
            ensureCapacity(arrayIndex + 1);
        } //End block
        bits[arrayIndex] ^= (1L << index);
        longCount = Math.max(longCount, arrayIndex + 1);
        shrinkSize();
        // ---------- Original Method ----------
        //if (index < 0) { 
            //checkIndex(index);
        //}
        //int arrayIndex = index / 64;
        //if (arrayIndex >= bits.length) {
            //ensureCapacity(arrayIndex + 1);
        //}
        //bits[arrayIndex] ^= (1L << index);
        //longCount = Math.max(longCount, arrayIndex + 1);
        //shrinkSize();
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.087 -0400", hash_original_method = "71550A783E2339080C93A6660DB93338", hash_generated_method = "C8FA5192241807840A1F26CB01ABAEB0")
    private void checkIndex(int index) {
        addTaint(index);
        if(index < 0)        
        {
            IndexOutOfBoundsException var0844B4140430A48A24893F35E1B439EB_673932844 = new IndexOutOfBoundsException("index < 0: " + index);
            var0844B4140430A48A24893F35E1B439EB_673932844.addTaint(taint);
            throw var0844B4140430A48A24893F35E1B439EB_673932844;
        } //End block
        // ---------- Original Method ----------
        //if (index < 0) {
            //throw new IndexOutOfBoundsException("index < 0: " + index);
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.087 -0400", hash_original_method = "87A456FF76D283B2A0EA4C0CB9963D07", hash_generated_method = "C4A733DCE80899F2C8620249FFB5A349")
    private void checkRange(int fromIndex, int toIndex) {
        addTaint(toIndex);
        addTaint(fromIndex);
        if((fromIndex | toIndex) < 0 || toIndex < fromIndex)        
        {
            IndexOutOfBoundsException varE69D6AE49FEA558067DDC5D1CAF0489D_122700977 = new IndexOutOfBoundsException("fromIndex=" + fromIndex + " toIndex=" + toIndex);
            varE69D6AE49FEA558067DDC5D1CAF0489D_122700977.addTaint(taint);
            throw varE69D6AE49FEA558067DDC5D1CAF0489D_122700977;
        } //End block
        // ---------- Original Method ----------
        //if ((fromIndex | toIndex) < 0 || toIndex < fromIndex) {
            //throw new IndexOutOfBoundsException("fromIndex=" + fromIndex + " toIndex=" + toIndex);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.089 -0400", hash_original_method = "5C76FE7FFACA682F8E2DA192826E5D27", hash_generated_method = "3904431648586ECB62D67901783EB680")
    public BitSet get(int fromIndex, int toIndex) {
        addTaint(toIndex);
        addTaint(fromIndex);
        checkRange(fromIndex, toIndex);
        int last = 64 * longCount;
        if(fromIndex >= last || fromIndex == toIndex)        
        {
BitSet varF8FB778614EB7FE1193DEE62DE759E3B_641822142 =             new BitSet(0);
            varF8FB778614EB7FE1193DEE62DE759E3B_641822142.addTaint(taint);
            return varF8FB778614EB7FE1193DEE62DE759E3B_641822142;
        } //End block
        if(toIndex > last)        
        {
            toIndex = last;
        } //End block
        int firstArrayIndex = fromIndex / 64;
        int lastArrayIndex = (toIndex - 1) / 64;
        long lowMask = ALL_ONES << fromIndex;
        long highMask = ALL_ONES >>> -toIndex;
        if(firstArrayIndex == lastArrayIndex)        
        {
            long result = (bits[firstArrayIndex] & (lowMask & highMask)) >>> fromIndex;
            if(result == 0)            
            {
BitSet varF8FB778614EB7FE1193DEE62DE759E3B_1152180440 =                 new BitSet(0);
                varF8FB778614EB7FE1193DEE62DE759E3B_1152180440.addTaint(taint);
                return varF8FB778614EB7FE1193DEE62DE759E3B_1152180440;
            } //End block
BitSet var649BCCBEDA95E402D97F50F9857E1C96_843268402 =             new BitSet(new long[] { result });
            var649BCCBEDA95E402D97F50F9857E1C96_843268402.addTaint(taint);
            return var649BCCBEDA95E402D97F50F9857E1C96_843268402;
        } //End block
        long[] newBits = new long[lastArrayIndex - firstArrayIndex + 1];
        newBits[0] = bits[firstArrayIndex] & lowMask;
        newBits[newBits.length - 1] = bits[lastArrayIndex] & highMask;
for(int i = 1;i < lastArrayIndex - firstArrayIndex;i++)
        {
            newBits[i] = bits[firstArrayIndex + i];
        } //End block
        int numBitsToShift = fromIndex % 64;
        int actualLen = newBits.length;
        if(numBitsToShift != 0)        
        {
for(int i = 0;i < newBits.length;i++)
            {
                newBits[i] = newBits[i] >>> (numBitsToShift);
                if(i != newBits.length - 1)                
                {
                    newBits[i] |= newBits[i + 1] << -numBitsToShift;
                } //End block
                if(newBits[i] != 0)                
                {
                    actualLen = i + 1;
                } //End block
            } //End block
        } //End block
BitSet var6784C2042A719E30E34F279CE467E085_799709037 =         new BitSet(newBits);
        var6784C2042A719E30E34F279CE467E085_799709037.addTaint(taint);
        return var6784C2042A719E30E34F279CE467E085_799709037;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.090 -0400", hash_original_method = "74386BE28B96B2445F889AFAD9F88AFA", hash_generated_method = "437C1B0E8EC9FBD240FA2CDAAE287A9F")
    public void set(int index, boolean state) {
        addTaint(state);
        addTaint(index);
        if(state)        
        {
            set(index);
        } //End block
        else
        {
            clear(index);
        } //End block
        // ---------- Original Method ----------
        //if (state) {
            //set(index);
        //} else {
            //clear(index);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.090 -0400", hash_original_method = "9EFB812AD22830556B4E1C754018229D", hash_generated_method = "D64A86EFB18A4D60A08EFAF715306F75")
    public void set(int fromIndex, int toIndex, boolean state) {
        addTaint(state);
        addTaint(toIndex);
        addTaint(fromIndex);
        if(state)        
        {
            set(fromIndex, toIndex);
        } //End block
        else
        {
            clear(fromIndex, toIndex);
        } //End block
        // ---------- Original Method ----------
        //if (state) {
            //set(fromIndex, toIndex);
        //} else {
            //clear(fromIndex, toIndex);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.091 -0400", hash_original_method = "8EA7A389047D1FB0971FCD5F7482B28A", hash_generated_method = "2309BC392D8D2DE8CDACCC9A041B29DF")
    public void clear() {
        Arrays.fill(bits, 0, longCount, 0L);
        longCount = 0;
        // ---------- Original Method ----------
        //Arrays.fill(bits, 0, longCount, 0L);
        //longCount = 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.091 -0400", hash_original_method = "A26503DA159C46EB79782AEABE473F9D", hash_generated_method = "DE32122E2745BC9BBCFC26B47892956B")
    public void set(int fromIndex, int toIndex) {
        addTaint(toIndex);
        addTaint(fromIndex);
        checkRange(fromIndex, toIndex);
        if(fromIndex == toIndex)        
        {
            return;
        } //End block
        int firstArrayIndex = fromIndex / 64;
        int lastArrayIndex = (toIndex - 1) / 64;
        if(lastArrayIndex >= bits.length)        
        {
            ensureCapacity(lastArrayIndex + 1);
        } //End block
        long lowMask = ALL_ONES << fromIndex;
        long highMask = ALL_ONES >>> -toIndex;
        if(firstArrayIndex == lastArrayIndex)        
        {
            bits[firstArrayIndex] |= (lowMask & highMask);
        } //End block
        else
        {
            int i = firstArrayIndex;
            bits[i++] |= lowMask;
            while
(i < lastArrayIndex)            
            {
                bits[i++] |= ALL_ONES;
            } //End block
            bits[i++] |= highMask;
        } //End block
        longCount = Math.max(longCount, lastArrayIndex + 1);
        // ---------- Original Method ----------
        //checkRange(fromIndex, toIndex);
        //if (fromIndex == toIndex) {
            //return;
        //}
        //int firstArrayIndex = fromIndex / 64;
        //int lastArrayIndex = (toIndex - 1) / 64;
        //if (lastArrayIndex >= bits.length) {
            //ensureCapacity(lastArrayIndex + 1);
        //}
        //long lowMask = ALL_ONES << fromIndex;
        //long highMask = ALL_ONES >>> -toIndex;
        //if (firstArrayIndex == lastArrayIndex) {
            //bits[firstArrayIndex] |= (lowMask & highMask);
        //} else {
            //int i = firstArrayIndex;
            //bits[i++] |= lowMask;
            //while (i < lastArrayIndex) {
                //bits[i++] |= ALL_ONES;
            //}
            //bits[i++] |= highMask;
        //}
        //longCount = Math.max(longCount, lastArrayIndex + 1);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.091 -0400", hash_original_method = "C97E5F07F0FAAF9942FBF154783DA0BB", hash_generated_method = "C0AC0B36CB0214F109133B60FCF3D401")
    public void clear(int fromIndex, int toIndex) {
        addTaint(toIndex);
        addTaint(fromIndex);
        checkRange(fromIndex, toIndex);
        if(fromIndex == toIndex || longCount == 0)        
        {
            return;
        } //End block
        int last = 64 * longCount;
        if(fromIndex >= last)        
        {
            return;
        } //End block
        if(toIndex > last)        
        {
            toIndex = last;
        } //End block
        int firstArrayIndex = fromIndex / 64;
        int lastArrayIndex = (toIndex - 1) / 64;
        long lowMask = ALL_ONES << fromIndex;
        long highMask = ALL_ONES >>> -toIndex;
        if(firstArrayIndex == lastArrayIndex)        
        {
            bits[firstArrayIndex] &= ~(lowMask & highMask);
        } //End block
        else
        {
            int i = firstArrayIndex;
            bits[i++] &= ~lowMask;
            while
(i < lastArrayIndex)            
            {
                bits[i++] = 0L;
            } //End block
            bits[i++] &= ~highMask;
        } //End block
        shrinkSize();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.092 -0400", hash_original_method = "AF219115F487DC5279F51F56FAD6576B", hash_generated_method = "BD7B8715BF4371AA99BD8D70EEB182B8")
    public void flip(int fromIndex, int toIndex) {
        addTaint(toIndex);
        addTaint(fromIndex);
        checkRange(fromIndex, toIndex);
        if(fromIndex == toIndex)        
        {
            return;
        } //End block
        int firstArrayIndex = fromIndex / 64;
        int lastArrayIndex = (toIndex - 1) / 64;
        if(lastArrayIndex >= bits.length)        
        {
            ensureCapacity(lastArrayIndex + 1);
        } //End block
        long lowMask = ALL_ONES << fromIndex;
        long highMask = ALL_ONES >>> -toIndex;
        if(firstArrayIndex == lastArrayIndex)        
        {
            bits[firstArrayIndex] ^= (lowMask & highMask);
        } //End block
        else
        {
            int i = firstArrayIndex;
            bits[i++] ^= lowMask;
            while
(i < lastArrayIndex)            
            {
                bits[i++] ^= ALL_ONES;
            } //End block
            bits[i++] ^= highMask;
        } //End block
        longCount = Math.max(longCount, lastArrayIndex + 1);
        shrinkSize();
        // ---------- Original Method ----------
        //checkRange(fromIndex, toIndex);
        //if (fromIndex == toIndex) {
            //return;
        //}
        //int firstArrayIndex = fromIndex / 64;
        //int lastArrayIndex = (toIndex - 1) / 64;
        //if (lastArrayIndex >= bits.length) {
            //ensureCapacity(lastArrayIndex + 1);
        //}
        //long lowMask = ALL_ONES << fromIndex;
        //long highMask = ALL_ONES >>> -toIndex;
        //if (firstArrayIndex == lastArrayIndex) {
            //bits[firstArrayIndex] ^= (lowMask & highMask);
        //} else {
            //int i = firstArrayIndex;
            //bits[i++] ^= lowMask;
            //while (i < lastArrayIndex) {
                //bits[i++] ^= ALL_ONES;
            //}
            //bits[i++] ^= highMask;
        //}
        //longCount = Math.max(longCount, lastArrayIndex + 1);
        //shrinkSize();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.092 -0400", hash_original_method = "F6E914263E6B2AC21BC763D068DFC9F2", hash_generated_method = "CB0DC568DA886418C72F41E9D55ABAC4")
    public boolean intersects(BitSet bs) {
        addTaint(bs.getTaint());
        long[] bsBits = bs.bits;
        int length = Math.min(this.longCount, bs.longCount);
for(int i = 0;i < length;++i)
        {
            if((bits[i] & bsBits[i]) != 0L)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_161133083 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1061350886 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1061350886;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1837810460 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1128763771 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1128763771;
        // ---------- Original Method ----------
        //long[] bsBits = bs.bits;
        //int length = Math.min(this.longCount, bs.longCount);
        //for (int i = 0; i < length; ++i) {
            //if ((bits[i] & bsBits[i]) != 0L) {
                //return true;
            //}
        //}
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.093 -0400", hash_original_method = "83F89EEE7E2D54034E7D4AA2FF619E80", hash_generated_method = "68352DB8351AF91212BAC75BE14B3D68")
    public void and(BitSet bs) {
        int minSize = Math.min(this.longCount, bs.longCount);
for(int i = 0;i < minSize;++i)
        {
            bits[i] &= bs.bits[i];
        } //End block
        Arrays.fill(bits, minSize, longCount, 0L);
        shrinkSize();
        // ---------- Original Method ----------
        //int minSize = Math.min(this.longCount, bs.longCount);
        //for (int i = 0; i < minSize; ++i) {
            //bits[i] &= bs.bits[i];
        //}
        //Arrays.fill(bits, minSize, longCount, 0L);
        //shrinkSize();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.093 -0400", hash_original_method = "6AEA541E74DD35C186C561500AE782A6", hash_generated_method = "FA968970B875E05AC829030FFC80966A")
    public void andNot(BitSet bs) {
        int minSize = Math.min(this.longCount, bs.longCount);
for(int i = 0;i < minSize;++i)
        {
            bits[i] &= ~bs.bits[i];
        } //End block
        shrinkSize();
        // ---------- Original Method ----------
        //int minSize = Math.min(this.longCount, bs.longCount);
        //for (int i = 0; i < minSize; ++i) {
            //bits[i] &= ~bs.bits[i];
        //}
        //shrinkSize();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.093 -0400", hash_original_method = "BEA444ABE4A457608A295CEBFA17C48D", hash_generated_method = "B24B8D11F3F72D93704B9480A27DFFEC")
    public void or(BitSet bs) {
        int minSize = Math.min(this.longCount, bs.longCount);
        int maxSize = Math.max(this.longCount, bs.longCount);
        ensureCapacity(maxSize);
for(int i = 0;i < minSize;++i)
        {
            bits[i] |= bs.bits[i];
        } //End block
        if(bs.longCount > minSize)        
        {
            System.arraycopy(bs.bits, minSize, bits, minSize, maxSize - minSize);
        } //End block
        longCount = maxSize;
        // ---------- Original Method ----------
        //int minSize = Math.min(this.longCount, bs.longCount);
        //int maxSize = Math.max(this.longCount, bs.longCount);
        //ensureCapacity(maxSize);
        //for (int i = 0; i < minSize; ++i) {
            //bits[i] |= bs.bits[i];
        //}
        //if (bs.longCount > minSize) {
            //System.arraycopy(bs.bits, minSize, bits, minSize, maxSize - minSize);
        //}
        //longCount = maxSize;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.094 -0400", hash_original_method = "E1F10E844B44799F9E6FF97093185186", hash_generated_method = "BC430827DE6FEE0B33B4053DF3B2FEF5")
    public void xor(BitSet bs) {
        int minSize = Math.min(this.longCount, bs.longCount);
        int maxSize = Math.max(this.longCount, bs.longCount);
        ensureCapacity(maxSize);
for(int i = 0;i < minSize;++i)
        {
            bits[i] ^= bs.bits[i];
        } //End block
        if(bs.longCount > minSize)        
        {
            System.arraycopy(bs.bits, minSize, bits, minSize, maxSize - minSize);
        } //End block
        longCount = maxSize;
        shrinkSize();
        // ---------- Original Method ----------
        //int minSize = Math.min(this.longCount, bs.longCount);
        //int maxSize = Math.max(this.longCount, bs.longCount);
        //ensureCapacity(maxSize);
        //for (int i = 0; i < minSize; ++i) {
            //bits[i] ^= bs.bits[i];
        //}
        //if (bs.longCount > minSize) {
            //System.arraycopy(bs.bits, minSize, bits, minSize, maxSize - minSize);
        //}
        //longCount = maxSize;
        //shrinkSize();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.094 -0400", hash_original_method = "F33E07354BDEEAA3CDE5DA5EA8779C95", hash_generated_method = "6BFDD5AFFEFC72D463CB19ADF233C549")
    public int size() {
        int varE9CE183A6A2F1F6D9A2BA9CC7EC45B2C_532639984 = (bits.length * 64);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1085009379 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1085009379;
        // ---------- Original Method ----------
        //return bits.length * 64;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.094 -0400", hash_original_method = "6F3396C6D4F506441C95587742A4BBC3", hash_generated_method = "8C299ABCEB089776F50276DA455A4C70")
    public int length() {
        if(longCount == 0)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1625632889 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1981712043 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1981712043;
        } //End block
        int var2452850968D3D2910B4B80C9D3EF5947_1543305004 = (64 * (longCount - 1) + (64 - Long.numberOfLeadingZeros(bits[longCount - 1])));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_479520939 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_479520939;
        // ---------- Original Method ----------
        //if (longCount == 0) {
            //return 0;
        //}
        //return 64 * (longCount - 1) + (64 - Long.numberOfLeadingZeros(bits[longCount - 1]));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.095 -0400", hash_original_method = "A54CE267AEC3D3118A3C3A52C928D20A", hash_generated_method = "1CA63336F943750ED83751C03768F6C9")
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(longCount / 2);
        sb.append('{');
        boolean comma = false;
for(int i = 0;i < longCount;++i)
        {
            if(bits[i] != 0)            
            {
for(int j = 0;j < 64;++j)
                {
                    if((bits[i] & 1L << j) != 0)                    
                    {
                        if(comma)                        
                        {
                            sb.append(", ");
                        } //End block
                        else
                        {
                            comma = true;
                        } //End block
                        sb.append(64 * i + j);
                    } //End block
                } //End block
            } //End block
        } //End block
        sb.append('}');
String var2460B846747F8B22185AD8BE722266A5_1269554646 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_1269554646.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_1269554646;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(longCount / 2);
        //sb.append('{');
        //boolean comma = false;
        //for (int i = 0; i < longCount; ++i) {
            //if (bits[i] != 0) {
                //for (int j = 0; j < 64; ++j) {
                    //if ((bits[i] & 1L << j) != 0) {
                        //if (comma) {
                            //sb.append(", ");
                        //} else {
                            //comma = true;
                        //}
                        //sb.append(64 * i + j);
                    //}
                //}
            //}
        //}
        //sb.append('}');
        //return sb.toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.095 -0400", hash_original_method = "9B70742E631D0FF7E36300CA25C790B5", hash_generated_method = "1F32E485215752F15940D4001D19B954")
    public int nextSetBit(int index) {
        addTaint(index);
        checkIndex(index);
        int arrayIndex = index / 64;
        if(arrayIndex >= longCount)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1066016407 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1179872653 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1179872653;
        } //End block
        long mask = ALL_ONES << index;
        if((bits[arrayIndex] & mask) != 0)        
        {
            int var022C3B78654650580C0EF4EF209C6C81_158752929 = (64 * arrayIndex + Long.numberOfTrailingZeros(bits[arrayIndex] & mask));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_91119661 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_91119661;
        } //End block
        while
(++arrayIndex < longCount && bits[arrayIndex] == 0)        
        {
        } //End block
        if(arrayIndex == longCount)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1462969930 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_805474933 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_805474933;
        } //End block
        int var5E8E7D69AAB1F1917FA362920E5A11E4_638122629 = (64 * arrayIndex + Long.numberOfTrailingZeros(bits[arrayIndex]));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2117085291 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2117085291;
        // ---------- Original Method ----------
        //checkIndex(index);
        //int arrayIndex = index / 64;
        //if (arrayIndex >= longCount) {
            //return -1;
        //}
        //long mask = ALL_ONES << index;
        //if ((bits[arrayIndex] & mask) != 0) {
            //return 64 * arrayIndex + Long.numberOfTrailingZeros(bits[arrayIndex] & mask);
        //}
        //while (++arrayIndex < longCount && bits[arrayIndex] == 0) {
        //}
        //if (arrayIndex == longCount) {
            //return -1;
        //}
        //return 64 * arrayIndex + Long.numberOfTrailingZeros(bits[arrayIndex]);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.096 -0400", hash_original_method = "B6E36E70EF447F6B993A99CF808640C0", hash_generated_method = "D56C7E6783218EE82946CE22FBCBF005")
    public int nextClearBit(int index) {
        addTaint(index);
        checkIndex(index);
        int arrayIndex = index / 64;
        if(arrayIndex >= longCount)        
        {
            int var6A992D5529F459A44FEE58C733255E86_1955028784 = (index);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1273068531 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1273068531;
        } //End block
        long mask = ALL_ONES << index;
        if((~bits[arrayIndex] & mask) != 0)        
        {
            int varAAA30A2CF34A7E6FACA140ED74D71282_2037883655 = (64 * arrayIndex + Long.numberOfTrailingZeros(~bits[arrayIndex] & mask));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1232290349 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1232290349;
        } //End block
        while
(++arrayIndex < longCount && bits[arrayIndex] == ALL_ONES)        
        {
        } //End block
        if(arrayIndex == longCount)        
        {
            int varB4EBB5889A8FF0272C896FE4C839AC70_2048647283 = (size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1898020327 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1898020327;
        } //End block
        int var6917E55946CAC0DA2E7FE42EF00A5DAF_912278751 = (64 * arrayIndex + Long.numberOfTrailingZeros(~bits[arrayIndex]));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_417123967 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_417123967;
        // ---------- Original Method ----------
        //checkIndex(index);
        //int arrayIndex = index / 64;
        //if (arrayIndex >= longCount) {
            //return index;
        //}
        //long mask = ALL_ONES << index;
        //if ((~bits[arrayIndex] & mask) != 0) {
            //return 64 * arrayIndex + Long.numberOfTrailingZeros(~bits[arrayIndex] & mask);
        //}
        //while (++arrayIndex < longCount && bits[arrayIndex] == ALL_ONES) {
        //}
        //if (arrayIndex == longCount) {
            //return size();
        //}
        //return 64 * arrayIndex + Long.numberOfTrailingZeros(~bits[arrayIndex]);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.096 -0400", hash_original_method = "BDE3A7C277C6F771330A08D119C9767D", hash_generated_method = "BE136E9CB3E63AC6C3F411543F95128C")
    public int previousSetBit(int index) {
        addTaint(index);
        if(index == -1)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_467030691 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1531365348 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1531365348;
        } //End block
        checkIndex(index);
for(int i = index;i >= 0;--i)
        {
            if(get(i))            
            {
                int var865C0C0B4AB0E063E5CAA3387C1A8741_2015196375 = (i);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1595285848 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1595285848;
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1279143900 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_419426964 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_419426964;
        // ---------- Original Method ----------
        //if (index == -1) {
            //return -1;
        //}
        //checkIndex(index);
        //for (int i = index; i >= 0; --i) {
            //if (get(i)) {
                //return i;
            //}
        //}
        //return -1;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.097 -0400", hash_original_method = "4D910DE065D256451DE439F25B5A6A08", hash_generated_method = "75B43382CDF78A14A8EB4B1604E0E6B7")
    public int previousClearBit(int index) {
        addTaint(index);
        if(index == -1)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1949769214 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_594599049 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_594599049;
        } //End block
        checkIndex(index);
for(int i = index;i >= 0;--i)
        {
            if(!get(i))            
            {
                int var865C0C0B4AB0E063E5CAA3387C1A8741_681101454 = (i);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1025759516 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1025759516;
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_8258812 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1847769298 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1847769298;
        // ---------- Original Method ----------
        //if (index == -1) {
            //return -1;
        //}
        //checkIndex(index);
        //for (int i = index; i >= 0; --i) {
            //if (!get(i)) {
                //return i;
            //}
        //}
        //return -1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.097 -0400", hash_original_method = "F34A10F6A3FF7AEAC6E09DDBD9741E2B", hash_generated_method = "A38EFE4A86371A54F705D44D246C39DA")
    public boolean isEmpty() {
        boolean var60CD0C882761802667A0357E96B37C08_413889391 = ((longCount == 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_632237634 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_632237634;
        // ---------- Original Method ----------
        //return (longCount == 0);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.097 -0400", hash_original_method = "5D3E782DB55862032A3B0CF1D30A4050", hash_generated_method = "7C7B6E983075841811A3726421E4E5E1")
    public int cardinality() {
        int result = 0;
for(int i = 0;i < longCount;++i)
        {
            result += Long.bitCount(bits[i]);
        } //End block
        int varB4A88417B3D0170D754C647C30B7216A_1681086124 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_288751595 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_288751595;
        // ---------- Original Method ----------
        //int result = 0;
        //for (int i = 0; i < longCount; ++i) {
            //result += Long.bitCount(bits[i]);
        //}
        //return result;
    }

    
    @DSModeled(DSC.BAN)
    public static BitSet valueOf(long[] longs) {
        return new BitSet(longs.clone());
    }

    
    @DSModeled(DSC.BAN)
    public static BitSet valueOf(LongBuffer longBuffer) {
        long[] longs = new long[longBuffer.remaining()];
        for (int i = 0; i < longs.length; ++i) {
            longs[i] = longBuffer.get(longBuffer.position() + i);
        }
        return BitSet.valueOf(longs);
    }

    
    @DSModeled(DSC.BAN)
    public static BitSet valueOf(byte[] bytes) {
        return BitSet.valueOf(ByteBuffer.wrap(bytes));
    }

    
    @DSModeled(DSC.BAN)
    public static BitSet valueOf(ByteBuffer byteBuffer) {
        byteBuffer = byteBuffer.slice().order(ByteOrder.LITTLE_ENDIAN);
        long[] longs = arrayForBits(byteBuffer.remaining() * 8);
        int i = 0;
        while (byteBuffer.remaining() >= SizeOf.LONG) {
            longs[i++] = byteBuffer.getLong();
        }
        for (int j = 0; byteBuffer.hasRemaining(); ++j) {
            longs[i] |= ((((long) byteBuffer.get()) & 0xff) << (8*j));
        }
        return BitSet.valueOf(longs);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.097 -0400", hash_original_method = "87C10E36682237AA1B22F77F460E655A", hash_generated_method = "380FE4AE2E39356DB2A00038C5512480")
    public long[] toLongArray() {
        long[] varA7B86AB69207221E0772B497BB3C8517_44835742 = (Arrays.copyOf(bits, longCount));
                long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_1263874342 = {getTaintLong()};
        return var3908C7C3AF5171CEE1F112DAE77A5C4D_1263874342;
        // ---------- Original Method ----------
        //return Arrays.copyOf(bits, longCount);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.098 -0400", hash_original_method = "BCE80AE7073A25796C80405F8FB14636", hash_generated_method = "4D5052E13FAD006B143E16F0C1482264")
    public byte[] toByteArray() {
        int bitCount = length();
        byte[] result = new byte[(bitCount + 7)/ 8];
for(int i = 0;i < result.length;++i)
        {
            int lowBit = 8 * i;
            int arrayIndex = lowBit / 64;
            result[i] = (byte) (bits[arrayIndex] >>> lowBit);
        } //End block
        byte[] varB4A88417B3D0170D754C647C30B7216A_1371672060 = (result);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1638900536 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1638900536;
        // ---------- Original Method ----------
        //int bitCount = length();
        //byte[] result = new byte[(bitCount + 7)/ 8];
        //for (int i = 0; i < result.length; ++i) {
            //int lowBit = 8 * i;
            //int arrayIndex = lowBit / 64;
            //result[i] = (byte) (bits[arrayIndex] >>> lowBit);
        //}
        //return result;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.098 -0400", hash_original_method = "928646C6EBB028EB87EF1072BE151B53", hash_generated_method = "ABED21843088C993299A9DDD6D02486F")
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        addTaint(ois.getTaint());
        ois.defaultReadObject();
        this.longCount = this.bits.length;
        shrinkSize();
        // ---------- Original Method ----------
        //ois.defaultReadObject();
        //this.longCount = this.bits.length;
        //shrinkSize();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.098 -0400", hash_original_field = "1746B9E5B72A597D589BE87B4E70F48A", hash_generated_field = "975BBBA7B21A6881F86AABFE03BF689A")

    private static final long serialVersionUID = 7997698588986878753L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:59.098 -0400", hash_original_field = "550DEA04DA165D0625CB0E2028B4AB38", hash_generated_field = "BC830E41BA8334B8E98728347067D4B9")

    private static final long ALL_ONES = ~0L;
}

