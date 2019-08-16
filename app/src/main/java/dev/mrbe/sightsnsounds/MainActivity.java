package dev.mrbe.sightsnsounds;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    //locate ImageView
    @BindView(R.id.cross_river_logo)
    ImageView crossRiverView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_states);

        //Attach Butterknife
        ButterKnife.bind(this);

        //Set onclick listener
        crossRiverView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveIntent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(moveIntent);
            }
        });
    }
}
