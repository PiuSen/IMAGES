package com.example.images.Module;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.images.Imagedetails;
import com.example.images.R;
import com.example.images.db.EntityClass;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Context context;
    private List<Photo>photos;


    public Adapter(Context context, List<Photo> photos) {
        this.context = context;
        this.photos = photos;
    }



    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        Glide.with(context).load(photos.get(position).getSrc().getMedium()).into(holder.image);


        holder.image.setOnClickListener(v -> {
        Intent i = new Intent(context, Imagedetails.class);
        i.putExtra("imageData", photos.get(position));
        context.startActivity(i);
        });


    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image);
        }

    }


}
