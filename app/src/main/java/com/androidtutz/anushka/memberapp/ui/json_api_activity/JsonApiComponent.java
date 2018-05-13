package com.androidtutz.anushka.memberapp.ui.json_api_activity;

import com.androidtutz.anushka.memberapp.di.ApiModule;
import com.androidtutz.anushka.memberapp.di.ViewModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApiModule.class, ViewModule.class})
public interface JsonApiComponent {
    void inject(JsonApiActivity jsonApiActivity);
}
