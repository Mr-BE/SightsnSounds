package dev.mrbe.sightsnsounds;

import androidx.fragment.app.Fragment;

public class NatureFragment extends Fragment {
//
//    //Locate view to be used for list items
//    @BindView(R.id.list)
//    ListView listView;
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View rootView = inflater.inflate(R.layout.location_list, container,
//                false);
//
//        //Create an arrayList of attractions
//        final ArrayList<Location> locations = new ArrayList<>();
//        locations.add(new Location(getString(R.string.obudu_montain), getString(R.string.obudu), R.drawable.obudu_huts, getString(R.string.obudu_dets)));
//        locations.add(new Location(getString(R.string.afi_sanctuary), getString(R.string.akamkpa), R.drawable.afi_drill, getString(R.string.afi_dets)));
//        locations.add(new Location(getString(R.string.agbokim_falls), getString(R.string.ikom), R.drawable.agbokim_falls, getString(R.string.agbokim_dets)));
//
//        //Setup ArrayAdapter
//        LocationAdapter itemsAdapter = new LocationAdapter(
//                getActivity(), locations, R.color.colorText_Icons);
//
//        //Attach Butterknife
//        ButterKnife.bind(this, rootView);
//
//        //Set onItemClickListener for each item in list view
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                //Get each position in the list view and store it as a "Location" object
//                Location location = (Location) listView.getItemAtPosition(position);
//
//                /*Initialize intent*/
//                Intent detailsIntent = new Intent(getContext(), FragmentFullDetailsActivity.class);
//                detailsIntent.putExtra(FragmentFullDetailsActivity.LOCATION, location);
//                startActivity(detailsIntent);
//            }
//        });
//
//        //Attach listview to adapter
//        listView.setAdapter(itemsAdapter);
//        return rootView;
//    }
//
//    //Called when fragment is closed
//    @Override
//    public void onStop() {
//        super.onStop();
//    }
}
