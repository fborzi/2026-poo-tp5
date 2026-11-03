package com.francoborzi.modulos.ejercicio2504;

public class NoListaException extends Exception {
    private String nombre;
    private Long cantidadTrabajos;

    public NoListaException(String nombre, Long trabajos) {
        this.nombre = nombre;
        this.cantidadTrabajos = trabajos;
    }

    @Override
    public String getMessage() {
        return "la cola de Trabajo: " + nombre
                + " no esta disponible cantidad de trabajos a procesar: "
                + cantidadTrabajos;
    }
}
