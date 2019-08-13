package dev.mrbe.sightsnsounds;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TabActivity extends AppCompatActivity {
    //Locate View pager for swipe-able fragments
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    // Locate the TabLayout for ViewPager
    @BindView(R.id.sliding_tabs)
    TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set content of the view
        setContentView(R.layout.activity_tab);

        //Attach Butterknife
        ButterKnife.bind(this);

        //Instantiate adapter for fragments
        MyFragmentPageAdapter adapter =
                new MyFragmentPageAdapter(this, getSupportFragmentManager());
        //Set adapter to View pager
        viewPager.setAdapter(adapter);

        //Connect tab layout to viewpager
        tabLayout.setupWithViewPager(viewPager);
    }
}
