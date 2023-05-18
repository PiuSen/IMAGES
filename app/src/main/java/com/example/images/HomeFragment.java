package com.example.images;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.images.Module.Adapter;
import com.example.images.Module.ImageInstance;
import com.example.images.Module.ImageInterface;
import com.example.images.Module.Model;
import com.example.images.Module.Photo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }
    RecyclerView recyclerImage;
    List<Photo> photos=new ArrayList<>();
    Adapter adapter;
    ProgressBar progressBar;
    
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerImage = view.findViewById(R.id.recyclerHome);
        progressBar=view.findViewById(R.id.progressbar);

        adapter=new Adapter(requireContext(),photos);
        recyclerImage.setLayoutManager( new GridLayoutManager(requireContext(),2 ));
        recyclerImage.setAdapter(adapter);

        progressBar.setVisibility(View.VISIBLE);

        ImageInterface imageInterface= ImageInstance.getImageInterface();
        Call<Model> response=imageInterface.getModel(10);

        response.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                if(response.isSuccessful()){
                    photos.addAll(response.body().getPhotos());
                    adapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                }
            }


            @Override
            public void onFailure(Call<Model> call, Throwable t) {


            }
        });

        
        return view;
    }
}