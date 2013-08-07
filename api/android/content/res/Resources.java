package android.content.res;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.InputStream;
import java.lang.ref.WeakReference;

import libcore.icu.NativePluralRules;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.util.TypedValue;




public class Resources {
    final TypedValue mTmpValue = new TypedValue();
    final Configuration mTmpConfig = new Configuration();
    private final LongSparseArray<WeakReference<Drawable.ConstantState> > mDrawableCache
            = new LongSparseArray<WeakReference<Drawable.ConstantState> >();
    private final SparseArray<WeakReference<ColorStateList> > mColorStateListCache
            = new SparseArray<WeakReference<ColorStateList> >();
    private final LongSparseArray<WeakReference<Drawable.ConstantState> > mColorDrawableCache
            = new LongSparseArray<WeakReference<Drawable.ConstantState> >();
    private boolean mPreloading;
    TypedArray mCachedStyledAttributes = null;
    RuntimeException mLastRetrievedAttrs = null;
    private int mLastCachedXmlBlockIndex = -1;
    private final int[] mCachedXmlBlockIds = { 0, 0, 0, 0 };
    private final XmlBlock[] mCachedXmlBlocks = new XmlBlock[4];
    final AssetManager mAssets;
    private final Configuration mConfiguration = new Configuration();
    final DisplayMetrics mMetrics = new DisplayMetrics();
    private NativePluralRules mPluralRule;
    private CompatibilityInfo mCompatibilityInfo;
    
    @DSModeled
    public Resources(AssetManager assets, DisplayMetrics metrics,
            Configuration config){
		this(assets, metrics, config, (CompatibilityInfo) null);
	}

    
    
    @DSModeled(DSC.BAN)
    public Resources(AssetManager assets, DisplayMetrics metrics,
            Configuration config, CompatibilityInfo compInfo){
		//addTaint(assets.getTaint());
		mAssets = assets;  //Preserved
		//addTaint(compInfo.getTaint());
		mCompatibilityInfo = compInfo;  //Preserved
		/*
		mAssets = assets;
		mMetrics.setToDefaults();
		mCompatibilityInfo = compInfo;
		updateConfiguration(config, metrics);
		assets.ensureStringBlocks();
		*/
	}

    
    @DSModeled(DSC.BAN)
	public Resources() {
	    mAssets = null;
	}

    private static class MyEmptyArray extends LongSparseArray<Object> {
        @DSModeled(DSC.SAFE)
        public MyEmptyArray(int size) {
            //super(size);
        }
    }

    @DSModeled(DSC.BAN)
    @SuppressWarnings("unchecked")
    private static <T> LongSparseArray<T> emptySparseArray() {
        return (LongSparseArray<T>) EMPTY_ARRAY;
    }

    @DSModeled(DSC.BAN)
    public static int selectDefaultTheme(int curTheme, int targetSdkVersion){
		// Original method
		/*
		{
        return selectSystemTheme(curTheme, targetSdkVersion,
                com.android.internal.R.style.Theme,
                com.android.internal.R.style.Theme_Holo,
                com.android.internal.R.style.Theme_DeviceDefault);
    }
		*/
		return 0;
	}

    
    @DSModeled(DSC.BAN)
    public static int selectSystemTheme(int curTheme, int targetSdkVersion,
            int orig, int holo, int deviceDefault){
		// Original method
		/*
		{
        if (curTheme != 0) {
            return curTheme;
        }
        if (targetSdkVersion < Build.VERSION_CODES.HONEYCOMB) {
            return orig;
        }
        if (targetSdkVersion < Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            return holo;
        }
        return deviceDefault;
    }
		*/
		return 0;
	}

    
    @DSModeled(DSC.SAFE)
	public static Resources getSystem(){
	    if (mSystem == null)
	        mSystem = new Resources();
	    return mSystem;
	}



	
	@DSModeled(DSC.SPEC)
	public final String getString(int resId) {
		String str = new String();
        str.addTaint(resId);
        return str;
	}
	
	@DSModeled(DSC.SAFE)
	public final CharSequence getText(int resId) {
        String str = new String();
        str.addTaint(resId);
        return str;
	}
    
