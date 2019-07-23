package com.gargpiyush.android.restaurantlistings;

import com.gargpiyush.android.restaurantlistings.repository.RestaurantRepo;
import com.gargpiyush.android.restaurantlistings.viewModel.RestaurantViewModel;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Created by Piyush Garg
 * on 7/22/2019
 * at 18:02.
 */

public class RestaurantViewModelTest {

    @Mock
    private RestaurantRepo restaurantRepo;

    private RestaurantViewModel restaurantViewModel;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        restaurantViewModel = Mockito.spy(new RestaurantViewModel(restaurantRepo));
    }

    @Test
    public void test_getRestaurantResultDataObservable_default(){
        String lat = "37.422740";
        String lng = "-122.139956";
        String offset = "0";
        String limit = "20";
        restaurantViewModel.getRestaurantResultDataObservable();
        Mockito.verify(restaurantRepo, Mockito.times(1))
                .getRestaurantList(lat, lng, offset, limit);
    }

    @Test
    public void test_getRestaurantResultDataObservable_parametrized(){
        String lat = "37.422740";
        String lng = "-122.139956";
        String offset = "0";
        String limit = "20";
        restaurantViewModel.getRestaurantResultDataObservable(limit);
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
}
