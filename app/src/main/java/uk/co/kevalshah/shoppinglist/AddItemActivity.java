package uk.co.kevalshah.shoppinglist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Keval on 23/08/2015.
 */
public class AddItemActivity extends Activity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item);

        final Button cancelButton = (Button) findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCancel();
            }
        });

        final Button addButton = (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAdd();
            }
        });
    }

    private void onCancel() {
        setResult(RESULT_CANCELED);
        finish();
    }

    private void onAdd() {
        final Intent itemDataIntent = new Intent();
        itemDataIntent.putExtra(Item.ITEM_NAME, "Test");
        itemDataIntent.putExtra(Item.QUANTITY, 1);
        setResult(RESULT_OK, itemDataIntent);
        finish();
    }
}
