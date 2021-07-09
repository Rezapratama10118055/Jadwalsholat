package com.example.jadwalsholat;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jadwalsholat.model.alquran;
import com.example.jadwalsholat.model.sholat;

import java.io.IOException;
import java.util.List;

public class AdapterAlquran extends RecyclerView.Adapter<AdapterAlquran.ViewHolder> {
    private List<alquran> contacts;
    private Context context;

    public AdapterAlquran(){

    }

    public void setData(List<alquran>contacts){
        this.contacts = contacts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AdapterAlquran.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.alquran, parent, false);
        return new AdapterAlquran.ViewHolder(V);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        alquran alquran = contacts.get(position);
        String nama2 = alquran.getName();
        String arabic2 = alquran.getNameTranslations().getAr();
        String terjemah2 = alquran.getRecitation();
        holder.nama2.setText(nama2);
        holder.arabic2.setText(arabic2);
       holder.terjemahan2.setText(terjemah2);





    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nama2, arabic2, terjemahan2,stop,play;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nama2 = itemView.findViewById(R.id.nama2);
            arabic2 =itemView.findViewById(R.id.arabic2);
            terjemahan2 = itemView.findViewById(R.id.terjemahan2);

        }
    }
}
