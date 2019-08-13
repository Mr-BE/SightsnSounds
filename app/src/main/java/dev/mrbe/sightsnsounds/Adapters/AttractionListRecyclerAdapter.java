package dev.mrbe.sightsnsounds.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import dev.mrbe.sightsnsounds.Category;
import dev.mrbe.sightsnsounds.CategoryCatalogActivity;
import dev.mrbe.sightsnsounds.DataManager;
import dev.mrbe.sightsnsounds.Location;
import dev.mrbe.sightsnsounds.R;


public class AttractionListRecyclerAdapter extends RecyclerView.Adapter<AttractionListRecyclerAdapter.ViewHolder> {
    public static final String CATEGORY_LOCATIONS = "Category_Locations";
    //Context for Activity
    private final Context mContext;
    private final LayoutInflater mLayoutInflater;
    //list for notes
    private final List<Category> mCategories;

    //Recycler Views constants
    private final int VERTICAL = 1;
    private final int HORIZONTAL = 2;
    private final int CATALOG = 3;

    private DataManager da = DataManager.getInstance();
    private RecyclerView.RecycledViewPool viewPool;

    public AttractionListRecyclerAdapter(Context context, List<Category> categories) {
        mContext = context;
        mCategories = categories;
        mLayoutInflater = LayoutInflater.from(mContext);
//        this.viewPool = new RecyclerView.RecycledViewPool();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Create a view for the view holder (Inflate View, create new viewholder instance and associate view with instance)
        View itemView;
        ViewHolder holder;
        switch (viewType) {
            case VERTICAL:
                itemView = mLayoutInflater.inflate(R.layout.content_attraction, parent, false);
                //False simply means this View should not automatically attach to its parent viewGroup but depend on the adapter
                holder = new ViewHolder(itemView);
                break;
            case HORIZONTAL:
                itemView = mLayoutInflater.inflate(R.layout.content_main_parent, parent, false);
                holder = new HorizontalViewHolder(itemView);
                break;
//            case CATALOG:
//                itemView = mLayoutInflater.inflate(R.layout.item_category_catologue,parent,false);
//                holder = new CatalogueViewHolder(itemView);
            default:
                itemView = mLayoutInflater.inflate(R.layout.content_main_parent, parent, false);
                holder = new HorizontalViewHolder(itemView);
                break;
        }
        return holder;
    }

    /*Bind data to views*/
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if (holder.getItemViewType() == HORIZONTAL)
            horizontalView((HorizontalViewHolder) holder);

//        if (holder.getItemViewType()== CATALOG) catalogView((CatalogueViewHolder) holder);

        //Get note corresponding to position
        Category category = mCategories.get(position);

        //Get each Text Views from viewholder
        holder.mCategoryId.setText(category.getCategoryName());

        // Set List to nested recycler view
        RecyclerView locationRecyclerInCat = holder.getRecyclerView();
        locationRecyclerInCat.setLayoutManager(new LinearLayoutManager(
                holder.getRecyclerView().getContext(), 0, false));
        locationRecyclerInCat.setAdapter(new LocationRecyclerAdapter(mContext, category.getLocations()));
//        locationRecyclerInCat.setRecycledViewPool(this.viewPool);

        holder.mCurrentPosition = position;
    }

    private void catalogView(CatalogueViewHolder holder) {
    }

    private void horizontalView(HorizontalViewHolder holder) {
        List<Location> locations = da.getLocations();
        new Category("a", locations);
        Category category;
        for (int i = 0; i < mCategories.size(); i++) {
            category = mCategories.get(i);
            List<Location> categoryLocations = category.getLocations();

            for (int j = 0; j < categoryLocations.size(); j++) {
                String attractionName = categoryLocations.get(j).getmAttractionName();

                String locationName = categoryLocations.get(j).getmLocationName();
                int imageResource = categoryLocations.get(j).getmPrimaryImageResource();
                String attractionDetails = categoryLocations.get(j).getmAtrractionDetails();
                locations.add(new Location(attractionName, locationName, imageResource, attractionDetails));
            }
        }
        LocationRecyclerAdapter adapter = new LocationRecyclerAdapter(mContext, locations);
        holder.mRecyclerView.setRecycledViewPool(viewPool);
        holder.mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        holder.mRecyclerView.setAdapter(adapter);
    }

    /*Determine the number of items in the list*/
    @Override
    public int getItemCount() {
        return mCategories.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mCategories.get(position) != null)
            return HORIZONTAL;

        return -1;
    }

    /**
     * View holder class
     */
    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView mCategoryId;
        private final RecyclerView mLocationRecycler;
        //Viewholder position
        public int mCurrentPosition;

        public ViewHolder(View itemView) {
            super(itemView);
            //Get reference to TextViews for notes
            mCategoryId = itemView.findViewById(R.id.attraction_category_name);
            mLocationRecycler = itemView.findViewById(R.id.list_attractions_horizontal);

            //Set up OnClickListener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    List<Location> locations = mCategories.get(mCurrentPosition).getLocations();

                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList(CATEGORY_LOCATIONS, (ArrayList<? extends Parcelable>) locations);
                    bundle.putInt("Position", mCurrentPosition);
                    Intent intent = new Intent(mContext, CategoryCatalogActivity.class);
                    intent.putExtras(bundle);
                    mContext.startActivity(intent);

                    //Show courses
                    Snackbar.make(v, mCategories.get(mCurrentPosition).getCategoryName(),
                            Snackbar.LENGTH_LONG).show();
                }
            });
        }

        //Get nested Recycler View
        public RecyclerView getRecyclerView() {
            return this.mLocationRecycler;
        }
    }

    /**
     * View Holder for Inner Horizontal Recycler View
     */
    private class HorizontalViewHolder extends ViewHolder {
        RecyclerView mRecyclerView;

        public HorizontalViewHolder(View itemView) {
            super(itemView);
            mRecyclerView = itemView.findViewById(R.id.list_attractions_horizontal);
        }
    }

    /**
     * View Holder for Catalog Recycler View
     */
    private class CatalogueViewHolder extends ViewHolder {
        RecyclerView mCatalogRecyclerView;

        public CatalogueViewHolder(View itemView) {
            super(itemView);
            mCatalogRecyclerView = itemView.findViewById(R.id.catalog_list);
        }
    }

}
