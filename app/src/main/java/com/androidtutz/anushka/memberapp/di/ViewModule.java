package com.androidtutz.anushka.memberapp.di;

import com.androidtutz.anushka.memberapp.ui.json_api_activity.JsonAdapterView;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class ViewModule {

    @Singleton
    @Provides
    public JsonAdapterView providesJsonAdapterView(){
        return new JsonAdapterView();
    }
}
