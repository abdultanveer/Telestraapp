package com.example.telestraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.telestraapp.background.DownloadTask;

public class AsyncActivity extends AppCompatActivity {
ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);
        progressBar = findViewById(R.id.progressBardownload);



    }

    public void taskClick(View view) {
        DownloadTask downloadTask = new DownloadTask(progressBar,this);
        downloadTask.execute("www.imageurltobedowloaded.com");
    }
}