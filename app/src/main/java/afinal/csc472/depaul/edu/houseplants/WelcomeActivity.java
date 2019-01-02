package afinal.csc472.depaul.edu.houseplants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity{

    private Button add;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        this.add = findViewById(R.id.add);

        this.add.setOnClickListener(add_pressed);
    }

    private View.OnClickListener add_pressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            navigateToQuestion();
        }
    };

    private Activity getActivity() {
        return this;
    }

    private void navigateToQuestion() {
        Intent intent = new Intent(getActivity(), QuestionOneActivity.class);
        this.startActivity(intent);
    }
}
