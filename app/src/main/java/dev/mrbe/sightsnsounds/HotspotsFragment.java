package dev.mrbe.sightsnsounds;

import android.support.v4.app.Fragment;


public class HotspotsFragment extends Fragment {
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
//        locations.add(new Location(getString(R.string.tinapa), getString(R.string.calabar), R.drawable.tinapa, getString(R.string.tinapa_dets)));
//        locations.add(new Location(getString(R.string.marina_resort), getString(R.string.calabar), R.drawable.marina, getString(R.string.marina_dets)));
//
//        //Setup ArrayAdapter
//        LocationAdapter itemsAdapter = new LocationAdapter(
//                getActivity(), locations, R.color.colorText_Icons);
//
//        //Attach butterknife
//        ButterKnife.bind(this, rootView);
//        //       Set onItemClickListener for each item in list view
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
//    //Called on when Fragment is closed
//    @Override
//    public void onStop() {
//        super.onStop();
//    }
}
