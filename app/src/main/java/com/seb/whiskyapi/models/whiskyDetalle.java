package com.seb.whiskyapi.models;

import com.google.gson.annotations.SerializedName;

public class whiskyDetalle {

    @SerializedName("dt")
    private String Fecha;

    @SerializedName("winning_bid_max")
    private String pujaMaxima;

    @SerializedName("winning_bid_min")
    private String pujaMinima;

    @SerializedName("auction_trading_volume")
    private String cantidadMaxima;

    @SerializedName("auction_lots_count")
    private String CantiadaSusbastas;

    @SerializedName("auction_name")
    private String nombre;

    @SerializedName("auction_slug")
    private String codigo;

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getPujaMaxima() {
        return pujaMaxima;
    }

    public void setPujaMaxima(String pujaMaxima) {
        this.pujaMaxima = pujaMaxima;
    }

    public String getPujaMinima() {
        return pujaMinima;
    }

    public void setPujaMinima(String pujaMinima) {
        this.pujaMinima = pujaMinima;
    }

    public String getCantidadMaxima() {
        return cantidadMaxima;
    }

    public void setCantidadMaxima(String cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
    }

    public String getCantiadaSusbastas() {
        return CantiadaSusbastas;
    }

    public void setCantiadaSusbastas(String cantiadaSusbastas) { CantiadaSusbastas = cantiadaSusbastas; }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}

