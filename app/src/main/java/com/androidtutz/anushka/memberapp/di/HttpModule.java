package com.androidtutz.anushka.memberapp.di;

import com.androidtutz.anushka.memberapp.services.DownloadTask;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class HttpModule {

    @Provides
    public DownloadTask providesHttpService(){
        return new DownloadTask();
    }
}
