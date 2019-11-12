package com.example.ejerciciorecopilatorio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.Serializable;

public class Pedido implements Serializable {

    private String peso;
    private boolean urgente;
    private boolean regalo;
    private boolean tarjeta;

    public Pedido(String peso) {
        this.peso = peso;
        this.urgente = urgente;
        this.regalo = regalo;
        this.tarjeta = tarjeta;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public boolean esUrgente() {
        return urgente;
    }

    public void setUrgente(boolean urgente) {
        this.urgente = urgente;
    }

    public boolean conRegalo() {
        return regalo;
    }

    public void setRegalo(boolean regalo) {
        this.regalo = regalo;
    }

    public boolean conTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(boolean tarjeta) {
        this.tarjeta = tarjeta;
    }


}
