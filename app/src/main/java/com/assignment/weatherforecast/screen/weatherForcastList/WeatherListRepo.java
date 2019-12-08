package com.assignment.weatherforecast.screen.weatherForcastList;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.assignment.weatherforecast.db.WeatherDao;
import com.assignment.weatherforecast.db.WeatherEntity;
import com.assignment.weatherforecast.db.WeatherRoomDatabase;
import com.assignment.weatherforecast.network.CallServer;
import com.assignment.weatherforecast.network.Resource;
import com.assignment.weatherforecast.screen.weatherForcastList.model.WeatherForcastData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherListRepo {

    private Application application;
    private WeatherDao weatherDao;
    private List<WeatherEntity> listLiveData;

    WeatherListRepo(Application application) {
        this.application = application;

    }

    public static WeatherListRepo get(Application application) {
        return new WeatherListRepo(application);
    }

    public void getAllWeatherData(MutableLiveData<List<WeatherEntity>> listMutableLiveData) {
        new getAsyncTask(listMutableLiveData).execute();
    }

    public void insert(WeatherEntity word) {
        new insertAsyncTask(weatherDao).execute(word);
    }

    public LiveData<Resource<WeatherForcastData>> weatherDataList(final Context c, int period, String apiKey) {

        final MutableLiveData<Resource<WeatherForcastData>> data = new MutableLiveData<>();
        data.setValue(Resource.<WeatherForcastData>loading(null));

        CallServer.get().getAPIName().getWeather(period, apiKey).enqueue(new Callback<WeatherForcastData>() {
            @Override
            public void onResponse(Call<WeatherForcastData> call, Response<WeatherForcastData> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {

                        data.setValue(Resource.success(response.body()));
                    } else
                        data.setValue(Resource.error(response.message(), null, 0, null));

                }
            }

            @Override
            public void onFailure(Call<WeatherForcastData> call, Throwable t) {
                data.setValue(Resource.error(CallServer.serverError, null, 0, t));

            }
        });
        return data;
    }

    private class getAsyncTask extends AsyncTask<Void, Void, List<WeatherEntity>> {
        MutableLiveData<List<WeatherEntity>> listMutableLiveData;

        public getAsyncTask(MutableLiveData<List<WeatherEntity>> listMutableLiveData) {
            this.listMutableLiveData = listMutableLiveData;
        }

        @Override
        protected List<WeatherEntity> doInBackground(final Void... params) {
            WeatherRoomDatabase db = WeatherRoomDatabase.getDatabase(application);
            weatherDao = db.facilitiesDao();
            listLiveData = weatherDao.getAllData();

            return listLiveData;
        }

        @Override
        protected void onPostExecute(List<WeatherEntity> facilities) {
            super.onPostExecute(facilities);
            listMutableLiveData.setValue(facilities);

        }
    }

    private class insertAsyncTask extends AsyncTask<WeatherEntity, Void, Void> {

        private WeatherDao mAsyncTaskDao;

        insertAsyncTask(WeatherDao dao) {
            WeatherRoomDatabase db = WeatherRoomDatabase.getDatabase(application);
            mAsyncTaskDao = db.facilitiesDao();
        }

        @Override
        protected Void doInBackground(final WeatherEntity... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }


}
