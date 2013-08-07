package android.inputmethodservice;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Button;
import android.widget.LinearLayout;

import com.android.internal.view.menu.MenuBuilder;
import com.android.internal.view.menu.MenuPopupHelper;






public class ExtractEditLayout extends LinearLayout {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.106 -0400", hash_original_field = "3B382D379664B509F22D0EB5D96F2BA8", hash_generated_field = "84372CBE17BCE552A035CEA7A14F295A")

    ExtractActionMode mActionMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.106 -0400", hash_original_field = "3E6D26FB674BD5BECF55AF87AA05424D", hash_generated_field = "3B9794871E7B10840F19B29A2246BB31")

    Button mExtractActionButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.106 -0400", hash_original_field = "79CC0F5D3D0182DF888F5D7BF86044D2", hash_generated_field = "B2154EF2825FBCE7DE09C4738860180E")

    Button mEditButton;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.106 -0400", hash_original_method = "5E5A3BB351E8D9D7F73E3207F63F4561", hash_generated_method = "FF076AB15802724C5AF1EBE865EE317C")
    public  ExtractEditLayout(Context context) {
        super(context);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.107 -0400", hash_original_method = "5B5DDD3A07057211F0994E26CEDA1A4A", hash_generated_method = "2EEC1302466F1F5EA16905DCF8A7C2B8")
    public  ExtractEditLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.108 -0400", hash_original_method = "3AB740C640E719B54F03586FCEB648DB", hash_generated_method = "8CF68D2930BC359B55BF00CF6888DB92")
    @Override
    public ActionMode startActionModeForChild(View sourceView, ActionMode.Callback cb) {
        addTaint(cb.getTaint());
        addTaint(sourceView.getTaint());
        final ExtractActionMode mode = new ExtractActionMode(cb);
        if(mode.dispatchOnCreate())        
        {
            mode.invalidate();
            mExtractActionButton.setVisibility(INVISIBLE);
            mEditButton.setVisibility(VISIBLE);
            mActionMode = mode;
            sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED);
ActionMode var39C6EC747783AFD94A86A7BFC763D859_1766029480 =             mode;
            var39C6EC747783AFD94A86A7BFC763D859_1766029480.addTaint(taint);
            return var39C6EC747783AFD94A86A7BFC763D859_1766029480;
        } //End block
ActionMode var540C13E9E156B687226421B24F2DF178_1301784740 =         null;
        var540C13E9E156B687226421B24F2DF178_1301784740.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1301784740;
        // ---------- Original Method ----------
        //final ExtractActionMode mode = new ExtractActionMode(cb);
        //if (mode.dispatchOnCreate()) {
            //mode.invalidate();
            //mExtractActionButton.setVisibility(INVISIBLE);
            //mEditButton.setVisibility(VISIBLE);
            //mActionMode = mode;
            //sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED);
            //return mode;
        //}
        //return null;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.109 -0400", hash_original_method = "587B198236267AC63B96064EC21D7789", hash_generated_method = "5711011E305231E5CF09495B6483D732")
    public boolean isActionModeStarted() {
        boolean varDA8565957A542E3140746B0CEB2A49C1_593992466 = (mActionMode != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1700738667 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1700738667;
        // ---------- Original Method ----------
        //return mActionMode != null;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.109 -0400", hash_original_method = "CFF93884DD9A272729CBAF15B54B9CD3", hash_generated_method = "243FF5FE5C67F38767B697B08F4F7561")
    public void finishActionMode() {
        if(mActionMode != null)        
        {
            mActionMode.finish();
        } //End block
        // ---------- Original Method ----------
        //if (mActionMode != null) {
            //mActionMode.finish();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.112 -0400", hash_original_method = "F4E3F3E884E506D9FE93C33AFB725466", hash_generated_method = "B804DEA21B39172ABF8DD847BA7B5587")
    @Override
    public void onFinishInflate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onFinishInflate();
        mExtractActionButton = (Button) findViewById(com.android.internal.R.id.inputExtractAction);
        mEditButton = (Button) findViewById(com.android.internal.R.id.inputExtractEditButton);
        mEditButton.setOnClickListener(new OnClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.111 -0400", hash_original_method = "80ABF702BB778CBFC3E3D00BD35B5A63", hash_generated_method = "0CCA4BBBFC7BF284DEC747CFAA41AAA5")
        public void onClick(View clicked) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(clicked.getTaint());
            if(mActionMode != null)            
            {
                new MenuPopupHelper(getContext(), mActionMode.mMenu, clicked).show();
            } //End block
            // ---------- Original Method ----------
            //if (mActionMode != null) {
                    //new MenuPopupHelper(getContext(), mActionMode.mMenu, clicked).show();
                //}
        }
});
        // ---------- Original Method ----------
        //super.onFinishInflate();
        //mExtractActionButton = (Button) findViewById(com.android.internal.R.id.inputExtractAction);
        //mEditButton = (Button) findViewById(com.android.internal.R.id.inputExtractEditButton);
        //mEditButton.setOnClickListener(new OnClickListener() {
            //public void onClick(View clicked) {
                //if (mActionMode != null) {
                    //new MenuPopupHelper(getContext(), mActionMode.mMenu, clicked).show();
                //}
            //}
        //});
    }

    
    private class ExtractActionMode extends ActionMode implements MenuBuilder.Callback {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.113 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "8F251D8FB2618CB877D06AB4E966D630")

        private ActionMode.Callback mCallback;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.113 -0400", hash_original_field = "CFE8F878843D1CA6A8D8B333030E59FA", hash_generated_field = "E0FA7D9C40725579D8730D3DABE74643")

        MenuBuilder mMenu;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.114 -0400", hash_original_method = "1DFFBDF48C83C4F81EE07812707228A4", hash_generated_method = "7016906F6AE6283CE484B5EEE99D31EE")
        public  ExtractActionMode(Callback cb) {
            mMenu = new MenuBuilder(getContext());
            mMenu.setCallback(this);
            mCallback = cb;
            // ---------- Original Method ----------
            //mMenu = new MenuBuilder(getContext());
            //mMenu.setCallback(this);
            //mCallback = cb;
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.115 -0400", hash_original_method = "F1AD782B0CD2259E0BE9FDDD0EC2ADD5", hash_generated_method = "EA5142F85218179C74E31C4344F7840C")
        @Override
        public void setTitle(CharSequence title) {
            addTaint(title.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.116 -0400", hash_original_method = "B30C6763E9E5F305FC4AC0CFECBEE869", hash_generated_method = "C6BC91ECFE1C379B9775192FE76B7EE1")
        @Override
        public void setTitle(int resId) {
            addTaint(resId);
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.117 -0400", hash_original_method = "EB006AC48BB7A6AA8B2958DC91304E5C", hash_generated_method = "9DFEDFD3C97DB086294C2841AEBA9335")
        @Override
        public void setSubtitle(CharSequence subtitle) {
            addTaint(subtitle.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.117 -0400", hash_original_method = "1F86E8EB25240C47EC24308D126D97B9", hash_generated_method = "D51D417B20F4E43280CDC3BCD8EA2931")
        @Override
        public void setSubtitle(int resId) {
            addTaint(resId);
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.118 -0400", hash_original_method = "3E94F533B6F67EA66D83CADA4353AF33", hash_generated_method = "A18B374E9FE9E6972BDC43896DF58822")
        @Override
        public void setCustomView(View view) {
            addTaint(view.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.119 -0400", hash_original_method = "AE3782F4A9FD5538AF0C8FC979CD15B1", hash_generated_method = "09CD291F58A645AF3A8E9CF913126DF5")
        @Override
        public void invalidate() {
            mMenu.stopDispatchingItemsChanged();
            try 
            {
                mCallback.onPrepareActionMode(this, mMenu);
            } //End block
            finally 
            {
                mMenu.startDispatchingItemsChanged();
            } //End block
            // ---------- Original Method ----------
            //mMenu.stopDispatchingItemsChanged();
            //try {
                //mCallback.onPrepareActionMode(this, mMenu);
            //} finally {
                //mMenu.startDispatchingItemsChanged();
            //}
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.120 -0400", hash_original_method = "73ABB077D09B369F1D81F6F51241E9AF", hash_generated_method = "93F6D59BC2DAE93AB542B15EDE926B2F")
        public boolean dispatchOnCreate() {
            mMenu.stopDispatchingItemsChanged();
            try 
            {
                boolean varF1C88BDD71CAE111F59B32DE7A3CE40A_1823889902 = (mCallback.onCreateActionMode(this, mMenu));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_130969675 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_130969675;
            } //End block
            finally 
            {
                mMenu.startDispatchingItemsChanged();
            } //End block
            // ---------- Original Method ----------
            //mMenu.stopDispatchingItemsChanged();
            //try {
                //return mCallback.onCreateActionMode(this, mMenu);
            //} finally {
                //mMenu.startDispatchingItemsChanged();
            //}
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.122 -0400", hash_original_method = "2B69AFBC6E24AF84D26A0EF2F0EF4896", hash_generated_method = "254222131F1B94680509AD1AF1C2822E")
        @Override
        public void finish() {
            if(mActionMode != this)            
            {
                return;
            } //End block
            mCallback.onDestroyActionMode(this);
            mCallback = null;
            mExtractActionButton.setVisibility(VISIBLE);
            mEditButton.setVisibility(INVISIBLE);
            sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED);
            mActionMode = null;
            // ---------- Original Method ----------
            //if (mActionMode != this) {
                //return;
            //}
            //mCallback.onDestroyActionMode(this);
            //mCallback = null;
            //mExtractActionButton.setVisibility(VISIBLE);
            //mEditButton.setVisibility(INVISIBLE);
            //sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED);
            //mActionMode = null;
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.122 -0400", hash_original_method = "B2B8DF93D41CD214F77DE42BB625BB9F", hash_generated_method = "9EE13275369CDEB6B751C272BEA2CA39")
        @Override
        public Menu getMenu() {
Menu var10D851031FD6BA7C53B0186C7F1D9213_467043677 =             mMenu;
            var10D851031FD6BA7C53B0186C7F1D9213_467043677.addTaint(taint);
            return var10D851031FD6BA7C53B0186C7F1D9213_467043677;
            // ---------- Original Method ----------
            //return mMenu;
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.123 -0400", hash_original_method = "CD9B990298CF856E49A643E530553914", hash_generated_method = "C602FDFC644BF76905EE1C104D6ECCAB")
        @Override
        public CharSequence getTitle() {
CharSequence var540C13E9E156B687226421B24F2DF178_1976475173 =             null;
            var540C13E9E156B687226421B24F2DF178_1976475173.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1976475173;
            // ---------- Original Method ----------
            //return null;
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.123 -0400", hash_original_method = "F475DA391A1931FE20FFD2579FFFF5AF", hash_generated_method = "A9A55DD2DF2CEE6F09096E42F24F8A27")
        @Override
        public CharSequence getSubtitle() {
CharSequence var540C13E9E156B687226421B24F2DF178_2064891154 =             null;
            var540C13E9E156B687226421B24F2DF178_2064891154.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2064891154;
            // ---------- Original Method ----------
            //return null;
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.123 -0400", hash_original_method = "7A49E6A1A0BF55D8D926541A71E4907E", hash_generated_method = "81705C6C241BEDF183E86133EECACB12")
        @Override
        public View getCustomView() {
View var540C13E9E156B687226421B24F2DF178_327998564 =             null;
            var540C13E9E156B687226421B24F2DF178_327998564.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_327998564;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.124 -0400", hash_original_method = "DECFD94D9899EA20C3E59178999FB9F7", hash_generated_method = "7179CF4B28427CFA5A8AC55706693E03")
        @Override
        public MenuInflater getMenuInflater() {
MenuInflater varF9281FDCAD705FC65F86153FDD312F6B_412354070 =             new MenuInflater(getContext());
            varF9281FDCAD705FC65F86153FDD312F6B_412354070.addTaint(taint);
            return varF9281FDCAD705FC65F86153FDD312F6B_412354070;
            // ---------- Original Method ----------
            //return new MenuInflater(getContext());
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.125 -0400", hash_original_method = "51BD8FD51955B080CEEB769553E9A9F7", hash_generated_method = "55321F022FF510834C70863E02C835F7")
        @Override
        public boolean onMenuItemSelected(MenuBuilder menu, MenuItem item) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(item.getTaint());
            addTaint(menu.getTaint());
            if(mCallback != null)            
            {
                boolean var3FFB98B393CA4BB1089E3B773EEE7A13_925563237 = (mCallback.onActionItemClicked(this, item));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_240026579 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_240026579;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_875968403 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_860103970 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_860103970;
            // ---------- Original Method ----------
            //if (mCallback != null) {
                //return mCallback.onActionItemClicked(this, item);
            //}
            //return false;
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.126 -0400", hash_original_method = "BD3281B75359F57929C0B7D8E3BC0065", hash_generated_method = "4DC0BAA3678E3B1F051D28FC48B7B7DA")
        @Override
        public void onMenuModeChange(MenuBuilder menu) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(menu.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
}

