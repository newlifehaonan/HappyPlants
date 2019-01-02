package afinal.csc472.depaul.edu.houseplants;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.text.method.DigitsKeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

import static android.text.InputType.TYPE_CLASS_TEXT;

public class SuggestionActivity extends AppCompatActivity{
    private TextView suggestion;
    private Button startover;
    private Button explore;
    private ImageView avatar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yoursuggestion);
        String selection = SharedData.getSharedData().finalresult().getSpecies().toString();
        int imgavtar = SharedData.getSharedData().finalresult().getAvatar();
        this.suggestion = findViewById(R.id.suggestedlabel);
        this.explore = findViewById(R.id.explore);
        this.startover = findViewById(R.id.startover);
        this.avatar = findViewById(R.id.suggestedplant);
        this.avatar.setImageDrawable(getResources().getDrawable(imgavtar));
        this.suggestion.setText(selection);
        createNewPin();

        this.suggestion.setOnClickListener(explore_pressed);
        this.explore.setOnClickListener(explore_pressed);
        this.startover.setOnClickListener(startover_pressed);
    }

    private View.OnClickListener startover_pressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            navigateToQuestion1();
        }
    };

    private View.OnClickListener explore_pressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            navigateToAboutPlant();
        }
    };

    private void navigateToQuestion1() {
        Intent intent = new Intent(this, QuestionOneActivity.class);
        this.startActivity(intent);
    }

    private void navigateToAboutPlant() {
        Intent intent = new Intent(this, AboutPlantActivity.class);
        this.startActivity(intent);
    }

    private void createNewPin()
    {
        final EditText pin = new EditText(this);
        pin.setTextSize(24);
        pin.setTypeface(null, Typeface.BOLD);
        pin.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        pin.setFilters(new InputFilter[] {
                // Maximum 10 characters.
                new InputFilter.LengthFilter(10),
        });
        pin.setInputType(TYPE_CLASS_TEXT);

        final TextView pinTitle = new TextView(this);
        pinTitle.setPadding(10, 10, 10, 10);
        pinTitle.setText(getResources().getString(R.string.create_nickname));
        pinTitle.setTextSize(24);
        pinTitle.setTypeface(null, Typeface.BOLD);
        pinTitle.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        final AlertDialog createPin = new AlertDialog.Builder(this)
                .setCustomTitle(pinTitle)
                .setView(pin)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton)
                    {
                    }
                })
                .setOnKeyListener(new DialogInterface.OnKeyListener()
                {
                    @Override
                    public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event)
                    {
                        if (keyCode==KeyEvent.KEYCODE_ENTER)
                        {
                            dialog.dismiss();
                            SharedData.getSharedData().setNickname(pin.getText().toString());
                        }

                        return false;
                    }
                }).create();
        createPin.show();

        createPin.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                createPin.dismiss();
                SharedData.getSharedData().setNickname(pin.getText().toString());
            }
        });;

        createPin.getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        createPin.show();
    }

}
