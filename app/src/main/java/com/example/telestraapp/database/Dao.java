package com.example.telestraapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.telestraapp.database.FeedReaderContract.FeedEntry;


/**
 * database access object
 * access db -- create, read, update and delete rows in a db
 */
public class Dao {
    SQLiteDatabase database;
    FeedReaderDbHelper helper;

    public Dao(Context context) {
        helper = new FeedReaderDbHelper(context);//created a db
    }

    public  void openDb(){
        database = helper.getWritableDatabase();
    }
    public void closeDb(){
        database.close();
    }

    public void createRow(String title, String subtitle){
        ContentValues values = new ContentValues();
        values.put(FeedEntry.COLUMN_NAME_TITLE,title);
        values.put(FeedEntry.COLUMN_NAME_SUBTITLE,subtitle);
        database.insert(FeedEntry.TABLE_NAME,null,values);
    }

    /**
     * this will return pointer to the dataset containing all the rows
     * @return
     */
    public Cursor readRows(){
        return database.query(FeedEntry.TABLE_NAME,null,null,null,null,null,null);
       // database.execSQL("select * from entry");
    }

    public String readRow(){
        Cursor cursor = database.query(FeedEntry.TABLE_NAME,
                null,null,null,
                null,null,null);
        cursor.moveToLast();
        int titleIndex = cursor.getColumnIndexOrThrow(FeedEntry.COLUMN_NAME_TITLE); //1= index of title
        int subtitleIndex = cursor.getColumnIndexOrThrow(FeedEntry.COLUMN_NAME_SUBTITLE); //2

        String title = cursor.getString(titleIndex);
        String subtitle = cursor.getString(subtitleIndex);

        return  title +"\n"+ subtitle;
    }
    public void updateRow(){}
    public void deleteRow(){}

    public void createRow(Note note) {
        ContentValues values = new ContentValues();
        values.put(FeedEntry.COLUMN_NAME_TITLE,note.getTitle());
        values.put(FeedEntry.COLUMN_NAME_SUBTITLE,note.getSubTitle());
        database.insert(FeedEntry.TABLE_NAME,null,values);
    }
}
