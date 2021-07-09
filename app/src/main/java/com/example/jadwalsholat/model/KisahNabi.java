package com.example.jadwalsholat.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KisahNabi {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("nabi")
    @Expose
    private Nabi nabi;
    @SerializedName("creator")
    @Expose
    private String creator;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Nabi getNabi() {
        return nabi;
    }

    public void setNabi(Nabi nabi) {
        this.nabi = nabi;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}