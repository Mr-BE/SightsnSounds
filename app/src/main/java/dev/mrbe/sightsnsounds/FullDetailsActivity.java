package dev.mrbe.sightsnsounds;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.appbar.CollapsingToolbarLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FullDetailsActivity extends AppCompatActivity {
    /*Constant for location*/
    public static final String LOCATION_KEY = "Location";

    private final String TAG = getClass().getSimpleName();

    /*Locate views to be populated by intent*/
    //Attraction name
//    @BindView(R.id.attraction_name_detailed)
//    TextView fullAttractionName;
    //Attraction Image resource
    @BindView(R.id.attractionImage_detailed)
    ImageView fullAttractionImage;
    //Full details of attraction
    @BindView(R.id.attraction_details)
    TextView fullAttractionDetails;

    @BindView(R.id.full_details_tool_bar)
    Toolbar mToolbar;
    @BindView(R.id.collapsing_toolbar_layout)
    CollapsingToolbarLayout mCollapsingToolbarLayout;

    private Location mLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_details);
        Bundle bundle = new Bundle();
        bundle.getParcelable(LOCATION_KEY);
        Intent intent = getIntent();
        mLocation = intent.getParcelableExtra(LOCATION_KEY);

//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.setDisplayHomeAsUpEnabled(true); //show back button
//        }
        /*Attach Butterknife*/
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
//        getSupportActionBar().hide();
//        fullAttractionName.setText(mLocation.getAttractionName());
        fullAttractionDetails.setText(mLocation.getmAtrractionDetails());
        fullAttractionImage.setImageResource(mLocation.getmPrimaryImageResource());


        mToolbar.setBackground(getDrawable(R.drawable.background_graphics));
        mCollapsingToolbarLayout.setTitle(mLocation.getmAttractionName());
        mCollapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.colorSecondaryText, getTheme()));
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.matteBlack, getTheme()));
    }
}
