package uk.co.kevalshah.shoppinglist;

import android.content.Intent;

/**
 * Created by Keval on 31/08/2015.
 */
class Item {

    public static final String ITEM_NAME = "itemName";
    public static final String QUANTITY = "quantity";
    public static final String CATEGORY = "category";

    private String itemName;
    private int quantity;
    private String category;

    Item(final Intent intent) {
        itemName = intent.getStringExtra(ITEM_NAME);
        quantity = intent.getIntExtra(QUANTITY, 0);
        category = intent.getStringExtra(CATEGORY);
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCategory() {
        return category;
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
