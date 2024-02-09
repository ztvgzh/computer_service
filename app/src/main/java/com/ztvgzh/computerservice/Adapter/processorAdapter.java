package com.ztvgzh.computerservice.Adapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ztvgzh.computerservice.Models.Cart;
import com.ztvgzh.computerservice.Models.Processor;
import com.ztvgzh.computerservice.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
public class processorAdapter extends RecyclerView.Adapter<processorAdapter.CustomViewHolder> {
    private Context context;
    private List<Processor> processorList;
    private DatabaseReference ref;
    private String uid;



    public processorAdapter(Context context, List<Processor> processorList,String uid){
        this.context = context;
        this.processorList = processorList;
        this.uid = uid;
    }


    @NonNull
    @Override
    public processorAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull processorAdapter.CustomViewHolder holder,  int position) {

        holder.item_name.setText(processorList.get(position).getProcessorNumber());
        Glide.with(context).load(processorList.get(position).getImageUrl()).into(holder.item_image);
        holder.item_description.setText(processorList.get(position).getCores() +
                "/" + processorList.get(position).getThreads());
        holder.item_price.setText(processorList.get(position).getPrice() + " UZS");

        String name = processorList.get(position).getProcessorNumber();
        String description = processorList.get(position).getCores() +
                "/" + processorList.get(position).getThreads();
        String imageUrl = processorList.get(position).getImageUrl();
        int price = processorList.get(position).getPrice();

        holder.addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref = FirebaseDatabase.getInstance().getReference();
                Cart cart = new Cart(name, price, description, imageUrl);
                ref.child("Cart").child(uid).setValue(cart);


            }
        });

    }

    @Override
    public int getItemCount() {
        return processorList.size();
    }


    public class CustomViewHolder extends  RecyclerView.ViewHolder{

        TextView item_name, item_price, item_description;
        ImageView  item_image;
        MaterialButton addToCart;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            item_image = itemView.findViewById(R.id.item_image);
            item_name = itemView.findViewById(R.id.item_name);
            item_description = itemView.findViewById(R.id.item_description);
            item_price = itemView.findViewById(R.id.item_price);

            addToCart = itemView.findViewById(R.id.addToCart);



        }
    }

    public void filterList(ArrayList<Processor> filteredList){
        processorList = filteredList;
        notifyDataSetChanged();
    }


}
