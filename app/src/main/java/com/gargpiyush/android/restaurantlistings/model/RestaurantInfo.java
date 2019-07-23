package com.gargpiyush.android.restaurantlistings.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Piyush Garg
 * on 7/22/2019
 * at 14:47.
 */
public class RestaurantInfo {

    @SerializedName("phone_number")
    private String phoneNumber;

    @SerializedName("tags")
    private ArrayList<String> mTags;

    @SerializedName("description")
    private String mDescription;

    @SerializedName("name")
    private String mName;

    @SerializedName("average_rating")
    private Double averageRating;

    @SerializedName("address")
    private RestaurantAddress address;

    @SerializedName("cover_img_url")
    private String url;

    public RestaurantInfo(String phoneNumber, ArrayList<String> mTags, String mDescription,
                          String mName, Double averageRating, RestaurantAddress address,
                          String url) {
        this.phoneNumber = phoneNumber;
        this.mTags = mTags;
        this.mDescription = mDescription;
        this.mName = mName;
        this.averageRating = averageRating;
        this.address = address;
        this.url = url;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ArrayList<String> getmTags() {
        return mTags;
    }

    public String getmDescription() {
        return mDescription;
    }

    public String getmName() {
        return mName;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public RestaurantAddress getAddress() {
        return address;
    }

    public String getUrl() {
        return url;
    }
}
