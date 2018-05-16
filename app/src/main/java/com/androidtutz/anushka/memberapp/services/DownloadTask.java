package com.androidtutz.anushka.memberapp.services;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.inject.Inject;

public class DownloadTask extends AsyncTask<String, Void, String>{

    @Inject
    public DownloadTask() {
    }

    /*
    in our Actvity we call downloadTask.execute(String1, String2, String3)
    We send as many strings as necessary thanks to varags variable = String... strings
    Parameter 1 = String and it is in doInBackground(parameter 1)
    Parameter 3 = Return type of doInBackground(Parameter 1)
    Parameter 2 = While in progress value, ie a clock or counter or progress bar.
     */
    @Override
    protected String doInBackground(String... urls) {
        String result = "";
        URL url;//like a string but not. It's a url.

        /*
        HttpURLConnection is like a browser and we open it to see our URL
         */
        HttpURLConnection urlConnection = null;

        try {
            url = new URL(urls[0]);
            //load our urlConnection Browser with our url
            urlConnection = (HttpURLConnection)url.openConnection();
            //the load stream to hold the input of data.
            InputStream in = urlConnection.getInputStream();
            //our reader to read the input from the input stream
            //input stream is read one character ata time
            InputStreamReader reader = new InputStreamReader(in);
            //data will represent a character.
            //its placed in a while loop to read the entire url info in the stream
            int data = reader.read();

            while(data != -1){
                char current = (char)data;
                //our string result is a collection of characters
                result += current;
                //data moves on to the next character
                data = reader.read();
            }
            //result is returned back to the original task and then printed out.
            return result;

        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "Failed";
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed";
        }
        /*
        When do in progress is done
        parameter 3 = result is returned back to the activity that called it
         */
    }
}
