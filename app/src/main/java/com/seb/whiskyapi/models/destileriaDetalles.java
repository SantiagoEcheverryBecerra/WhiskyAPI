package com.seb.whiskyapi.models;

import com.google.gson.annotations.SerializedName;

public class destileriaDetalles {

    @SerializedName("dt")
    private String fecha;

    @SerializedName("winning_bid_max")
    private String pujaganadoramax;

    @SerializedName("winning_bid_min")
    private String pujaganadoraminima;

    @SerializedName("winning_bid_mean")
    private String pujaganadoramedia;

    @SerializedName("trading_volume")
    private String volumencomercio;

    @SerializedName("lots_count")
    private String conteolotes;

    @SerializedName("slug")
    private String codigo;

    @SerializedName("name")
    private String nombre;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPujaganadoramax() {
        return pujaganadoramax;
    }

    public void setPujaganadoramax(String pujaganadoramax) {
        this.pujaganadoramax = pujaganadoramax;
    }

    public String getPujaganadoraminima() {
        return pujaganadoraminima;
    }

    public void setPujaganadoraminima(String pujaganadoraminima) {
        this.pujaganadoraminima = pujaganadoraminima;
    }

    public String getPujaganadoramedia() {
        return pujaganadoramedia;
    }

    public void setPujaganadoramedia(String pujaganadoramedia) {
        this.pujaganadoramedia = pujaganadoramedia;
    }

    public String getVolumencomercio() {
        return volumencomercio;
    }

    public void setVolumencomercio(String volumencomercio) {
        this.volumencomercio = volumencomercio;
    }

    public String getConteolotes() {
        return conteolotes;
    }

    public void setConteolotes(String conteolotes) {
        this.conteolotes = conteolotes;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
