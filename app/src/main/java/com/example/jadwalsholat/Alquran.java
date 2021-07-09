package com.example.jadwalsholat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.jadwalsholat.Api.ApiAi;
import com.example.jadwalsholat.Api.ApiClient;
import com.example.jadwalsholat.Api.ApiService;
import com.example.jadwalsholat.model.alquran;
import com.example.jadwalsholat.model.surah;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Alquran extends AppCompatActivity {


    private TextView  terjemahan2, nama2, arabic2;
    private RecyclerView recyclerView2;
    private RecyclerView.Adapter Adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ApiService apiService;
    private List<alquran> alqurans;
    private FloatingActionButton stop,play;

    AdapterAlquran adapterAlquran;
    private Context a;
    MediaPlayer m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alquran);
        recyclerView2 = findViewById(R.id.recyclerView2);
        nama2 = findViewById(R.id.nama2);
        terjemahan2 = (TextView)findViewById(R.id.terjemahan2);
        arabic2 = findViewById(R.id.arabic2);
        play = findViewById(R.id.fabPlay);
        stop = findViewById(R.id.fabStop);

        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        recyclerView2.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        recyclerView2.setHasFixedSize(true);
        adapterAlquran = new AdapterAlquran();




        getAlquran();







    }
    private void getAlquran(){
        Call<List<alquran>> call = ApiAi.getDataAlquran().getAlquran();
        call.enqueue(new Callback<List<alquran>>() {
            @Override
            public void onResponse(Call<List<alquran>> call, Response<List<alquran>> response) {
                if(response.isSuccessful()){
                    Log.e("berhasil",response.body().toString());
                    List<alquran>alqurans = response.body();
                    adapterAlquran.setData(alqurans);
                    recyclerView2.setAdapter(adapterAlquran);
                    play();




                }
            }

            @Override
            public void onFailure(Call<List<alquran>> call, Throwable t) {
                Log.e("gagal",t.getLocalizedMessage());
            }
        });


    }
    public void play(){
        MediaPlayer mediaPlayer = new MediaPlayer();
        a = getApplicationContext();
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    mediaPlayer.setDataSource(alqurans.get(0).getRecitation());
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                }catch (IOException e){
                    e.printStackTrace();
                }

            }

        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                mediaPlayer.reset();
            }
        });
    }
}