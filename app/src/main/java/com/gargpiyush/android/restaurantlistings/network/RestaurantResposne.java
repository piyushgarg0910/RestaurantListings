package com.gargpiyush.android.restaurantlistings.network;

import android.provider.ContactsContract;

import com.gargpiyush.android.restaurantlistings.model.RestaurantInfo;
import com.gargpiyush.android.restaurantlistings.model.RestaurantResult;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Piyush Garg
 * on 7/22/2019
 * at 11:04.
 */
public interface RestaurantResposne {

    @GET("v2/restaurant/")
    Call<ArrayList<RestaurantResult>> getRestaurants(@Query("lat") String lat,
                                                     @Query("lng") String lng,
                                                     @Query("offset") String offset,
                                                     @Query("limit") String limit);

    @GET("v2/restaurant/{restaurant_id}")
    Call<RestaurantInfo> getRestaurant(@Path("restaurant_id") String restaurantId);
}
