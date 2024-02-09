package com.ztvgzh.computerservice;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ztvgzh.computerservice.Adapter.cartAdapter;
import com.ztvgzh.computerservice.Models.Cart;
import java.util.ArrayList;
public class CartFragment extends Fragment {
    private DatabaseReference ref;
    cartAdapter cartAdapter;
    ArrayList<Cart> cartList = new ArrayList<>();
    RecyclerView rv_cart;
    FirebaseUser user;
    FirebaseAuth auth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_cart, container, false);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        rv_cart = v.findViewById(R.id.rv_cart);
        rv_cart.setHasFixedSize(true);
        rv_cart.setLayoutManager(new LinearLayoutManager(getContext()));

        getDataFromFirebase();
        return v;
    }

    private void getDataFromFirebase() {
        ref = FirebaseDatabase.getInstance().getReference().child("Cart");

        FirebaseRecyclerOptions<Cart> options = new FirebaseRecyclerOptions.Builder<Cart>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Cart"), Cart.class)
                .build();
        cartAdapter = new cartAdapter(options);
        rv_cart.setAdapter(cartAdapter);
        cartAdapter.startListening();
    }

    @Override
    public void onStart() {
        super.onStart();
        cartAdapter.startListening();
    }
}