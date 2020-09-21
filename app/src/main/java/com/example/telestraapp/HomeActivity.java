package com.example.telestraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
       String mName = getIntent().getExtras().getString("studentname"); // --- getintent --- hIntent (ctrl + q for javadoc)
        TextView nameTextView = findViewById(R.id.textViewname);
        nameTextView.setText(mName);
    }
}