package com.example.images.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.images.Module.Photo;

import java.util.Collection;
import java.util.List;

@Dao
public interface FavouriteDao {
    @Insert
    public long insertFavourite(EntityClass entityClass);


    @Update
    public void updateFavourite(EntityClass entityClass);

    @Delete
    public void deletFavourite(EntityClass entityClass);

    @Query("delete from MyFavourite where id=:enterId")
    public void deletePhotoById(long enterId);

    @Query("select * from MyFavourite where id=:enterId")
    public EntityClass getAllPhoto(long enterId);

    @Query("select * from MyFavourite")
    public List<Photo> getAllFavourite();
    @Query("select imageId from MyFavourite where imageId=:enterImageId")
    public boolean isFavourite(int enterImageId);
    @Query("delete from MyFavourite where imageId=:enterImageId")
    public  void remove(int enterImageId);

}


