package com.example.jadwalsholat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.jadwalsholat.Api.ApiService;
import com.example.jadwalsholat.Api.ApiUrl;
import com.example.jadwalsholat.model.Modeljadwal;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView date,wilayah, tv_lokasi_value,tv_Fajr_value,tv_Shurooq_value,tv_dzuhur_value,tv_Ashar_value,tv_magrib_value,tv_isya_value;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Jadwal Sholat");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        tv_lokasi_value = findViewById(R.id.tv_lokasi_value);
//        tv_Fajr_value = findViewById(R.id.tv_Fajr_value);
        tv_Shurooq_value = findViewById(R.id.tv_Shurooq_value);
        tv_dzuhur_value = findViewById(R.id.tv_dzuhur_value);
        tv_Ashar_value= findViewById(R.id.tv_Ashar_value);
        tv_magrib_value= findViewById(R.id.tv_magrib_value);
        tv_isya_value= findViewById(R.id.tv_isya_value);
        wilayah = findViewById(R.id.wilayah);
        date =findViewById(R.id.date);
        fab = findViewById(R.id.fab);
        getJadwal();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getJadwal();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }


    private void getJadwal(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiUrl.URL_ROOT_HTTP).addConverterFactory(GsonConverterFactory.create()).build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<Modeljadwal> call = apiService.getJadwal();

        call.enqueue(new Callback<Modeljadwal>() {
            @Override
            public void onResponse(Call<Modeljadwal> call, Response<Modeljadwal> response) {
                if(response.isSuccessful()){
//                    tv_lokasi_value.setText(response.body().getQuery()+" , "+response.body().getItems().get(0).getDateFor());
//                    tv_Fajr_value.setText(response.body().getItems().get(0).getFajr());
                    wilayah .setText("Untuk Wilayah :"+response.body().getAddress()+" Dan Sekitarnya ");
                    tv_Shurooq_value .setText(response.body().getItems().get(0).getFajr());
                    tv_dzuhur_value .setText(response.body().getItems().get(0).getDhuhr());
                    tv_Ashar_value.setText(response.body().getItems().get(0).getAsr());
                    tv_magrib_value.setText(response.body().getItems().get(0).getMaghrib());
                    tv_isya_value.setText(response.body().getItems().get(0).getIsha());
                    date.setText("Tanggal : "+response.body().getItems().get(0).getDateFor());

                }else{

                }
            }

            @Override
            public void onFailure(Call<Modeljadwal> call, Throwable t) {

            }
        });
    }
}