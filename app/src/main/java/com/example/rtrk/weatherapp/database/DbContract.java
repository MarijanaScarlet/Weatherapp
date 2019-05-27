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

}
