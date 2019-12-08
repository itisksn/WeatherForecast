package com.assignment.weatherforecast.screen.weatherForcastList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.assignment.weatherforecast.BaseFragment;
import com.assignment.weatherforecast.R;
import com.assignment.weatherforecast.databinding.FragmentWeatherListBinding;
import com.assignment.weatherforecast.db.WeatherEntity;
import com.assignment.weatherforecast.network.Resource;
import com.assignment.weatherforecast.screen.weatherForcastList.model.WeatherForcastData;
import com.assignment.weatherforecast.utils.Utils;
import com.google.gson.Gson;

import java.util.List;


public class FragmentWeatherList extends BaseFragment {

    private FragmentWeatherListBinding binding;
    private AdapterWeatherForcast adapterWeatherForcast;
    private WeatherListViewModel weatherListViewModel;
    private int id = 7778677;

    public FragmentWeatherList() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_weather_list, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        inIt();
    }

    void inIt() {
        weatherListViewModel = ViewModelProviders.of(getActivity()).get(WeatherListViewModel.class);
        subscribeViewModel();
    }

    private void subscribeViewModel() {
        weatherListViewModel.listMutableLiveData.observe(getActivity(), new Observer<List<WeatherEntity>>() {
            @Override
            public void onChanged(List<WeatherEntity> weatherEntities) {
                if (weatherEntities != null && weatherEntities.size() > 0) {

                    long diff = Utils.getCurrentTime()-weatherEntities.get(0).getDate();
                    long diffHours = diff / (60 * 60 * 1000) % 24;
                    if (diffHours>1) {
                        weatherCall();
                        return;
                    }
                    WeatherForcastData propertyModel = new Gson().fromJson(weatherEntities.get(0).getData(), WeatherForcastData.class);
                    adapterWeatherForcast = new AdapterWeatherForcast(getActivity(), propertyModel);
                    binding.recycler.setAdapter(adapterWeatherForcast);

                } else {
                    weatherCall();
                }
            }
        });

        weatherListViewModel.getAllWeatherData();

    }


    void weatherCall() {
        if (!Utils.isNetworkAvailable(getActivity())) {
            Toast.makeText(getActivity(), "" + getActivity().getString(R.string.internet_not_working), Toast.LENGTH_LONG).show();
            return;
        }
        weatherListViewModel.getLiveDataProperty(id).observe(getActivity(), new Observer<Resource<WeatherForcastData>>() {
            @Override
            public void onChanged(@Nullable Resource<WeatherForcastData> resource) {

                if (resource == null) {
                    return;
                }
                switch (resource.status) {
                    case LOADING:
                        showProgressDialog(getActivity());
                        break;
                    case SUCCESS:
                        dismissProgressDialog();
                        if (resource.data != null) {
                            adapterWeatherForcast = new AdapterWeatherForcast(getActivity(), resource.data);
                            binding.recycler.setAdapter(adapterWeatherForcast);
                            WeatherForcastData responseBean = resource.data;
                            WeatherEntity weatherEntity = new WeatherEntity();
                            weatherEntity.setId(1);
                            weatherEntity.setDate(Utils.getCurrentTime());
                            weatherEntity.setData(new Gson().toJson(responseBean));
                            weatherListViewModel.insert(weatherEntity);

                        }
                        break;
                    case ERROR:
                        Toast.makeText(getActivity(), " " + getString(R.string.server_error), Toast.LENGTH_SHORT).show();
                        dismissProgressDialog();
                        break;
                }
            }
        });
    }
}
