package com.gargpiyush.android.restaurantlistings.viewModel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.gargpiyush.android.restaurantlistings.repository.RestaurantRepo;

/**
 * Created by Piyush Garg
 * on 7/22/2019
 * at 19:45.
 */
public class RestaurantViewModelFactory implements ViewModelProvider.Factory {

    private RestaurantRepo restaurantRepo;

    public RestaurantViewModelFactory(RestaurantRepo restaurantRepo){
        this.restaurantRepo = restaurantRepo;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new RestaurantViewModel(restaurantRepo);
    }
}
