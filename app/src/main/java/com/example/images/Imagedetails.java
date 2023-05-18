package com.example.images;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.Dialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.images.Module.Photo;
import com.example.images.db.EntityClass;
import com.example.images.db.FavouriteDatabase;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class Imagedetails extends AppCompatActivity {
    private TextView aboutImage;
    private ImageView zoom;
    ExtendedFloatingActionButton imageInfo,imageDownload,imageFavourite;

    private Photo photo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagedetails);

        photo= (Photo) getIntent().getSerializableExtra("imageData");

        aboutImage=findViewById(R.id.txtImage);
        zoom=findViewById(R.id.zoom);
        imageInfo=findViewById(R.id.imageInfo);
        imageDownload=findViewById(R.id.imageDownload);
        imageFavourite=findViewById(R.id.imageFavourite);
        FavouriteDatabase favouriteDatabase= Room.
                databaseBuilder(getApplicationContext(),
                FavouriteDatabase.class,"Db")
                .allowMainThreadQueries().build();


                if(photo!=null){
                Glide.with(this).load(photo.getSrc().getOriginal()).into(zoom);
                }


//         if(getIntent().getStringExtra("Class").equals("MyAdapter")){
//           Photo photo=(Photo)getIntent().getSerializableExtra("ImageInfo");
// //            Glide.with(this).load(photo.getSrc().getOriginal()).into(aboutImage);
//             if (photo.getAlt()!=null) {
//                 aboutImage.setText("");
//             }
//             else {
//                 aboutImage.setText("");
//                 aboutImage.setTextColor(Color.parseColor(photo.getAvgColor()));
//             }
//
//         }

        imageInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showingImageInformation(photo.getHeight()+"", ""+photo.getWidth()+"", ""+photo.getPhotographerId()+"",""+photo.getPhotographer(),""+photo.getAlt());


            }
        });
        imageFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(favouriteDatabase.getFavouriteDao().isFavourite(photo.getId())){

                    imageFavourite.setIconTint(ColorStateList.valueOf(Color.TRANSPARENT));
                    favouriteDatabase.getFavouriteDao().remove(photo.getId());
                    Toast.makeText(Imagedetails.this, "Removed from the favourite", Toast.LENGTH_SHORT).show();
                }
                else{
                    EntityClass entityClass=new EntityClass(photo.getId(),photo.getHeight(),photo.getWidth(),photo.getPhotographer(),
                            photo.getPhotographerId());
                    favouriteDatabase.getFavouriteDao().insertFavourite(entityClass);
                    imageFavourite.setIconTint(ColorStateList.valueOf(Color.CYAN));
                    Toast.makeText(Imagedetails.this, "Added to the favourite", Toast.LENGTH_SHORT).show();
                }

            }
        });
        imageDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filename;
                if(photo.getAlt().equals("")){
                    filename=System.currentTimeMillis()+"";
                }
                else{
                    filename=photo.getAlt();
                }
                downLoad(filename,photo.getPhotographer());
                Toast.makeText(Imagedetails.this, "Download", Toast.LENGTH_SHORT).show();


            }
        });



    }

    private void showingImageInformation(String s, String s1, String s2, String s3, String s4) {
        Dialog dialog=new Dialog(Imagedetails.this);
        dialog.setContentView(R.layout.activity_imagedetails);

    }

    private void downLoad(String filename,String photographerId) {


    }



}