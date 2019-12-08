package com.assignment.weatherforecast.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {WeatherEntity.class}, version = 1)

public abstract class WeatherRoomDatabase extends RoomDatabase {

    private static volatile WeatherRoomDatabase INSTANCE;

    public static WeatherRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WeatherRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WeatherRoomDatabase.class, "Weather_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract WeatherDao facilitiesDao();
}