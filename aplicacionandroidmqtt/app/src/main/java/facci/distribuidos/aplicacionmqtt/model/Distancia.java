package facci.distribuidos.aplicacionmqtt.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Distancia {
    @SerializedName("distancia")
    String distancia;
    @SerializedName("date")
    Date date;

    public Distancia() {
    }

    public Distancia(String distancia, Date date) {
        this.distancia = distancia;
        this.date = date;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
