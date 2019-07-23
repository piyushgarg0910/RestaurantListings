package com.gargpiyush.android.restaurantlistings.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gargpiyush.android.restaurantlistings.R;
import com.gargpiyush.android.restaurantlistings.adapter.ListAdapter;
import com.gargpiyush.android.restaurantlistings.model.RestaurantResult;
import com.gargpiyush.android.restaurantlistings.repository.RestaurantRepo;
import com.gargpiyush.android.restaurantlistings.viewModel.RestaurantViewModel;
import com.gargpiyush.android.restaurantlistings.viewModel.RestaurantViewModelFactory;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Piyush Garg
 * on 7/22/2019
 * at 08:47.
 */

public class RestaurantListFragment extends Fragment {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
    ListAdapter listAdapter = new ListAdapter();
    private RestaurantViewModel restaurantViewModel;
    ArrayList<RestaurantResult> Restaurants = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment,container,false);
        ButterKnife.bind(this,view);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite,null));
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.toolbar_title);
        if (savedInstanceState != null)
            Restaurants = (ArrayList<RestaurantResult>) savedInstanceState.getSerializable("restaurant");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(listAdapter);
        if (Restaurants.size() == 0) {
            RestaurantViewModelFactory restaurantViewModelFactory = new RestaurantViewModelFactory(new RestaurantRepo());
            restaurantViewModel = ViewModelProviders.of(this,restaurantViewModelFactory).get(RestaurantViewModel.class);
            restaurantViewModel.getRestaurantResultDataObservable().observe(this,
                    new Observer<ArrayList<RestaurantResult>>() {
                        @Override
                        public void onChanged(@Nullable ArrayList<RestaurantResult> restaurantResults) {
                            Restaurants = restaurantResults;
                            listAdapter.setRestaurantResults(Restaurants);
                            listAdapter.notifyDataSetChanged();
                        }
                    });
        }
        else{
            listAdapter.setRestaurantResults(Restaurants);
            listAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("restaurant",Restaurants);
    }
}
