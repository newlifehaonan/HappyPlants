package afinal.csc472.depaul.edu.houseplants;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity {
    //  get ui elements
    private ImageView signin_google;
    private ImageView signin_facebook;
    private ImageView signin_twitter;
    private Button createAccount;
    private Button signin;
    private db db;

    //    Life Cycle hook
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(!isNetworkAvailable()) {
            Toast.makeText(this,"No network connection.", Toast.LENGTH_LONG).show();
            navigateToHome();
        }
        else {
            Toast.makeText(this,"Network connected.", Toast.LENGTH_LONG).show();

        }

        createAccount = findViewById(R.id.create_account_button);
        signin = findViewById(R.id.SignIn);

        signin_google = findViewById(R.id.logo_google);
        signin_facebook = findViewById(R.id.logo_facebook);
        signin_twitter = findViewById(R.id.logo_twitter);

//      init the db service
        db = new db(this);
        SharedData.getSharedData().setDb(this.db);

//      set up listener
        createAccount.setOnClickListener(
                new Listener_Create_Account(db, this)
        );

        signin_google.setOnClickListener(
                new Listener_Google_SignIn(db, this)
        );

        signin_facebook.setOnClickListener(
                new Listener_Facebook_SignIn(db, this)
        );

        signin_twitter.setOnClickListener(
                new Listener_Twitter_SignIn(db,this)
        );

        signin.setOnClickListener(
                new Listener_Email_SignIn(db, this)
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == db.getRcSignIn()) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
            navigateToWelcome();
            Toast.makeText(this,"Sign in with google successful", Toast.LENGTH_LONG).show();
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Toast.makeText(this,"Invalid google account!", Toast.LENGTH_LONG).show();
        }
    }

    private void navigateToWelcome(){
        Intent intent = new Intent(this, WelcomeActivity.class);
        this.startActivity(intent);
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void navigateToHome() {
        Intent intent = new Intent(this, HomeActivity.class);
        this.startActivity(intent);
    }
}