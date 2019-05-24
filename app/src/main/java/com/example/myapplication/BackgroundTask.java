package com.example.myapplication;

import android.content.Context;
import android.os.AsyncTask;

public class BackgroundTask extends AsyncTask<Void, Void, Void> {

    Context ctx;
    public BackgroundTask(Context ctx){
        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute(){
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Void... values){
        super.onProgressUpdate(values);
    }

    @Override
    protected Void doInBackground(Void... params) {
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid){
        super.onPostExecute(aVoid);
    }
}
