package com.example.images.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "MyFavourite")
public class EntityClass  implements Serializable {
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo(name = "imageId")
    int imageId;
    @ColumnInfo(name = "height")
    int height;
    @ColumnInfo(name="weight")
    int weight;
    @ColumnInfo(name="photographer")
    String photographer;
    @ColumnInfo(name="photographerId")
    int photographerId;


    public EntityClass(int imageId,int height, int weight,String photographer,int photographerId) {
        this.height = height;
        this.weight = weight;
        this.imageId=imageId;
        this.photographer=photographer;
        this.photographerId=photographerId;


    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getPhotographer() {
        return photographer;
    }

    public void setPhotographer(String photographer) {
        this.photographer = photographer;
    }

    public int getPhotographerId() {
        return photographerId;
    }

    public void setPhotographerId(int photographerId) {
        this.photographerId = photographerId;
    }
}

