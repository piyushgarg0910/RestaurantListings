package com.gargpiyush.android.restaurantlistings.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.gargpiyush.android.restaurantlistings.model.RestaurantInfo;
import com.gargpiyush.android.restaurantlistings.model.RestaurantResult;
import com.gargpiyush.android.restaurantlistings.network.RestaurantApi;
import com.gargpiyush.android.restaurantlistings.network.RestaurantResposne;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Piyush Garg
 * on 7/22/2019
 * at 11:19.
 */

public class RestaurantRepo {

    private RestaurantResposne restaurantResposne = RestaurantApi.getRetrofitInstance()
            .create(RestaurantResposne.class);;

    public LiveData<ArrayList<RestaurantResult>> getRestaurantList(String lat, String lng,
                                                                   String offset, String limit){
        final MutableLiveData<ArrayList<RestaurantResult>> restaurantResponseLiveData
                = new MutableLiveData<>();

        restaurantResposne.getRestaurants(lat,lng,offset,limit).enqueue(
                new Callback<ArrayList<RestaurantResult>>() {
            @Override
            public void onResponse(Call<ArrayList<RestaurantResult>> call,
                                   Response<ArrayList<RestaurantResult>> response) {
                restaurantResponseLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<RestaurantResult>> call, Throwable t) {

            }
        });

        return restaurantResponseLiveData;
    }

    public LiveData<RestaurantInfo> getRestaurantInfo(String id){

        final MutableLiveData<RestaurantInfo> restaurantInfoLiveData = new MutableLiveData<>();

        restaurantResposne.getRestaurant(id).enqueue(new Callback<RestaurantInfo>() {
            @Override
            public void onResponse(Call<RestaurantInfo> call, Response<RestaurantInfo> response) {
                restaurantInfoLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<RestaurantInfo> call, Throwable t) {

            }
        });
        return  restaurantInfoLiveData;
    }
}
