package com.example.images.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {EntityClass.class},version = 1)
public abstract  class FavouriteDatabase extends RoomDatabase {
    public abstract FavouriteDao getFavouriteDao();

}
