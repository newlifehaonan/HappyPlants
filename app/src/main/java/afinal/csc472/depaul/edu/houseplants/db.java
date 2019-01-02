package afinal.csc472.depaul.edu.houseplants;

import android.app.Activity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class db {

    private FirebaseDatabase db;
    private FirebaseAuth mAuth;
    //  google signin
    private GoogleSignInOptions gso;
    private GoogleSignInClient mGoogleSignInClient;
    private static final int RC_SIGN_IN = 9001;

    public db(Activity activity) {
        mAuth = FirebaseAuth.getInstance();
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        mGoogleSignInClient = GoogleSignIn.getClient(activity, gso);
        db = FirebaseDatabase.getInstance();
    }

    public FirebaseDatabase getDb() {
        return db;
    }

    public FirebaseAuth getmAuth() {
        return mAuth;
    }

    public GoogleSignInOptions getGso() {
        return gso;
    }

    public GoogleSignInClient getmGoogleSignInClient() {
        return mGoogleSignInClient;
    }

    public void addSelectedToGarden(PlantProfile userChoice){
        String key = this.db.getReference().push().getKey();
        String uID = mAuth.getCurrentUser().getUid();
        this.db.getReference().child(uID).child("Garden").child(key).setValue(userChoice);
    }

    public void addSelectedToExplore(PlantProfile userChoice){
        String key = this.db.getReference().push().getKey();
        String uID = mAuth.getCurrentUser().getUid();
        this.db.getReference().child(uID).child("Explore").child(key).setValue(userChoice);
    }

    public static int getRcSignIn() {
        return RC_SIGN_IN;
    }

}
