package com.gargpiyush.android.restaurantlistings.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gargpiyush.android.restaurantlistings.R;
import com.gargpiyush.android.restaurantlistings.util.AlertDialogScreen;

/**
 * Created by Piyush Garg
 * on 7/22/2019
 * at 08:31.
 */

public class MainActivity extends AppCompatActivity {

    Fragment fragment = new RestaurantListFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null)
        {
            fragment = (RestaurantListFragment)getSupportFragmentManager().findFragmentByTag("RestaurantListFragment");
        }
        else {
            fragment = new RestaurantListFragment();
        }
        if (!fragment.isInLayout()) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_activity_layout, fragment, "RestaurantListFragment");
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount() == 0)
            new AlertDialogScreen().showAlert(this);
        else
            getSupportFragmentManager().popBackStack();
    }
}
