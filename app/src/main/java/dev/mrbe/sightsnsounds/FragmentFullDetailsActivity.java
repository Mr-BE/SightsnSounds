package dev.mrbe.sightsnsounds;

import androidx.appcompat.app.AppCompatActivity;

public class FragmentFullDetailsActivity extends AppCompatActivity {
//    /*Constant for location*/
//    public static final String LOCATION_POSITION = "c.codeblaq.sightsandsounds2.LOCATION_POSITION";
//    public static final int POSITION_NOT_SET = -1;
//
//    private final String TAG = getClass().getSimpleName();
//
//    /*Locate views to be populated by intent*/
//    //Attraction name
//    @BindView(R.id.attraction_name_detailed)
//    TextView fullAttractionName;
//    //Attraction Image resource
//    @BindView(R.id.attractionImage_detailed)
//    ImageView fullAttractionImage;
//    //Full details of attraction
//    @BindView(R.id.attraction_details)
//    TextView fullAttractionDetails;
//    private Location mLocation;
//
//    //Location position
//    private  int mLocationPosition ;
//
//    //DataManager Instance
//    private DataManager mDataManager = DataManager.getInstance();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_full_details);
//
//        /*Attach Butterknife*/
//        ButterKnife.bind(this);
//        //Read values from parcel
//        readDisplayValues();
//        //display read values
//        displayValues(fullAttractionName, fullAttractionDetails, fullAttractionImage);
//    }
//
//    /**
//     * Helper method to display values read from parcel
//     *
//     * @param attractionName    is the name of the location
//     * @param attractionDetails is the details text associated with the location
//     * @param attractionImage   is the image of the location
//     */
//    private void displayValues(TextView attractionName, TextView attractionDetails, ImageView attractionImage) {
////
//        attractionName.setText(mLocation.getmAttractionName());
//        attractionDetails.setText(mLocation.getmAtrractionDetails());
//        attractionImage.setImageResource(mLocation.getmPrimaryImageResource());
//
//    }
//
//    /**
//     * Helper method to read values from parcel
//     */
//    private void readDisplayValues() {
//        Intent intent = getIntent();
////        Get position from intent
//       mLocationPosition = intent.getIntExtra(LOCATION_POSITION, POSITION_NOT_SET);
//
//        if (mLocationPosition!= POSITION_NOT_SET)//Position exist in list
////        //Get location from Data Manager
//            mLocation = mDataManager.getLocations().get(mLocationPosition);
//    }
}
