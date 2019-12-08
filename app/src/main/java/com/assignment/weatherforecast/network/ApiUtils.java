package com.assignment.weatherforecast.network;


import com.assignment.weatherforecast.screen.weatherForcastList.model.WeatherForcastData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiUtils {
    @GET("weather")
    Call<WeatherForcastData> getWeather(@Query("id") int id, @Query("appid") String appid);

}
