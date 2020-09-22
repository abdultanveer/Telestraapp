package com.example.telestraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = HomeActivity.class.getSimpleName() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.i(TAG,"home activiy started");
       String mName = getIntent().getExtras().getString("studentname"); // --- getintent --- hIntent (ctrl + q for javadoc)
        TextView nameTextView = findViewById(R.id.textViewname);
        nameTextView.setText(mName);
    }
}