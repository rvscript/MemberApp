package com.androidtutz.anushka.memberapp.di;

import com.androidtutz.anushka.memberapp.model.member_model.MemberDataManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MemberDataModule {

    @Singleton
    @Provides
    MemberDataManager provideMemberDataManager(){
        return new MemberDataManager();
    }
}
