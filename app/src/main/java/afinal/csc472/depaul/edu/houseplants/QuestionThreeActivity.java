package afinal.csc472.depaul.edu.houseplants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class QuestionThreeActivity extends AppCompatActivity{
    private Button bonsai;
    private Button cleanairplant;
    private Button ground;
    private Button flowering;
    private Button hanging;
    private Button officeplants;

    private Button previous;
    private Button skip;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question3);
        this.bonsai = findViewById(R.id.bonsai);
        this.cleanairplant = findViewById(R.id.cleanairplant);
        this.ground = findViewById(R.id.ground);
        this.flowering = findViewById(R.id.flowering);
        this.hanging = findViewById(R.id.hanging);
        this.officeplants = findViewById(R.id.officeplants);
        this.previous = findViewById(R.id.Previous);
        this.skip = findViewById(R.id.skip);

        // set up button listener
        this.bonsai.setOnClickListener(bonsai_pressed);
        this.cleanairplant.setOnClickListener(cleanair_pressed);
        this.ground.setOnClickListener(ground_pressed);
        this.flowering.setOnClickListener(flowering_pressed);
        this.hanging.setOnClickListener(hanging_pressed);
        this.officeplants.setOnClickListener(office_pressed);
        this.previous.setOnClickListener(previous_pressed);
        this.skip.setOnClickListener(skip_pressed);
    }

    private Activity getActivity() {
        return this;
    }

    private View.OnClickListener bonsai_pressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity(),"You choose bonsai", Toast.LENGTH_LONG).show();
            SharedData.getSharedData().getSelection().setInterest(Interest.bonsai);
            navigateToFour();
        }
    };

    private View.OnClickListener cleanair_pressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity(),"You choose cleanair", Toast.LENGTH_LONG).show();
            SharedData.getSharedData().getSelection().setInterest(Interest.cleanairplant);
            navigateToFour();
        }
    };

    private View.OnClickListener ground_pressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity(),"You choose ground", Toast.LENGTH_LONG).show();
            SharedData.getSharedData().getSelection().setInterest(Interest.ground);
            navigateToFour();
        }
    };

    private View.OnClickListener flowering_pressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity(),"You choose flowering", Toast.LENGTH_LONG).show();
            SharedData.getSharedData().getSelection().setInterest(Interest.flowering);
            navigateToFour();
        }
    };

    private View.OnClickListener hanging_pressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity(),"You choose hanging", Toast.LENGTH_LONG).show();
            SharedData.getSharedData().getSelection().setInterest(Interest.hanging);
            navigateToFour();
        }
    };

    private View.OnClickListener office_pressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity(),"You choose office", Toast.LENGTH_LONG).show();
            SharedData.getSharedData().getSelection().setInterest(Interest.officeplants);
            navigateToFour();
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
            navigateToFour();
        }
    };
    private void navigateToFour() {
        Intent intent = new Intent(getActivity(), QuestionFourActivity.class);
        this.startActivity(intent);
    }
}
