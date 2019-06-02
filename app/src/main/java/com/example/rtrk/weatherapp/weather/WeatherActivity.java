package com.example.rtrk.weatherapp.weather;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.rtrk.weatherapp.R;
import com.example.rtrk.weatherapp.WeatherApplication;
import com.example.rtrk.weatherapp.database.Entitets.WeatherResponse;
import com.example.rtrk.weatherapp.database.Entitets.WeatherEntity;
import com.example.rtrk.weatherapp.database.ORMFrameworkSimulator;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class WeatherActivity extends AppCompatActivity {

    public static String BaseUrl = "http://api.openweathermap.org/";
    public static String AppId = "b75bc8f0fad37f7f959618798f42eedd";
    public static String name = "London";
    public static String id = "524901";
    private TextView weatherData;
    private static ORMFrameworkSimulator database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        database = new ORMFrameworkSimulator(getApplicationContext());

        weatherData = findViewById(R.id.textView);


        long currentTimestamp = System.currentTimeMillis();
        long lastTimestamp = database.getTimestamp();

        if(lastTimestamp < currentTimestamp){
            ArrayList<WeatherResponse> weatherResponse = database.getWeather("today");
        }else{
            //get new Data from server and set new timestamp
            getCurrentData();
//            getTomorrowData();
//            getDataFromFiveDays();
            database.insertTimestamp(currentTimestamp);
        }



    }

//GSON is a java API from Google that converts java objects to their JSON representations and vice-versa. Installation instructions and sample usage

    void getCurrentData() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WeatherService.Curent service = retrofit.create(WeatherService.Curent.class);
        Call<WeatherResponse> call = service.getCurrentWeatherData(name, AppId);
        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(@NonNull Call<WeatherResponse> call, @NonNull Response<WeatherResponse> response) {
                if (response.code() == 200) {
                    WeatherResponse weatherResponse = response.body();
                    assert weatherResponse != null;

                    long currentTimestamp = System.currentTimeMillis();
                    long lastTimestamp = database.getTimestamp();

                    database.insertIntoWeather(weatherResponse, "today");

                    Log.i("Marijana today", response.body().toString());
                    Log.i("Marijana today", call.request().toString());

                }
            }

            @Override
            public void onFailure(@NonNull Call<WeatherResponse> call, @NonNull Throwable t) {
                weatherData.setText(t.getMessage());
            }
        });


    }

    void getTomorrowData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WeatherService.Tommorow service = retrofit.create(WeatherService.Tommorow.class);
        Call<WeatherResponse> call = service.getTommorowWeatherData(name, AppId);
        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(@NonNull Call<WeatherResponse> call, @NonNull Response<WeatherResponse> response) {
                if (response.code() == 200) {
                    WeatherResponse weatherResponse = response.body();
                    assert weatherResponse != null;

                    WeatherEntity weatherEntity = new WeatherEntity(weatherResponse);

                    Log.i("Marijana today", response.body().toString());
                    Log.i("Marijana today", call.request().toString());

                }
            }

            @Override
            public void onFailure(@NonNull Call<WeatherResponse> call, @NonNull Throwable t) {
                weatherData.setText(t.getMessage());
            }
        });
    }

    void getDataFromFiveDays(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WeatherService.InFiveDays service = retrofit.create(WeatherService.InFiveDays.class);
        Call<WeatherResponse> call = service.getAllWeatherData(name, AppId);;
        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(@NonNull Call<WeatherResponse> call, @NonNull Response<WeatherResponse> response) {
                if (response.code() == 200) {
                    WeatherResponse weatherResponse = response.body();
                    assert weatherResponse != null;

                    WeatherEntity weatherEntity = new WeatherEntity(weatherResponse);

                    Log.i("Marijana today", response.body().toString());
                    Log.i("Marijana today", call.request().toString());

                }
            }

            @Override
            public void onFailure(@NonNull Call<WeatherResponse> call, @NonNull Throwable t) {
                weatherData.setText(t.getMessage());
            }
        });
    }
}
