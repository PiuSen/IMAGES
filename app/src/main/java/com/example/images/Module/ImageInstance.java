package com.example.images.Module;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImageInstance {
    public static  final Retrofit retrofit=new Retrofit.Builder()
            .baseUrl("https://api.pexels.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private  static ImageInterface imageInterface=null;
    public static  ImageInterface getImageInterface(){
        if(imageInterface==null){
            imageInterface=retrofit.create(ImageInterface.class);
        }
        return imageInterface;
    }
}

