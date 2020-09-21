package com.example.telestraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText nameEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //inflation --- xml to memory variables

        /*Button mButton = new Button(this);
        mButton.setText("sign in");
        setContentView(mButton);*/
        nameEditText = findViewById(R.id.editTextTextPersonName); //initialised here ---

    }

    public void clickListener(View view) {
        switch (view.getId()){
            case R.id.buttonLogin:
                startHomeActivity();
                break;
            case R.id.buttonCancel:
                Intent dIntent = new Intent();
                dIntent.setAction(Intent.ACTION_DIAL);
                dIntent.setData( Uri.parse("tel:98765432"));
                startActivity(dIntent);
                break;
        }

    }

    private void startHomeActivity() {
        String name = nameEditText.getText().toString();
        Toast.makeText(this, "welcome "+name +" to android", Toast.LENGTH_SHORT).show();
        Intent hIntent = new Intent(MainActivity.this, HomeActivity.class);
        hIntent.putExtra("studentname",name);
        startActivity(hIntent);
    }


}