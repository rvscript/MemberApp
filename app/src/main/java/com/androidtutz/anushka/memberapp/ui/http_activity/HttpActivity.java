package com.androidtutz.anushka.memberapp.ui.http_activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.androidtutz.anushka.memberapp.MemberApplication;
import com.androidtutz.anushka.memberapp.R;
import com.androidtutz.anushka.memberapp.services.DownloadTask;

import java.util.concurrent.ExecutionException;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.OkHttpClient;
import timber.log.Timber;

public class HttpActivity extends AppCompatActivity {
    @BindView(R.id.tv_result)TextView textView;

    @Inject
    DownloadTask downloadTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);

        ButterKnife.bind(this);

        /*
        Dagger Call
        StaticApplication.getApplication().getActivityComponent.inject(Activity.this);
         */
        MemberApplication.getMemberApplication().getHttpActivityComponent().inject(this);

        //We are using DownloadTask dependency and injecting it into this Activity
        /*
        We want to send String data into our AsyncTask = downloadTask
        http://www.ecowebhosting.co.uk
         */
        String toSend1= "https://www.nasa.gov/";
        String toSend2= "http://www.stackoverflow.com";

        //this string gets the result and places it in String result;
        String result = null;

            try {
                result = downloadTask.execute(toSend1).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            Timber.i("Contents of URL = "+result);

    }

}
