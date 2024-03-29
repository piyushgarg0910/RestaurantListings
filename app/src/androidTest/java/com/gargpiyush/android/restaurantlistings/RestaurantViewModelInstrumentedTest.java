package com.gargpiyush.android.restaurantlistings;

import android.arch.lifecycle.MutableLiveData;

import com.gargpiyush.android.restaurantlistings.model.RestaurantInfo;
import com.gargpiyush.android.restaurantlistings.model.RestaurantResult;
import com.gargpiyush.android.restaurantlistings.repository.RestaurantRepo;
import com.gargpiyush.android.restaurantlistings.viewModel.RestaurantViewModel;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Piyush Garg
 * on 7/23/2019
 * at 07:32.
 */

public class RestaurantViewModelInstrumentedTest {


    private RestaurantRepo restaurantRepo = new RestaurantRepo();

    private RestaurantViewModel restaurantViewModel = new RestaurantViewModel(restaurantRepo);
    private ArrayList<RestaurantResult> searchResults = new ArrayList<>();
    private RestaurantInfo restaurantInfo;

    private MutableLiveData<ArrayList<RestaurantResult>> restaurantLiveData
            = new MutableLiveData<>();

    private MutableLiveData<RestaurantInfo> restaurantInfoMutableLiveData = new MutableLiveData<>();

    @Before
    public void setUp() {

        searchResults.add(new RestaurantResult("10","ABC",
                "Lunch","url", "closed",
                "0.0"));
        searchResults.add(new RestaurantResult("20","EFG",
                "Snacks","url1", "25 mins",
                "0.0"));
        searchResults.add(new RestaurantResult("10","ABC",
                "Dinner","url2",
                "Pre-order for Pre-order", "0.0"));
        restaurantInfo = new RestaurantInfo("+19876543210",
                null,"food", "ABC", 4.5,
                null, "url");
    }

    @Test
    public void test_handleRestaurantListResponse_failure(){
        restaurantViewModel.getRestaurantResultDataObservable();
        assertNotEquals(searchResults,restaurantLiveData.getValue());
    }

    @Test
    public void test_handleRestaurantListResponse_success() {
        restaurantLiveData.postValue(searchResults);
        restaurantViewModel.getRestaurantResultDataObservable();
        assertEquals(searchResults,restaurantLiveData.getValue());
    }

    @Test
    public void test_handleRestaurantListResponse_data(){
        restaurantLiveData.postValue(searchResults);
        restaurantViewModel.getRestaurantResultDataObservable();
        assertEquals(restaurantLiveData.getValue().get(0).getRestaurantName(),"ABC");
    }

    @Test
    public void test_handleRestaurantDetails_failure(){
        restaurantViewModel.getRestaurantInfo("30");
        assertNotEquals(restaurantInfo,restaurantInfoMutableLiveData.getValue());
    }

    @Test
    public void test_handleRestaurantDetails_success(){
        restaurantInfoMutableLiveData.postValue(restaurantInfo);
        restaurantViewModel.getRestaurantInfo("30");
        assertEquals(restaurantInfo,restaurantInfoMutableLiveData.getValue());
    }
}
