package c.codeblaq.sightsandsounds;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import c.codeblaq.sightsandsounds.Adapters.LocationRecyclerAdapter;

public class HistoricalFragment extends Fragment {

    //Locate view to be used for list items
    @BindView(R.id.list_location)
    RecyclerView mRecyclerLocations;
    //Recycler Adapter object
    private LocationRecyclerAdapter mLocationRecyclerAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.location_list, container,
                false);

        initializeContentDisplay(rootView);

        return rootView;
    }

    //Called when fragment is closed
    @Override
    public void onStop() {
        super.onStop();
    }

    /*Display content in Recycler View*/
    private void initializeContentDisplay(View view) {

        //Create Recycler View variable
        final RecyclerView recyclerLocations = view.findViewById(R.id.list_location);

        //Create Linear manager instance
        final LinearLayoutManager locationLayoutManager =
                new LinearLayoutManager(getContext());
        //associate recycler view with manager
        recyclerLocations.setLayoutManager(locationLayoutManager);

        //Get Locations to be displayed in Recycler View
        List<Location> locations = DataManager.getInstance().getLocations();

        //Create instance of LocationRecyclerAdapter
        mLocationRecyclerAdapter = new LocationRecyclerAdapter(getContext(), locations);
        //Bind Adapter to Recycler View
        recyclerLocations.setAdapter(mLocationRecyclerAdapter);
    }
}