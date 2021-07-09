package com.example.jadwalsholat.Api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static Retrofit getApiClient(){
        HttpLoggingInterceptor httpLoggingInterception = new HttpLoggingInterceptor();
        httpLoggingInterception.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterception).build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://islamic-api-zhirrr.vercel.app/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit;

        //        if (retrofit==null){
//            retrofit = new Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//        }
//        return retrofit;
   }
   public static ApiService getUser(){
        ApiService apiService = getApiClient().create(ApiService.class);
        return apiService;
   }

    public static Retrofit getApiSholat(){
        HttpLoggingInterceptor httpLoggingInterception = new HttpLoggingInterceptor();
        httpLoggingInterception.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterception).build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://islamic-api-zhirrr.vercel.app/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit;


    }
    public static ApiService getData(){
        ApiService apiService = getApiClient().create(ApiService.class);
        return apiService;
    }





}


