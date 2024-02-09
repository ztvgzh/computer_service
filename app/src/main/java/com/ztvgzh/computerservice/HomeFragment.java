package com.ztvgzh.computerservice;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.card.MaterialCardView;
public class HomeFragment extends Fragment {

    MaterialCardView cd1, cd2, cd3, cd4, cd5, cd6, cd7, cd8, cd9, cd10, cd11, cd12;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);

        cd1 = v.findViewById(R.id.categoryCPU);
        cd2 = v.findViewById(R.id.categoryMotherboard);
        cd3 = v.findViewById(R.id.categoryRam);
        cd4 = v.findViewById(R.id.categoryVideoCard);
        cd5 = v.findViewById(R.id.categoryFive);
        cd6 = v.findViewById(R.id.categorySix);
        cd7 = v.findViewById(R.id.categorySeven);
        cd8 = v.findViewById(R.id.categoryEight);
        cd9 = v.findViewById(R.id.categoryNine);
        cd10 = v.findViewById(R.id.categoryTen);
        cd11 = v.findViewById(R.id.categoryEleven);
        cd12 = v.findViewById(R.id.categoryTwelve);


        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.categoryCPU:
                        Context context = view.getContext();
                        startActivity(new Intent(context, ProductsActivity.class));
                        break;
                    case R.id.categoryMotherboard:

                        break;
                    case R.id.categoryRam:

                        break;
                    case R.id.categoryVideoCard:

                        break;
                    case R.id.categoryFive:

                        break;
                    case R.id.categorySix:

                        break;
                    case R.id.categorySeven:

                        break;
                    case R.id.categoryEight:

                        break;
                    case R.id.categoryNine:

                        break;
                    case R.id.categoryTen:

                        break;
                    case R.id.categoryEleven:

                        break;
                    case R.id.categoryTwelve:

                        break;

                }
            }
        };

        cd1.setOnClickListener(onClickListener);
        cd2.setOnClickListener(onClickListener);
        cd3.setOnClickListener(onClickListener);
        cd4.setOnClickListener(onClickListener);
        cd5.setOnClickListener(onClickListener);
        cd6.setOnClickListener(onClickListener);
        cd7.setOnClickListener(onClickListener);
        cd8.setOnClickListener(onClickListener);
        cd9.setOnClickListener(onClickListener);
        cd10.setOnClickListener(onClickListener);
        cd11.setOnClickListener(onClickListener);
        cd12.setOnClickListener(onClickListener);
        return v;
    }
}