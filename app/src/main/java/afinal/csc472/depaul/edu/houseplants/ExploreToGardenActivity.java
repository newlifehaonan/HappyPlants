package afinal.csc472.depaul.edu.houseplants;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ExploreToGardenActivity extends AppCompatActivity{
    private ImageView avatar;
    private TextView decription;
    private TextView addToGarden;
    private TextView backToExplore;
    private PlantProfile plantProfile;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore_to_garden);
        this.avatar = findViewById(R.id.explore_plant_compound);
        this.decription = findViewById(R.id.explore_description);
        this.addToGarden = findViewById(R.id.explore_addplant);
        this.backToExplore = findViewById(R.id.explore_back);

        PlantProfile plantProfile = (PlantProfile) getIntent().getParcelableExtra("explore_plant");
        this.plantProfile = plantProfile;
        this.avatar.setImageDrawable(getDrawable(plantProfile.getClipAvatar()));
        this.decription.setText(plantProfile.getDescription());

        this.backToExplore.setOnClickListener(backpressed);
        this.addToGarden.setOnClickListener(addpressed);
    }

    private View.OnClickListener backpressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            navigateToExplore();
        }
    };

    private View.OnClickListener addpressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            navigateToGarden();
        }
    };

    private void navigateToExplore() {
        Intent intent = new Intent(this, ExploreActivity.class);
        this.startActivity(intent);
    }

    private void navigateToGarden() {
        removeFromX(this.plantProfile);
        addToG(this.plantProfile);
        Intent intent = new Intent(this, HomeActivity.class);
        this.startActivity(intent);
    }

    private void removeFromX(PlantProfile plantProfile) {
        LocalStorage.getLocalStorage().removeFromX(this, plantProfile);
    }

    private void addToG(PlantProfile plantProfile) {
        LocalStorage.getLocalStorage().addToG(this, plantProfile);
    }
}
