package com.assignment.weatherforecast.screen.weatherForcastList.model;

import android.os.Parcel;
import android.os.Parcelable;

public class WeatherForcastDataWind implements Parcelable {
    public static final Creator<WeatherForcastDataWind> CREATOR = new Creator<WeatherForcastDataWind>() {
        @Override
        public WeatherForcastDataWind createFromParcel(Parcel source) {
            WeatherForcastDataWind var = new WeatherForcastDataWind();
            var.deg = source.readInt();
            var.speed = source.readDouble();
            var.gust = source.readDouble();
            return var;
        }

        @Override
        public WeatherForcastDataWind[] newArray(int size) {
            return new WeatherForcastDataWind[size];
        }
    };
    private int deg;
    private double speed;
    private double gust;

    public int getDeg() {
        return this.deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    public double getSpeed() {
        return this.speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getGust() {
        return this.gust;
    }

    public void setGust(double gust) {
        this.gust = gust;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.deg);
        dest.writeDouble(this.speed);
        dest.writeDouble(this.gust);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
