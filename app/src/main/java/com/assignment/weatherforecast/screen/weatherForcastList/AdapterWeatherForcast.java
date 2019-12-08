package com.assignment.weatherforecast.screen.weatherForcastList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.assignment.weatherforecast.R;
import com.assignment.weatherforecast.databinding.ListAdapterBinding;
import com.assignment.weatherforecast.screen.weatherForcastList.model.WeatherForcastData;
import com.assignment.weatherforecast.utils.Utils;
import com.bumptech.glide.Glide;


public class AdapterWeatherForcast extends RecyclerView.Adapter<AdapterWeatherForcast.ViewHolderDataClass> {

    private Context context;
    private WeatherForcastData weatherForcastDataWeather;

    public AdapterWeatherForcast(Context context, WeatherForcastData weatherForcastDataWeather) {
        this.context = context;
        this.weatherForcastDataWeather = weatherForcastDataWeather;

    }

    @NonNull
    @Override
    public ViewHolderDataClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListAdapterBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.list_adapter, parent, false);

        return new ViewHolderDataClass(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDataClass holder, int position) {
        holder.binding.setWeatherData(weatherForcastDataWeather);
        holder.binding.press.setText("" + weatherForcastDataWeather.getMain().getPressure());
        holder.binding.hum.setText("" + weatherForcastDataWeather.getMain().getHumidity());
        holder.binding.windSpeed.setText("" + weatherForcastDataWeather.getWind().getSpeed());
        holder.binding.windDeg.setText("," + weatherForcastDataWeather.getWind().getDeg() + " \u2109");

        try {
            if (weatherForcastDataWeather.getWeather().get(0).getIcon() != null
            ) {
                String url = Utils.IMG_URl + "" + weatherForcastDataWeather.getWeather().get(0).getIcon() + "" + Utils.IMG_EX;
                Glide
                        .with(context)
                        .load(url)
                        .centerCrop()
                        .placeholder(R.drawable.ic_launcher_background)
                        .into(holder.binding.condIcon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return weatherForcastDataWeather.getWeather().size();
    }

    public class ViewHolderDataClass extends RecyclerView.ViewHolder {
        private ListAdapterBinding binding;

        public ViewHolderDataClass(@NonNull ListAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }


    }

}
