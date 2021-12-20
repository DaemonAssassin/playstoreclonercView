package com.gmail.mateendev3.nestedrv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.gmail.mateendev3.nestedrv.R;
import com.gmail.mateendev3.nestedrv.model.CategoryItem;

import java.util.List;

//Adapter class
public class CategoryItemsAdapter extends RecyclerView.Adapter<CategoryItemsAdapter.CategoryItemsViewHolder> {

    //declaring members
    private static List<CategoryItem> categoryItemList;
    private static Context context;

    //constructor
    public CategoryItemsAdapter(List<CategoryItem> categoryItemList, Context c) {
        this.categoryItemList = categoryItemList;
        context = c;

    }

    //method invoked to create ViewHolder Objects
    @NonNull
    @Override
    public CategoryItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryItemsViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_category_items_row, parent, false));
    }

    //method invoked to bind views to ViewHolder Objects
    @Override
    public void onBindViewHolder(@NonNull CategoryItemsViewHolder holder, int position) {
        CategoryItem item = categoryItemList.get(position);
        holder.getIvCategoryItemIcon().setImageResource(item.getItemIconResId());
        holder.getTvCategoryItemName().setText(item.getItemName());
        holder.getTvCategoryItemSize().setText(item.getItemSize());

        //setting click listener to holder
        settingListenerToHolder(holder, item);
    }

    private void settingListenerToHolder(CategoryItemsViewHolder holder, CategoryItem item) {
        holder.getClCategoryItemRoot().setOnClickListener(v -> {
            Toast.makeText(context, "You choose: " + item.getItemName(), Toast.LENGTH_SHORT).show();
        });
    }

    //method invoked to get the number to elements to show in the RV
    @Override
    public int getItemCount() {
        return categoryItemList.size();
    }

    //inner ViewHolder class
    public static class CategoryItemsViewHolder extends RecyclerView.ViewHolder {
        private final ConstraintLayout clCategoryItemRoot;
        private final ImageView ivCategoryItemIcon;
        private final TextView tvCategoryItemName;
        private final TextView tvCategoryItemSize;

        public CategoryItemsViewHolder(@NonNull View itemView) {
            super(itemView);

            //initializing members
            ivCategoryItemIcon = itemView.findViewById(R.id.iv_category_item_icon);
            tvCategoryItemName = itemView.findViewById(R.id.tv_category_item_name);
            tvCategoryItemSize = itemView.findViewById(R.id.tv_category_item_size);
            clCategoryItemRoot = itemView.findViewById(R.id.cl_category_item);
        }

        //getters
        public ImageView getIvCategoryItemIcon() {
            return ivCategoryItemIcon;
        }

        public TextView getTvCategoryItemName() {
            return tvCategoryItemName;
        }

        public TextView getTvCategoryItemSize() {
            return tvCategoryItemSize;
        }

        public ConstraintLayout getClCategoryItemRoot() {
            return clCategoryItemRoot;
        }
    }
}
