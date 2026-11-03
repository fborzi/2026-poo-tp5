package com.francoborzi.modulos.ejercicio2504;

public class SinTrabajoEnColaException extends Exception {
    private String nombre;

    public SinTrabajoEnColaException(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getMessage() {
        return "la cola " + nombre
                + " no tiene trabajos para procesar";
    }
}
