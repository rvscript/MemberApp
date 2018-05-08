package com.androidtutz.anushka.memberapp.api;

import com.androidtutz.anushka.memberapp.model.github_model.GitHubRepo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubService {

    @GET("users/{user}/repos")
    Call<List<GitHubRepo>> reposFromUser(@Path("user")String username);
}
