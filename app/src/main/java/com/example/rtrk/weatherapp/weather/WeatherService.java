package com.example.rtrk.weatherapp.weather;

import com.example.rtrk.weatherapp.database.Entitets.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {

    public interface Curent{
        @GET("data/2.5/weather")
        Call<WeatherResponse> getCurrentWeatherData(@Query("q") String name, @Query("APPID") String app_id);
    }
    public interface Tommorow{
        @GET("data/2.5/forecast")
        Call<WeatherResponse> getTommorowWeatherData(@Query("id") String id, @Query("APPID") String app_id);
    }
    public interface InFiveDays{
        @GET("data/2.5/forecast/daily")
        Call<WeatherResponse> getAllWeatherData(@Query("id") String id, @Query("APPID") String app_id);
    }

}
