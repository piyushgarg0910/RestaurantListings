package com.gargpiyush.android.restaurantlistings.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Piyush Garg
 * on 7/22/2019
 * at 11:00.
 */
public class RestaurantApi {

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://api.doordash.com/";

    public static Retrofit getRetrofitInstance(){
        if(retrofit == null){
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
