package uk.co.kevalshah.shoppinglist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Keval on 31/08/2015.
 */
public class ShoppingListAdapter extends BaseAdapter {

    private static final String TAG = "ShoppingListAdapter";

    private final List<Item> items = new ArrayList<Item>();
    private final Context context;

    public ShoppingListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(final int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(final int position) {
        return position;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {

        return null;
    }
}
