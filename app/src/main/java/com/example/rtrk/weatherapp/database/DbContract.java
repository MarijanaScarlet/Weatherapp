package com.example.rtrk.weatherapp.database;

import android.provider.BaseColumns;

public class DbContract {

    private DbContract() {}

    /* Inner class that defines the table contents */
    public static class UsersEntry implements BaseColumns {
        public static final String TABLE_NAME = "users";
        public static final String COLUMN_NAME_USERNAME = "username";
        public static final String COLUMN_NAME_PASSWORD = "password";
    }

    public static class TimestampEntry implements BaseColumns{
        public static final String TABLE_NAME = "timestamp";
        public static final String COLUMN_NAME_DATE_AND_TIME = "date_and_time";
    }

    public static class WeatherEntry implements BaseColumns{
        public static final String TABLE_NAME = "weather";
        public static final String COLUMN_NAME_LON = "lon";
        public static final String COLUMN_NAME_LAT = "lat";
        public static final String COLUMN_NAME_TEMP = "c_temp";
        public static final String COLUMN_NAME_PRESSURE = "pressur4e";
        public static final String COLUMN_NAME_HUMIDITY = "humidity";
        public static final String COLUMN_NAME_MIN_TEMP = "min_temp";
        public static final String COLUMN_NAME_MAX_TEMP = "max_temp";
        public static final String COLUMN_NAME_SEA_LEVEL = "sea_level";
        public static final String COLUMN_NAME_GRND_LEVEL = "grnd";
        public static final String COLUMN_NAME_WIND_SPEED = "wind";
        public static final String COLUMN_NAME_CLOUDS = "clouds";
        public static final String COLUMN_NAME_SUNSET = "sunset";
        public static final String COLUMN_NAME_SUNRISE = "sunrise";
        public static final String COLUMN_NAME_CITY_ID = "city_id";
        public static final String COLUMN_NAME_CITY_NAME = "city_name";
        public static final String COLUMN_NAME_CITY_COD = "city_cod";


        //it means - today, tomorrow, infivedays
        public static final String COLUMN_NAME_WEATHER_TYPE = "type";

    }
}
