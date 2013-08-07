package android.widget;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;



public abstract class BaseAdapter implements ListAdapter, SpinnerAdapter {
    private final DataSetObservable mDataSetObservable = new DataSetObservable();
    
@DSModeled(DSC.SAFE)
	public BaseAdapter() {
		//Not in the initial implementation, generated for specdump
	}
    @DSModeled(DSC.SAFE)
    public boolean hasStableIds() {
        return false;
    }

    
    @DSModeled(DSC.SAFE)
    public void registerDataSetObserver(DataSetObserver observer) {
        mDataSetObservable.registerObserver(observer);
    }

    
    @DSModeled(DSC.SAFE)
    public void unregisterDataSetObserver(DataSetObserver observer) {
        mDataSetObservable.unregisterObserver(observer);
    }

    
    @DSModeled(DSC.SAFE)
    public void notifyDataSetChanged() {
        mDataSetObservable.notifyChanged();
    }

    
    @DSModeled(DSC.SAFE)
    public void notifyDataSetInvalidated() {
        mDataSetObservable.notifyInvalidated();
    }

    
    @DSModeled(DSC.SAFE)
    public boolean areAllItemsEnabled() {
        return true;
    }

    
    @DSModeled(DSC.SAFE)
    public boolean isEnabled(int position) {
        return true;
    }

    
    @DSModeled(DSC.SAFE)
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position, convertView, parent);
    }

    
    @DSModeled(DSC.SAFE)
    public int getItemViewType(int position) {
        return 0;
    }

    
    @DSModeled(DSC.SAFE)
    public int getViewTypeCount() {
        return 1;
    }

    
    @DSModeled(DSC.SAFE)
    public boolean isEmpty() {
        return getCount() == 0;
    }

    
}

