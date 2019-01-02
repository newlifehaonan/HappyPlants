package afinal.csc472.depaul.edu.houseplants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class QuestionOneActivity extends AppCompatActivity {

    private Button low;
    private Button average;
    private Button high;

    private Button previous;
    private Button skip;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question1);
//        get the button from UI
        this.low = findViewById(R.id.lowlight);
        this.average = findViewById(R.id.add);
        this.high = findViewById(R.id.highlight);
        this.previous = findViewById(R.id.Previous);
        this.skip = findViewById(R.id.skip);

//        set up button listener
        this.low.setOnClickListener(low_pressed);
        this.average.setOnClickListener(average_pressed);
        this.high.setOnClickListener(high_pressed);
        this.previous.setOnClickListener(previous_pressed);
        this.skip.setOnClickListener(skip_pressed);
    }

    private Activity getActivity() {
        return this;
    }

    private View.OnClickListener low_pressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity(),"You choose Low Light", Toast.LENGTH_LONG).show();
            SharedData.getSharedData().getSelection().setLight(Light.LOW);
            navigateToTwo();
        }
    };

    private View.OnClickListener average_pressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity(),"You choose Average Light", Toast.LENGTH_LONG).show();
            SharedData.getSharedData().getSelection().setLight(Light.MEDIUM);
            navigateToTwo();
        }
    };

    private View.OnClickListener high_pressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity(),"You choose High Light", Toast.LENGTH_LONG).show();
            SharedData.getSharedData().getSelection().setLight(Light.HIGH);
            navigateToTwo();
        }
    };

    private View.OnClickListener previous_pressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };

    private View.OnClickListener skip_pressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            navigateToTwo();
        }
    };

    private void navigateToTwo() {
        Intent intent = new Intent(getActivity(), QuestionTwoActivity.class);
        this.startActivity(intent);
    }

}
