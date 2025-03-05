package com.megha.myfoodapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.megha.myfoodapp.R;
import com.megha.myfoodapp.adapters.FeaturedAdapter;
import com.megha.myfoodapp.adapters.FeaturedVerAdapter;
import com.megha.myfoodapp.models.FeaturedModel;
import com.megha.myfoodapp.models.FeaturedVerModels;

import java.util.ArrayList;
import java.util.List;


public class FirstFragment extends Fragment {

    ///////////////featured hor recyclerview
    List<FeaturedModel> featuredModels;
    RecyclerView recyclerView;
    FeaturedAdapter featuredAdapter;

    ///////////////featured ver recyclerview
    List<FeaturedVerModels> featuredVerModels;
    RecyclerView recyclerView2;
    FeaturedVerAdapter featuredVerAdapter;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_first, container, false);

        ///////////////featured hor recyclerview
        recyclerView = view.findViewById(R.id.featured_hor_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        featuredModels = new ArrayList<>();

        featuredModels.add(new FeaturedModel(R.drawable.fav1,"Featured 1","Description 1"));
        featuredModels.add(new FeaturedModel(R.drawable.fav3,"Featured 2","Description 2"));
        featuredModels.add(new FeaturedModel(R.drawable.fav2,"Featured 3","Description 3"));

        featuredAdapter = new FeaturedAdapter(featuredModels);
        recyclerView.setAdapter(featuredAdapter);

        ///////////////featured ver recyclerview
        recyclerView2 = view.findViewById(R.id.featured_ver_rec);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        featuredVerModels = new ArrayList<>();

        featuredVerModels.add(new FeaturedVerModels(R.drawable.ver1,"Featured 1","Description 1","4.8","10:00 - 8:00"));
        featuredVerModels.add(new FeaturedVerModels(R.drawable.ver2,"Featured 2","Description 2","4.8","10:00 - 8:00"));
        featuredVerModels.add(new FeaturedVerModels(R.drawable.ver3,"Featured 3","Description 3","4.8","10:00 - 8:00"));
        featuredVerModels.add(new FeaturedVerModels(R.drawable.ver1,"Featured 1","Description 1","4.8","10:00 - 8:00"));
        featuredVerModels.add(new FeaturedVerModels(R.drawable.ver2,"Featured 2","Description 2","4.8","10:00 - 8:00"));
        featuredVerModels.add(new FeaturedVerModels(R.drawable.ver3,"Featured 3","Description 3","4.8","10:00 - 8:00"));


        featuredVerAdapter = new FeaturedVerAdapter(featuredVerModels);
        recyclerView2.setAdapter(featuredVerAdapter);
        return view;
    }
}