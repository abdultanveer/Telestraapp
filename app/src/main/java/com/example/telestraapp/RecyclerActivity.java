package com.example.telestraapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class RecyclerActivity extends AppCompatActivity {
    String[] countries = new String[]{"india","usa","uk"}; //1

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        RecyclerView countriesRecyclerView = findViewById(R.id.recyclerViewCountries);//3

        CountriesAdapter adapter = new CountriesAdapter(countries,this);//7---10

        countriesRecyclerView.setAdapter(adapter);//17
        countriesRecyclerView.setLayoutManager(new LinearLayoutManager(this));//18
        //layout manager --- he's suppose to arrange the layout of list either horizontally or vertically or staggered
    }
}