package com.example.rtrk.weatherapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

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
                    cursor.getColumnIndexOrThrow(DbContract.UsersEntry._ID));

            String password = cursor.getString(
                    cursor.getColumnIndexOrThrow(DbContract.UsersEntry._ID));

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



}
