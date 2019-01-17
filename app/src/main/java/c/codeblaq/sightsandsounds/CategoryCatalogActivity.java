package c.codeblaq.sightsandsounds;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import c.codeblaq.sightsandsounds.Adapters.CatalogAdapter;

public class CategoryCatalogActivity extends AppCompatActivity {
    //Locate Views to be bound
    @BindView(R.id.attraction_image_horizontal)
    ImageView catalogImage;
    @BindView(R.id.attraction_name_horizontal)
    TextView catalogLocName;
    private Category mCategory;
    //Location position
    private int mLocationPosition;
    //DataManager Instance
    private DataManager mDataManager = DataManager.getInstance();
    private List<Location> mLocations;
    private RecyclerView mCatatolgRecycler;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_category_catologue);
        final RecyclerView catatolgRecycler = findViewById(R.id.catalog_list);
        final GridLayoutManager manager = new GridLayoutManager(this, 2);
        catatolgRecycler.setLayoutManager(manager);

        //get locations
        Bundle bundle = new Bundle();
        bundle.getParcelable("Category_Locations");
        Intent intent = getIntent();
        mLocations = intent.getParcelableArrayListExtra("Category_Locations");

        CatalogAdapter adapter1 = new CatalogAdapter(this, mLocations);
        catatolgRecycler.setAdapter(adapter1);
    }

}