	 @DSModeled
	public CharSequence getQuantityText(int id, int quantity){
		
		String str = new String();
		str.addTaint(id);
		str.addTaint(quantity);
		str.addTaint(taint);
		return str;
	}

	  @DSModeled(DSC.BAN)
    private NativePluralRules getPluralRule(){
		// Original method
		/*
		{
        synchronized (mSync) {
            if (mPluralRule == null) {
                mPluralRule = NativePluralRules.forLocale(mConfiguration.locale);
            }
            return mPluralRule;
        }
    }
		*/
		return null;
	}

    
    @DSModeled(DSC.BAN)
	private static int attrForQuantityCode(int quantityCode){
		// Original method
		/*
		{
        switch (quantityCode) {
            case NativePluralRules.ZERO: return 0x01000005;
            case NativePluralRules.ONE:  return 0x01000006;
            case NativePluralRules.TWO:  return 0x01000007;
            case NativePluralRules.FEW:  return 0x01000008;
            case NativePluralRules.MANY: return 0x01000009;
            default:                     return ID_OTHER;
        }
    }
		*/
		return 0;
	}

    
    @DSModeled(DSC.BAN)
	private static String stringForQuantityCode(int quantityCode){
    	String str = new String();
		str.addTaint(quantityCode);
		return str;

	}
	
	
	@DSModeled(DSC.SPEC)
	public String getString(int id, Object... formatArgs){
		String str = new String();
		str.addTaint(id);
		//str.addTaint(formatArgs[0]);
		return str;
	}

    
    @DSModeled(DSC.SPEC)
	public String getQuantityString(int id, int quantity, Object... formatArgs){
    	String str = new String();
		str.addTaint(id);
		str.addTaint(quantity);
		str.addTaint(taint);
		return str;
	}

    
    @DSModeled(DSC.SPEC)
	public String getQuantityString(int id, int quantity){
    	String str = new String();
		str.addTaint(id);
		str.addTaint(quantity);
		str.addTaint(taint);
		return str;
	}

    
    @DSModeled(DSC.SPEC)
	public CharSequence getText(int id, CharSequence def){
    	String str = new String();
		str.addTaint(id);
		str.addTaint(def.taint);
		str.addTaint(taint);
		return str;
	}

    
    @DSModeled(DSC.SPEC)
	public CharSequence[] getTextArray(int id){
		// Original method
		/*
		{
        CharSequence[] res = mAssets.getResourceTextArray(id);
        if (res != null) {
            return res;
        }
        throw new NotFoundException("Text array resource ID #0x"
                                    + Integer.toHexString(id));
    }
		*/
		return null;
	}

    
    @DSModeled(DSC.SPEC)
	public String[] getStringArray(int id){
		// Original method
		/*
		{
        String[] res = mAssets.getResourceStringArray(id);
        if (res != null) {
            return res;
        }
        throw new NotFoundException("String array resource ID #0x"
                                    + Integer.toHexString(id));
    }
		*/
		return null;
	}

    
    @DSModeled(DSC.SPEC)
	public int[] getIntArray(int id){
		// Original method
		/*
		{
        int[] res = mAssets.getArrayIntResource(id);
        if (res != null) {
            return res;
        }
        throw new NotFoundException("Int array resource ID #0x"
                                    + Integer.toHexString(id));
    }
		*/
		return null;
	}

    
    @DSModeled(DSC.SPEC)
	public TypedArray obtainTypedArray(int id){
		// Original method
		/*
		{
        int len = mAssets.getArraySize(id);
        if (len < 0) {
            throw new NotFoundException("Array resource ID #0x"
                                        + Integer.toHexString(id));
        }
        TypedArray array = getCachedStyledAttributes(len);
        array.mLength = mAssets.retrieveArray(id, array.mData);
        array.mIndices[0] = 0;
        return array;
    }
		*/
		return null;
	}

    
    @DSModeled(DSC.SPEC)
	public float getDimension(int id){
		// Original method
		/*
		{
        synchronized (mTmpValue) {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
            if (value.type == TypedValue.TYPE_DIMENSION) {
                return TypedValue.complexToDimension(value.data, mMetrics);
            }
            throw new NotFoundException(
                    "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                    + Integer.toHexString(value.type) + " is not valid");
        }
    }
		*/
		return 0;
	}

    
    @DSModeled(DSC.SPEC)
	public int getDimensionPixelOffset(int id){
		// Original method
		/*
		{
        synchronized (mTmpValue) {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
            if (value.type == TypedValue.TYPE_DIMENSION) {
                return TypedValue.complexToDimensionPixelOffset(
                        value.data, mMetrics);
            }
            throw new NotFoundException(
                    "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                    + Integer.toHexString(value.type) + " is not valid");
        }
    }
		*/
		return 0;
	}

    
    @DSModeled(DSC.SPEC)
	public int getDimensionPixelSize(int id){
		// Original method
		/*
		{
        synchronized (mTmpValue) {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
            if (value.type == TypedValue.TYPE_DIMENSION) {
                return TypedValue.complexToDimensionPixelSize(
                        value.data, mMetrics);
            }
            throw new NotFoundException(
                    "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                    + Integer.toHexString(value.type) + " is not valid");
        }
    }
		*/
		return 0;
	}

    
    @DSModeled(DSC.SPEC)
	public float getFraction(int id, int base, int pbase){
		// Original method
		/*
		{
        synchronized (mTmpValue) {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
            if (value.type == TypedValue.TYPE_FRACTION) {
                return TypedValue.complexToFraction(value.data, base, pbase);
            }
            throw new NotFoundException(
                    "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                    + Integer.toHexString(value.type) + " is not valid");
        }
    }
		*/
		return 0;
	}

    
    @DSModeled(DSC.SPEC)
	public Drawable getDrawable(int id){
		// Original method
		/*
		{
        synchronized (mTmpValue) {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
            return loadDrawable(value, id);
        }
    }
		*/
		return null;
	}

    
    @DSModeled(DSC.BAN)
	public Drawable getDrawableForDensity(int id, int density){
		// Original method
		/*
		{
        synchronized (mTmpValue) {
            TypedValue value = mTmpValue;
            getValueForDensity(id, density, value, true);
            if (value.density > 0 && value.density != TypedValue.DENSITY_NONE) {
                if (value.density == density) {
                    value.density = DisplayMetrics.DENSITY_DEVICE;
                } else {
                    value.density = (value.density * DisplayMetrics.DENSITY_DEVICE) / density;
                }
            }
            return loadDrawable(value, id);
        }
    }
		*/
		return null;
	}

    
    @DSModeled(DSC.SPEC)
	public Movie getMovie(int id){
		// Original method
		/*
		{
        InputStream is = openRawResource(id);
        Movie movie = Movie.decodeStream(is);
        try {
            is.close();
        }
        catch (java.io.IOException e) {
        }
        return movie;
    }
		*/
		return null;
	}

    
    @DSModeled(DSC.SPEC)
	public int getColor(int id){
		// Original method
		/*
		{
        synchronized (mTmpValue) {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
            if (value.type >= TypedValue.TYPE_FIRST_INT
                && value.type <= TypedValue.TYPE_LAST_INT) {
                return value.data;
            } else if (value.type == TypedValue.TYPE_STRING) {
                ColorStateList csl = loadColorStateList(mTmpValue, id);
                return csl.getDefaultColor();
            }
            throw new NotFoundException(
                "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                + Integer.toHexString(value.type) + " is not valid");
        }
    }
		*/
		return 0;
	}

    
    @DSModeled(DSC.SPEC)
	public ColorStateList getColorStateList(int id){
		// Original method
		/*
		{
        synchronized (mTmpValue) {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
            return loadColorStateList(value, id);
        }
    }
		*/
		return null;
	}

    
    @DSModeled(DSC.SPEC)
	public boolean getBoolean(int id){
		// Original method
		/*
		{
        synchronized (mTmpValue) {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
            if (value.type >= TypedValue.TYPE_FIRST_INT
                && value.type <= TypedValue.TYPE_LAST_INT) {
                return value.data != 0;
            }
            throw new NotFoundException(
                "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                + Integer.toHexString(value.type) + " is not valid");
        }
    }
		*/
		return false;
	}

    
    @DSModeled(DSC.SPEC)
	public int getInteger(int id){
		// Original method
		/*
		{
        synchronized (mTmpValue) {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
            if (value.type >= TypedValue.TYPE_FIRST_INT
                && value.type <= TypedValue.TYPE_LAST_INT) {
                return value.data;
            }
            throw new NotFoundException(
                "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                + Integer.toHexString(value.type) + " is not valid");
        }
    }
		*/
		return 0;
	}

    
    @DSModeled(DSC.SPEC)
	public XmlResourceParser getLayout(int id){
		// Original method
		/*
		{
        return loadXmlResourceParser(id, "layout");
    }
		*/
		return null;
	}

    
    @DSModeled(DSC.SPEC)
	public XmlResourceParser getAnimation(int id){
		// Original method
		/*
		{
        return loadXmlResourceParser(id, "anim");
    }
		*/
		return null;
	}

    
    @DSModeled(DSC.SPEC)
	public XmlResourceParser getXml(int id){
		// Original method
		/*
		{
        return loadXmlResourceParser(id, "xml");
    }
		*/
		return null;
	}

    
    @DSModeled(DSC.SPEC)
	public InputStream openRawResource(int id){
		// Original method
		/*
		{
        synchronized (mTmpValue) {
            return openRawResource(id, mTmpValue);
        }
    }
		*/
		return null;
	}

    
    @DSModeled(DSC.SPEC)
	public InputStream openRawResource(int id, TypedValue value){
		// Original method
		/*
		{
        getValue(id, value, true);
        try {
            return mAssets.openNonAsset(value.assetCookie, value.string.toString(),
                    AssetManager.ACCESS_STREAMING);
        } catch (Exception e) {
            NotFoundException rnf = new NotFoundException("File " + value.string.toString() +
                    " from drawable resource ID #0x" + Integer.toHexString(id));
            rnf.initCause(e);
            throw rnf;
        }
    }
		*/
		return null;
	}

    
    @DSModeled(DSC.SPEC)
	public AssetFileDescriptor openRawResourceFd(int id){
		// Original method
		/*
		{
        synchronized (mTmpValue) {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
            try {
                return mAssets.openNonAssetFd(
                    value.assetCookie, value.string.toString());
            } catch (Exception e) {
                NotFoundException rnf = new NotFoundException(
                    "File " + value.string.toString()
                    + " from drawable resource ID #0x"
                    + Integer.toHexString(id));
                rnf.initCause(e);
                throw rnf;
            }
        }
    }
		*/
		return null;
	}

    
    @DSModeled(DSC.SPEC)
	public void getValue(int id, TypedValue outValue, boolean resolveRefs){
		// Original method
		/*
		{
        boolean found = mAssets.getResourceValue(id, 0, outValue, resolveRefs);
        if (found) {
            return;
        }
        throw new NotFoundException("Resource ID #0x"
                                    + Integer.toHexString(id));
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.BAN)
	public void getValueForDensity(int id, int density, TypedValue outValue, boolean resolveRefs){
		// Original method
		/*
		{
        boolean found = mAssets.getResourceValue(id, density, outValue, resolveRefs);
        if (found) {
            return;
        }
        throw new NotFoundException("Resource ID #0x" + Integer.toHexString(id));
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SPEC)
	public void getValue(String name, TypedValue outValue, boolean resolveRefs){
		// Original method
		/*
		{
        int id = getIdentifier(name, "string", null);
        if (id != 0) {
            getValue(id, outValue, resolveRefs);
            return;
        }
        throw new NotFoundException("String resource name " + name);
    }
		*/
		//Return nothing
	}

    
    public final Theme newTheme(){
		// Original method
		/*
		{
        return new Theme();
    }
		*/
		return null;
	}

    
    public TypedArray obtainAttributes(AttributeSet set, int[] attrs){
		// Original method
		/*
		{
        int len = attrs.length;
        TypedArray array = getCachedStyledAttributes(len);
        XmlBlock.Parser parser = (XmlBlock.Parser)set;
        mAssets.retrieveAttributes(parser.mParseState, attrs,
                array.mData, array.mIndices);
        array.mRsrcs = attrs;
        array.mXml = parser;
        return array;
    }
		*/
		return null;
	}

    
    public void updateConfiguration(Configuration config,
            DisplayMetrics metrics){
		// Original method
		/*
		{
        updateConfiguration(config, metrics, null);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.BAN)
    public void updateConfiguration(Configuration config,
            DisplayMetrics metrics, CompatibilityInfo compat){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    @DSModeled(DSC.BAN)
    private void clearDrawableCache(
            LongSparseArray<WeakReference<ConstantState>> cache,
            int configChanges){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    @DSModeled(DSC.BAN)
    public static void updateSystemConfiguration(Configuration config, DisplayMetrics metrics,
            CompatibilityInfo compat){
		// Original method
		/*
		{
        if (mSystem != null) {
            mSystem.updateConfiguration(config, metrics, compat);
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.BAN)
    public static void updateSystemConfiguration(Configuration config, DisplayMetrics metrics){
		// Original method
		/*
		{
        updateSystemConfiguration(config, metrics, null);
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public DisplayMetrics getDisplayMetrics(){
		return mMetrics;
		// Original method
		/*
		{
        if (DEBUG_CONFIG) Slog.v(TAG, "Returning DisplayMetrics: " + mMetrics.widthPixels
                + "x" + mMetrics.heightPixels + " " + mMetrics.density);
        return mMetrics;
    }
		*/
	}

    
    @DSModeled(DSC.SAFE)
    public Configuration getConfiguration(){
        return mConfiguration;
	}

    
    @DSModeled(DSC.BAN)
    public CompatibilityInfo getCompatibilityInfo(){
		// Original method
		/*
		{
        return mCompatibilityInfo != null ? mCompatibilityInfo
                : CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO;
    }
		*/
		return null;
	}

    
    @DSModeled(DSC.BAN)
    public void setCompatibilityInfo(CompatibilityInfo ci){
		//addTaint(ci.getTaint());
		mCompatibilityInfo = ci;  //Preserved
		// Original method
		/*
		{
        mCompatibilityInfo = ci;
        updateConfiguration(mConfiguration, mMetrics);
    }
		*/
		//Return nothing
	}

    
    public int getIdentifier(String name, String defType, String defPackage){
		// Original method
		/*
		{
        try {
            return Integer.parseInt(name);
        } catch (Exception e) {
        }
        return mAssets.getResourceIdentifier(name, defType, defPackage);
    }
		*/
		return 0;
	}

    
    public String getResourceName(int resid){
		// Original method
		/*
		{
        String str = mAssets.getResourceName(resid);
        if (str != null) return str;
        throw new NotFoundException("Unable to find resource ID #0x"
                + Integer.toHexString(resid));
    }
		*/
		return "";
	}

    
    public String getResourcePackageName(int resid){
		// Original method
		/*
		{
        String str = mAssets.getResourcePackageName(resid);
        if (str != null) return str;
        throw new NotFoundException("Unable to find resource ID #0x"
                + Integer.toHexString(resid));
    }
		*/
		return "";
	}

