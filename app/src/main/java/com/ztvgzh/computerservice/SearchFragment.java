package com.ztvgzh.computerservice;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.card.MaterialCardView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.ztvgzh.computerservice.Adapter.processorAdapter;
import com.ztvgzh.computerservice.Models.Processor;
import com.ztvgzh.computerservice.Models.Search;
public class SearchFragment extends Fragment {

    RecyclerView rv_result;
    SearchView searchView;
    DatabaseReference reference;
    processorAdapter processorAdapter;
    private static final String SPREAD_SHEET_ID = "1oqZYqFuRNuDjJNuEk7KIhxODG2EBFnfZXjVNa5kCtTA";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_search, container, false);


        rv_result = v.findViewById(R.id.rv_result);
        return v;
    }

}