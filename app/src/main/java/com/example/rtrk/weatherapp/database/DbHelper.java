package com.example.rtrk.weatherapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "WeatherApp1.db";


    private static final String SQL_CREATE_ENTRY_USERS =
            "CREATE TABLE " + DbContract.UsersEntry.TABLE_NAME + " (" +
                    DbContract.UsersEntry._ID + " INTEGER PRIMARY KEY," +
                    DbContract.UsersEntry.COLUMN_NAME_USERNAME + " TEXT UNIQUE," +
                    DbContract.UsersEntry.COLUMN_NAME_PASSWORD + " TEXT)";

    private static final String SQL_CREATE_ENTRY_TIMESTAMP =
            "CREATE TABLE " + DbContract.TimestampEntry.TABLE_NAME + " (" +
                    DbContract.TimestampEntry._ID + " INTEGER PRIMARY KEY," +
                    DbContract.TimestampEntry.COLUMN_NAME_DATE_AND_TIME + " INTEGER)";

    private static final String SQL_CREATE_ENTRY_WEATHER =
            "CREATE TABLE " + DbContract.WeatherEntry.TABLE_NAME + " (" +
                    DbContract.WeatherEntry._ID + " INTEGER PRIMARY KEY," +
                    DbContract.WeatherEntry.COLUMN_NAME_LON + " INTEGER," +
                    DbContract.WeatherEntry.COLUMN_NAME_LAT + " INTEGER," +
                    DbContract.WeatherEntry.COLUMN_NAME_TEMP + " INTEGER," +
                    DbContract.WeatherEntry.COLUMN_NAME_PRESSURE + " INTEGER," +
                    DbContract.WeatherEntry.COLUMN_NAME_HUMIDITY + " INTEGER," +
                    DbContract.WeatherEntry.COLUMN_NAME_MAX_TEMP + " INTEGER," +
                    DbContract.WeatherEntry.COLUMN_NAME_MIN_TEMP + " INTEGER," +
                    DbContract.WeatherEntry.COLUMN_NAME_SEA_LEVEL + " INTEGER," +
                    DbContract.WeatherEntry.COLUMN_NAME_GRND_LEVEL + " INTEGER," +
                    DbContract.WeatherEntry.COLUMN_NAME_WIND_SPEED + " INTEGER," +
                    DbContract.WeatherEntry.COLUMN_NAME_CLOUDS + " INTEGER," +
                    DbContract.WeatherEntry.COLUMN_NAME_SUNRISE + " INTEGER," +
                    DbContract.WeatherEntry.COLUMN_NAME_SUNSET + " INTEGER," +
                    DbContract.WeatherEntry.COLUMN_NAME_CITY_ID + " INTEGER," +
                    DbContract.WeatherEntry.COLUMN_NAME_CITY_NAME + " TEXT," +
                    DbContract.WeatherEntry.COLUMN_NAME_CITY_COD + " INTEGER)";

    private static final String SQL_DELETE_ENTRY_USERS =
            "DROP TABLE IF EXISTS " + DbContract.UsersEntry.TABLE_NAME;

    private static final String SQL_DELETE_ENTRY_TIMESTAMP =
            "DROP TABLE IF EXISTS " + DbContract.TimestampEntry.TABLE_NAME;

    private static final String SQL_DELETE_ENTRY_WEATHER =
            "DROP TABLE IF EXISTS " + DbContract.WeatherEntry.TABLE_NAME;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRY_USERS);
        db.execSQL(SQL_CREATE_ENTRY_TIMESTAMP);
        db.execSQL(SQL_CREATE_ENTRY_WEATHER);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRY_USERS);
        db.execSQL(SQL_DELETE_ENTRY_TIMESTAMP);
        db.execSQL(SQL_DELETE_ENTRY_WEATHER);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }



}
