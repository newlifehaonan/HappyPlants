package afinal.csc472.depaul.edu.houseplants;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class ExploreActivity extends AppCompatActivity implements RecyclerViewListener{

    private Button gobacktogarden;
    PlantLaterRecyclerViewAdapter RecyclerViewAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_suggestions);
        setupSaveForlater();
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

    private void setupSaveForlater() {
        LocalStorage.getLocalStorage().createTwoTables(this);
        ArrayList<PlantProfile> plantForLater = LocalStorage.getLocalStorage().readFromX(this);
        RecyclerView recyclerView = findViewById(R.id.plantLaterRecycler);
        if(recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            RecyclerViewAdapter = new PlantLaterRecyclerViewAdapter(this, plantForLater);
            RecyclerViewAdapter.setClickListener(this);
            recyclerView.setAdapter(RecyclerViewAdapter);
        }
    }

    private void createPlantExploreProfile(PlantProfile profile) {
        Intent intent = new Intent(this, ExploreToGardenActivity.class);
        intent.putExtra("explore_plant", profile);
        this.startActivity(intent);
    }

    @Override
    public void Click(View view, int position) {
        PlantProfile profile = RecyclerViewAdapter.getItem(position);
        createPlantExploreProfile(profile);
    }
}
