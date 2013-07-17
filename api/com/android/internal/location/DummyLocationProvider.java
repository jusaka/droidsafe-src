package com.android.internal.location;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.location.ILocationManager;
import android.location.LocationProvider;

public class DummyLocationProvider extends LocationProvider {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.221 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C")

    String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.221 -0400", hash_original_field = "182459C6AF0846CF429E94DF2B5959BF", hash_generated_field = "DF2B3171B11A67F621676EF40A236159")

    boolean mRequiresNetwork;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.221 -0400", hash_original_field = "EFC1F8EB20F439228277C82383DD8A28", hash_generated_field = "2FAE948EF0EDA44AE36030A345BCA7F9")

    boolean mRequiresSatellite;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.221 -0400", hash_original_field = "E39A10840F71D93205DC1F88A34956EC", hash_generated_field = "CD2451BEADF29CB4B04A5FBF2BECE7A5")

    boolean mRequiresCell;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.221 -0400", hash_original_field = "B83959B604F2556CE5CD8C482DC210E6", hash_generated_field = "9BB0C6F2515CD3D4097971FB7222AFC9")

    boolean mHasMonetaryCost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.221 -0400", hash_original_field = "FCDDD58BCD6E2BF64ED3B1463A2C99BB", hash_generated_field = "FE17A406A6FDB81F55F27A7ED9FDCF16")

    boolean mSupportsAltitude;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.221 -0400", hash_original_field = "B441555425878714F69CE88456EA4B51", hash_generated_field = "E9787058DB54707705A7DDFE4B3B4B19")

    boolean mSupportsSpeed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.221 -0400", hash_original_field = "421850CAFF8369DEEAE79E4BFA800D3E", hash_generated_field = "8D283BB3EB5888B0DE27DB1FD6DF7003")

    boolean mSupportsBearing;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.222 -0400", hash_original_field = "8CE6AA00EE3C11F8598CD0D337F6CAE9", hash_generated_field = "16051051674F42DF07BACDCFF2C64789")

    int mPowerRequirement;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.222 -0400", hash_original_field = "662D142255956BF41BF8EF5110A28B67", hash_generated_field = "A988C0B68D6A03FA302108721EA90905")

