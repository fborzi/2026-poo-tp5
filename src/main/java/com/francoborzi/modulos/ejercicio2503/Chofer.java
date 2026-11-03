package com.francoborzi.modulos.ejercicio2503;

public class Chofer {

    private String nombre;
    private String dni;
    private Colectivo colectivo;

    public Chofer(String nombre, String dni, Colectivo colectivo) {
        this.nombre = nombre;
        this.dni = dni;
        this.colectivo = colectivo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public Colectivo getColectivo() {
        return colectivo;
    }

    @Override
    public String toString() {
        return "Chofer: " + nombre
                + " | DNI: " + dni
                + " | " + colectivo;
    }
}