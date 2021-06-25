package com.seb.whiskyapi.models;

import com.google.gson.annotations.SerializedName;

public class Destileria {
    @SerializedName("name")
    private String tvNameDesti;

    @SerializedName("slug")
    private String tvSlugDesti;

    @SerializedName("country")
    private String tvPaisDesti;

    public String getTvNameDesti() {
        return tvNameDesti;
    }

    public void setTvNameDesti(String tvNameDesti) {
        this.tvNameDesti = tvNameDesti;
    }

    public String getTvSlugDesti() {
        return tvSlugDesti;
    }

    public void setTvSlugDesti(String tvSlugDesti) {
        this.tvSlugDesti = tvSlugDesti;
    }

    public String getTvPaisDesti() {
        return tvPaisDesti;
    }

    public void setTvPaisDesti(String tvPaisDesti) {
        this.tvPaisDesti = tvPaisDesti;
    }
}