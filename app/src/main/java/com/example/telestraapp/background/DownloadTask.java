package com.example.telestraapp.background;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

public class DownloadTask extends AsyncTask<String,Integer,Void> { //inputtype, progresstype, resulttype
    ProgressBar mProgressBar;
    public static String TAG = DownloadTask.class.getSimpleName();
    public DownloadTask(ProgressBar progressBar) {
        mProgressBar = progressBar;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mProgressBar.setVisibility(View.VISIBLE);
    }

    /**
     * all that you write in this method will execute on a seperate  bg thread
     * @param strings
     * @return
     */
    @Override
    protected Void doInBackground(String... strings) {
        Log.i(TAG,strings[0]);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
       // mProgressBar.setVisibility(View.INVISIBLE);
    }
}
