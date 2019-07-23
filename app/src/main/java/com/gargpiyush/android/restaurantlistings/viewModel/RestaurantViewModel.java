package com.gargpiyush.android.restaurantlistings.viewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.gargpiyush.android.restaurantlistings.model.RestaurantInfo;
import com.gargpiyush.android.restaurantlistings.model.RestaurantResult;
import com.gargpiyush.android.restaurantlistings.repository.RestaurantRepo;

import java.util.ArrayList;

/**
 * Created by Piyush Garg
 * on 7/22/2019
 * at 09:13.
 */

public class RestaurantViewModel extends ViewModel {

    private RestaurantRepo restaurantRepo;

    public RestaurantViewModel(RestaurantRepo restaurantRepo){
        this.restaurantRepo = restaurantRepo;
    }

    public LiveData<ArrayList<RestaurantResult>> getRestaurantResultDataObservable() {
        return restaurantRepo.getRestaurantList("37.422740","-122.139956","0","20");
    }

    public LiveData<ArrayList<RestaurantResult>> getRestaurantResultDataObservable(String limit) {
        return restaurantRepo.getRestaurantList("37.422740","-122.139956","0",limit);
    }

    public LiveData<RestaurantInfo> getRestaurantInfo(String id){
        if (id != null)
            return restaurantRepo.getRestaurantInfo(id);
        else
            return null;
    }
}
