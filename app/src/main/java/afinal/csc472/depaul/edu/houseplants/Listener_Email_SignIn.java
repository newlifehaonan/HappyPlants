package afinal.csc472.depaul.edu.houseplants;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public class Listener_Email_SignIn implements View.OnClickListener{
    private db db;
    private Activity activity;

    public Listener_Email_SignIn(db db, Activity activity) {
        this.db = db;
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        EditText email_address = this.activity.findViewById(R.id.email);
        EditText password = this.activity.findViewById(R.id.password);
        String email_string = email_address.getText().toString();
        String password_string = password.getText().toString();

        this.db.getmAuth()
                 .signInWithEmailAndPassword(email_string, password_string)
                 .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>(){
                     @Override
                     public void onComplete(@NonNull Task<AuthResult> task) {
                         if (task.isSuccessful()) {
                             // Sign in success, update UI with the signed-in user's information
                              Toast.makeText(activity,"signInWithEmail:successful", Toast.LENGTH_LONG).show();
                              // check whether user has flower in its garden
                              // IF not
                              // routing to Question1
                             navigateToWelcome();
                         } else {
                             // If sign in fails, display a message to the user.
                              Toast.makeText(activity,"signInWithEmail:failure", Toast.LENGTH_LONG).show();
                         }
                     }
                 });
    }

    private void navigateToWelcome(){
        Intent intent = new Intent(activity, WelcomeActivity.class);
        this.activity.startActivity(intent);
    }
}
