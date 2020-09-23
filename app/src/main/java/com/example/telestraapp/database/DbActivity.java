package com.example.telestraapp.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.telestraapp.R;

public class DbActivity extends AppCompatActivity {
EditText titleET,subtitleET;
Dao dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        titleET = findViewById(R.id.titleEdittext);
        subtitleET = findViewById(R.id.subtitleedittext);
        dao = new Dao(this);
        dao.openDb();

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
    }
}