package com.androidtutz.anushka.memberapp.ui.http_activity;

import com.androidtutz.anushka.memberapp.di.HttpModule;
import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = {HttpModule.class})
public interface HttpActivityComponent {
    void inject(HttpActivity httpActivity);
}
