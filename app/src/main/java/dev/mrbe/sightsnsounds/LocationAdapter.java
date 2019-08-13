package dev.mrbe.sightsnsounds;

//public class LocationAdapter extends ArrayAdapter<Location> {
//    //Log tag for debugging
//    private static final String LOG_TAG =
//            LocationAdapter.class.getSimpleName();
//    //Locate TextView in the list view for Attraction name
//    @BindView(R.id.attraction_name)
//    TextView attractionName;
//    //Locate TextView in the list view for Attraction Location name
//    @BindView(R.id.location_name)
//    TextView locationName;
//    //Locate ImageView in the list view for Attraction Image
//    @BindView(R.id.attractionImage)
//    ImageView attractionImage;
//    /*Set the theme color to List View*/
//    @BindView(R.id.text_container)
//    View textContainer;
//    // Resource ID for list background color
//    private int mColorResourceId;
//
//    /**
//     * Constructor for Location Adapter
//     *
//     * @param context          is the context used to layout file
//     * @param locations        is a list of attractions and their locations to be displayed
//     * @param mColorResourceId is the color resource for the various activities
//     */
//    public LocationAdapter(@NonNull Context context, @NonNull ArrayList<Location> locations,
//                           int mColorResourceId) {
//
//        //Initialize the ArrayAdapter's internal storage for the context and the list
//        super(context, 0, locations);
//        //Set constructor to get color resource ID from activity
//        this.mColorResourceId = mColorResourceId;
//    }
//
//    /**
//     * Provides a view for an AdapterView
//     *
//     * @param position    The position in the list of data that should be displayed in the list item
//     * @param convertView The recycled view to populate
//     * @param parent      The parent ViewGroup used for inflation
//     * @return The view for the position in the Adapter
//     */
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//
//        //Check if the existing view is being used, otherwise inflate the view
//        if (convertView == null) {
//            convertView = LayoutInflater.from(getContext()).inflate(
//                    R.layout.list_content, parent, false);
//        }
//        //Get the {@link Location} object located at a given position in the list
//        Location currentLocation = getItem(position);
//
//        //Attach Butterknife to view {convertView}
//        ButterKnife.bind(this, convertView);
//
//        //Get the attraction name from current Location object and set this text to above TextView
//        attractionName.setText(currentLocation.getmAttractionName());
//
//        //Get the attraction location name from current Location object and set this text to above TextView
//        locationName.setText(currentLocation.getmLocationName());
//
//        //Check if activity contains image
//        if (currentLocation.hasImage()) {
//            //Get attraction image from current Location object
//            attractionImage.setImageResource(currentLocation.getmPrimaryImageResource());
//            //Make view visible
//            attractionImage.setVisibility(View.VISIBLE);
//        } else {
//            attractionImage.setVisibility(View.GONE);
//        }
//
//        //Find the color from resource ID
//        int color = ContextCompat.getColor(getContext(), mColorResourceId);
//        //Set the background color of the text container view
//        textContainer.setBackgroundColor(color);
//
//        return convertView;
//    }
//}
