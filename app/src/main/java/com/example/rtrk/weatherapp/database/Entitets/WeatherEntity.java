package com.example.rtrk.weatherapp.database.Entitets;

import android.provider.BaseColumns;

import com.example.rtrk.weatherapp.database.Entitets.WeatherResponse;

//Razmotri da li da naucis Room ili sa stranim kljucevima ovo?

public class WeatherEntity implements BaseColumns {

    private float dt;
    private int cityId;
    private String cityName;
    private float cod;

//Za pocetak staviti samo jedan, prvi iz liste
//WeatherEntity
    private int idWeather;
    private String main;
    private String description;
    private String icon;

//Clouds
    private float all;

//Rain
    private float h3;


//Wind
    private float speed;
    private float deg;


//Main
    private float temp;
    private float humidity;
    private float pressure;
    private float temp_min;
    private float temp_max;


//Sys
    private String country;
    private long sunrise;
    private long sunset;


//Coord
    private float lon;
    private float lat;


    public WeatherEntity(WeatherResponse weatherResponse){

//        this.dt = weatherResponse.dt;
//        this.cityId = weatherResponse.id;
//        this.cityName = weatherResponse.name;
//        this.cod = weatherResponse.cod;
//
//        this.idWeather = weatherResponse.weather.get(0).;
//        this.main = weatherResponse.weather.get(0).main;
//        this.description = weatherResponse.weather.get(0).description;
//        this.icon =
//
//        this.all =
//        this.h3 =
//
//        this.speed =
//        this.deg =
//
//        this.temp =
//        this.humidity =
//        this.pressure =
//        this.temp_min =
//        this.temp_max =
//
//        this.country =
//        this.sunrise =
//        this.sunset =
//
//        this.lon =
//        this.lat =

    }

    public float getDt() {
        return dt;
    }

    public int getCityId() {
        return cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public float getCod() {
        return cod;
    }

    public int getIdWeather() {
        return idWeather;
    }

    public String getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }

    public float getAll() {
        return all;
    }

    public float getH3() {
        return h3;
    }

    public float getSpeed() {
        return speed;
    }

    public float getDeg() {
        return deg;
    }

    public float getTemp() {
        return temp;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public float getTemp_min() {
        return temp_min;
    }

    public float getTemp_max() {
        return temp_max;
    }

    public String getCountry() {
        return country;
    }

    public long getSunrise() {
        return sunrise;
    }

    public long getSunset() {
        return sunset;
    }

    public float getLon() {
        return lon;
    }

    public float getLat() {
        return lat;
    }

    public void setDt(float dt) {
        this.dt = dt;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setCod(float cod) {
        this.cod = cod;
    }

    public void setIdWeather(int idWeather) {
        this.idWeather = idWeather;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setAll(float all) {
        this.all = all;
    }

    public void setH3(float h3) {
        this.h3 = h3;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void setDeg(float deg) {
        this.deg = deg;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public void setTemp_min(float temp_min) {
        this.temp_min = temp_min;
    }

    public void setTemp_max(float temp_max) {
        this.temp_max = temp_max;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    public void setSunset(long sunset) {
        this.sunset = sunset;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }
}
