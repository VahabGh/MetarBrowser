package com.vahabgh.metarbrowser.main.data.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {AirportEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DB_NAME = "MetarDb";

    private static AppDatabase instance;

    public static AppDatabase get(Context applicationContext){
        if (instance == null)
            instance = createDb(applicationContext);
        return instance;
    }

    private static AppDatabase createDb(Context applicationContext) {
        return Room.databaseBuilder(applicationContext,
                AppDatabase.class, DB_NAME).build();
    }

    public abstract MetarBrowserDao metarBrowserDao();

}
