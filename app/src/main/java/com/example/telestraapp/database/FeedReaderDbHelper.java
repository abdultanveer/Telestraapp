package com.example.telestraapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import com.example.telestraapp.database.FeedReaderContract.FeedEntry;

/**
 * helper will create db and then create a table in that db
 */
public class FeedReaderDbHelper extends SQLiteOpenHelper {
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
                   // FeedEntry._ID +
                    "_id"+
                    " INTEGER PRIMARY KEY," +
                    FeedEntry.COLUMN_NAME_TITLE + " TEXT," +
                    FeedEntry.COLUMN_NAME_SUBTITLE + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;


    /**c
     * constructor
     * @param context
     */
    public FeedReaderDbHelper(@Nullable Context context) {
        super(context, "dbname", null, 1);
    }

    /**
     * this method helps in creating a table
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_ENTRIES); //table would be created
    }

    /**
     * when we upgrade our app and db [if we add or remove cols from table]
     * this method
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
