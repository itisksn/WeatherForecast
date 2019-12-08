package com.assignment.weatherforecast.screen.weatherForcastList.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class WeatherForcastData implements Parcelable {

    public static final Creator<WeatherForcastData> CREATOR = new Creator<WeatherForcastData>() {
        @Override
        public WeatherForcastData createFromParcel(Parcel in) {
            return new WeatherForcastData(in);
        }

        @Override
        public WeatherForcastData[] newArray(int size) {
            return new WeatherForcastData[size];
        }
    };
    private int visibility;
    private int timezone;
    private WeatherForcastDataMain main;
    private WeatherForcastDataClouds clouds;
    private WeatherForcastDataSys sys;
    private int dt;
    private WeatherForcastDataCoord coord;
    private ArrayList<WeatherForcastDataWeather> weather;
    private String name;
    private int cod;
    private int id;
    private String base;
    private WeatherForcastDataWind wind;

    protected WeatherForcastData(Parcel in) {
        visibility = in.readInt();
        timezone = in.readInt();
        main = in.readParcelable(WeatherForcastDataMain.class.getClassLoader());
        clouds = in.readParcelable(WeatherForcastDataClouds.class.getClassLoader());
        sys = in.readParcelable(WeatherForcastDataSys.class.getClassLoader());
        dt = in.readInt();
        coord = in.readParcelable(WeatherForcastDataCoord.class.getClassLoader());
        weather = in.createTypedArrayList(WeatherForcastDataWeather.CREATOR);
        name = in.readString();
        cod = in.readInt();
        id = in.readInt();
        base = in.readString();
        wind = in.readParcelable(WeatherForcastDataWind.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(visibility);
        dest.writeInt(timezone);
        dest.writeParcelable(main, flags);
        dest.writeParcelable(clouds, flags);
        dest.writeParcelable(sys, flags);
        dest.writeInt(dt);
        dest.writeParcelable(coord, flags);
        dest.writeTypedList(weather);
        dest.writeString(name);
        dest.writeInt(cod);
        dest.writeInt(id);
        dest.writeString(base);
        dest.writeParcelable(wind, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public ArrayList<WeatherForcastDataWeather> getWeather() {
        return weather;
    }

    public void setWeather(ArrayList<WeatherForcastDataWeather> weather) {
        this.weather = weather;
    }

    public int getVisibility() {
        return this.visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public int getTimezone() {
        return this.timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public WeatherForcastDataMain getMain() {
        return this.main;
    }

    public void setMain(WeatherForcastDataMain main) {
        this.main = main;
    }

    public WeatherForcastDataClouds getClouds() {
        return this.clouds;
    }

    public void setClouds(WeatherForcastDataClouds clouds) {
        this.clouds = clouds;
    }

    public WeatherForcastDataSys getSys() {
        return this.sys;
    }

    public void setSys(WeatherForcastDataSys sys) {
        this.sys = sys;
    }

    public int getDt() {
        return this.dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public WeatherForcastDataCoord getCoord() {
        return this.coord;
    }

    public void setCoord(WeatherForcastDataCoord coord) {
        this.coord = coord;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCod() {
        return this.cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBase() {
        return this.base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public WeatherForcastDataWind getWind() {
        return this.wind;
    }

    public void setWind(WeatherForcastDataWind wind) {
        this.wind = wind;
    }

}
