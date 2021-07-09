package com.example.jadwalsholat.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class alquran {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("name_translations")
    @Expose
    private NameTranslations nameTranslations;
    @SerializedName("number_of_ayah")
    @Expose
    private Integer numberOfAyah;
    @SerializedName("number_of_surah")
    @Expose
    private Integer numberOfSurah;
    @SerializedName("place")
    @Expose
    private String place;
    @SerializedName("recitation")
    @Expose
    private String recitation;
    @SerializedName("type")
    @Expose
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NameTranslations getNameTranslations() {
        return nameTranslations;
    }

    public void setNameTranslations(NameTranslations nameTranslations) {
        this.nameTranslations = nameTranslations;
    }

    public Integer getNumberOfAyah() {
        return numberOfAyah;
    }

    public void setNumberOfAyah(Integer numberOfAyah) {
        this.numberOfAyah = numberOfAyah;
    }

    public Integer getNumberOfSurah() {
        return numberOfSurah;
    }

    public void setNumberOfSurah(Integer numberOfSurah) {
        this.numberOfSurah = numberOfSurah;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getRecitation() {
        return recitation;
    }

    public void setRecitation(String recitation) {
        this.recitation = recitation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
