package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListFragment extends Fragment {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.569 -0400", hash_original_field = "6781893E9FA50A9B7103FD3F674E566B", hash_generated_field = "ED5BAD7C7A1EC83F341419B29A267C9F")

    final private Handler mHandler = new Handler();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.105 -0400", hash_original_field = "F487762B42FCD79D908F11802425F9AE", hash_generated_field = "1DE73C7158094283DF2E07B61B66A0F0")

    final private Runnable mRequestFocus = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.105 -0400", hash_original_method = "4F290F2508C3F0B44E09591C5B0749BC", hash_generated_method = "203642A5324F5F18B21A0D020E65FD5C")
        public void run() {
            mList.focusableViewAvailable(mList);
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.106 -0400", hash_original_field = "9B3F30A71979D6623D111E114AFFBE5E", hash_generated_field = "42C04E77E3D60E8D569E30C744D85151")

    final private AdapterView.OnItemClickListener mOnClickListener = new AdapterView.OnItemClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:19.105 -0400", hash_original_method = "FBAC6E1DF4BED6C0A21E33622DB577EE", hash_generated_method = "D00BEF8ABA88B27607955BB6270FA24E")
        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            
            onListItemClick((ListView)parent, v, position, id);
            addTaint(parent.getTaint());
            addTaint(v.getTaint());
            addTaint(position);
            addTaint(id);
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.569 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "CBDD62EF585589E92C0E00AE9F4F22E2")

    ListAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.569 -0400", hash_original_field = "F796A16BE866311501B24C73148D80F1", hash_generated_field = "A5B73AC2B922200A8C47FEAA8C3EB07A")

    ListView mList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.569 -0400", hash_original_field = "70C77B82E1F7307619839CA84E110E30", hash_generated_field = "7791203818A2C8C23F9ABF8545C329FB")

    View mEmptyView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.569 -0400", hash_original_field = "55016CBFD3CE49ADBAB505CE2082E915", hash_generated_field = "1BF76B462D7F24436F14F7F745BB541C")

    TextView mStandardEmptyView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.570 -0400", hash_original_field = "56720DB5DBB6738225C3A90D862F1AB2", hash_generated_field = "5A35A3CD88A2CD2FFD5E60C83A9EA805")

    View mProgressContainer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.570 -0400", hash_original_field = "45A98EEED29C789395ED1681F7616E63", hash_generated_field = "4BEB12F6053492A04536FE88CDB7F3C9")

    View mListContainer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.570 -0400", hash_original_field = "7AE2AFD490CFC5D0B1BA25431F78642B", hash_generated_field = "D3680587F795E32338C0D453701D98D2")

    CharSequence mEmptyText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.570 -0400", hash_original_field = "EEBC082FD5621811F12260D0FCF8CF84", hash_generated_field = "DED3E45D8C8FC4CDC3B9DE2C2A90BA30")

    boolean mListShown;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.570 -0400", hash_original_method = "EF57861318B397409B17ABF77AE47B37", hash_generated_method = "D5B2EF6298161BB1BE7DCF257A07817C")
    public  ListFragment() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.572 -0400", hash_original_method = "BEDEF1303F07526C038707780C2D3CB6", hash_generated_method = "F402FAC1D445F5F4F680FAA99AA19D3B")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(savedInstanceState.getTaint());
        addTaint(container.getTaint());
        addTaint(inflater.getTaint());
View var1B87B9722589983B280E6A80193F3C07_1933071262 =         inflater.inflate(com.android.internal.R.layout.list_content,
                container, false);
        var1B87B9722589983B280E6A80193F3C07_1933071262.addTaint(taint);
        return var1B87B9722589983B280E6A80193F3C07_1933071262;
        // ---------- Original Method ----------
        //return inflater.inflate(com.android.internal.R.layout.list_content,
                //container, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.573 -0400", hash_original_method = "3AF156F2799514C47B044D45A77C4F43", hash_generated_method = "2BCE58E31FB785C574D5AEC6E88F358A")
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(savedInstanceState.getTaint());
        addTaint(view.getTaint());
        super.onViewCreated(view, savedInstanceState);
        ensureList();
        // ---------- Original Method ----------
        //super.onViewCreated(view, savedInstanceState);
        //ensureList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.574 -0400", hash_original_method = "4AE67C9B14400A0313E10E10FEB59F4C", hash_generated_method = "350457CE5B7B3348E789915760B51908")
    @Override
    public void onDestroyView() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mHandler.removeCallbacks(mRequestFocus);
        mList = null;
        mListShown = false;
        mEmptyView = mProgressContainer = mListContainer = null;
        mStandardEmptyView = null;
        super.onDestroyView();
        // ---------- Original Method ----------
        //mHandler.removeCallbacks(mRequestFocus);
        //mList = null;
        //mListShown = false;
        //mEmptyView = mProgressContainer = mListContainer = null;
        //mStandardEmptyView = null;
        //super.onDestroyView();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.574 -0400", hash_original_method = "BF490B4BB4BD29ACC689E0297B614061", hash_generated_method = "88BEAA79114E29F33BC32B86B2051CD9")
    public void onListItemClick(ListView l, View v, int position, long id) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(id);
        addTaint(position);
        addTaint(v.getTaint());
        addTaint(l.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.575 -0400", hash_original_method = "B9F859547BD6410EA28F34027A6366BE", hash_generated_method = "603A4D55808103A90D851FF671C09445")
    public void setListAdapter(ListAdapter adapter) {
        boolean hadAdapter = mAdapter != null;
        mAdapter = adapter;
        if(mList != null)        
        {
            mList.setAdapter(adapter);
            if(!mListShown && !hadAdapter)            
            {
                setListShown(true, getView().getWindowToken() != null);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //boolean hadAdapter = mAdapter != null;
        //mAdapter = adapter;
        //if (mList != null) {
            //mList.setAdapter(adapter);
            //if (!mListShown && !hadAdapter) {
                //setListShown(true, getView().getWindowToken() != null);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.575 -0400", hash_original_method = "6FC4BB7AE2BE523C1207DDD3222220F6", hash_generated_method = "6D445B8D673D3639928814553952A446")
    public void setSelection(int position) {
        addTaint(position);
        ensureList();
        mList.setSelection(position);
        // ---------- Original Method ----------
        //ensureList();
        //mList.setSelection(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.576 -0400", hash_original_method = "602C73B7F7242D55D7B4B399409B7E51", hash_generated_method = "054FA073BC97D890368B8BF5E7873997")
    public int getSelectedItemPosition() {
        ensureList();
        int varB3259E78107540D8D68BCBB3E503CBA4_36753569 = (mList.getSelectedItemPosition());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1840671032 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1840671032;
        // ---------- Original Method ----------
        //ensureList();
        //return mList.getSelectedItemPosition();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.576 -0400", hash_original_method = "7FA8F631361DB814AF49E068AB6A3A01", hash_generated_method = "9D51F070F4DD52470D16D24E9917AAD8")
    public long getSelectedItemId() {
        ensureList();
        long var9B989EB69692C97E4AB8970CCD694C25_1970846890 = (mList.getSelectedItemId());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_386363951 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_386363951;
        // ---------- Original Method ----------
        //ensureList();
        //return mList.getSelectedItemId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.577 -0400", hash_original_method = "B9D8406BF510100833C8B83670824289", hash_generated_method = "7F997D21684F9C1E616482AF9417D03E")
    public ListView getListView() {
        ensureList();
ListView var344AE622895130273F3D062543816FEE_996198527 =         mList;
        var344AE622895130273F3D062543816FEE_996198527.addTaint(taint);
        return var344AE622895130273F3D062543816FEE_996198527;
        // ---------- Original Method ----------
        //ensureList();
        //return mList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.577 -0400", hash_original_method = "BDE8F4E2DF99E8DBF624FF236090A0E2", hash_generated_method = "2CBF4AE71D67641A355DE8ABFD16DD2A")
    public void setEmptyText(CharSequence text) {
        ensureList();
        if(mStandardEmptyView == null)        
        {
            IllegalStateException varD4103A519630FF4520E774F631D45BAC_1593601844 = new IllegalStateException("Can't be used with a custom content view");
            varD4103A519630FF4520E774F631D45BAC_1593601844.addTaint(taint);
            throw varD4103A519630FF4520E774F631D45BAC_1593601844;
        } //End block
        mStandardEmptyView.setText(text);
        if(mEmptyText == null)        
        {
            mList.setEmptyView(mStandardEmptyView);
        } //End block
        mEmptyText = text;
        // ---------- Original Method ----------
        //ensureList();
        //if (mStandardEmptyView == null) {
            //throw new IllegalStateException("Can't be used with a custom content view");
        //}
        //mStandardEmptyView.setText(text);
        //if (mEmptyText == null) {
            //mList.setEmptyView(mStandardEmptyView);
        //}
        //mEmptyText = text;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.578 -0400", hash_original_method = "58A7D31C5F755970E32BD1449250481A", hash_generated_method = "ECFA22EF7C67E65DE11CACB9B16B3B88")
    public void setListShown(boolean shown) {
        addTaint(shown);
        setListShown(shown, true);
        // ---------- Original Method ----------
        //setListShown(shown, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.578 -0400", hash_original_method = "9A20C5F20729EB8F1D1E26962B6A5257", hash_generated_method = "2204BE8E8F3D2EB7B29E24737821F7B6")
    public void setListShownNoAnimation(boolean shown) {
        addTaint(shown);
        setListShown(shown, false);
        // ---------- Original Method ----------
        //setListShown(shown, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.579 -0400", hash_original_method = "01D2A62CF5C9E9D8F31EAD95561BA6AA", hash_generated_method = "C22595E15D4345FF413A64708110ACBD")
    private void setListShown(boolean shown, boolean animate) {
        addTaint(animate);
        ensureList();
        if(mProgressContainer == null)        
        {
            IllegalStateException varD4103A519630FF4520E774F631D45BAC_2145275149 = new IllegalStateException("Can't be used with a custom content view");
            varD4103A519630FF4520E774F631D45BAC_2145275149.addTaint(taint);
            throw varD4103A519630FF4520E774F631D45BAC_2145275149;
        } //End block
        if(mListShown == shown)        
        {
            return;
        } //End block
        mListShown = shown;
        if(shown)        
        {
            if(animate)            
            {
                mProgressContainer.startAnimation(AnimationUtils.loadAnimation(
                        getActivity(), android.R.anim.fade_out));
                mListContainer.startAnimation(AnimationUtils.loadAnimation(
                        getActivity(), android.R.anim.fade_in));
            } //End block
            else
            {
                mProgressContainer.clearAnimation();
                mListContainer.clearAnimation();
            } //End block
            mProgressContainer.setVisibility(View.GONE);
            mListContainer.setVisibility(View.VISIBLE);
        } //End block
        else
        {
            if(animate)            
            {
                mProgressContainer.startAnimation(AnimationUtils.loadAnimation(
                        getActivity(), android.R.anim.fade_in));
                mListContainer.startAnimation(AnimationUtils.loadAnimation(
                        getActivity(), android.R.anim.fade_out));
            } //End block
            else
            {
                mProgressContainer.clearAnimation();
                mListContainer.clearAnimation();
            } //End block
            mProgressContainer.setVisibility(View.VISIBLE);
            mListContainer.setVisibility(View.GONE);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.579 -0400", hash_original_method = "6C199B6FBEC38BDF6D031387113C1DD5", hash_generated_method = "298B8C9565411E29EEDE48C63E734DE3")
    public ListAdapter getListAdapter() {
ListAdapter varD72668EDE5E63ADF9340F3D8A19FD205_928310078 =         mAdapter;
        varD72668EDE5E63ADF9340F3D8A19FD205_928310078.addTaint(taint);
        return varD72668EDE5E63ADF9340F3D8A19FD205_928310078;
        // ---------- Original Method ----------
        //return mAdapter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:54.580 -0400", hash_original_method = "E4157ED141058B6B94474E0556BB8B74", hash_generated_method = "D9D156B208E7682D94664026CEA3EB14")
    private void ensureList() {
        if(mList != null)        
        {
            return;
        } //End block
        View root = getView();
        if(root == null)        
        {
            IllegalStateException var052948DC6923A855D5D68E1310933CAB_592062927 = new IllegalStateException("Content view not yet created");
            var052948DC6923A855D5D68E1310933CAB_592062927.addTaint(taint);
            throw var052948DC6923A855D5D68E1310933CAB_592062927;
        } //End block
        if(root instanceof ListView)        
        {
            mList = (ListView)root;
        } //End block
        else
        {
            mStandardEmptyView = (TextView)root.findViewById(
                    com.android.internal.R.id.internalEmpty);
            if(mStandardEmptyView == null)            
            {
                mEmptyView = root.findViewById(android.R.id.empty);
            } //End block
            else
            {
                mStandardEmptyView.setVisibility(View.GONE);
            } //End block
            mProgressContainer = root.findViewById(com.android.internal.R.id.progressContainer);
            mListContainer = root.findViewById(com.android.internal.R.id.listContainer);
            View rawListView = root.findViewById(android.R.id.list);
            if(!(rawListView instanceof ListView))            
            {
                RuntimeException var21587997F544C4FA9C985E7B90148739_938303562 = new RuntimeException(
                        "Content has view with id attribute 'android.R.id.list' "
                        + "that is not a ListView class");
                var21587997F544C4FA9C985E7B90148739_938303562.addTaint(taint);
                throw var21587997F544C4FA9C985E7B90148739_938303562;
            } //End block
            mList = (ListView)rawListView;
            if(mList == null)            
            {
                RuntimeException var814898E2A75124B230F991BD301E888E_408624016 = new RuntimeException(
                        "Your content must have a ListView whose id attribute is " +
                        "'android.R.id.list'");
                var814898E2A75124B230F991BD301E888E_408624016.addTaint(taint);
                throw var814898E2A75124B230F991BD301E888E_408624016;
            } //End block
            if(mEmptyView != null)            
            {
                mList.setEmptyView(mEmptyView);
            } //End block
            else
            if(mEmptyText != null)            
            {
                mStandardEmptyView.setText(mEmptyText);
                mList.setEmptyView(mStandardEmptyView);
            } //End block
        } //End block
        mListShown = true;
        mList.setOnItemClickListener(mOnClickListener);
        if(mAdapter != null)        
        {
            ListAdapter adapter = mAdapter;
            mAdapter = null;
            setListAdapter(adapter);
        } //End block
        else
        {
            if(mProgressContainer != null)            
            {
                setListShown(false, false);
            } //End block
        } //End block
        mHandler.post(mRequestFocus);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

