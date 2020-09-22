package com.example.telestraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.telestraapp.overide.Gst;
import com.example.telestraapp.staticdemo.Student;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName() ; //"MainActivity"
    EditText nameEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //inflation --- xml to memory variables
        Log.i(TAG,"mainactivity created");
        /*Button mButton = new Button(this);
        mButton.setText("sign in");
        setContentView(mButton);*/
        nameEditText = findViewById(R.id.editTextTextPersonName); //initialised here ---

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"mainactivity onStart");
        Gst gst = new Gst();
        gst.calculateTax(10000);

    }

    @Override
    protected void onResume() { //restore the data
        super.onResume();
        Log.i(TAG,"mainactivity onResume");

    }

    @Override
    protected void onPause() { //saving data
        super.onPause();
        Log.i(TAG,"mainactivity onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"mainactivity onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"mainactivity onDestroy");

    }

    public void clickListener(View view) {
        Log.e(TAG,"button Clicked");

        switch (view.getId()){
            case R.id.buttonLogin:
                int a = add(10,20);

                startHomeActivity();
                break;
            case R.id.buttonCancel:
                dialPhone();
                Student student = new Student();
                student.name = "abdul";
               // Student.COLLEGE_NAME;
                break;
        }

    }

    private int add(int i, int i1) {
        return  i+i1;
    }

    private void dialPhone() {
        Log.v(TAG,"dialing phone no");

        Intent dIntent = new Intent();
        dIntent.setAction(Intent.ACTION_DIAL);// implicit intent
        dIntent.setData( Uri.parse("tel:98765432"));
        startActivity(dIntent);
    }

    private void startHomeActivity() {
        Log.w(TAG,"starting home activity");

        String name = nameEditText.getText().toString();
        Toast.makeText(this, "welcome "+name +" to android", Toast.LENGTH_SHORT).show();
        Intent hIntent = new Intent(MainActivity.this, HomeActivity.class); //explicit intent
        hIntent.putExtra("studentname",name);
        startActivity(hIntent);
    }


}