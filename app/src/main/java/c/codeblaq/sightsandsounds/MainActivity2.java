package c.codeblaq.sightsandsounds;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity2 extends AppCompatActivity {

    //Locate TextView to be populated
    @BindView(R.id.state_destination)
    TextView destinationTV;
    //Locate Text View to be populated with State details
    @BindView(R.id.destination_intro)
    TextView destinationDetailsTV;
    //Locate Proceed button
    @BindView(R.id.proceed_button)
    Button proceedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_desc);

        //Attach ButterKnife
        ButterKnife.bind(this);

        //Attach text to TextView
        destinationTV.setText(R.string.cross_river);

        //Attach destination details text to  TextView
        destinationDetailsTV.setText(R.string.cross_dets);

        //Set onClickListener to button
        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Setup proceed intent
                Intent proceedIntent = new Intent(MainActivity2.this, TabActivity.class);
                //start intent
                startActivity(proceedIntent);
            }
        });
    }
}
