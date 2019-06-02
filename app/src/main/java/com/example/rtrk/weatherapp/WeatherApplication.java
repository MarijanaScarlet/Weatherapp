package com.example.rtrk.weatherapp;

import android.app.Application;

import com.example.rtrk.weatherapp.database.ORMFrameworkSimulator;

public class WeatherApplication extends Application {

    private static ORMFrameworkSimulator database;

    @Override
    public void onCreate() {
        super.onCreate();

        database = new ORMFrameworkSimulator(getApplicationContext());
    }


}
