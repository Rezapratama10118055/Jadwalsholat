package com.example.jadwalsholat.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class sholat {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("arabic")
    @Expose
    private String arabic;
    @SerializedName("latin")
    @Expose
    private String latin;
    @SerializedName("terjemahan")
    @Expose
    private String terjemahan;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArabic() {
        return arabic;
    }

    public void setArabic(String arabic) {
        this.arabic = arabic;
    }

    public String getLatin() {
        return latin;
    }

    public void setLatin(String latin) {
        this.latin = latin;
    }

    public String getTerjemahan() {
        return terjemahan;
    }

    public void setTerjemahan(String terjemahan) {
        this.terjemahan = terjemahan;
    }

}