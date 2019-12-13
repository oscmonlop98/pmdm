package com.example.examenoscar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.Serializable;

public class MedioTransporte implements Serializable {


    private String tipo, modelo, precio;
    //private int precio;
    private int logo;

    public MedioTransporte(String tipo, String modelo, String precio, int logo) {
        this.tipo = tipo;
        this.modelo = modelo;
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public  int getLogo() {
        return logo;
    }


}