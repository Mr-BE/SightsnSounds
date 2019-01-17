package c.codeblaq.sightsandsounds.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import c.codeblaq.sightsandsounds.FullDetailsActivity;
import c.codeblaq.sightsandsounds.Location;
import c.codeblaq.sightsandsounds.R;

public class LocationRecyclerAdapter extends RecyclerView.Adapter<LocationRecyclerAdapter.ViewHolder> {
    //Context for Activity
    private final Context mContext;
    private final LayoutInflater mLayoutInflater;
    //    List for locations
    private final List<Location> mLocations;
    private String mAttractionText;
    private int mAttractionImageId;

    /*Constructor*/
    public LocationRecyclerAdapter(Context context, List<Location> locations) {
        mContext = context;
        mLocations = locations;
        mLayoutInflater = LayoutInflater.from(mContext);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Create a view for the View Holder
//        View itemView = mLayoutInflater.inflate(R.layout.item_horizontal_list, parent,false);
        View itemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_horizontal_list, parent, false
        );
        return new ViewHolder(itemView);
    }

    /*Bind data to views*/
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Get location corresponding to location
        final Location location = mLocations.get(position);
        //Get each value from View Holder
        holder.mAttractionImage.setImageResource(location.getmPrimaryImageResource());
        holder.mAttractionText.setText(location.getmAttractionName());
//        holder.mAttractionLocationText.setText(location.getmLocationName());
        holder.mCurrentPosition = position;
        holder.mAttractionImage.setOnClickListener(new View.OnClickListener() {
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

    /*Determine list size*/
    @Override
    public int getItemCount() {
        return mLocations.size();
    }

    /**
     * View Holder class
     */

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView mAttractionText;
        public final ImageView mAttractionImage;
        //public final TextView mAttractionLocationText;
//ViewHolder position
        private int mCurrentPosition;
        private String mCatName;

        public ViewHolder(View itemView) {
            super(itemView);
            //Get References to items for Locations
            mAttractionText = itemView.findViewById(R.id.attraction_name_horizontal);
            mAttractionImage = itemView.findViewById(R.id.attraction_image_horizontal);
//        mAttractionLocationText = itemView.findViewById(R.id.location_name);

            final Location location = mLocations.get(mCurrentPosition);

            String a = location.getmAttractionName();
            String b = "Location name at position " + mCurrentPosition + " is " + a;
            Log.v("TAG", b);
            //Set up OnClickListener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                Intent intent = new Intent(mContext, FragmentFullDetailsActivity.class);
//                intent.putExtra(LOCATION_POSITION, mCurrentPosition );
//                mContext.startActivity(intent);

                }
            });
        }
    }
}
