package com.gmail.mateendev3.nestedrv.model;

public class CategoryItem {

    //declaring members
    private final int itemIconResId;
    private final String itemName;
    private final String itemSize;

    //constructor
    public CategoryItem(int itemIconResId, String itemName, String itemSize) {
        this.itemIconResId = itemIconResId;
        this.itemName = itemName;
        this.itemSize = itemSize;
    }

    //getters
    public int getItemIconResId() {
        return itemIconResId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemSize() {
        return itemSize;
    }
}
