package com.fadetoproductions.rvkn.clothesconsensus.activity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TimePicker;

import com.fadetoproductions.rvkn.clothesconsensus.R;
import com.fadetoproductions.rvkn.clothesconsensus.databinding.ActivityHomeBinding;
import com.fadetoproductions.rvkn.clothesconsensus.databinding.ToolbarBinding;
import com.fadetoproductions.rvkn.clothesconsensus.fragments.AllLooksFragment;
import com.fadetoproductions.rvkn.clothesconsensus.models.User;

import org.parceler.Parcels;

public class HomeActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener{

    ActivityHomeBinding activityHomeBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHomeBinding = DataBindingUtil.setContentView(this,R.layout.activity_home);
        ToolbarBinding toolbarBinding = DataBindingUtil.inflate(getLayoutInflater(),R.layout.toolbar,null,false);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbarBinding.llToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        //Network call here to fetch the looks.
        //Make the model
        //
        if(savedInstanceState == null)
            showAllLooksFragment();

    }

    private void showAllLooksFragment() {
        AllLooksFragment looksFragment = AllLooksFragment.newInstance();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(activityHomeBinding.flContainer.getId(), looksFragment);
        ft.commit();
    }
    @Override
    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
        // Do something with the tvTime here.

    }
    public void onProfileView(MenuItem item) {
        Intent profileIntent = new Intent(this, ProfileActivity.class);
        // TODO get current user by api calls.
        User user = null;
        profileIntent.putExtra("user_id", Parcels.wrap(user));
        startActivity(profileIntent);
    }
}
