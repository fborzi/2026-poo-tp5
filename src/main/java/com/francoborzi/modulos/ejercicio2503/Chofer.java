package com.francoborzi.modulos.ejercicio2503;

/**
 * Representa a un chofer que tiene un nombre y esta  asociado
 * a un colectivo.
 * Recibe ambos datos mediante el constructor y permite
 * consultar el nombre del chofer y el colectivo asignado.
 */

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
