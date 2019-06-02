package com.example.rtrk.weatherapp.database.Entitets;

import android.arch.persistence.room.Entity;

import com.example.rtrk.weatherapp.weather.Main;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

//Sa room probaj da stavis i @Entity anotaciju na ovo moci ce sig
//a na ove druge klse @Embedded

public class WeatherResponse {

    //The SerializedName annotation is used to parse the server response and their name & type should be the same as the Json Response received from the server.
    //You must check weather the data on server is in JSON files or for example XML files so you must add in build.gradle file dependency to convert JSON/XML to GSON/GXML
    @SerializedName("coord")
    public Coord coord;
    @SerializedName("sys")
    public Sys sys;
    @SerializedName("weather")
    public ArrayList<Weather> weather = new ArrayList<Weather>();
    @SerializedName("main")
    public Main main;
    @SerializedName("wind")
    public Wind wind;
    @SerializedName("rain")
    public Rain rain;
    @SerializedName("clouds")
    public Clouds clouds;
    @SerializedName("dt")
    public float dt;
    @SerializedName("id")
    public int id;
    @SerializedName("name")
    public String name;
    @SerializedName("cod")
    public float cod;

    public WeatherResponse(float min, float max){
        main = new Main(min, max);
    }
}






