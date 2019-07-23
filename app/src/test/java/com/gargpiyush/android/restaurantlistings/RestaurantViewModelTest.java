package com.gargpiyush.android.restaurantlistings;

import android.arch.lifecycle.MutableLiveData;

import com.gargpiyush.android.restaurantlistings.adapter.ListAdapter;
import com.gargpiyush.android.restaurantlistings.model.RestaurantInfo;
import com.gargpiyush.android.restaurantlistings.model.RestaurantResult;
import com.gargpiyush.android.restaurantlistings.repository.RestaurantRepo;
import com.gargpiyush.android.restaurantlistings.view.RestaurantDetailsFragment;
import com.gargpiyush.android.restaurantlistings.viewModel.RestaurantViewModel;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

import java.util.ArrayList;


/**
 * Created by Piyush Garg
 * on 7/22/2019
 * at 18:02.
 */

public class RestaurantViewModelTest {

    @Mock
    private RestaurantRepo restaurantRepo;

    @Mock
    private ListAdapter listAdapter;

    @Mock
    private RestaurantDetailsFragment restaurantDetailsFragment;

    private RestaurantViewModel restaurantViewModel;
    private ArrayList<RestaurantResult> searchResults = new ArrayList<>();
    private RestaurantInfo restaurantInfo;

    @Mock
    private MutableLiveData<ArrayList<RestaurantResult>> restaurantLiveData
            = new MutableLiveData<>();

    @Mock
    private MutableLiveData<RestaurantInfo> restaurantInfoMutableLiveData = new MutableLiveData<>();

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);

        restaurantViewModel = Mockito.spy(new RestaurantViewModel(restaurantRepo));

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
    public void test_getRestaurantResultDataObservable(){
        String lat = "37.422740";
        String lng = "-122.139956";
        String offset = "0";
        String limit = "20";
        restaurantViewModel.getRestaurantResultDataObservable();
        Mockito.verify(restaurantRepo, Mockito.times(1))
                .getRestaurantList(lat, lng, offset, limit);
    }

    @Test
    public void test_getRestaurantInfo_NoQuery(){
        String query = null;
        restaurantViewModel.getRestaurantInfo(query);
        Mockito.verify(restaurantRepo,Mockito.never()).getRestaurantInfo(query);
    }

    @Test
    public void test_getRestaurantInfo(){
        String query = "30";
        restaurantViewModel.getRestaurantInfo(query);
        Mockito.verify(restaurantRepo,Mockito.times(1))
                .getRestaurantInfo(query);
    }

    @Test
    public void test_handleRestaurantListResponse_Success() {
        restaurantLiveData.setValue(searchResults);
        Mockito.doReturn(restaurantLiveData).when(restaurantViewModel)
                .getRestaurantResultDataObservable();
        restaurantLiveData.postValue(searchResults);
        restaurantViewModel.getRestaurantResultDataObservable();
        assertEquals(searchResults,restaurantLiveData.getValue());
    }

    @Test
    public void test_handleRestaurantDetails_success(){
        restaurantInfoMutableLiveData.setValue(restaurantInfo);
        Mockito.doReturn(restaurantInfoMutableLiveData).when(restaurantViewModel)
                .getRestaurantInfo("30");
        restaurantViewModel.getRestaurantInfo("30");
        assertEquals(restaurantInfo,restaurantInfoMutableLiveData.getValue());
    }
}
