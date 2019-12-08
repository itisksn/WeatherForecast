package com.assignment.weatherforecast.screen.weatherForcastList;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.assignment.weatherforecast.BuildConfig;
import com.assignment.weatherforecast.db.WeatherEntity;
import com.assignment.weatherforecast.network.Resource;
import com.assignment.weatherforecast.screen.weatherForcastList.model.WeatherForcastData;

import java.util.List;

public class WeatherListViewModel extends AndroidViewModel {

    public LiveData<Resource<WeatherForcastData>> weatherLiveData;
    public MutableLiveData<List<WeatherEntity>> listMutableLiveData = new MutableLiveData<>();

    public WeatherListViewModel(@NonNull Application application) {
        super(application);

    }

    public LiveData<Resource<WeatherForcastData>> getLiveDataProperty(int id) {

        weatherLiveData = WeatherListRepo.get(getApplication()).weatherDataList(getApplication().getApplicationContext(), id, BuildConfig.API_KEY);
        return weatherLiveData;
    }

    public void getAllWeatherData() {

        WeatherListRepo.get(getApplication()).getAllWeatherData(listMutableLiveData);
    }

    public void insert(WeatherEntity weatherEntity) {
        WeatherListRepo.get(getApplication()).insert(weatherEntity);
    }
}
