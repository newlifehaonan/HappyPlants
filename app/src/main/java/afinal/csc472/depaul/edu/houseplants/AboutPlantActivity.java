package afinal.csc472.depaul.edu.houseplants;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutPlantActivity extends AppCompatActivity{
    private TextView addToGarden;
    private TextView saveForLater;
    private TextView plantname;
    private TextView plantDescription;
    private ImageView plant_clip_avater;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutplant);
        this.addToGarden = findViewById(R.id.addplant);
        this.saveForLater = findViewById(R.id.save);
        this.plantname = findViewById(R.id.plant_name);
        this.plantDescription = findViewById(R.id.plant_description);
        this.plant_clip_avater = findViewById(R.id.plant_compound);

        this.plant_clip_avater.setImageDrawable(getResources().getDrawable(SharedData.getSharedData().getPlantProfile().getClipAvatar()));

        this.plantname.setText(SharedData.getSharedData().getPlantProfile().getSpecies().toString());
        this.plantDescription.setText(SharedData.getSharedData().getPlantProfile().getDescription().toString());
        this.addToGarden.setOnClickListener(addtoGarden_pressed);
        this.saveForLater.setOnClickListener(saveforlater_pressed);
    }

    private View.OnClickListener addtoGarden_pressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//            add to db under user profile's garden
            db db = SharedData.getSharedData().getDb();
            PlantProfile userselected = SharedData.getSharedData().getPlantProfile();
            db.addSelectedToGarden(userselected);
            LocalStorage.getLocalStorage().writeToG(getActivity(), userselected);
            navigateToHome();
        }
    };

    private View.OnClickListener saveforlater_pressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//            add to db under user profile's explore
            db db = SharedData.getSharedData().getDb();
            PlantProfile userselected = SharedData.getSharedData().getPlantProfile();
            db.addSelectedToExplore(userselected);
            LocalStorage.getLocalStorage().writeToX(getActivity(), userselected);
            navigateToHome();
        }
    };

    private void navigateToHome() {
        Intent intent = new Intent(this, HomeActivity.class);
        this.startActivity(intent);
    }

    private Activity getActivity() {
        return this;
    }
}
