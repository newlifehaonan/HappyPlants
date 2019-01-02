package afinal.csc472.depaul.edu.houseplants;

import android.app.Notification;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static afinal.csc472.depaul.edu.houseplants.App.CHANNEL_1_ID;

import java.util.Locale;

public class PlantDetailActivity extends AppCompatActivity{
    private TextView plant_nickname;
    private TextView plant_description;
    private TextView time;
    private TextView species;
    private ImageView avatar;
    private CountDownTimer mCountDownTimer;
    private NotificationManagerCompat notificationManager;
    private boolean mTimerRunning;
    private String CHANNEL_ID = "2933";

    private long mTimeLeftInMillis;
    private int startTime;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plant_detail_profile);
        plant_nickname = findViewById(R.id.plant_name);
        plant_description = findViewById(R.id.plant_description);
        time = findViewById(R.id.time);
        species = findViewById(R.id.species);
        avatar = findViewById(R.id.plant_compound);

        PlantProfile plantProfile = (PlantProfile) getIntent().getParcelableExtra("parcel_profile");
//        START_TIME_IN_MILLIS = plantProfile.getTime();
        this.startTime = plantProfile.getTime();

        this.plant_nickname.setText(plantProfile.getNickname());
        this.plant_description.setText(plantProfile.getDescription());
        this.species.setText(plantProfile.getSpecies().toString());
        this.time.setText(Integer.toString(plantProfile.getTime()));
        this.avatar.setImageDrawable(getResources().getDrawable(plantProfile.getClipAvatar()));

        mTimeLeftInMillis = plantProfile.getTime();
        startTimer(startTime);
        notificationManager = NotificationManagerCompat.from(this);
    }

    private void startTimer(final long plantWateringTime) {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                sendOnChannel1(findViewById(R.id.plantProfile));
                time.setTextColor(Color.parseColor("#ff0000"));


                //send push alert
                System.out.println("Sending Alert...");


            }
        }.start();

        mTimerRunning = true;


    }

    public void wateredPlant(View view) {
        mCountDownTimer.cancel();
        resetTimer();

        Toast toast = Toast.makeText(getApplicationContext(),
                "Great job watering! You made your plant happy.",
                Toast.LENGTH_SHORT);

        toast.show();
    }

    private void resetTimer() {
        time.setTextColor(Color.parseColor("#ff99cc00"));
        mTimeLeftInMillis = this.startTime;
        updateCountDownText();
        startTimer(mTimeLeftInMillis);

    }

    private void updateCountDownText() {
        int hours = (int) ((mTimeLeftInMillis / (1000 * 60 * 60)) % 24);
        int minutes = (int) (mTimeLeftInMillis / 1000 / 60);
        int seconds = (int) (mTimeLeftInMillis / 1000 % 60);

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d:%02d", hours, minutes, seconds);
        time.setText(timeLeftFormatted);
    }

    public void sendOnChannel1(View v) {
        String title = "Happy Plants - Care Reminder";
        String message = "Times up! It's time to water your " + plant_nickname.getText() + " plant.";

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.bonsai)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManager.notify(1, notification);
        //startTimer(mTimeLeftInMillis);
    }
}
