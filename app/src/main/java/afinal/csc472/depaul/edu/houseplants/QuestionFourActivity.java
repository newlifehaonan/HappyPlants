package afinal.csc472.depaul.edu.houseplants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class QuestionFourActivity extends AppCompatActivity{

    private Button yes;
    private Button no;

    private Button previous;
    private Button skip;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question4);
//        get the button from UI
        this.yes = findViewById(R.id.yes);
        this.no = findViewById(R.id.no);
        this.previous = findViewById(R.id.Previous);
        this.skip = findViewById(R.id.skip);

//        set up button listener
        this.yes.setOnClickListener(yes_pressed);
        this.no.setOnClickListener(no_pressed);
        this.previous.setOnClickListener(previous_pressed);
        this.skip.setOnClickListener(skip_pressed);
    }

    private Activity getActivity() {
        return this;
    }

    private View.OnClickListener yes_pressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity(),"You choose Yes", Toast.LENGTH_LONG).show();
            SharedData.getSharedData().getSelection().setEnvironment(Environment.yes);
            navigateToSuggestion();
        }
    };

    private View.OnClickListener no_pressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity(),"You choose No", Toast.LENGTH_LONG).show();
            SharedData.getSharedData().getSelection().setEnvironment(Environment.no);
            navigateToSuggestion();
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
            navigateToSuggestion();
        }
    };

    private void navigateToSuggestion() {
        Intent intent = new Intent(getActivity(), SuggestionActivity.class);
        this.startActivity(intent);
    }
}