    @DSModeled
    public String getResourceTypeName(int resid){
		// Original method
		/*
		{
        String str = mAssets.getResourceTypeName(resid);
        if (str != null) return str;
        throw new NotFoundException("Unable to find resource ID #0x"
                + Integer.toHexString(resid));
    }
		*/
		return "";
	}

    @DSModeled
    public String getResourceEntryName(int resid){
		// Original method
		/*
		{
        String str = mAssets.getResourceEntryName(resid);
        if (str != null) return str;
        throw new NotFoundException("Unable to find resource ID #0x"
                + Integer.toHexString(resid));
    }
		*/
		return "";
	}

    @DSModeled
    public void parseBundleExtras(XmlResourceParser parser, Bundle outBundle){
		// Original method
		/*
		{
        int outerDepth = parser.getDepth();
        int type;
        while ((type=parser.next()) != XmlPullParser.END_DOCUMENT
               && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth)) {
            if (type == XmlPullParser.END_TAG || type == XmlPullParser.TEXT) {
                continue;
            }
            String nodeName = parser.getName();
            if (nodeName.equals("extra")) {
                parseBundleExtra("extra", parser, outBundle);
                XmlUtils.skipCurrentTag(parser);
            } else {
                XmlUtils.skipCurrentTag(parser);
            }
        }        
    }
		*/
		//Return nothing
	}

