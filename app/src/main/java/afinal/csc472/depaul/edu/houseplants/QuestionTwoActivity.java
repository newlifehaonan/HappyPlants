package afinal.csc472.depaul.edu.houseplants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class QuestionTwoActivity extends AppCompatActivity{
    private Button easy;
    private Button medium;
    private Button difficult;

    private Button previous;
    private Button skip;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question2);
        this.easy = findViewById(R.id.easy);
        this.medium = findViewById(R.id.average);
        this.difficult = findViewById(R.id.difficult);
        this.previous = findViewById(R.id.Previous);
        this.skip = findViewById(R.id.skip);

        //        set up button listener
        this.easy.setOnClickListener(easy_pressed);
        this.medium.setOnClickListener(average_pressed);
        this.difficult.setOnClickListener(difficult_pressed);
        this.previous.setOnClickListener(previous_pressed);
        this.skip.setOnClickListener(skip_pressed);
    }

    private Activity getActivity() {
        return this;
    }

    private View.OnClickListener easy_pressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity(),"You choose easy", Toast.LENGTH_LONG).show();
            SharedData.getSharedData().getSelection().setDifficulty(Difficulty.EASY);
            navigateToThree();
        }
    };

    private View.OnClickListener average_pressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity(),"You choose medium", Toast.LENGTH_LONG).show();
            SharedData.getSharedData().getSelection().setDifficulty(Difficulty.AVERAGE);
            navigateToThree();
        }
    };

    private View.OnClickListener difficult_pressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity(),"You choose difficult", Toast.LENGTH_LONG).show();
            SharedData.getSharedData().getSelection().setDifficulty(Difficulty.DIFFICULT);
            navigateToThree();
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
            navigateToThree();
        }
    };

    private void navigateToThree() {
        Intent intent = new Intent(getActivity(), QuestionThreeActivity.class);
        this.startActivity(intent);
    }
}
