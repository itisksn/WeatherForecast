package com.assignment.weatherforecast.screen.weatherForcastList.model;

import android.os.Parcel;
import android.os.Parcelable;

public class WeatherForcastDataClouds implements Parcelable {
    public static final Creator<WeatherForcastDataClouds> CREATOR = new Creator<WeatherForcastDataClouds>() {
        @Override
        public WeatherForcastDataClouds createFromParcel(Parcel source) {
            WeatherForcastDataClouds var = new WeatherForcastDataClouds();
            var.all = source.readInt();
            return var;
        }

        @Override
        public WeatherForcastDataClouds[] newArray(int size) {
            return new WeatherForcastDataClouds[size];
        }
    };
    private int all;

    public int getAll() {
        return this.all;
    }

    public void setAll(int all) {
        this.all = all;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.all);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
