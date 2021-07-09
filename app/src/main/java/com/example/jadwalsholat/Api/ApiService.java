package com.example.jadwalsholat.Api;

import com.example.jadwalsholat.model.Modeljadwal;
import com.example.jadwalsholat.model.alquran;
import com.example.jadwalsholat.model.sholat;
import com.example.jadwalsholat.model.surah;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("https://muslimsalat.com/belitung.json?key=65d0d558d81723d982b2eb86cb153c29")
    Call<Modeljadwal>getJadwal();

    @GET("niatshalat")
    Call<List<surah>>getQuran();

    @GET("bacaanshalat")
    Call<List<sholat>>getSholat();

    @GET("penggguna/QuranJSON/master/quran.json")
    Call<List<alquran>>getAlquran();
}
