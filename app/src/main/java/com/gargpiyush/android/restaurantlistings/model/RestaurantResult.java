package com.gargpiyush.android.restaurantlistings.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Piyush Garg
 * on 7/22/2019
 * at 10:47.
 */
public class RestaurantResult {

    @SerializedName("id")
    private String restaurantId;

    @SerializedName("name")
    private String restaurantName;

    @SerializedName("description")
    private String restaurantDescription;

    @SerializedName("cover_img_url")
    private String restaurantCoverImage;

    @SerializedName("status")
    private String restaurantStatus;

    @SerializedName("delivery_fee")
    private String restaurantDeliveryFee;

    public RestaurantResult(String restaurantId, String restaurantName,
                            String restaurantDescription, String restaurantCoverImage,
                            String restaurantStatus, String restaurantDeliveryFee) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.restaurantDescription = restaurantDescription;
        this.restaurantCoverImage = restaurantCoverImage;
        this.restaurantStatus = restaurantStatus;
        this.restaurantDeliveryFee = restaurantDeliveryFee;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getRestaurantDescription() {
        return restaurantDescription;
    }

    public String getRestaurantCoverImage() {
        return restaurantCoverImage;
    }

    public String getRestaurantStatus() {
        return restaurantStatus;
    }

    public String getRestaurantDeliveryFee() {
        return restaurantDeliveryFee;
    }
}
