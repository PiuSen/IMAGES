package com.example.images;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.images.Module.Adapter;
import com.example.images.Module.Photo;
import com.example.images.db.EntityClass;
import com.example.images.db.FavouriteDatabase;

import java.util.ArrayList;
import java.util.List;


public class FavouriteFragment extends Fragment {
    private RecyclerView recyclerviewFavourite;
    private List<Photo>photos;
    FavouriteDatabase favouriteDatabase;
    Adapter adapter;


    public FavouriteFragment() {
        // Required empty public constructor
    }


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favourite, container, false);
        recyclerviewFavourite = view.findViewById(R.id.recyclerviewFavourite);
        favouriteDatabase = Room.databaseBuilder(getContext(), FavouriteDatabase.class, "DB").allowMainThreadQueries().build();

        adapter = new Adapter(getContext(), photos);


        if (favouriteDatabase.getFavouriteDao().getAllFavourite().size() != 0) {
            photos.addAll(favouriteDatabase.getFavouriteDao().getAllFavourite());

        }





        recyclerviewFavourite.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerviewFavourite.setAdapter(adapter);
        recyclerviewFavourite.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener());

        return view;
    }
}