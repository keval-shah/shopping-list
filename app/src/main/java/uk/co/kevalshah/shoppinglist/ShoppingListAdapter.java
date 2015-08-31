package uk.co.kevalshah.shoppinglist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Keval on 31/08/2015.
 */
public class ShoppingListAdapter extends BaseExpandableListAdapter {

    private static final String TAG = "ShoppingListAdapter";

    private final Context context;
    private final List<String> categories = new ArrayList<>();
    private final Map<String, List<Item>> itemsByCategory = new HashMap<>();

    public ShoppingListAdapter(Context context) {
        this.context = context;
    }

    public void add(final Item item) {
        final String category = item.getCategory();
        if (!categories.contains(category)) {
            categories.add(category);
        }
        List<Item> items = itemsByCategory.get(category);
        if (items == null) {
            items = new ArrayList<>();
            itemsByCategory.put(category, items);
        }
        items.add(item);
        notifyDataSetChanged();
    }

    @Override
    public int getGroupCount() {
        return categories.size();
    }

    @Override
    public int getChildrenCount(final int groupPosition) {
        final String category = categories.get(groupPosition);
        final List<Item> items = itemsByCategory.get(category);
        return items == null ? 0 : items.size();
    }

    @Override
    public Object getGroup(final int groupPosition) {
        return categories.get(groupPosition);
    }

    @Override
    public Object getChild(final int groupPosition, final int childPosition) {
        final String category = categories.get(groupPosition);
        final List<Item> items = itemsByCategory.get(category);
        return items.get(childPosition);
    }

    @Override
    public long getGroupId(final int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(final int groupPosition, final int childPosition) {
        return childPosition;
    }

    @Override
    public View getGroupView(final int groupPosition, final boolean isExpanded, View convertView,
                             final ViewGroup parent) {
        CategoryViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.category, parent, false);
            holder = new CategoryViewHolder();
            holder.categoryText = (TextView) convertView.findViewById(R.id.category);

            convertView.setTag(holder);
        } else {
            holder = (CategoryViewHolder) convertView.getTag();
        }

        final String category = (String) getGroup(groupPosition);
        holder.categoryText.setText(category);

        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, final boolean isLastChild,
                             View convertView, final ViewGroup parent) {
        ItemViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
            holder = new ItemViewHolder();
            holder.itemText = (TextView) convertView.findViewById(R.id.item);

            convertView.setTag(holder);
        } else {
            holder = (ItemViewHolder) convertView.getTag();
        }

        final Item item = (Item) getChild(groupPosition, childPosition);
        holder.itemText.setText(item.getDescription());

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    static class CategoryViewHolder {
        TextView categoryText;
    }

    static class ItemViewHolder {
        TextView itemText;
    }
}
