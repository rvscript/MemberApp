package com.androidtutz.anushka.memberapp.di;

import com.androidtutz.anushka.memberapp.api.GitHubService;
import com.androidtutz.anushka.memberapp.api.RetrofitGenerator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApiModule {

    @Singleton
    @Provides
    public GitHubService providesGitHubService(RetrofitGenerator serviceGenerator){
        return serviceGenerator.createService(GitHubService.class);
    }
}
