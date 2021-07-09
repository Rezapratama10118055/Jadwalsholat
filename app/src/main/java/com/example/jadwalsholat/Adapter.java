package com.example.jadwalsholat;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jadwalsholat.model.surah;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<surah> contacts;
    private Context context;


//    public Adapter(List<surah> contacts, Context context) {
//        this.contacts = contacts;
//        this.context = context;
//    }

    public Adapter() {

    }

    public void setData(List<surah>contacts){
        this.contacts = contacts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       context = parent.getContext();
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new ViewHolder(V);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        surah surah = contacts.get(position);
         String nama = surah.getName();
         String arabic =surah.getArabic();
         String terjemah = surah.getTerjemahan();
        holder.nama.setText(nama);
        holder.arabic.setText(arabic);
        holder.terjemahan.setText(terjemah);



    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nama, arabic, terjemahan;
        private LinearLayout ListItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.nama);
            arabic =itemView.findViewById(R.id.arabic);
            terjemahan = itemView.findViewById(R.id.terjemahan);
        }
    }

}