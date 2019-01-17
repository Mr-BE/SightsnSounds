package c.codeblaq.sightsandsounds;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class HistoricalActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Inflate the Categories activity
        setContentView(R.layout.activity_fragment_container);
        //Fragment contract
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new HistoricalFragment())
                .commit();
    }
}
