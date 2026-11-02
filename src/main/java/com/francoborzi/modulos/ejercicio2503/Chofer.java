package com.francoborzi.modulos.ejercicio2503;

public class Chofer {

    private String nombre;
    private Colectivo colectivo;

    public Chofer(String nombre, Colectivo colectivo) {
        this.nombre = nombre;
        this.colectivo = colectivo;
    }

    public String getNombre() {
        return nombre;
    }

    public Colectivo getColectivo() {
        return colectivo;
    }
}