package android.webkit;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.List;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;





final class DeviceOrientationService implements SensorEventListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.314 -0400", hash_original_field = "3ED8275DCE79E42B3B02ABEA2442432B", hash_generated_field = "9C5FFC7AB264A9E2409475E7791D4532")

    private float[] mGravityVector;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.314 -0400", hash_original_field = "7AE8C37126C35170590102A57FD32B35", hash_generated_field = "0130128FE056DC76160B4827D4BE644E")

    private float[] mMagneticFieldVector;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.314 -0400", hash_original_field = "1D4FD4FBF6080AF66D4D90562FE06036", hash_generated_field = "66D108DFC043A6E0A2844E4843186070")

    private DeviceMotionAndOrientationManager mManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.314 -0400", hash_original_field = "130D713CAF236B328B5223DFA18F1488", hash_generated_field = "B2DDC5809B05187D32A84097DC68019C")

    private boolean mIsRunning;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.314 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private Handler mHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.314 -0400", hash_original_field = "8CDFC97B128FB94D2A2F11FDAFFE50EA", hash_generated_field = "D8CC5B9F3DF5D78484C533BB7CDDA85C")

    private SensorManager mSensorManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.314 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.314 -0400", hash_original_field = "7574041472B9B2E76867A37482E74343", hash_generated_field = "0A23F4655A3DFB9C9E452D889EBE9404")

    private Double mAlpha;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.314 -0400", hash_original_field = "6A50E75BFB2FD3E51E931E0FB19516A2", hash_generated_field = "64234C701661B0D83F7238BD4569B56F")

    private Double mBeta;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.314 -0400", hash_original_field = "D0E25905791C4A3739FADA1C0E52A041", hash_generated_field = "9EEB92A35AEC39199205F7CE49B953F3")

    private Double mGamma;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.314 -0400", hash_original_field = "2C3606D875A88A4154C18923EE3485CF", hash_generated_field = "16AAE3611879142DAF4D4972E6DBF92E")

    private boolean mHaveSentErrorEvent;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.315 -0400", hash_original_method = "4D8FCE308D7FC749FF19FBAE89D7CA70", hash_generated_method = "87D6AFD046F32ED648775F26C5959B17")
    public  DeviceOrientationService(DeviceMotionAndOrientationManager manager, Context context) {
        mManager = manager;
        mContext = context;
        // ---------- Original Method ----------
        //mManager = manager;
        //assert(mManager != null);
        //mContext = context;
        //assert(mContext != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.316 -0400", hash_original_method = "4CC8267164C7FA2FF7A54409829F5B3F", hash_generated_method = "1271AEFE8C3FFFE0936AD75B93E923E4")
    public void start() {
        mIsRunning = true;
        registerForSensors();
        // ---------- Original Method ----------
        //mIsRunning = true;
        //registerForSensors();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.316 -0400", hash_original_method = "E95AF6342D982D1129097C11892774DC", hash_generated_method = "574593EF3A6A5CC6922E3DFC8DCA805B")
    public void stop() {
        mIsRunning = false;
        unregisterFromSensors();
        // ---------- Original Method ----------
        //mIsRunning = false;
        //unregisterFromSensors();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.317 -0400", hash_original_method = "D444E72BAE4BC67A93A8D811E5903DC0", hash_generated_method = "C883279CD5E1305CF1724780C166A59B")
    public void suspend() {
        if(mIsRunning)        
        {
            unregisterFromSensors();
        } //End block
        // ---------- Original Method ----------
        //if (mIsRunning) {
            //unregisterFromSensors();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.317 -0400", hash_original_method = "13F627D50D1CD4F6B5F8D936ACD57861", hash_generated_method = "3117D756CAF8B65FBD016E23A95BDACB")
    public void resume() {
        if(mIsRunning)        
        {
            registerForSensors();
        } //End block
        // ---------- Original Method ----------
        //if (mIsRunning) {
            //registerForSensors();
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.318 -0400", hash_original_method = "C4E19FEB85A20B838CCD6120912B24F7", hash_generated_method = "ABEAB5B3E2E12E12C119B904BB044706")
    private void sendErrorEvent() {
        if(mHaveSentErrorEvent)        
        return;
        mHaveSentErrorEvent = true;
        mHandler.post(new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.318 -0400", hash_original_method = "1621C64DF7C2F75E1B41A795930D55FE", hash_generated_method = "159DA07BF2E63017CDEBCB598DD661E0")
        @Override
        public void run() {
            if(mIsRunning)            
            {
                mManager.onOrientationChange(null, null, null);
            } //End block
            // ---------- Original Method ----------
            //assert WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName());
            //if (mIsRunning) {
                    //mManager.onOrientationChange(null, null, null);
                //}
        }
});
        // ---------- Original Method ----------
        //assert WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName());
        //if (mHaveSentErrorEvent)
            //return;
        //mHaveSentErrorEvent = true;
        //mHandler.post(new Runnable() {
            //@Override
            //public void run() {
                //assert WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName());
                //if (mIsRunning) {
                    //mManager.onOrientationChange(null, null, null);
                //}
            //}
        //});
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.319 -0400", hash_original_method = "A01419D47FD253423887BAF542AEFD8C", hash_generated_method = "B7C539EED17301F99C7F75A7F4191932")
    private void registerForSensors() {
        if(mHandler == null)        
        {
            mHandler = new Handler();
        } //End block
        if(!registerForAccelerometerSensor() || !registerForMagneticFieldSensor())        
        {
            unregisterFromSensors();
            sendErrorEvent();
        } //End block
        // ---------- Original Method ----------
        //if (mHandler == null) {
            //mHandler = new Handler();
        //}
        //if (!registerForAccelerometerSensor() || !registerForMagneticFieldSensor()) {
            //unregisterFromSensors();
            //sendErrorEvent();
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.320 -0400", hash_original_method = "A3B30EF17FDC8C38C5B1B85F341CAEE6", hash_generated_method = "F89677568426AB4B7FB8C9E9AE566DF4")
    private void getOrientationUsingGetRotationMatrix() {
        if(mGravityVector == null || mMagneticFieldVector == null)        
        {
            return;
        } //End block
        float[] deviceRotationMatrix = new float[9];
        if(!SensorManager.getRotationMatrix(
                deviceRotationMatrix, null, mGravityVector, mMagneticFieldVector))        
        {
            return;
        } //End block
        float[] rotationAngles = new float[3];
        SensorManager.getOrientation(deviceRotationMatrix, rotationAngles);
        double alpha = Math.toDegrees(-rotationAngles[0]) - 90.0;
        while
(alpha < 0.0)        
        {
            alpha += 360.0;
        } //End block
        double beta = Math.toDegrees(-rotationAngles[1]);
        while
(beta < -180.0)        
        {
            beta += 360.0;
        } //End block
        double gamma = Math.toDegrees(rotationAngles[2]);
        while
(gamma < -90.0)        
        {
            gamma += 360.0;
        } //End block
        maybeSendChange(alpha, beta, gamma);
        // ---------- Original Method ----------
        //if (mGravityVector == null || mMagneticFieldVector == null) {
            //return;
        //}
        //float[] deviceRotationMatrix = new float[9];
        //if (!SensorManager.getRotationMatrix(
                //deviceRotationMatrix, null, mGravityVector, mMagneticFieldVector)) {
            //return;
        //}
        //float[] rotationAngles = new float[3];
        //SensorManager.getOrientation(deviceRotationMatrix, rotationAngles);
        //double alpha = Math.toDegrees(-rotationAngles[0]) - 90.0;
        //while (alpha < 0.0) { alpha += 360.0; }
        //double beta = Math.toDegrees(-rotationAngles[1]);
        //while (beta < -180.0) { beta += 360.0; }
        //double gamma = Math.toDegrees(rotationAngles[2]);
        //while (gamma < -90.0) { gamma += 360.0; }
        //maybeSendChange(alpha, beta, gamma);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.322 -0400", hash_original_method = "D09B23AC902B5D9C0E49BB52A156F918", hash_generated_method = "225149FBEE566755F3B686C87EE9F7F9")
    private SensorManager getSensorManager() {
        if(mSensorManager == null)        
        {
            mSensorManager = (SensorManager) mContext.getSystemService(Context.SENSOR_SERVICE);
        } //End block
SensorManager varAF949C78846D4F076444FE5DD86DE06F_1776423920 =         mSensorManager;
        varAF949C78846D4F076444FE5DD86DE06F_1776423920.addTaint(taint);
        return varAF949C78846D4F076444FE5DD86DE06F_1776423920;
        // ---------- Original Method ----------
        //assert WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName());
        //if (mSensorManager == null) {
            //mSensorManager = (SensorManager) mContext.getSystemService(Context.SENSOR_SERVICE);
        //}
        //return mSensorManager;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.323 -0400", hash_original_method = "B3284C523F8E8DEDA1572FA7CE19585B", hash_generated_method = "7459FC141BF55EA41336E0E2C606D79A")
    private boolean registerForAccelerometerSensor() {
        List<Sensor> sensors = getSensorManager().getSensorList(Sensor.TYPE_ACCELEROMETER);
        if(sensors.isEmpty())        
        {
            boolean var68934A3E9455FA72420237EB05902327_269427576 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_796019598 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_796019598;
        } //End block
        boolean var320D0CCDEA6DF6796F8BA2DEE97A55AA_1761816893 = (getSensorManager().registerListener(
                this, sensors.get(0), SensorManager.SENSOR_DELAY_FASTEST, mHandler));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_270197456 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_270197456;
        // ---------- Original Method ----------
        //List<Sensor> sensors = getSensorManager().getSensorList(Sensor.TYPE_ACCELEROMETER);
        //if (sensors.isEmpty()) {
            //return false;
        //}
        //return getSensorManager().registerListener(
                //this, sensors.get(0), SensorManager.SENSOR_DELAY_FASTEST, mHandler);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.323 -0400", hash_original_method = "DFE78C89ABF5437F78B53A9E5486BEA8", hash_generated_method = "5667CF9F377410C95FA65FFE95910D98")
    private boolean registerForMagneticFieldSensor() {
        List<Sensor> sensors = getSensorManager().getSensorList(Sensor.TYPE_MAGNETIC_FIELD);
        if(sensors.isEmpty())        
        {
            boolean var68934A3E9455FA72420237EB05902327_843806934 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1222832640 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1222832640;
        } //End block
        boolean var320D0CCDEA6DF6796F8BA2DEE97A55AA_98997650 = (getSensorManager().registerListener(
                this, sensors.get(0), SensorManager.SENSOR_DELAY_FASTEST, mHandler));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_643817904 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_643817904;
        // ---------- Original Method ----------
        //List<Sensor> sensors = getSensorManager().getSensorList(Sensor.TYPE_MAGNETIC_FIELD);
        //if (sensors.isEmpty()) {
            //return false;
        //}
        //return getSensorManager().registerListener(
                //this, sensors.get(0), SensorManager.SENSOR_DELAY_FASTEST, mHandler);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.324 -0400", hash_original_method = "3017DC11BC04FDEC5E6982352A18F2D7", hash_generated_method = "D951C525941C25B5CE19BA545AA9B4D8")
    private void unregisterFromSensors() {
        getSensorManager().unregisterListener(this);
        // ---------- Original Method ----------
        //getSensorManager().unregisterListener(this);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.324 -0400", hash_original_method = "B4ADD48907D203A526782697C56D84A1", hash_generated_method = "3C1A1EC0C343A6858CE51FA636390E27")
    private void maybeSendChange(double alpha, double beta, double gamma) {
        if(mAlpha == null || mBeta == null || mGamma == null
                || Math.abs(alpha - mAlpha) > DELTA_DEGRESS
                || Math.abs(beta - mBeta) > DELTA_DEGRESS
                || Math.abs(gamma - mGamma) > DELTA_DEGRESS)        
        {
            mAlpha = alpha;
            mBeta = beta;
            mGamma = gamma;
            mManager.onOrientationChange(mAlpha, mBeta, mGamma);
            mHaveSentErrorEvent = false;
        } //End block
        // ---------- Original Method ----------
        //assert WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName());
        //if (mAlpha == null || mBeta == null || mGamma == null
                //|| Math.abs(alpha - mAlpha) > DELTA_DEGRESS
                //|| Math.abs(beta - mBeta) > DELTA_DEGRESS
                //|| Math.abs(gamma - mGamma) > DELTA_DEGRESS) {
            //mAlpha = alpha;
            //mBeta = beta;
            //mGamma = gamma;
            //mManager.onOrientationChange(mAlpha, mBeta, mGamma);
            //mHaveSentErrorEvent = false;
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.326 -0400", hash_original_method = "2695E209DFB6DD433B7C6CE1A619CE79", hash_generated_method = "4B78C89890BD75034BFA745D6F3B71B4")
    public void onSensorChanged(SensorEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(!mIsRunning)        
        {
            return;
        } //End block
switch(event.sensor.getType()){
        case Sensor.TYPE_ACCELEROMETER:
        if(mGravityVector == null)        
        {
            mGravityVector = new float[3];
        } //End block
        mGravityVector[0] = event.values[0];
        mGravityVector[1] = event.values[1];
        mGravityVector[2] = event.values[2];
        getOrientationUsingGetRotationMatrix();
        break;
        case Sensor.TYPE_MAGNETIC_FIELD:
        if(mMagneticFieldVector == null)        
        {
            mMagneticFieldVector = new float[3];
        } //End block
        mMagneticFieldVector[0] = event.values[0];
        mMagneticFieldVector[1] = event.values[1];
        mMagneticFieldVector[2] = event.values[2];
        getOrientationUsingGetRotationMatrix();
        break;
        default:
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.326 -0400", hash_original_method = "4C77A6863BACF480F39B2826F5CA663C", hash_generated_method = "3B735DACA44A7088C201CD04E68BCC26")
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(accuracy);
        addTaint(sensor.getTaint());
        // ---------- Original Method ----------
        //assert WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName());
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.327 -0400", hash_original_field = "7FDCB9E51A150844B0E9DB43E2297EE0", hash_generated_field = "4E3D251C42A5CB0D1F6817ECA2EF0DA8")

    private static final double DELTA_DEGRESS = 1.0;
}

