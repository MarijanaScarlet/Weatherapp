package com.example.rtrk.weatherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.rtrk.weatherapp.database.ORMFrameworkSimulator;

public class MainActivity extends AppCompatActivity {

    ORMFrameworkSimulator database;

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
        }
    }

    public void register(View v)
    {

    }
}
