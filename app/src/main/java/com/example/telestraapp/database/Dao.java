package com.example.telestraapp.database;

import android.database.sqlite.SQLiteDatabase;

/**
 * database access object
 * access db -- create, read, update and delete rows in a db
 */
public class Dao {
    SQLiteDatabase database;
    FeedReaderDbHelper helper;

    public Dao() {
    }

    public  void openDb(){}
    public void closeDb(){}

    public void createRow(){}
    public void readRows(){}
    public void updateRow(){}
    public void deleteRow(){}

}
