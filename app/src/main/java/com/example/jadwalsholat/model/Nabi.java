package com.example.jadwalsholat.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Nabi {

    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("lahir")
    @Expose
    private String lahir;
    @SerializedName("umur")
    @Expose
    private String umur;
    @SerializedName("tempat")
    @Expose
    private String tempat;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("kisah")
    @Expose
    private String kisah;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getLahir() {
        return lahir;
    }

    public void setLahir(String lahir) {
        this.lahir = lahir;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public String getTempat() {
        return tempat;
    }

    public void setTempat(String tempat) {
        this.tempat = tempat;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getKisah() {
        return kisah;
    }

    public void setKisah(String kisah) {
        this.kisah = kisah;
    }

}