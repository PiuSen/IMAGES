package com.example.images;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

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

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerImage;
    List<Photo>photos=new ArrayList<>();
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerImage=findViewById(R.id.RecyclerImage);


        adapter=new Adapter(this,photos);
        recyclerImage.setLayoutManager( new GridLayoutManager(this,2 ));
        recyclerImage.setAdapter(adapter);

        ImageInterface imageInterface= ImageInstance.getImageInterface();
        Call<Model> response=imageInterface.getModel(60);

        response.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                if(response.isSuccessful()){
                    photos.addAll(response.body().getPhotos());
                    adapter.notifyDataSetChanged();
                }
            }


            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        });


        }

    }
