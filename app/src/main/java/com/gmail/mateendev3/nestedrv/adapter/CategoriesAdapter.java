package com.gmail.mateendev3.nestedrv.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gmail.mateendev3.nestedrv.R;
import com.gmail.mateendev3.nestedrv.model.Categories;
import com.gmail.mateendev3.nestedrv.model.CategoryItem;

import java.util.List;

//Adapter Class
public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder> {

    //declaring members
    private static List<Categories> categoriesList;
    private static OnCategoryTVClickListener onCategoryTVClickListener;
    private static CategoryItemsAdapter adapter;

    //constructor
    public CategoriesAdapter(List<Categories> categoriesList) {
        this.categoriesList = categoriesList;
    }

    //method invoked to create ViewHolder Objects
    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoriesViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_categories_row, parent, false));
    }

    //method invoked to bind views to ViewHolder Objects
    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {
        Categories categories = categoriesList.get(position);

        //setting RC View
        setCategoryItemRecyclerView(holder.getRvCategoryItems(), categories.getCategoryItemsList());

        holder.getTvCategoryTitle().setText(categories.getCategoryType());
    }

    //method invoked to set categories to RC View
    private void setCategoryItemRecyclerView(RecyclerView categoryItemRecyclerView, List<CategoryItem> items) {
        //creating adapter for RC View
        adapter = new CategoryItemsAdapter(items, categoryItemRecyclerView.getContext());
        categoryItemRecyclerView.setLayoutManager(new LinearLayoutManager(
                categoryItemRecyclerView.getContext(),
                RecyclerView.HORIZONTAL,
                false
        ));

        categoryItemRecyclerView.setAdapter(adapter);
    }

    //method invoked to get the number to elements to show in the RV
    @Override
    public int getItemCount() {
        return categoriesList.size();
    }


    /**
     * Inner ViewHolder class
     **/
    public static class CategoriesViewHolder extends RecyclerView.ViewHolder {
        //declaring members
        private final TextView tvCategoryTitle;
        private final RecyclerView rvCategoryItems;

        public CategoriesViewHolder(@NonNull View itemView) {
            super(itemView);

            //initializing members
            tvCategoryTitle = itemView.findViewById(R.id.tv_category_title);
            rvCategoryItems = itemView.findViewById(R.id.rv_categories_items);

            setListenerToTitle(tvCategoryTitle);
        }

        private void setListenerToTitle(TextView tvCategoryTitle) {
            tvCategoryTitle.setOnClickListener(v -> {
                if (onCategoryTVClickListener != null) {
                    onCategoryTVClickListener.onCategoryTVClick(getAdapterPosition(), tvCategoryTitle);
                }
            });
        }

        //getters
        public TextView getTvCategoryTitle() {
            return tvCategoryTitle;
        }

        public RecyclerView getRvCategoryItems() {
            return rvCategoryItems;
        }
    }


    //setters of adapter
    public void setOnCategoryTVClickListener(OnCategoryTVClickListener l) {
        onCategoryTVClickListener = l;
    }

    //public contracts/interfaces to handle clicks
    public interface OnCategoryTVClickListener {
        void onCategoryTVClick(int position, TextView tvCategoryClick);
    }
}
