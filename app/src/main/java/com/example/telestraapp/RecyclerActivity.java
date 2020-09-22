package com.example.telestraapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.telestraapp.model.Location;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {
    String[] countries = new String[]{"india","usa","uk"}; //1

    List<Location> locationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        RecyclerView countriesRecyclerView = findViewById(R.id.recyclerViewCountries);//3
        createData();
        CountriesAdapter adapter = new CountriesAdapter(locationList,this);//7---10

        countriesRecyclerView.setAdapter(adapter);//17
        countriesRecyclerView.setLayoutManager(new LinearLayoutManager(this));//18
        //layout manager --- he's suppose to arrange the layout of list either horizontally or vertically or staggered
    }

    private void createData() {
        locationList = new ArrayList<>();
        locationList.add(new Location("karnataka","India"));
        locationList.add(new Location("london","uk"));
        locationList.add(new Location("new york","usa"));
        locationList.add(new Location("karnataka","India"));
        locationList.add(new Location("karnataka","India"));
        locationList.add(new Location("karnataka","India"));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.recycler_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
         super.onOptionsItemSelected(item);
         switch (item.getItemId()){
             case R.id.settings:
                 break;
             case R.id.logout:
                 Toast.makeText(this, "logging out", Toast.LENGTH_SHORT).show();
                 break;
         }
        return true;
    }
}