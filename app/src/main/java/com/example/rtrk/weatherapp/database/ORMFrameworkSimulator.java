package com.example.rtrk.weatherapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.example.rtrk.weatherapp.database.Entitets.User;
import com.example.rtrk.weatherapp.database.Entitets.Weather;
import com.example.rtrk.weatherapp.database.Entitets.WeatherResponse;

import java.util.ArrayList;

public class ORMFrameworkSimulator  {

    private DbHelper dbHelper;
    private SQLiteDatabase db;


    public ORMFrameworkSimulator(Context context){
        dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();

        insertIntoUsers("maki", "maki");
    }

    public void insertIntoUsers(String username, String password){
        ContentValues values = new ContentValues();
        values.put(DbContract.UsersEntry.COLUMN_NAME_USERNAME, username);
        values.put(DbContract.UsersEntry.COLUMN_NAME_PASSWORD, password);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(DbContract.UsersEntry.TABLE_NAME, null, values);
    }

    private ArrayList<User> allUsers(){

        String[] projection = {
                BaseColumns._ID,
                DbContract.UsersEntry.COLUMN_NAME_USERNAME,
                DbContract.UsersEntry.COLUMN_NAME_PASSWORD
        };


        Cursor cursor = db.query(
                DbContract.UsersEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null               // The sort order
        );


        ArrayList<User> users = new ArrayList<>();
        while(cursor.moveToNext()) {

            long itemId = cursor.getLong(
                    cursor.getColumnIndexOrThrow(DbContract.UsersEntry._ID));

            String username = cursor.getString(
                    cursor.getColumnIndexOrThrow(DbContract.UsersEntry.COLUMN_NAME_USERNAME));

            String password = cursor.getString(
                    cursor.getColumnIndexOrThrow(DbContract.UsersEntry.COLUMN_NAME_PASSWORD));

            User user = new User(username, password);

            users.add(user);
        }
        cursor.close();


        return users;

    }

    public boolean userExists(String username, String password){

        String[] projection = {
                BaseColumns._ID,
                DbContract.UsersEntry.COLUMN_NAME_USERNAME,
                DbContract.UsersEntry.COLUMN_NAME_PASSWORD
        };

        // Filter results WHERE "title" = 'My Title'
        String selection = DbContract.UsersEntry.COLUMN_NAME_USERNAME + " = ? AND " + DbContract.UsersEntry.COLUMN_NAME_PASSWORD + " = ?";
        String[] selectionArgs = { username, password };



        Cursor cursor = db.query(
                DbContract.UsersEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null               // The sort order
        );


        if(cursor.getCount() != 0)
            return true;
        else
            return false;

    }


    public long getTimestamp(){

        String[] projection = {
                BaseColumns._ID,
                DbContract.TimestampEntry.COLUMN_NAME_DATE_AND_TIME,
        };

        String selection = null;
        String[] selectionArgs = null;

        Cursor cursor = db.query(
                DbContract.TimestampEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null               // The sort order
        );

        long date_and_time = 0;

        while(cursor.moveToNext()){
             date_and_time = cursor.getLong(
                    cursor.getColumnIndexOrThrow(DbContract.TimestampEntry.COLUMN_NAME_DATE_AND_TIME));
        }
        cursor.close();

        return date_and_time;
    }

    public void insertTimestamp(long millis){
        ContentValues values = new ContentValues();
        values.put(DbContract.TimestampEntry.COLUMN_NAME_DATE_AND_TIME, (int)millis);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(DbContract.UsersEntry.TABLE_NAME, null, values);
    }

    public void insertIntoWeather(WeatherResponse wr, String type){
        ContentValues values = new ContentValues();
        values.put(DbContract.WeatherEntry.COLUMN_NAME_LON , wr.coord.lon);
        values.put(DbContract.WeatherEntry.COLUMN_NAME_LAT , wr.coord.lat);
        values.put(DbContract.WeatherEntry.COLUMN_NAME_TEMP , wr.main.temp);
        values.put(DbContract.WeatherEntry.COLUMN_NAME_PRESSURE , wr.main.pressure);
        values.put(DbContract.WeatherEntry.COLUMN_NAME_HUMIDITY, wr.main.humidity);
        values.put(DbContract.WeatherEntry.COLUMN_NAME_MAX_TEMP , wr.main.temp_max);
        values.put(DbContract.WeatherEntry.COLUMN_NAME_MIN_TEMP , wr.main.temp_min);
        values.put(DbContract.WeatherEntry.COLUMN_NAME_WIND_SPEED , wr.wind.speed);
        values.put(DbContract.WeatherEntry.COLUMN_NAME_CLOUDS , wr.clouds.all);
        values.put(DbContract.WeatherEntry.COLUMN_NAME_SUNRISE, wr.sys.sunrise);
        values.put(DbContract.WeatherEntry.COLUMN_NAME_SUNSET , wr.sys.sunset);
        values.put(DbContract.WeatherEntry.COLUMN_NAME_CITY_ID , wr.id);
        values.put(DbContract.WeatherEntry.COLUMN_NAME_CITY_NAME , wr.name);
        values.put(DbContract.WeatherEntry.COLUMN_NAME_CITY_COD, wr.cod);
        values.put(DbContract.WeatherEntry.COLUMN_NAME_WEATHER_TYPE, type);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(DbContract.UsersEntry.TABLE_NAME, null, values);
    }

    public ArrayList<WeatherResponse> getWeather(String type) {
        String[] projection = {
            BaseColumns._ID,
            DbContract.WeatherEntry.COLUMN_NAME_LON,
            DbContract.WeatherEntry.COLUMN_NAME_LAT,
            DbContract.WeatherEntry.COLUMN_NAME_TEMP ,
            DbContract.WeatherEntry.COLUMN_NAME_PRESSURE,
            DbContract.WeatherEntry.COLUMN_NAME_HUMIDITY,
            DbContract.WeatherEntry.COLUMN_NAME_MAX_TEMP ,
            DbContract.WeatherEntry.COLUMN_NAME_MIN_TEMP ,
            DbContract.WeatherEntry.COLUMN_NAME_WIND_SPEED ,
            DbContract.WeatherEntry.COLUMN_NAME_CLOUDS ,
            DbContract.WeatherEntry.COLUMN_NAME_SUNRISE,
            DbContract.WeatherEntry.COLUMN_NAME_SUNSET ,
            DbContract.WeatherEntry.COLUMN_NAME_CITY_ID ,
            DbContract.WeatherEntry.COLUMN_NAME_CITY_NAME ,
            DbContract.WeatherEntry.COLUMN_NAME_CITY_COD
        };

        // Filter results WHERE "title" = 'My Title'
        String selection = DbContract.WeatherEntry.COLUMN_NAME_WEATHER_TYPE + " = ?";
        String[] selectionArgs = { type };



        Cursor cursor = db.query(
                DbContract.UsersEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null               // The sort order
        );


        ArrayList<WeatherResponse> weathers = new ArrayList<>();
        while(cursor.moveToNext()) {

            long itemId = cursor.getLong(
                    cursor.getColumnIndexOrThrow(DbContract.WeatherEntry._ID));

            float max_temp = cursor.getFloat(
                    cursor.getColumnIndexOrThrow(DbContract.WeatherEntry.COLUMN_NAME_MAX_TEMP));

            float min_temp = cursor.getFloat(
                    cursor.getColumnIndexOrThrow(DbContract.WeatherEntry.COLUMN_NAME_MIN_TEMP));

            WeatherResponse weatherResponse = new WeatherResponse(max_temp, min_temp);

            weathers.add(weatherResponse);
        }
        cursor.close();

        return weathers;
    }
}
