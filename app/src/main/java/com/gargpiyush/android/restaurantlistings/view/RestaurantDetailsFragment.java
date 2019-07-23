package com.gargpiyush.android.restaurantlistings.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gargpiyush.android.restaurantlistings.R;
import com.gargpiyush.android.restaurantlistings.model.RestaurantInfo;
import com.gargpiyush.android.restaurantlistings.repository.RestaurantRepo;
import com.gargpiyush.android.restaurantlistings.viewModel.RestaurantViewModel;
import com.gargpiyush.android.restaurantlistings.viewModel.RestaurantViewModelFactory;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Piyush Garg
 * on 7/22/2019
 * at 14:39.
 */
public class RestaurantDetailsFragment extends Fragment {

    @BindView(R.id.res_logo)
    ImageView imageView;

    @BindView(R.id.res_name)
    TextView resName;

    @BindView(R.id.res_des)
    TextView resDes;

    @BindView(R.id.res_ratings)
    TextView resRatings;

    @BindView(R.id.res_tags)
    TextView resTags;

    @BindView(R.id.res_address)
    TextView resAddress;

    @BindView(R.id.res_phone)
    TextView resPhone;

    private RestaurantViewModel restaurantViewModel;
    String id;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.restaurant_details,container,false);
        ButterKnife.bind(this,view);
        Bundle bundle = getArguments();
        id = bundle.getString("RestaurantId");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RestaurantViewModelFactory restaurantViewModelFactory = new RestaurantViewModelFactory(new RestaurantRepo());
        restaurantViewModel = ViewModelProviders.of(this,restaurantViewModelFactory).get(RestaurantViewModel.class);
        restaurantViewModel.getRestaurantInfo(id).observe(this, new Observer<RestaurantInfo>() {
            @Override
            public void onChanged(@Nullable RestaurantInfo restaurantInfo) {
                if(restaurantInfo != null){
                    updateUI(restaurantInfo);
                }
            }
        });
    }

    public void updateUI(RestaurantInfo restaurantInfo){
        resName.setText(restaurantInfo.getmName());
        String add = getResources().getString(R.string.address) + ": "
                + restaurantInfo.getAddress().getrAddress();
        resAddress.setText(add);
        String contact = getResources().getString(R.string.phone_number) + ": "
                + restaurantInfo.getPhoneNumber();
        resPhone.setText(contact);
        String ratings = getResources().getString(R.string.ratings) + ": "
                + restaurantInfo.getAverageRating();
        resRatings.setText(ratings);
        String description = getResources().getString(R.string.cuisine) + ": "
                + restaurantInfo.getmDescription();
        resDes.setText(description);
        StringBuffer tags = new StringBuffer();
        for (String tag : restaurantInfo.getmTags()){
            tags.append(tag);
            tags.append(", ");
        }
        tags.deleteCharAt(tags.length()-1);
        String type = getResources().getString(R.string.tags) + ": "
                + tags.toString();
        resTags.setText(type);
        Picasso.with(getContext()).load(restaurantInfo.getUrl())
                .placeholder(R.drawable.ic_android)
                .error(R.drawable.ic_android)
                .into(imageView);
    }
}
