package afinal.csc472.depaul.edu.houseplants;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;

public class SearchAllActivity extends AppCompatActivity implements RecyclerViewListener{
    private Toolbar toolbar;
    private MaterialSearchView searchView;
    SearchAllRecyclerViewAdapter RecyclerViewAdapter;
    ArrayList<PlantProfile> plantAll = new ArrayList<PlantProfile>();
    Context context;
    RecyclerViewListener activity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_all_activity);
        this.toolbar = findViewById(R.id.toolbar);
        this.context = getBaseContext();
        this.activity = this;
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Plant Search");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        toolbar.setBackgroundColor(Color.parseColor("#000000"));
        searchView = findViewById(R.id.search_toolbar);
        for(Plant plant: Plant.values()) {
            PlantProfile temp = new PlantProfile(plant);
            plantAll.add(temp);
        }

        setupSearchAll();
        searchView.setOnSearchViewListener(
                new MaterialSearchView.SearchViewListener() {
                    @Override
                    public void onSearchViewShown() {

                    }

                    @Override
                    public void onSearchViewClosed() {
                        setupSearchAll();
                    }
                }
        );
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText != null && !newText.isEmpty()){
                    ArrayList<PlantProfile> lstfound = new ArrayList<PlantProfile>();
                    for(PlantProfile profile : plantAll) {
                        if(profile.getSpecies().toString().contains(newText)) {
                            lstfound.add(profile);
                        }
                    }

                    RecyclerView recyclerView = findViewById(R.id.search_recycler);
                    if(recyclerView != null) {
                        recyclerView.setLayoutManager(new LinearLayoutManager(context));
                        RecyclerViewAdapter = new SearchAllRecyclerViewAdapter(context, lstfound);
                        RecyclerViewAdapter.setClickListener(activity);
                        recyclerView.setAdapter(RecyclerViewAdapter);
                    }
                }
                else {
                    setupSearchAll();
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);
        return true;
    }

    private void setupSearchAll() {
        RecyclerView recyclerView = findViewById(R.id.search_recycler);
        if(recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            RecyclerViewAdapter = new SearchAllRecyclerViewAdapter(this, this.plantAll);
            RecyclerViewAdapter.setClickListener(this);
            recyclerView.setAdapter(RecyclerViewAdapter);
        }
    }

    @Override
    public void Click(View view, int position) {

    }
}
