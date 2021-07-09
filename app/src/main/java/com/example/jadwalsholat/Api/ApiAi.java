package com.example.jadwalsholat.Api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiAi {

    public static Retrofit getApiAlquran(){
        HttpLoggingInterceptor httpLoggingInterception = new HttpLoggingInterceptor();
        httpLoggingInterception.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterception).build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit;


    }
    public static ApiService getDataAlquran(){
        ApiService apiService = getApiAlquran().create(ApiService.class);
        return apiService;
    }

}
