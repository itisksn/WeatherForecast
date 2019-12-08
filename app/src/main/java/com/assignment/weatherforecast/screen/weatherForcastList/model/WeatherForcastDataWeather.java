package com.assignment.weatherforecast.screen.weatherForcastList.model;

import android.os.Parcel;
import android.os.Parcelable;

public class WeatherForcastDataWeather implements Parcelable {
    public static final Creator<WeatherForcastDataWeather> CREATOR = new Creator<WeatherForcastDataWeather>() {
        @Override
        public WeatherForcastDataWeather createFromParcel(Parcel source) {
            WeatherForcastDataWeather var = new WeatherForcastDataWeather();
            var.icon = source.readString();
            var.description = source.readString();
            var.main = source.readString();
            var.id = source.readInt();
            return var;
        }

        @Override
        public WeatherForcastDataWeather[] newArray(int size) {
            return new WeatherForcastDataWeather[size];
        }
    };
    private String icon;
    private String description;
    private String main;
    private int id;

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMain() {
        return this.main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.icon);
        dest.writeString(this.description);
        dest.writeString(this.main);
        dest.writeInt(this.id);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
