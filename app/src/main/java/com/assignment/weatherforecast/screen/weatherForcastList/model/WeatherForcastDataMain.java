package com.assignment.weatherforecast.screen.weatherForcastList.model;

import android.os.Parcel;
import android.os.Parcelable;

public class WeatherForcastDataMain implements Parcelable {
    public static final Creator<WeatherForcastDataMain> CREATOR = new Creator<WeatherForcastDataMain>() {
        @Override
        public WeatherForcastDataMain createFromParcel(Parcel source) {
            WeatherForcastDataMain var = new WeatherForcastDataMain();
            var.temp = source.readDouble();
            var.temp_min = source.readDouble();
            var.humidity = source.readInt();
            var.pressure = source.readInt();
            var.temp_max = source.readDouble();
            return var;
        }

        @Override
        public WeatherForcastDataMain[] newArray(int size) {
            return new WeatherForcastDataMain[size];
        }
    };
    private double temp;
    private double temp_min;
    private int humidity;
    private int pressure;
    private double temp_max;

    public double getTemp() {
        return this.temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getTemp_min() {
        return this.temp_min;
    }

    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }

    public int getHumidity() {
        return this.humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getPressure() {
        return this.pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public double getTemp_max() {
        return this.temp_max;
    }

    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(this.temp);
        dest.writeDouble(this.temp_min);
        dest.writeInt(this.humidity);
        dest.writeInt(this.pressure);
        dest.writeDouble(this.temp_max);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
