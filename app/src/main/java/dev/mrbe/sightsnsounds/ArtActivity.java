package dev.mrbe.sightsnsounds;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class ArtActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Inflate the Categories activity
        setContentView(R.layout.activity_fragment_container);
        //Fragment contract
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new ArtFragment())
                .commit();
    }
}
