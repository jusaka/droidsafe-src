package junit.framework;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Vector;
import java.util.Enumeration;

public class TestResult extends Object {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.294 -0400", hash_original_field = "A9DB4B1F5286C1409CCDE497F567244F", hash_generated_field = "3D48F046A221F0C0CA21EE3F7549F095")

    protected Vector fFailures;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.294 -0400", hash_original_field = "612EB9AD300A0668958A49D69DCDE945", hash_generated_field = "CB39F2BEBE63A1FE78E2D765CFDAB523")

    protected Vector fErrors;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.294 -0400", hash_original_field = "B6E2D63A9DC9045E9FB05C85615D0611", hash_generated_field = "75B9096774F248001DC15E9E0240C705")

    protected Vector fListeners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.294 -0400", hash_original_field = "53D392AC28E0DA7A2A8E4DDB2F5DD653", hash_generated_field = "875AED0EFC33F81818A45FCF1EA1C295")

    protected int fRunTests;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.295 -0400", hash_original_field = "2971494BCF0D07D01887CCC65BC0A659", hash_generated_field = "478913F24D71102954C1FE6CB2B345DC")

    private boolean fStop;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.296 -0400", hash_original_method = "8F7D8E869233098F7B3F654359449283", hash_generated_method = "077061235279A3097A476FE8301982CA")
    public  TestResult() {
        fFailures= new Vector();
        fErrors= new Vector();
        fListeners= new Vector();
        fRunTests= 0;
        fStop= false;
        // ---------- Original Method ----------
        //fFailures= new Vector();
        //fErrors= new Vector();
        //fListeners= new Vector();
        //fRunTests= 0;
        //fStop= false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.296 -0400", hash_original_method = "B8BD2BCA50B2996F91FE0AB13C346E57", hash_generated_method = "FBF82B84E8DC598585D81C26FBDBE983")
    public synchronized void addError(Test test, Throwable t) {
        addTaint(t.getTaint());
        addTaint(test.getTaint());
        fErrors.addElement(new TestFailure(test, t));
for(Enumeration e= cloneListeners().elements();e.hasMoreElements();)
        {
            ((TestListener)e.nextElement()).addError(test, t);
        } //End block
        // ---------- Original Method ----------
        //fErrors.addElement(new TestFailure(test, t));
        //for (Enumeration e= cloneListeners().elements(); e.hasMoreElements(); ) {
            //((TestListener)e.nextElement()).addError(test, t);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.297 -0400", hash_original_method = "CE28B7D5A93F674A0286463AAF68C789", hash_generated_method = "47C5FEB5778DDBE16BE884A1FCF0C8B0")
    public synchronized void addFailure(Test test, AssertionFailedError t) {
        addTaint(t.getTaint());
        addTaint(test.getTaint());
        fFailures.addElement(new TestFailure(test, t));
for(Enumeration e= cloneListeners().elements();e.hasMoreElements();)
        {
            ((TestListener)e.nextElement()).addFailure(test, t);
        } //End block
        // ---------- Original Method ----------
        //fFailures.addElement(new TestFailure(test, t));
        //for (Enumeration e= cloneListeners().elements(); e.hasMoreElements(); ) {
            //((TestListener)e.nextElement()).addFailure(test, t);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.297 -0400", hash_original_method = "FF5754A93EFEC96878F60030305F1AA8", hash_generated_method = "D2225646E0867302399CDE4C8F823005")
    public synchronized void addListener(TestListener listener) {
        addTaint(listener.getTaint());
        fListeners.addElement(listener);
        // ---------- Original Method ----------
        //fListeners.addElement(listener);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.297 -0400", hash_original_method = "D8517093E47E932F74FDEA97974509FB", hash_generated_method = "EC3BD395244FD7A7C331DF582C87D3F0")
    public synchronized void removeListener(TestListener listener) {
        addTaint(listener.getTaint());
        fListeners.removeElement(listener);
        // ---------- Original Method ----------
        //fListeners.removeElement(listener);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.298 -0400", hash_original_method = "B6A6493DA121BF70308A3AD912C75AC8", hash_generated_method = "6BDFBCBDB7E53341DBE16B5234AE83A9")
    private synchronized Vector cloneListeners() {
Vector varD882C66CDA18635825D85407EC1AFEC6_1125848865 =         (Vector)fListeners.clone();
        varD882C66CDA18635825D85407EC1AFEC6_1125848865.addTaint(taint);
        return varD882C66CDA18635825D85407EC1AFEC6_1125848865;
        // ---------- Original Method ----------
        //return (Vector)fListeners.clone();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.298 -0400", hash_original_method = "FC137DB7CC1014A530CE1472E28E1AFA", hash_generated_method = "BA8A82BBF4BB600B3D60A77ADF1184E5")
    public void endTest(Test test) {
        addTaint(test.getTaint());
for(Enumeration e= cloneListeners().elements();e.hasMoreElements();)
        {
            ((TestListener)e.nextElement()).endTest(test);
        } //End block
        // ---------- Original Method ----------
        //for (Enumeration e= cloneListeners().elements(); e.hasMoreElements(); ) {
            //((TestListener)e.nextElement()).endTest(test);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.299 -0400", hash_original_method = "4DB7FF1416CFDDE04ED7DBC866AEEF40", hash_generated_method = "3FBE42933246E75B6FD999391549E7D4")
    public synchronized int errorCount() {
        int var1328BAC3D2F908A5787897BFAF428628_1645429235 = (fErrors.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2042810366 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2042810366;
        // ---------- Original Method ----------
        //return fErrors.size();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.300 -0400", hash_original_method = "F86874BC4C4C4E18BB69ECCAB73A2619", hash_generated_method = "0AD46C3341E260ED1BA9FC0603640C2B")
    public synchronized Enumeration errors() {
Enumeration var0685D1417794BEC7FB3DD5A0E4795D31_881139043 =         fErrors.elements();
        var0685D1417794BEC7FB3DD5A0E4795D31_881139043.addTaint(taint);
        return var0685D1417794BEC7FB3DD5A0E4795D31_881139043;
        // ---------- Original Method ----------
        //return fErrors.elements();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.301 -0400", hash_original_method = "24C81F8B6EECD0B079C96068F78E52B2", hash_generated_method = "6006DBD4DF74BEAD4AFBA7F646FF862D")
    public synchronized int failureCount() {
        int var6B4139FD0B21230308B80BA0A025956A_1715010413 = (fFailures.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1282474168 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1282474168;
        // ---------- Original Method ----------
        //return fFailures.size();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.301 -0400", hash_original_method = "5ED608529AAF18DC65BC239874C7ECA6", hash_generated_method = "422DBC4A7BC398673FE59945EB6DD7CD")
    public synchronized Enumeration failures() {
Enumeration varB9E0BF60CDAD5BE5B5A751F5B7678F67_2038512752 =         fFailures.elements();
        varB9E0BF60CDAD5BE5B5A751F5B7678F67_2038512752.addTaint(taint);
        return varB9E0BF60CDAD5BE5B5A751F5B7678F67_2038512752;
        // ---------- Original Method ----------
        //return fFailures.elements();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.302 -0400", hash_original_method = "5370441BB8A506FBAD652ED7C05E8864", hash_generated_method = "48530B6938E7C8226E1AFBA9FF5CAC93")
    protected void run(final TestCase test) {
        addTaint(test.getTaint());
        startTest(test);
        Protectable p = new Protectable() {
            public void protect() throws Throwable {
                test.runBare();
            }
        };
        runProtected(test, p);
        endTest(test);
        // ---------- Original Method ----------
        //startTest(test);
        //Protectable p= new Protectable() {
            //public void protect() throws Throwable {
                //test.runBare();
            //}
        //};
        //runProtected(test, p);
        //endTest(test);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.303 -0400", hash_original_method = "B255F5DC6E019A7B063A4503DC44009F", hash_generated_method = "37CA6D888B1E4E7CB5FE7341EB8283E5")
    public synchronized int runCount() {
        int var53D392AC28E0DA7A2A8E4DDB2F5DD653_1166880280 = (fRunTests);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1700759524 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1700759524;
        // ---------- Original Method ----------
        //return fRunTests;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.303 -0400", hash_original_method = "94AFC9FBE774A81FB25FA734A5EF1C27", hash_generated_method = "2238F6193B8C52DDBF5A9F31EAE0EB0D")
    public void runProtected(final Test test, Protectable p) {
        addTaint(p.getTaint());
        addTaint(test.getTaint());
        try 
        {
            p.protect();
        } //End block
        catch (AssertionFailedError e)
        {
            addFailure(test, e);
        } //End block
        catch (ThreadDeath e)
        {
            e.addTaint(taint);
            throw e;
        } //End block
        catch (Throwable e)
        {
            addError(test, e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //p.protect();
        //}
        //catch (AssertionFailedError e) {
            //addFailure(test, e);
        //}
        //catch (ThreadDeath e) { 
            //throw e;
        //}
        //catch (Throwable e) {
            //addError(test, e);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.304 -0400", hash_original_method = "2A4A3BCA46AEDD234384156D1F68427A", hash_generated_method = "AD8ED997461714B91B91571268CF1D85")
    public synchronized boolean shouldStop() {
        boolean var2971494BCF0D07D01887CCC65BC0A659_1883501651 = (fStop);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_347611411 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_347611411;
        // ---------- Original Method ----------
        //return fStop;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.304 -0400", hash_original_method = "214B52CD6256D7D6465E310658C00D6D", hash_generated_method = "921147E62E4C2434E15687E1AC69C439")
    public void startTest(Test test) {
        addTaint(test.getTaint());
        final int count = test.countTestCases();
        synchronized
(this)        {
            fRunTests+= count;
        } //End block
for(Enumeration e= cloneListeners().elements();e.hasMoreElements();)
        {
            ((TestListener)e.nextElement()).startTest(test);
        } //End block
        // ---------- Original Method ----------
        //final int count= test.countTestCases();
        //synchronized(this) {
            //fRunTests+= count;
        //}
        //for (Enumeration e= cloneListeners().elements(); e.hasMoreElements(); ) {
            //((TestListener)e.nextElement()).startTest(test);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.305 -0400", hash_original_method = "9AD54EE55D5A75E97AE6A449995157CC", hash_generated_method = "A30B6ABC6D3DEBCDA1E349CB6199EDB8")
    public synchronized void stop() {
        fStop= true;
        // ---------- Original Method ----------
        //fStop= true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.305 -0400", hash_original_method = "0F0C9C72850FB77DD8C966716104A782", hash_generated_method = "D40A8506F0B8C31E657FAEC210B510F0")
    public synchronized boolean wasSuccessful() {
        boolean var9685D8BD39F1881B021C1C2369FF1E2D_1285276805 = (failureCount() == 0 && errorCount() == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1100238267 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1100238267;
        // ---------- Original Method ----------
        //return failureCount() == 0 && errorCount() == 0;
    }

    
}

