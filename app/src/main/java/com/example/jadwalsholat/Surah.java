package com.example.jadwalsholat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jadwalsholat.Api.ApiClient;
import com.example.jadwalsholat.Api.ApiService;
import com.example.jadwalsholat.Api.ApiUrl;
import com.example.jadwalsholat.model.Modeljadwal;
import com.example.jadwalsholat.model.sholat;
import com.example.jadwalsholat.model.surah;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;

public class Surah extends AppCompatActivity  {

    private TextView terjemahan, nama, arabic , terjemahan1, nama1, arabic1;
    private RecyclerView recyclerView;
    private RecyclerView recyclerView1;
    private RecyclerView.Adapter Adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ApiService apiService;
    private List<surah> surah;
    Adapter adapter;
    AdapterSholat adapterSholat;



    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView1 = findViewById(R.id.recyclerView1);


        nama = findViewById(R.id.nama);
        terjemahan = findViewById(R.id.terjemahan);
        arabic = findViewById(R.id.arabic);
        nama1 = findViewById(R.id.nama1);
        terjemahan1 = findViewById(R.id.terjemahan1);
        arabic1 = findViewById(R.id.arabic1);

//        layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        adapter = new Adapter();

        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        recyclerView1.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapterSholat = new AdapterSholat();

//        //Membuat Underline pada Setiap Item Didalam List
//        DividerItemDecoration itemDecoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
//        itemDecoration.setDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.line));
//        recyclerView.addItemDecoration(itemDecoration);


        getQuran();
        getSholat();


    }



    private void getQuran() {

        Call<List<surah>> call = ApiClient.getUser().getQuran();
        call.enqueue(new Callback<List<surah>>(){
            @Override
            public void onResponse(Call<List<surah>> call, Response<List<surah>> response) {
                if(response.isSuccessful()){
                    Log.e("berhasil",response.body().toString());
                    List<surah>surah = response.body();
                    adapter.setData(surah);
                    recyclerView.setAdapter(adapter);
                }

            }

            @Override
            public void onFailure(Call<List<surah>> call, Throwable t) {
                Log.e("gagal",t.getLocalizedMessage());
            }



       });

    }
    private void getSholat(){
        Call<List<sholat>> call = ApiClient.getData().getSholat();
        call.enqueue(new Callback<List<sholat>>() {
            @Override
            public void onResponse(Call<List<sholat>> call, Response<List<sholat>> response) {
                if(response.isSuccessful()){
                    Log.e("berhasil",response.body().toString());
                    List<sholat>sholat = response.body();
                    adapterSholat.setData(sholat);
                    recyclerView1.setAdapter(adapterSholat);
                }
            }

            @Override
            public void onFailure(Call<List<sholat>> call, Throwable t) {
                Log.e("gagal",t.getLocalizedMessage());
            }
        });
    }




}
