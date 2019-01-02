package afinal.csc472.depaul.edu.houseplants;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements RecyclerViewListener{
    private ImageView garden;
    private ImageView discover;
    private ImageView stories;
    private ImageView profiles;
    private ImageView search_db;

    private Button addnew;
    PlantProfileRecyclerViewAdapter RecyclerViewAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        this.garden = findViewById(R.id.garden);
        this.discover = findViewById(R.id.discover);
        this.stories = findViewById(R.id.story);
        this.profiles = findViewById(R.id.user);
        this.addnew = findViewById(R.id.addnew);
        this.search_db = findViewById(R.id.search_db);
        if(isNetworkAvailable()){
            ArrayList<PlantProfile> plantProfiles = LocalStorage.getLocalStorage().readFromG(this);
            if (plantProfiles.size() == 0){
                LinearLayout main_container = findViewById(R.id.main_container);
                if (main_container != null)
                {

                    LayoutInflater layoutInflater = LayoutInflater.from(this);
                    LinearLayout noPlantPanel = (LinearLayout)layoutInflater.inflate(R.layout.noplantpanel, null);
                    main_container.addView(noPlantPanel);

                }
            }
            else {
                setupPlantCard();
            }
        }
        else {

            if(LocalStorage.getLocalStorage().isDbexist(this)) {
                ArrayList<PlantProfile> plantProfiles = LocalStorage.getLocalStorage().readFromG(this);
                if (plantProfiles.size() == 0){
                    LinearLayout main_container = findViewById(R.id.main_container);
                    if (main_container != null)
                    {

                        LayoutInflater layoutInflater = LayoutInflater.from(this);
                        LinearLayout noPlantPanel = (LinearLayout)layoutInflater.inflate(R.layout.noplantpanel, null);
                        main_container.addView(noPlantPanel);

                    }
                }
                else {
                    setupPlantCard();
                }
            }
            else {
                LocalStorage.getLocalStorage().createTwoTables(this);
            }
        }

        this.garden.setOnClickListener(garden_pressed);
        this.discover.setOnClickListener(discover_pressed);
        this.stories.setOnClickListener(stories_pressed);
        this.profiles.setOnClickListener(profile_pressed);
        this.addnew.setOnClickListener(addnew_pressed);
        this.search_db.setOnClickListener(searchAll_pressed);
    }

    private View.OnClickListener searchAll_pressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            navigateToSearchAll();
        }
    };

    private View.OnClickListener garden_pressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//            render Garden UI use recyclerview
            setupPlantCard();
        }
    };

    private View.OnClickListener discover_pressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//            render discover UI use recyclerview
            navigateToExplore();
        }
    };

    private View.OnClickListener stories_pressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//            render story UI, add share to facebook messaing functionality
            navigateToStory();
        }
    };

    private View.OnClickListener profile_pressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//            render User Profile UI
            navigateToUserProfile();
        }
    };

    private View.OnClickListener addnew_pressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            navigateToWelcome();
        }
    };

    private void setupPlantCard()
    {
        // pull data from either local or cloud database
        ArrayList<PlantProfile> plantProfiles = LocalStorage.getLocalStorage().readFromG(this);
        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.plantRecycler);
        if (recyclerView != null)
        {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            RecyclerViewAdapter = new PlantProfileRecyclerViewAdapter(this, plantProfiles);
            RecyclerViewAdapter.setClickListener(this);
            recyclerView.setAdapter(RecyclerViewAdapter);
        }
    }

    private void navigateToWelcome() {
        Intent intent = new Intent(this, WelcomeActivity.class);
        this.startActivity(intent);
    }
    private void navigateToExplore() {
        Intent intent = new Intent(this, ExploreActivity.class);
        this.startActivity(intent);
    }
    private void navigateToStory() {
        Intent intent = new Intent(this, PlantStoryActivity.class);
        this.startActivity(intent);
    }
    private void navigateToSearchAll() {
        Intent intent = new Intent(this, SearchAllActivity.class);
        this.startActivity(intent);
    }
    private void navigateToUserProfile() {
        Intent intent = new Intent(this, UserProfileActivity.class);
        this.startActivity(intent);
    }


    private void createPlantDetailProfile(PlantProfile profile) {
        Intent intent = new Intent(this, PlantDetailActivity.class);
        intent.putExtra("parcel_profile", profile);
        this.startActivity(intent);
    }

    @Override
    public void Click(View view, int position) {
        PlantProfile profile = RecyclerViewAdapter.getItem(position);
        createPlantDetailProfile(profile);
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
