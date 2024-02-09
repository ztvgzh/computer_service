package com.ztvgzh.computerservice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ztvgzh.computerservice.Adapter.processorAdapter;
import com.ztvgzh.computerservice.Models.Processor;

import java.util.ArrayList;

public class ProductsActivity extends AppCompatActivity implements TextWatcher {
    RecyclerView rv_products;
    DatabaseReference ref;
    processorAdapter processorAdapter;
    GridLayoutManager gridLayoutManager;
    ArrayList<Processor> prList = new ArrayList<>();
    FirebaseUser user;
    FirebaseAuth auth;
    String uid;
    EditText ed_search;
    private static final String SPREAD_SHEET_ID = "1oqZYqFuRNuDjJNuEk7KIhxODG2EBFnfZXjVNa5kCtTA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();


        uid = user.getUid();




        ed_search = findViewById(R.id.ed_search);
        ed_search.addTextChangedListener(this);

        rv_products = findViewById(R.id.rv_processors);

        rv_products.setHasFixedSize(true);
        rv_products.setLayoutManager(new LinearLayoutManager(this));
        getListOfProducts();
    }


    private void getListOfProducts() {
        ref = FirebaseDatabase.getInstance().getReference().child(SPREAD_SHEET_ID).child("processor");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot snapshot1: snapshot.getChildren()){

                    String name = snapshot1.child("processorNumber").getValue().toString();
                    String imageUrl = snapshot1.child("imageUrl").getValue().toString();
                    int cores = Integer.valueOf(snapshot1.child("cores").getValue().toString());
                    int threads = Integer.valueOf(snapshot1.child("threads").getValue().toString());
                    int price = Integer.valueOf(snapshot1.child("price").getValue().toString());
                    prList.add(new Processor(name, imageUrl, cores, threads, price));

                }

                processorAdapter = new processorAdapter(ProductsActivity.this, prList, uid);
                rv_products.setAdapter(processorAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });





    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

        filter(editable.toString());

    }

    private void filter(String textSearch) {
        ArrayList<Processor> filteredList = new ArrayList<>();

        for(Processor item: prList){
            if(item.getProcessorNumber().toLowerCase().contains(textSearch.toLowerCase())){
                filteredList.add(item);
            }
        }

        if(processorAdapter != null){
            processorAdapter.filterList(filteredList);
        }
    }
}