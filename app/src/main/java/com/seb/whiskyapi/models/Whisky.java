package com.seb.whiskyapi.models;

import com.google.gson.annotations.SerializedName;

public class Whisky {
    @SerializedName("name")
    private String tvName;

    @SerializedName("slug")
    private String tvSlug;

    @SerializedName("base_currency")
    private String tvMoneda;

    @SerializedName("url")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTvName() {
        return tvName;
    }

    public void setTvName(String tvName) {
        this.tvName = tvName;
    }

    public String getTvSlug() {
        return tvSlug;
    }

    public void setTvSlug(String tvSlug) {
        this.tvSlug = tvSlug;
    }

    public String getTvMoneda() {
        return tvMoneda;
    }

    public void setTvMoneda(String tvMoneda) {
        this.tvMoneda = tvMoneda;
    }
}