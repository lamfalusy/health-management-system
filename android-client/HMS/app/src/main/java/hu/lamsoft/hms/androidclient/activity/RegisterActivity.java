package hu.lamsoft.hms.androidclient.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import hu.lamsoft.hms.androidclient.R;

public class RegisterActivity extends NavigationActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle("Register");
    }
}
