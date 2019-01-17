package c.codeblaq.sightsandsounds;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FullDetailsActivity extends AppCompatActivity {
    /*Constant for location*/
    public static final String LOCATION_POSITION = "c.codeblaq.test.LOCATION_POSITION";
    public static final int POSITION_NOT_SET = -1;

    private final String TAG = getClass().getSimpleName();

    /*Locate views to be populated by intent*/
    //Attraction name
    @BindView(R.id.attraction_name_detailed)
    TextView fullAttractionName;
    //Attraction Image resource
    @BindView(R.id.attractionImage_detailed)
    ImageView fullAttractionImage;
    //Full details of attraction
    @BindView(R.id.attraction_details)
    TextView fullAttractionDetails;
    private Location mLocation;

    //Location position
    private int mLocationPosition;

    //DataManager Instance
    private DataManager mDataManager = DataManager.getInstance();
    private List<Category> mCategory;
    private Location mCatLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_details);

        Bundle bundle = new Bundle();
        bundle.getParcelable("Location");
        Intent intent = getIntent();
        mLocation = intent.getParcelableExtra("Location");



        /*Attach Butterknife*/
        ButterKnife.bind(this);
        //Read values from parcel
//        readDisplayValues();
        //display read values
//        displayValues(fullAttractionName, fullAttractionDetails, fullAttractionImage);

        fullAttractionName.setText(mLocation.getmAttractionName());
        fullAttractionDetails.setText(mLocation.getmAtrractionDetails());
        fullAttractionImage.setImageResource(mLocation.getmPrimaryImageResource());

    }

    /**
     * Helper method to display values read from parcel
     *
     * @param attractionName    is the name of the location
     * @param attractionDetails is the details text associated with the location
     * @param attractionImage   is the image of the location
     */
    private void displayValues(TextView attractionName, TextView attractionDetails, ImageView attractionImage) {
//
        attractionName.setText(mCatLocation.getmAttractionName());
        attractionDetails.setText(mCatLocation.getmAtrractionDetails());
        attractionImage.setImageResource(mCatLocation.getmPrimaryImageResource());
    }

    /**
     * Helper method to read values from parcel
     */
    private void readDisplayValues() {
        Intent intent = getIntent();
//        Get position from intent
        mLocationPosition = intent.getIntExtra(LOCATION_POSITION, POSITION_NOT_SET);

        if (mLocationPosition != POSITION_NOT_SET)//Position exist in list
//        //Get location from Data Manager
            mCategory = mDataManager.getCategories();
        for (int i = 0; i < mCategory.size(); i++)
            mCatLocation = mCategory.get(i).getLocations().get(mLocationPosition);
        mLocation = mDataManager.getLocations().get(mLocationPosition);
    }
}
