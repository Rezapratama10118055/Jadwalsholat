package com.example.jadwalsholat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jadwalsholat.model.sholat;
import com.example.jadwalsholat.model.surah;

import java.util.List;

public class AdapterSholat extends RecyclerView.Adapter<AdapterSholat.ViewHolder> {
    private List<sholat> contacts;
    private Context context;

    public  AdapterSholat(){

    }

    public void setData(List<sholat>contacts){
        this.contacts = contacts;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.sholat_layout, parent, false);
        return new AdapterSholat.ViewHolder(V);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        sholat sholat = contacts.get(position);
        String nama1 = sholat.getName();
        String arabic1 =sholat.getArabic();
        String terjemah1 = sholat.getTerjemahan();
        holder.nama1.setText(nama1);
        holder.arabic1.setText(arabic1);
        holder.terjemahan1.setText(terjemah1);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nama1, arabic1, terjemahan1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nama1 = itemView.findViewById(R.id.nama1);
            arabic1 =itemView.findViewById(R.id.arabic1);
            terjemahan1 = itemView.findViewById(R.id.terjemahan1);
        }
    }


}
