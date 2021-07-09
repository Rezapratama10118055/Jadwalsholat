package com.example.jadwalsholat.model;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NameTranslations {

    @SerializedName("ar")
    @Expose
    private String ar;
    @SerializedName("en")
    @Expose
    private String en;
    @SerializedName("id")
    @Expose
    private String id;

    public String getAr() {
        return ar;
    }

    public void setAr(String ar) {
        this.ar = ar;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}