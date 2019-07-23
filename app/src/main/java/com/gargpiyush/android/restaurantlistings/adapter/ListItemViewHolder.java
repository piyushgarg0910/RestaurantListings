package com.gargpiyush.android.restaurantlistings.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gargpiyush.android.restaurantlistings.R;
import com.gargpiyush.android.restaurantlistings.model.RestaurantResult;
import com.gargpiyush.android.restaurantlistings.view.RestaurantDetailsFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Piyush Garg
 * on 7/22/2019
 * at 09:08.
 */

public class ListItemViewHolder extends RecyclerView.ViewHolder {

    Context context;

    @BindView(R.id.restaurant_logo)
    ImageView image;

    @BindView(R.id.restaurant_name)
    TextView name;

    @BindView(R.id.restaurant_cuisine)
    TextView cuisine;

    @BindView(R.id.restaurant_status)
    TextView status;

    public ListItemViewHolder(View view, Context context, ArrayList<RestaurantResult> restaurants){
        super(view);
        ButterKnife.bind(this,view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("RestaurantId",restaurants.get(getAdapterPosition()).getRestaurantId());
                Fragment fragment = new RestaurantDetailsFragment();
                fragment.setArguments(bundle);
                FragmentTransaction fragmentTransaction = ((FragmentActivity)context)
                        .getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.restaurantListFragment,fragment).addToBackStack("Here");
                fragmentTransaction.commit();
            }
        });
    }
}
