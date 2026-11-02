package com.francoborzi.modulos.ejercicio2505;

public class Elementos {
    private String Nombre;

    public Elementos(String nombre) {
        Nombre = nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Elementos{");
        sb.append("Nombre='").append(Nombre).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
