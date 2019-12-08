package com.assignment.weatherforecast.screen.weatherForcastList.model;

import android.os.Parcel;
import android.os.Parcelable;

public class WeatherForcastDataCoord implements Parcelable {
    public static final Creator<WeatherForcastDataCoord> CREATOR = new Creator<WeatherForcastDataCoord>() {
        @Override
        public WeatherForcastDataCoord createFromParcel(Parcel source) {
            WeatherForcastDataCoord var = new WeatherForcastDataCoord();
            var.lon = source.readDouble();
            var.lat = source.readDouble();
            return var;
        }

        @Override
        public WeatherForcastDataCoord[] newArray(int size) {
            return new WeatherForcastDataCoord[size];
        }
    };
    private double lon;
    private double lat;

    public double getLon() {
        return this.lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return this.lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(this.lon);
        dest.writeDouble(this.lat);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
