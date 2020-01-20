package com.example.spinnerfragmento;

import java.io.Serializable;

public class Persona implements Serializable {
    private String nombre;
    private String apellido;
    private int edad;
    private int foto;

    Persona (String nombre,String apellido,int edad,int foto){
        this.nombre=nombre;
        this.apellido=apellido;
        this.edad=edad;
        this.foto=foto;
    }

    public String getNombre (){
        return nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public int getEdad(){
        return edad;
    }
    public int getFoto(){
        return foto;
    }

    public String toString(){
        String cad="";
        cad+="NOMBRE:"+ nombre+ " APELLIDO:" + apellido + " EDAD:" + edad;
        return cad;
    }

}