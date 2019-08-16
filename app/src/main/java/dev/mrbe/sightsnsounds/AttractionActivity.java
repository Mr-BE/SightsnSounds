package dev.mrbe.sightsnsounds;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AttractionActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private final String TAG = "AttractionActivity";

    private RecyclerView mRecyclerView;
    private DataManager mDataManager = DataManager.getInstance();
    private RecyclerView mCatatolgRecycler;
    private ActionBar toolbar;

    private FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction);
//        final Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        toolbar = getSupportActionBar();
        toolbar.setTitle("Home");
        loadFragment(new HomeFragment());

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View headerView = navigationView.getHeaderView(0);

        //Set up bottom navigation bar
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        Fragment fragment;

                        //Toggle visible fragments
                        switch (menuItem.getItemId()) {

                            case R.id.action_home:
                                toolbar.show();
                                toolbar.setTitle("Home");
                                fragment = new HomeFragment();
                                loadFragment(fragment);
                                break;
                            case R.id.action_search:
                                toolbar.show();
                                toolbar.setTitle("Search");
                                fragment = new SearchFragment();
                                loadFragment(fragment);
                                break;
                            case R.id.action_fav:
                                toolbar.show();
                                toolbar.setTitle("Likes");
                                fragment = new LikesFragment();
                                loadFragment(fragment);
                                break;
                            case R.id.action_drawer:
                                toolbar.hide();
                                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                                drawer.openDrawer(Gravity.LEFT);
                                break;
                            default:
                                toolbar.show();
                                toolbar.setTitle("Home");
                                fragment = new HomeFragment();
                                loadFragment(fragment);
                                break;
                        }
                        return true;
                    }
                }
        );

        //Initialize content
//        initDisplayContent();

        //Get current firebase user
        mUser = FirebaseAuth.getInstance().getCurrentUser();

        //get details
        getUserDetails();

        //Display user details in Drawer layout
        TextView username, email;
        ImageView displayPicture;

        username = headerView.findViewById(R.id.drawerUsernameText);
        email = headerView.findViewById(R.id.drawerEmailText);
        displayPicture = headerView.findViewById(R.id.drawerImageView);

        email.setText(mUser.getEmail());

    }

//    private void initDisplayContent() {
//        mRecyclerView = findViewById(R.id.whole_attraction_list);
//
//        mCatatolgRecycler = findViewById(R.id.catalog_list);
//
//        List<Category> categories = mDataManager.getCategories();
//
//        AttractionListRecyclerAdapter adapter = new AttractionListRecyclerAdapter(this, categories);
//        mRecyclerView.setAdapter(adapter);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//    }

    private void getUserDetails() {
        if (mUser != null) {//User authenticated
            String uId = mUser.getUid();
            String name = mUser.getDisplayName();
            String email = mUser.getEmail();
            Uri photoUrl = mUser.getPhotoUrl();

            String properties = "uId: " + uId + "\n" +
                    "name: " + name + "\n" +
                    "email: " + email + "\n" +
                    "photoUrl: " + photoUrl;

            Log.d(TAG, "getUserDetails: properties -> \n" + properties);
        }
    }

    //Load fragments
    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.attractions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
