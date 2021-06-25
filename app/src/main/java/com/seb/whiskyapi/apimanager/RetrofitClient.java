package com.seb.whiskyapi.apimanager;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient instance = null;
    private EnlaceApi myApi;
    private RetrofitClient(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(EnlaceApi.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        myApi = retrofit.create(EnlaceApi.class);
    }

    public static synchronized RetrofitClient getInstance(){
        if(instance == null){
            instance = new RetrofitClient();
        }

        return instance;
    }

    public EnlaceApi getMyApi(){
        return myApi;
    }
}
