package com.gmail.mateendev3.nestedrv.model;

import java.util.List;

public class Categories {

    //declaring members
    private final String categoryType;
    private final List<CategoryItem> categoryItemList;

    //creating constructor
    public Categories(String categoryType, List<CategoryItem> list) {
        this.categoryType = categoryType;
        this.categoryItemList = list;
    }

    //creating getters
    public String getCategoryType() {
        return categoryType;
    }

    public List<CategoryItem> getCategoryItemsList() {
        return categoryItemList;
    }
}
