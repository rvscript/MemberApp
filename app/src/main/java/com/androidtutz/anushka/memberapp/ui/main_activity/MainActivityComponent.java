package com.androidtutz.anushka.memberapp.ui.main_activity;

import com.androidtutz.anushka.memberapp.di.MemberDataModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MemberDataModule.class})
public interface MainActivityComponent {
    //Classes to accept modules here
    void inject(MainActivity mainActivity);
}
