package dev.mrbe.sightsnsounds.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import dev.mrbe.sightsnsounds.Category;
import dev.mrbe.sightsnsounds.DataManager;
import dev.mrbe.sightsnsounds.FullDetailsActivity;
import dev.mrbe.sightsnsounds.Location;
import dev.mrbe.sightsnsounds.R;

public class CatalogAdapter extends RecyclerView.Adapter<CatalogAdapter.ViewHolder> {

    private final LayoutInflater mLayoutInflater;
    //    List for locations
    private final List<Location> mLocations;
    private Context mContext;
    private DataManager mDataManager = DataManager.getInstance();
    private List<Category> mCategories = mDataManager.getCategories();

    public CatalogAdapter(Context context, List<Location> locations) {
        mContext = context;
//        this.mCategories = categories;
        mLocations = locations;
        this.mLayoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = mLayoutInflater.inflate(R.layout.item_horizontal_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mCatalogImage.setImageResource(mLocations.get(position).getmPrimaryImageResource());
        holder.mCatalogLocation.setText(mLocations.get(position).getmAttractionName());
        holder.mCurrentPosition = position;

        final Location location = mLocations.get(position);

        holder.mCatalogImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("Location", location);
                Intent intent = new Intent(mContext, FullDetailsActivity.class);
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mLocations.size();

    }

    /**
     * Horizontal view holder
     */
    public class ViewHolder extends RecyclerView.ViewHolder {

        public final ImageView mCatalogImage;
        public final TextView mCatalogLocation;
        public int mCurrentPosition;


        public ViewHolder(View itemView) {
            super(itemView);
            //Get image
            mCatalogImage = itemView.findViewById(R.id.attraction_image_horizontal);
            mCatalogLocation = itemView.findViewById(R.id.attraction_name_horizontal);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    List<Location> locations = mCategories.get(mCurrentPosition).getLocations();
//                    String a = locations.get(mCurrentPosition).getmAttractionName();
//                    Snackbar.make(view, a, Snackbar.LENGTH_LONG).show();
                }
            });
        }
    }

}