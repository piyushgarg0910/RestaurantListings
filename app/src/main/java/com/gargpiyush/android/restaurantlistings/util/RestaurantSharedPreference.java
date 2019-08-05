package com.gargpiyush.android.restaurantlistings.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.gargpiyush.android.restaurantlistings.model.RestaurantInfo;
import com.gargpiyush.android.restaurantlistings.model.RestaurantResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Piyush Garg
 * on 8/5/2019
 * at 08:23.
 */
public class RestaurantSharedPreference {

    SharedPreferences preferences;
    Context context;

    public static SharedPreferences getSharedPrefs(Context context){
        return context.getSharedPreferences("prefs",Context.MODE_PRIVATE);
    }

    public static void add(Context context, Set<String> set){
        SharedPreferences.Editor editor = getSharedPrefs(context).edit();
        editor.putStringSet("favRestaurants",set);
        editor.apply();
    }

    public static Set<String> getData(Context context){
        return getSharedPrefs(context)
                .getStringSet("favRestaurants", new HashSet<>());
    }
}
