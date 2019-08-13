package dev.mrbe.sightsnsounds;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class FullDetailsActivity extends AppCompatActivity {
    /*Constant for location*/
    public static final String LOCATION_KEY = "Location";

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_details);

        Bundle bundle = new Bundle();
        bundle.getParcelable(LOCATION_KEY);
        Intent intent = getIntent();
        mLocation = intent.getParcelableExtra(LOCATION_KEY);

        /*Attach Butterknife*/
        ButterKnife.bind(this);

        fullAttractionName.setText(mLocation.getmAttractionName());
        fullAttractionDetails.setText(mLocation.getmAtrractionDetails());
        fullAttractionImage.setImageResource(mLocation.getmPrimaryImageResource());

    }
}
