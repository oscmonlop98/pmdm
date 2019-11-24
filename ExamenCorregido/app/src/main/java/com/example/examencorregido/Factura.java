package com.example.examencorregido;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.Serializable;

public class Factura implements Serializable {

    private MedioTransporte[] medio;
    private int dias;
    private float extras;
    private boolean seguro;

    public Factura(MedioTransporte[] medio, int dias, float extras, boolean seguro) {
        this.medio = medio;
        this.dias = dias;
        this.extras = extras;
        this.seguro = seguro;
    }

    public MedioTransporte[] getMedio() {
        return medio;
    }

    public void setMedio(MedioTransporte[] medio) {
        this.medio = medio;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public float getExtras() {
        return extras;
    }

    public void setExtras(float extras) {
        this.extras = extras;
    }

    public boolean getSeguro() {
        return seguro;
    }

    public void setSeguro(boolean seguro) {
        this.seguro = seguro;
    }

    public float calcularTotal() {
        float precioTotal = Float.parseFloat(medio[0].getPrecio()) + dias;
        precioTotal += extras;
        if (seguro) {
            precioTotal += precioTotal * 0.2f;
        }
        return precioTotal;
    }
}