    @DSModeled
    public void parseBundleExtra(String tagName, AttributeSet attrs,
            Bundle outBundle){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}

    
    @DSModeled(DSC.SAFE)
    public final AssetManager getAssets(){
        return mAssets;
	}

    
    public final void flushLayoutCache(){
		// Original method
		/*
		{
        synchronized (mCachedXmlBlockIds) {
            final int num = mCachedXmlBlockIds.length;
            for (int i=0; i<num; i++) {
                mCachedXmlBlockIds[i] = -0;
                XmlBlock oldBlock = mCachedXmlBlocks[i];
                if (oldBlock != null) {
                    oldBlock.close();
                }
                mCachedXmlBlocks[i] = null;
            }
        }
    }
		*/
		//Return nothing
	}

    
    @DSModeled(DSC.BAN)
    public final void startPreloading(){
		// Original method
		/*
		{
        synchronized (mSync) {
            if (mPreloaded) {
                throw new IllegalStateException("Resources already preloaded");
            }
            mPreloaded = true;
            mPreloading = true;
        }
    }
		*/
		//Return nothing
	}

    
    public final void finishPreloading(){
		// Original method
		/*
		{
        if (mPreloading) {
            mPreloading = false;
            flushLayoutCache();
        }
    }
		*/
		//Return nothing
	}

    
    Drawable loadDrawable(TypedValue value, int id){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return null;
	}

    
    @DSModeled(DSC.BAN)
    private Drawable getCachedDrawable(
            LongSparseArray<WeakReference<ConstantState>> drawableCache,
            long key){
		// Original method
		/*
		{
        synchronized (mTmpValue) {
            WeakReference<Drawable.ConstantState> wr = drawableCache.get(key);
            if (wr != null) {   
                Drawable.ConstantState entry = wr.get();
                if (entry != null) {
                    return entry.newDrawable(this);
                }
                else {  
                    drawableCache.delete(key);
                }
            }
        }
        return null;
    }
		*/
		return null;
	}

    
    ColorStateList loadColorStateList(TypedValue value, int id){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return null;
	}

    
    @DSModeled(DSC.BAN)
    private ColorStateList getCachedColorStateList(int key){
		// Original method
		/*
		{
        synchronized (mTmpValue) {
            WeakReference<ColorStateList> wr = mColorStateListCache.get(key);
            if (wr != null) {   
                ColorStateList entry = wr.get();
                if (entry != null) {
                    return entry;
                }
                else {  
                    mColorStateListCache.delete(key);
                }
            }
        }
        return null;
    }
		*/
		return null;
	}

    
    XmlResourceParser loadXmlResourceParser(int id, String type){
		// Original method
		/*
		{
        synchronized (mTmpValue) {
            TypedValue value = mTmpValue;
            getValue(id, value, true);
            if (value.type == TypedValue.TYPE_STRING) {
                return loadXmlResourceParser(value.string.toString(), id,
                        value.assetCookie, type);
            }
            throw new NotFoundException(
                    "Resource ID #0x" + Integer.toHexString(id) + " type #0x"
                    + Integer.toHexString(value.type) + " is not valid");
        }
    }
		*/
		return null;
	}

    
    XmlResourceParser loadXmlResourceParser(String file, int id,
            int assetCookie, String type){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return null;
	}

    
    @DSModeled(DSC.BAN)
    private TypedArray getCachedStyledAttributes(int len){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return null;
	}

    
    public static class NotFoundException extends RuntimeException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.136 -0400", hash_original_method = "16646BE2B605A836CC81C1207D23548C", hash_generated_method = "57BD6F9AE62C00D5DA005539BF3270C7")
        @DSModeled(DSC.SAFE)
        public  NotFoundException() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.136 -0400", hash_original_method = "4E6E00F1F6EDF0AE5B66F6F35CDBCBD1", hash_generated_method = "3B0DADC8F2E02A2F21624EB7BCDA9AFB")
        @DSModeled(DSC.SAFE)
        public  NotFoundException(String name) {
            super(name);
            addTaint(name.getTaint());
            // ---------- Original Method ----------
        }
        
    }


    
    public final class Theme {
        private final AssetManager mAssets = null;
        private final int mTheme = 0;
        
        Theme(){
			/*
			mAssets = Resources.this.mAssets;
			mTheme = mAssets.createTheme();
			*/
		}

        
        public void applyStyle(int resid, boolean force){
			// Original method
			/*
			{
            AssetManager.applyThemeStyle(mTheme, resid, force);
        }
			*/
			//Return nothing
		}

        
        public void setTo(Theme other){
			// Original method
			/*
			{
            AssetManager.copyTheme(mTheme, other.mTheme);
        }
			*/
			//Return nothing
		}

        
        public TypedArray obtainStyledAttributes(int[] attrs){
			// Original method
			/*
			{
            int len = attrs.length;
            TypedArray array = getCachedStyledAttributes(len);
            array.mRsrcs = attrs;
            AssetManager.applyStyle(mTheme, 0, 0, 0, attrs,
                    array.mData, array.mIndices);
            return array;
        }
			*/
			return null;
		}

        
        public TypedArray obtainStyledAttributes(int resid, int[] attrs){
			// Original method
			/* Original Method Too Long, Refer to Original Implementation */
			return null;
		}

        
        public TypedArray obtainStyledAttributes(AttributeSet set,
                int[] attrs, int defStyleAttr, int defStyleRes){
			// Original method
			/* Original Method Too Long, Refer to Original Implementation */
			return null;
		}

        
        public boolean resolveAttribute(int resid, TypedValue outValue,
                boolean resolveRefs){
			// Original method
			/*
			{
            boolean got = mAssets.getThemeValue(mTheme, resid, outValue, resolveRefs);
            if (false) {
                System.out.println(
                    "resolveAttribute #" + Integer.toHexString(resid)
                    + " got=" + got + ", type=0x" + Integer.toHexString(outValue.type)
                    + ", data=0x" + Integer.toHexString(outValue.data));
            }
            return got;
        }
			*/
			return false;
		}

        
        public void dump(int priority, String tag, String prefix){
			// Original method
			/*
			{
            AssetManager.dumpTheme(mTheme, priority, tag, prefix);
        }
			*/
			//Return nothing
		}

        
        protected void finalize(){
			// Original method
			/*
			{
            super.finalize();
            mAssets.releaseTheme(mTheme);
        }
			*/
			//Return nothing
		}

        
    }


    
    static final String TAG = "Resources";
    private static final boolean DEBUG_LOAD = false;
    private static final boolean DEBUG_CONFIG = false;
    private static final boolean DEBUG_ATTRIBUTES_CACHE = false;
    private static final boolean TRACE_FOR_PRELOAD = false;
    private static final boolean TRACE_FOR_MISS_PRELOAD = false;
    private static final int ID_OTHER = 0x01000004;
    private static final Object mSync = new Object();
    static Resources mSystem = null;
    private static final LongSparseArray<Drawable.ConstantState> sPreloadedDrawables
            = new LongSparseArray<Drawable.ConstantState>();
    private static final SparseArray<ColorStateList> mPreloadedColorStateLists
            = new SparseArray<ColorStateList>();
    private static final LongSparseArray<Drawable.ConstantState> sPreloadedColorDrawables
            = new LongSparseArray<Drawable.ConstantState>();
    private static boolean mPreloaded;
    private static final LongSparseArray<Object> EMPTY_ARRAY = new MyEmptyArray(0);
}