    int mAccuracy;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.222 -0400", hash_original_method = "2D2A21251E5C69E5D6553C80AB5C5FAF", hash_generated_method = "0F2EE2A59421CE5E665E6F54FE7883D8")
    public  DummyLocationProvider(String name, ILocationManager service) {
        super(name, service);
        addTaint(service.getTaint());
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.223 -0400", hash_original_method = "1F8DE8B3742DB968D48AC8E46FA2231B", hash_generated_method = "B491D2865225D184CA94E5FDA8C8C83A")
    public void setRequiresNetwork(boolean requiresNetwork) {
        mRequiresNetwork = requiresNetwork;
        // ---------- Original Method ----------
        //mRequiresNetwork = requiresNetwork;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.223 -0400", hash_original_method = "29EAF7BAC1D59C67F0068E19069EC95C", hash_generated_method = "6417F8E937DEF182FD4384B8EC43DEFA")
    public void setRequiresSatellite(boolean requiresSatellite) {
        mRequiresSatellite = requiresSatellite;
        // ---------- Original Method ----------
        //mRequiresSatellite = requiresSatellite;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.223 -0400", hash_original_method = "800DBE9AB92460271BA9850123B2E01B", hash_generated_method = "59AA1D4331D17CE5FE6E163324E4AAF8")
    public void setRequiresCell(boolean requiresCell) {
        mRequiresCell = requiresCell;
        // ---------- Original Method ----------
        //mRequiresCell = requiresCell;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.224 -0400", hash_original_method = "3E58BDCD583420258AF42AE15C5A1B66", hash_generated_method = "7A8F281C030D2AB2F4123F69F3ED81E7")
    public void setHasMonetaryCost(boolean hasMonetaryCost) {
        mHasMonetaryCost = hasMonetaryCost;
        // ---------- Original Method ----------
        //mHasMonetaryCost = hasMonetaryCost;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.224 -0400", hash_original_method = "CCF8D193AEBD5AA7F01F4990E2AE806C", hash_generated_method = "038ABF6E048EB620C4682786FEA54672")
    public void setSupportsAltitude(boolean supportsAltitude) {
        mSupportsAltitude = supportsAltitude;
        // ---------- Original Method ----------
        //mSupportsAltitude = supportsAltitude;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.224 -0400", hash_original_method = "92E2AFB41DD112983B18606F5344DACF", hash_generated_method = "ADEA9A24C7E4EA76ACFC2A2BDA342523")
    public void setSupportsSpeed(boolean supportsSpeed) {
        mSupportsSpeed = supportsSpeed;
        // ---------- Original Method ----------
        //mSupportsSpeed = supportsSpeed;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.225 -0400", hash_original_method = "F9CE2AAA32ACB1BAFD2F9DDDA0BB7D16", hash_generated_method = "8412DD7B3724FC89A37067DC4C863938")
    public void setSupportsBearing(boolean supportsBearing) {
        mSupportsBearing = supportsBearing;
        // ---------- Original Method ----------
        //mSupportsBearing = supportsBearing;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.225 -0400", hash_original_method = "2C88F96CAFDD5DC38199E97F56E6E512", hash_generated_method = "AB54773A7A0BA7F8B4062B2F76D15C71")
    public void setPowerRequirement(int powerRequirement) {
        mPowerRequirement = powerRequirement;
        // ---------- Original Method ----------
        //mPowerRequirement = powerRequirement;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.225 -0400", hash_original_method = "50C70CC35BE1C99F5177BBD5E6545CA6", hash_generated_method = "D288525613995EDA7816DABBB501D13A")
    public void setAccuracy(int accuracy) {
        mAccuracy = accuracy;
        // ---------- Original Method ----------
        //mAccuracy = accuracy;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.226 -0400", hash_original_method = "12AE735753CC1F454105371651D9BBA1", hash_generated_method = "ED957AE08E2A191D830E140E04470858")
    public boolean requiresNetwork() {
        boolean var182459C6AF0846CF429E94DF2B5959BF_257423319 = (mRequiresNetwork);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_769912466 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_769912466;
        // ---------- Original Method ----------
        //return mRequiresNetwork;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.226 -0400", hash_original_method = "A3DAE9100E63CBDE8137FDA5BE5C7B6B", hash_generated_method = "2E87FDAA4C9A342DE29B36698DF0FE71")
    public boolean requiresSatellite() {
        boolean varEFC1F8EB20F439228277C82383DD8A28_1666039235 = (mRequiresSatellite);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1103053999 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1103053999;
        // ---------- Original Method ----------
        //return mRequiresSatellite;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.226 -0400", hash_original_method = "BE22582F45632E0BED7FA33E3D9F0EE8", hash_generated_method = "B7FFED801756EF4E9205C53B9A74479C")
    public boolean requiresCell() {
        boolean varE39A10840F71D93205DC1F88A34956EC_542742884 = (mRequiresCell);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_737889432 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_737889432;
        // ---------- Original Method ----------
        //return mRequiresCell;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.227 -0400", hash_original_method = "464B91F9461F0393A5548F6081396811", hash_generated_method = "868BE07951D0714977D28D62B0936694")
    public boolean hasMonetaryCost() {
        boolean varB83959B604F2556CE5CD8C482DC210E6_1103152992 = (mHasMonetaryCost);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_867514968 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_867514968;
        // ---------- Original Method ----------
        //return mHasMonetaryCost;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.227 -0400", hash_original_method = "80EB2267564425834001A2243EC06FBE", hash_generated_method = "F26A4479CB89D67514243968711B33AF")
    public boolean supportsAltitude() {
        boolean varFCDDD58BCD6E2BF64ED3B1463A2C99BB_606488186 = (mSupportsAltitude);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_648790672 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_648790672;
        // ---------- Original Method ----------
        //return mSupportsAltitude;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.227 -0400", hash_original_method = "F5A7ECCEC7D24AC04E83E34652847C55", hash_generated_method = "17C94D78E9F0B2F40BCEF44CA5250F09")
    public boolean supportsSpeed() {
        boolean varB441555425878714F69CE88456EA4B51_688342209 = (mSupportsSpeed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1430814556 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1430814556;
        // ---------- Original Method ----------
        //return mSupportsSpeed;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.227 -0400", hash_original_method = "ADDCD70E458E7B4958723B2C0A9B7ABB", hash_generated_method = "5938055FBB784C107678D63238B8023A")
    public boolean supportsBearing() {
        boolean var421850CAFF8369DEEAE79E4BFA800D3E_209589609 = (mSupportsBearing);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_140293176 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_140293176;
        // ---------- Original Method ----------
        //return mSupportsBearing;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.227 -0400", hash_original_method = "50AB5D6061392E8FAC8A81CA41B14FB2", hash_generated_method = "D9DEB5740C78EF3055F05F5607EEDD1F")
    public int getPowerRequirement() {
        int var8CE6AA00EE3C11F8598CD0D337F6CAE9_1372704212 = (mPowerRequirement);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1025365362 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1025365362;
        // ---------- Original Method ----------
        //return mPowerRequirement;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.228 -0400", hash_original_method = "8D132D636D1C633E7B8C919AFBA33B78", hash_generated_method = "4BD05EE322638BEC2243CE205E722E8E")
    public int getAccuracy() {
        int var662D142255956BF41BF8EF5110A28B67_153518083 = (mAccuracy);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_391543646 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_391543646;
        // ---------- Original Method ----------
        //return mAccuracy;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.228 -0400", hash_original_field = "6DB4E50C9647E9E62752AF81FB6BC633", hash_generated_field = "901EFB6E43A09AC53DEA608D292AE5C5")

    private static final String TAG = "DummyLocationProvider";
}

