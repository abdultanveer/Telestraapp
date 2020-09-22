package com.example.telestraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener { //extends Context

    //database --- 5 columns viz name, id , age ..
    String[] countries = new String[]{"india","usa","uk"};
    private static final String TAG = HomeActivity.class.getSimpleName() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button hButton = findViewById(R.id.buttonHome);
        hButton.setOnClickListener(this);

        ListView countriesListView = findViewById(R.id.countrieslist);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,  /// layout for each row of the listview
                countries);  //data
        countriesListView.setAdapter(adapter); // putting adapter into socket

        countriesListView.setOnItemClickListener(this);

        Log.i(TAG,"home activiy started");
        if(getIntent().getExtras()!= null) {  //null safety
            String mName = getIntent().getExtras().getString("studentname"); // --- getintent --- hIntent (ctrl + q for javadoc)
            TextView nameTextView = findViewById(R.id.textViewname);
            nameTextView.setText(mName);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> data, View view, int position, long id) {
       /* switch (view.getId()){
            case R.id.countrieslist:
                break;
        }*/
        String item = (String) data.getItemAtPosition(position);
        Toast.makeText(this, item, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View v) {
        Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();

    }
}