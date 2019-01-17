package c.codeblaq.sightsandsounds;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyFragmentPageAdapter extends FragmentPagerAdapter {
    //Number of fragment pages in tab activity
    final int PAGE_COUNT = 4;
    //Activity Context
    /*This context is important so that references can be made to this activity
     * Also, this is needed to access app resources*/
    private Context mContext;

    /**
     * Create a new {@link MyFragmentPageAdapter} object
     *
     * @param fm       is the fragment manager keeping the state of each fragment between swipes
     * @param mContext is the application context
     */
    public MyFragmentPageAdapter(Context mContext, FragmentManager fm) {
        super(fm);
        this.mContext = mContext;
    }

    //Get number of fragment pages
    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    /* Get different fragments based on screen position*/
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new HistoricalFragment();
        } else if (position == 1) {
            return new NatureFragment();
        } else if (position == 2) {
            return new ArtFragment();
        } else return new HotspotsFragment();
    }

    //Generate fragment page title based on item position
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.historical);
        } else if (position == 1) {
            return mContext.getString(R.string.natural_att);
        } else if (position == 2) {
            return mContext.getString(R.string.art);
        } else {
            return mContext.getString(R.string.hotspots);
        }
    }
}
