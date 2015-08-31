package uk.co.kevalshah.shoppinglist;

import android.content.Intent;

/**
 * Created by Keval on 31/08/2015.
 */
class Item {

    public static final String ITEM_NAME = "itemName";
    public static final String QUANTITY = "quantity";

    private String itemName;
    private int quantity;

    Item(final Intent intent) {
        itemName = intent.getStringExtra(ITEM_NAME);
        quantity = intent.getIntExtra(QUANTITY, 0);
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription () {
        String desc = "";
        if (quantity > 1) {
            desc = quantity + " ";
        }
        desc = desc + itemName;
        return desc;
    }
}
