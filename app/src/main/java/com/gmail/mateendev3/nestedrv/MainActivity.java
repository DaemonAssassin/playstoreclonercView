package com.gmail.mateendev3.nestedrv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.gmail.mateendev3.nestedrv.adapter.CategoriesAdapter;
import com.gmail.mateendev3.nestedrv.model.Categories;
import com.gmail.mateendev3.nestedrv.model.CategoryItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //declaring members
    private List<Categories> categoriesList;
    private RecyclerView rvCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting RC View
        setCategoriesRecyclerView();
    }

    //method invoked to set categories to RC View
    private void setCategoriesRecyclerView() {
        //creating adapter for RC View
        CategoriesAdapter adapter = new CategoriesAdapter(generateData());

        //setting click listener to adapter TV
        adapter.setOnCategoryTVClickListener((position, tvCategoryClick) -> {
            Categories category = categoriesList.get(position);
            Toast.makeText(MainActivity.this, "Let Go To: " + category.getCategoryType(), Toast.LENGTH_SHORT).show();
        });

        rvCategories = findViewById(R.id.rv_categories);
        rvCategories.setLayoutManager(new LinearLayoutManager(this));
        rvCategories.setAdapter(adapter);
    }

    //method invoked to generated data
    private List<Categories> generateData() {

        categoriesList = new ArrayList<>();
        categoriesList.add(new Categories("Recommended for you", generateDataList1()));
        categoriesList.add(new Categories("Suggested for you", generateDataList2()));
        categoriesList.add(new Categories("Based on your recent activity", generateDataList3()));
        categoriesList.add(new Categories("Editor's choice apps", generateDataList4()));

        return categoriesList;
    }

    private List<CategoryItem> generateDataList1() {

        List<CategoryItem> items = new ArrayList<>();

        items.add(new CategoryItem(R.drawable.netflix, "Netflix", "18 MB"));
        items.add(new CategoryItem(R.drawable.whatsapp, "WhatsApp", "50 MB"));
        items.add(new CategoryItem(R.drawable.telegram, "Telegram", "15 MB"));
        items.add(new CategoryItem(R.drawable.instagram, "Instagram", "22 MB"));
        items.add(new CategoryItem(R.drawable.facebook, "Facebook", "300 MB"));
        items.add(new CategoryItem(R.drawable.twitter, "Twitter", "80 MB"));

        return items;
    }
    private List<CategoryItem> generateDataList2() {

        List<CategoryItem> items = new ArrayList<>();

        items.add(new CategoryItem(R.drawable.twitter, "Twitter", "80 MB"));
        items.add(new CategoryItem(R.drawable.facebook, "Facebook", "300 MB"));
        items.add(new CategoryItem(R.drawable.telegram, "Telegram", "15 MB"));
        items.add(new CategoryItem(R.drawable.instagram, "Instagram", "22 MB"));
        items.add(new CategoryItem(R.drawable.whatsapp, "WhatsApp", "50 MB"));
        items.add(new CategoryItem(R.drawable.netflix, "Netflix", "18 MB"));

        return items;
    }
    private List<CategoryItem> generateDataList3() {

        List<CategoryItem> items = new ArrayList<>();

        items.add(new CategoryItem(R.drawable.whatsapp, "WhatsApp", "50 MB"));
        items.add(new CategoryItem(R.drawable.netflix, "Netflix", "18 MB"));
        items.add(new CategoryItem(R.drawable.instagram, "Instagram", "22 MB"));
        items.add(new CategoryItem(R.drawable.telegram, "Telegram", "15 MB"));
        items.add(new CategoryItem(R.drawable.twitter, "Twitter", "80 MB"));
        items.add(new CategoryItem(R.drawable.facebook, "Facebook", "300 MB"));

        return items;
    }
    private List<CategoryItem> generateDataList4() {

        List<CategoryItem> items = new ArrayList<>();

        items.add(new CategoryItem(R.drawable.facebook, "Facebook", "300 MB"));
        items.add(new CategoryItem(R.drawable.netflix, "Netflix", "18 MB"));
        items.add(new CategoryItem(R.drawable.whatsapp, "WhatsApp", "50 MB"));
        items.add(new CategoryItem(R.drawable.telegram, "Telegram", "15 MB"));
        items.add(new CategoryItem(R.drawable.instagram, "Instagram", "22 MB"));
        items.add(new CategoryItem(R.drawable.twitter, "Twitter", "80 MB"));

        return items;
    }
}