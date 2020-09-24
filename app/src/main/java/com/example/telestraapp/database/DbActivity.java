package com.example.telestraapp.database;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;


import com.example.telestraapp.R;

public class DbActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    public static final int COOLIE_ID = 123;
    Bundle instructions;
    private static final String TAG = DbActivity.class.getSimpleName();
    EditText titleET,subtitleET;
    ListView dbListView;
    LoaderManager loaderManager; //manage coolies
    CursorAdapter adapter;
Dao dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        titleET = findViewById(R.id.titleEdittext);
        subtitleET = findViewById(R.id.subtitleedittext);
        dao = new Dao(this);
        dao.openDb();
        loaderManager = getSupportLoaderManager(); // supporting previous versions of android
        loaderManager.initLoader(COOLIE_ID,instructions,this);

        //FeedReaderContract.FeedEntry.TABLE_NAME;
        dbListView = findViewById(R.id.dblist);
       /* Cursor dataCursor =  dao.readRows();
        Cursor cursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,null, null, null, null);
        */
       // Cursor cursor = getContentResolver().query(uriSms, null,null,null,null);

       // Log.i(TAG,"messagebody="+c.getString(c.getColumnIndexOrThrow("body"))+uriSms.toString());
         adapter = new SimpleCursorAdapter(DbActivity.this,
                android.R.layout.simple_list_item_1,  //layout
                null, //data
                new String[]{"body"},
                        //ContactsContract.Contacts.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER},
                        //FeedEntry.COLUMN_NAME_TITLE,FeedEntry.COLUMN_NAME_SUBTITLE},// from column names
                new int[]{android.R.id.text1}); ///to these 2 textviews

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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(this, "back pressed", Toast.LENGTH_SHORT).show();
    }

    @NonNull
    @Override  //when coolie gets hired
    public Loader<Cursor> onCreateLoader(int coolieid, @Nullable Bundle instructs) {
        Uri uriSms = Uri.parse("content://sms/inbox");  //telling the coolie location of warehouse

       // return new CursorLoader(this,uriSms,null,null,null,null);
        return new CursorLoader(this,uriSms,null,null,null,null);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor goods) {
        adapter.swapCursor(goods);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {

    }




}