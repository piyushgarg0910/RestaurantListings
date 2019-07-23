package com.gargpiyush.android.restaurantlistings.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Piyush Garg
 * on 7/22/2019
 * at 14:57.
 */
public class RestaurantAddress {

    @SerializedName("city")
    private String rCity;

    @SerializedName("printable_address")
    private String rAddress;

    @SerializedName("state")
    private String rState;

    @SerializedName("street")
    private String rStreet;

    @SerializedName("country")
    private String rCountry;

    @SerializedName("lat")
    private String rLat;

    @SerializedName("lng")
    private String rLng;

    @SerializedName("zip_code")
    private String rZip;

    public RestaurantAddress(String rCity, String rAddress, String rState, String rStreet,
                             String rCountry, String rLat, String rLng, String rZip) {
        this.rCity = rCity;
        this.rAddress = rAddress;
        this.rState = rState;
        this.rStreet = rStreet;
        this.rCountry = rCountry;
        this.rLat = rLat;
        this.rLng = rLng;
        this.rZip = rZip;
    }

    public String getrCity() {
        return rCity;
    }

    public String getrAddress() {
        return rAddress;
    }

    public String getrState() {
        return rState;
    }

    public String getrStreet() {
        return rStreet;
    }

    public String getrCountry() {
        return rCountry;
    }

    public String getrLat() {
        return rLat;
    }

    public String getrLng() {
        return rLng;
    }

    public String getrZip() {
        return rZip;
    }
}
