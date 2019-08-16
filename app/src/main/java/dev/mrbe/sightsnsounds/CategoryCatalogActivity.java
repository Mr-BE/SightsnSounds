package dev.mrbe.sightsnsounds;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import dev.mrbe.sightsnsounds.Adapters.CatalogAdapter;
import static dev.mrbe.sightsnsounds.Adapters.AttractionListRecyclerAdapter.CATEGORY_LOCATIONS;

public class CategoryCatalogActivity extends AppCompatActivity {

    private List<Location> mLocations;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_category_catologue);
        final RecyclerView catatolgRecycler = findViewById(R.id.catalog_list);
        final GridLayoutManager manager = new GridLayoutManager(this, 2);
        catatolgRecycler.setLayoutManager(manager);

        //get locations
        Bundle bundle = new Bundle();
        bundle.getParcelable(CATEGORY_LOCATIONS);
        Intent intent = getIntent();
        mLocations = intent.getParcelableArrayListExtra(CATEGORY_LOCATIONS);

        CatalogAdapter adapter1 = new CatalogAdapter(this, mLocations);
        catatolgRecycler.setAdapter(adapter1);
    }
}
