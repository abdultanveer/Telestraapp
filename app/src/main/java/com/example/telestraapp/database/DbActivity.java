package com.example.telestraapp.database;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import com.example.telestraapp.database.FeedReaderContract.FeedEntry;


import com.example.telestraapp.R;

public class DbActivity extends AppCompatActivity {
EditText titleET,subtitleET;
ListView dbListView;
Dao dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        titleET = findViewById(R.id.titleEdittext);
        subtitleET = findViewById(R.id.subtitleedittext);
        dao = new Dao(this);
        dao.openDb();

        dbListView = findViewById(R.id.dblist);
        Cursor dataCursor =  dao.readRows();

        CursorAdapter adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_2,  //layout
                dataCursor, //data
                new String[]{FeedEntry.COLUMN_NAME_TITLE,FeedEntry.COLUMN_NAME_SUBTITLE},// from column names
                new int[]{android.R.id.text1,android.R.id.text2}); ///to these 2 textviews

        dbListView.setAdapter(adapter);

    }

    public void handleDbClicks(View view) {
        switch (view.getId()){
            case R.id.buttonput:
                putDb();
                break;
            case R.id.buttonget:
                getDb();
                break;
        }
    }

    private void getDb() {
        String result = dao.readRow();
        TextView resultTextView = findViewById(R.id.textViewdb);
        resultTextView.setText(result);
    }

    //test case -- open db and see the data
    private void putDb() {
        String title = titleET.getText().toString();
        String subtitle = subtitleET.getText().toString();
        dao.createRow(title,subtitle);
        /*Note note = new Note(title,subtitle);
        dao.createRow(note);*/
    }
}