package afinal.csc472.depaul.edu.houseplants;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public class Listener_Create_Account implements View.OnClickListener {

    private db db;
    private Activity activity;

    public Listener_Create_Account(db db, Activity activity) {
        this.db = db;
        this.activity = activity;
    }

    @Override
    public void onClick(View v)
    {
        EditText email_address = this.activity.findViewById(R.id.email);
        EditText password = this.activity.findViewById(R.id.password);
        String email_string = email_address.getText().toString();
        String password_string = password.getText().toString();

        if(!email_string.equals("") && !password_string.equals("")) {
            db.getmAuth().createUserWithEmailAndPassword(email_string, password_string).addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(activity,"Account created", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(activity,"Fail to create", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

}
