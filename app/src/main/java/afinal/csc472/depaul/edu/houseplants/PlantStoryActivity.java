package afinal.csc472.depaul.edu.houseplants;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.text.InputType.TYPE_CLASS_TEXT;

public class PlantStoryActivity extends AppCompatActivity implements RecyclerViewListener{
    private Button gobacktogarden;
    PlantStoryRecyclerViewAdapter RecyclerViewAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_story);
        setupStoryCard();
        this.gobacktogarden = findViewById(R.id.backtogarden);

        this.gobacktogarden.setOnClickListener(goback_pressed);
    }

    private View.OnClickListener goback_pressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            navigateToHome();
        }
    };

    private void navigateToHome() {
        Intent intent = new Intent(this, HomeActivity.class);
        this.startActivity(intent);
    }

    @Override
    public void Click(View view, int position) {
        PlantProfile plantProfile = RecyclerViewAdapter.getItem(position);
        createShareDialog(plantProfile);
    }

    private void setupStoryCard() {
        ArrayList<PlantProfile> plantStories = LocalStorage.getLocalStorage().readFromG(this);
        RecyclerView recyclerView = findViewById(R.id.plantStoryRecycler);
        if(recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            RecyclerViewAdapter = new PlantStoryRecyclerViewAdapter(this, plantStories);
            RecyclerViewAdapter.setClickListener(this);
            recyclerView.setAdapter(RecyclerViewAdapter);
        }
    }

    private void createShareDialog(PlantProfile plantProfile)
    {
        Intent intent = new Intent(this, ShareStoryPopActivity.class);
        intent.putExtra("story_parcelable", plantProfile);
        this.startActivity(intent);
    }
}
