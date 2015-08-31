package uk.co.kevalshah.shoppinglist;

import android.app.ExpandableListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class ShoppingListManagerActivity extends ExpandableListActivity {

    private static final int ADD_SHOPPING_ITEM_REQUEST = 0;

    private ShoppingListAdapter adapter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new ShoppingListAdapter(getApplicationContext());

        //Add an add item footer to the list view
        final ListView listView = getExpandableListView();
        listView.setFooterDividersEnabled(true);
        final View addItemFooter = getLayoutInflater().inflate(R.layout.item_list_footer, listView, false);
        listView.addFooterView(addItemFooter);
        addItemFooter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAdd();
            }
        });

        setListAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_shopping_list, menu);

        menu.add(Menu.NONE, 0, 0, "Add");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
        if (id == 0) {
            onAdd();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void onAdd() {
        final Intent addItemIntent = new Intent(this, AddItemActivity.class);
        startActivityForResult(addItemIntent, ADD_SHOPPING_ITEM_REQUEST);
    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        if (ADD_SHOPPING_ITEM_REQUEST == requestCode) {
            if (RESULT_OK == resultCode) {
                final Item item = new Item(data);
                adapter.add(item);
            }
        }
    }
}
