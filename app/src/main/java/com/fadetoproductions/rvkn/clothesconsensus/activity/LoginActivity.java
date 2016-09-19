package com.fadetoproductions.rvkn.clothesconsensus.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.fadetoproductions.rvkn.clothesconsensus.R;
import com.fadetoproductions.rvkn.clothesconsensus.models.User;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        User user = User.getLoggedInUser(this);
        if (user != null) {
            startHomeActivity();
        }

        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnSignInWithTwitter, R.id.btnSignInWithEmail, R.id.btnSignInWithFacebook})
    public void login(View view) {
        Log.v("actions", "Logging in");
        //TODO: Hardcoded user for now. Change to the user which is logged in.
        client.getUser(119);
    }

    @Override
    public void onGetUser(User user) {
        User.setLoggedInUser(this, user);
        startHomeActivity();
    }

    private void startHomeActivity() {
        Intent i = new Intent(this, HomeActivity.class);
        startActivity(i);
    }
}
