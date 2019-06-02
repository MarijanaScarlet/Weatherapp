package com.example.rtrk.weatherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.rtrk.weatherapp.database.ORMFrameworkSimulator;
import com.example.rtrk.weatherapp.weather.WeatherActivity;

public class MainActivity extends AppCompatActivity {

    private static ORMFrameworkSimulator database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = new ORMFrameworkSimulator(getApplicationContext());
    }


    public void login(View v)
    {
        String username =  ((EditText)findViewById(R.id.username)).getText().toString();
        String password =  ((EditText)findViewById(R.id.password)).getText().toString();

        if(database.userExists(username,password)){
            System.out.println("User exists");

            startActivity(new Intent(this,WeatherActivity.class));
        }


    }

    public void register(View v)
    {

    }
}
