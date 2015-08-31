package uk.co.kevalshah.shoppinglist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


/**
 * Created by Keval on 23/08/2015.
 */
public class AddItemActivity extends Activity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item);

        setupCategoriesSpinner();

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

    private void setupCategoriesSpinner() {
        final Spinner spinner = (Spinner) findViewById(R.id.categoriesSpinner);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.categories_array,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void onCancel() {
        setResult(RESULT_CANCELED);
        finish();
    }

    private void onAdd() {
        final EditText itemNameView = (EditText) findViewById(R.id.itemName);
        final String itemName = itemNameView.getText().toString();

        final EditText quantityFieldView = (EditText) findViewById(R.id.quantityField);
        final String quantityStr = quantityFieldView.getText().toString();
        final int quantity = "".equals(quantityStr) ? 0 : Integer.valueOf(quantityStr);

        final Spinner categoriesSpinner = (Spinner) findViewById(R.id.categoriesSpinner);
        final String selectedCategory = categoriesSpinner.getSelectedItem().toString();

        final Intent itemDataIntent = new Intent();
        itemDataIntent.putExtra(Item.ITEM_NAME, itemName);
        itemDataIntent.putExtra(Item.QUANTITY, quantity);
        itemDataIntent.putExtra(Item.CATEGORY, selectedCategory);
        setResult(RESULT_OK, itemDataIntent);
        finish();
    }
}
