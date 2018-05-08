package com.androidtutz.anushka.memberapp.api;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitGenerator {
    //static base url
    private static String BASE_URL = "http://api.github.com/";
    //retrofitBuilder
    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    private Retrofit retrofit = builder.build();

    //adding a logging interceptor
    private HttpLoggingInterceptor httpLoggingInterceptor =
            new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    //Client to hold interceptor. In our case "httpLoggingInterceptor"
    private OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    //The service interface class is placed in here and generated
    public <s> s createService(Class<s>serviceClass){
        if(!httpClient.interceptors().contains(httpLoggingInterceptor)){
            httpClient.addInterceptor(httpLoggingInterceptor);
            builder.client(httpClient.build());
            retrofit = builder.build();
        }
        return retrofit.create(serviceClass);
    }
    @Inject
    public RetrofitGenerator(){
        //TODO create base_url parameter for a reusable generator
    }
}
