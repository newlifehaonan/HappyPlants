package afinal.csc472.depaul.edu.houseplants;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ShareStoryPopActivity extends AppCompatActivity{

    private Button cancle;
    private Button post;
    private TextView username;
    private TextView plant_name;
    private TextView description;
    private ImageView avatar;
    private EditText user_twit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share_story_popup);
        cancle = findViewById(R.id.cancle_share);
        post = findViewById(R.id.post);
        username = findViewById(R.id.user_name);
        plant_name = findViewById(R.id.plant_index);
        description = findViewById(R.id.plant_des_name);
        user_twit = findViewById(R.id.user_twit);
        avatar = findViewById(R.id.story_avatar);

        PlantProfile plantProfile = (PlantProfile) getIntent().getParcelableExtra("story_parcelable");
        setupdata(plantProfile);

        cancle.setOnClickListener(cancle_pressed);
        post.setOnClickListener(post_pressed);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.8), (int)(height*0.5));
    }

    private View.OnClickListener cancle_pressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };

    private View.OnClickListener post_pressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // do post to facebook
        }
    };

    private void setupdata(PlantProfile plantProfile){
        this.description.setText("I added a " + plantProfile.getSpecies().toString() + " called "+ plantProfile.getNickname() + " to my garden");
        this.plant_name.setText("Plant " + plantProfile.getNickname());
        this.avatar.setImageDrawable(getDrawable(plantProfile.getAvatar()));
    }
}
