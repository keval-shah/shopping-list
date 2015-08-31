package uk.co.kevalshah.shoppinglist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Keval on 31/08/2015.
 */
public class ShoppingListAdapter extends BaseAdapter {

    private static final String TAG = "ShoppingListAdapter";

    private final List<Item> items = new ArrayList<>();
    private final Context context;

    public ShoppingListAdapter(Context context) {
        this.context = context;
    }

    public void add(final Item item) {
        items.add(item);
        notifyDataSetChanged();
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
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
            holder = new ViewHolder();
            holder.itemText = (TextView) convertView.findViewById(R.id.item);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final Item item = items.get(position);
        holder.itemText.setText(item.getDescription());

        return convertView;
    }

    static class ViewHolder {
        TextView itemText;
    }
}
