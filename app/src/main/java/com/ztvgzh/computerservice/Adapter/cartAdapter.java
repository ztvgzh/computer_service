package com.ztvgzh.computerservice.Adapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ztvgzh.computerservice.Models.Cart;
import com.ztvgzh.computerservice.Models.Processor;
import com.ztvgzh.computerservice.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class cartAdapter extends FirebaseRecyclerAdapter<Cart, cartAdapter.CustomViewHolder> {

    Context context;

    public cartAdapter(@NonNull FirebaseRecyclerOptions<Cart> options) {

        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull cartAdapter.CustomViewHolder holder, int position, @NonNull Cart model) {

        holder.cart_name.setText(model.getProductName());
        holder.cart_price.setText(model.getPrice() + "UZS");
        holder.cart_description.setText(model.getDescription());
       // Glide.with(holder.cart_image.getContext()).load(model.getImageUrl()).into(holder.cart_image);

    }

    @NonNull
    @Override
    public cartAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);

        return new CustomViewHolder(view);
    }

     class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView cart_name, cart_description, cart_price;
        ImageView cart_image;
        MaterialCardView cd_item;

         public CustomViewHolder(@NonNull View itemView) {
             super(itemView);

             cart_image = itemView.findViewById(R.id.item_image);
             cart_name = itemView.findViewById(R.id.item_name);
             cart_description = itemView.findViewById(R.id.item_description);
             cart_price = itemView.findViewById(R.id.item_price);
             cd_item = itemView.findViewById(R.id.cd_item);
         }
     }
}





