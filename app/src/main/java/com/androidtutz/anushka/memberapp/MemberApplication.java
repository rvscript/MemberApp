package com.androidtutz.anushka.memberapp;

import android.app.Application;

import com.androidtutz.anushka.memberapp.di.ApiModule;
import com.androidtutz.anushka.memberapp.di.HttpModule;
import com.androidtutz.anushka.memberapp.di.MemberDataModule;
import com.androidtutz.anushka.memberapp.di.ViewModule;
import com.androidtutz.anushka.memberapp.ui.http_activity.DaggerHttpActivityComponent;
import com.androidtutz.anushka.memberapp.ui.http_activity.HttpActivityComponent;
import com.androidtutz.anushka.memberapp.ui.json_api_activity.DaggerJsonApiComponent;
import com.androidtutz.anushka.memberapp.ui.json_api_activity.JsonApiComponent;
import com.androidtutz.anushka.memberapp.ui.main_activity.DaggerMainActivityComponent;
import com.androidtutz.anushka.memberapp.ui.main_activity.MainActivityComponent;

import timber.log.Timber;

public class MemberApplication extends Application{

    private static MemberApplication memberApplication;
    private MainActivityComponent mainActivityComponent;
    private JsonApiComponent jsonApiComponent;
    private HttpActivityComponent httpActivityComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        if(BuildConfig.DEBUG){
            Timber.plant(new Timber.DebugTree());
        }

        memberApplication = this;

        //generate component
        //also rebuild project to generate dagger class
        mainActivityComponent = DaggerMainActivityComponent.builder()
                .memberDataModule(new MemberDataModule())
                .build();

        /*
        generate component for JsonApiComponent
        create a JsonApiComponent field
        create a JsonApiComponent getter
        generate component and add all modules in component
         */
        jsonApiComponent = DaggerJsonApiComponent.builder()
                .apiModule(new ApiModule())
                .viewModule(new ViewModule())
                .build();

        /*
        Adding 3rd component to HttpActivity
        ea Activity should have it's own component and @scope
        for this example, we are making all @scope = @Singleton
         */
        httpActivityComponent = DaggerHttpActivityComponent.builder()
                .httpModule(new HttpModule())
                .build();

    }

    //Getter method for activities to get dagger component
    public static MemberApplication getMemberApplication() {
        return memberApplication;
    }

    //Component getters to be used in activities
    public MainActivityComponent getMainActivityComponent() {
        return this.mainActivityComponent;
    }

    public JsonApiComponent getJsonApiComponent() {
        return jsonApiComponent;
    }

    //component getter for HttpActivityComponent

    public HttpActivityComponent getHttpActivityComponent() {
        return httpActivityComponent;
    }
}
