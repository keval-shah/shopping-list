package uk.co.kevalshah.shoppinglist;

import android.app.Activity;
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

        final Button addButton = (Button) findViewById(R.id.saveButton);
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
        //todo: make an intent containing the data for the item and send back to the starting activity
        setResult(RESULT_OK);
        finish();
    }
}
