package com.gargpiyush.android.restaurantlistings.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gargpiyush.android.restaurantlistings.R;
import com.gargpiyush.android.restaurantlistings.model.RestaurantResult;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Piyush Garg
 * on 7/22/2019
 * at 09:06.
 */
public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<RestaurantResult> restaurantResults = new ArrayList<>();
    private Context context;

    public void setRestaurantResults(ArrayList<RestaurantResult> restaurantResults ){
        this.restaurantResults = restaurantResults;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_layout,
            parent, false);
        context = parent.getContext();
        return new ListItemViewHolder(view,context,restaurantResults);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        String title = restaurantResults.get(position).getRestaurantName();
        String description = restaurantResults.get(position).getRestaurantDescription();
        String status = restaurantResults.get(position).getRestaurantStatus();
        String image_url = restaurantResults.get(position).getRestaurantCoverImage();
        ((ListItemViewHolder)viewHolder).name.setText(title);
        ((ListItemViewHolder)viewHolder).cuisine.setText(description);
        if (status.equals("Pre-order for Pre-order")){
            ((ListItemViewHolder)viewHolder).status.setText(context.getText(R.string.pre_order_text));
        }
        else {
            ((ListItemViewHolder)viewHolder).status.setText(status);
        }
        Picasso.with(context).load(image_url)
                .placeholder(R.drawable.ic_android)
                .error(R.drawable.ic_android)
                .into(((ListItemViewHolder)viewHolder).image);
    }

    @Override
    public int getItemCount() {
        if (restaurantResults == null)
            return 0;
        else
            return restaurantResults.size();
    }
}
