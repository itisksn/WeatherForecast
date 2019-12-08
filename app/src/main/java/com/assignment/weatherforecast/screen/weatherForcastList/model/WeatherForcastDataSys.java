package com.assignment.weatherforecast.screen.weatherForcastList.model;

import android.os.Parcel;
import android.os.Parcelable;

public class WeatherForcastDataSys implements Parcelable {
    public static final Creator<WeatherForcastDataSys> CREATOR = new Creator<WeatherForcastDataSys>() {
        @Override
        public WeatherForcastDataSys createFromParcel(Parcel source) {
            WeatherForcastDataSys var = new WeatherForcastDataSys();
            var.country = source.readString();
            var.sunrise = source.readInt();
            var.sunset = source.readInt();
            var.id = source.readInt();
            var.type = source.readInt();
            return var;
        }

        @Override
        public WeatherForcastDataSys[] newArray(int size) {
            return new WeatherForcastDataSys[size];
        }
    };
    private String country;
    private int sunrise;
    private int sunset;
    private int id;
    private int type;

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getSunrise() {
        return this.sunrise;
    }

    public void setSunrise(int sunrise) {
        this.sunrise = sunrise;
    }

    public int getSunset() {
        return this.sunset;
    }

    public void setSunset(int sunset) {
        this.sunset = sunset;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.country);
        dest.writeInt(this.sunrise);
        dest.writeInt(this.sunset);
        dest.writeInt(this.id);
        dest.writeInt(this.type);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
