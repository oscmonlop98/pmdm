package com.example.listadoble;

import java.io.Serializable;
import java.util.ArrayList;

public class Director implements Serializable {

    private String nombre;
    private String[] peliculas;

    public Director(String nombre, String[] peliculas){
        this.nombre = nombre;
        this.peliculas = peliculas;
    }

    public String getNombre (){
        return nombre;
    }
    public String[] getPeliculas(){
        return peliculas;
    }


    public void setNombre(String nuevoNom){
        nombre=nuevoNom;
    }
    public void setPeliculas(String[] peliculas){
        this.peliculas = peliculas;
    }

}