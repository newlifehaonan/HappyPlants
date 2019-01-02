package afinal.csc472.depaul.edu.houseplants;

import android.app.Activity;
import android.view.View;

public class Listener_Twitter_SignIn implements View.OnClickListener{
    private db db;
    private Activity activity;

    public Listener_Twitter_SignIn(db db, Activity activity) {
        this.db = db;
        this.activity = activity;
    }
    @Override
    public void onClick(View v) {

    }
}
