package com.assignment.weatherforecast.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(WeatherEntity weatherEntity);

    @Query("SELECT * from weather_data")
    List<WeatherEntity> getAllData();

}
