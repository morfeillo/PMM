package com.example.raul.examenandroid;

/**
 * Created by raul on 29/01/2015.
 */
public class Zona {
    protected String zona;
    protected String region;
    protected int precio;

    public Zona(String zona, String region, int precio) {
        this.zona = zona;
        this.region = region;
        this.precio = precio;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}