package com.francoborzi.modulos.ejercicio2504;

/**
 * Representa una excepcion que se produce cuando una cola
 * de trabajo no esta disponible.
 * Almacena el nombre de la cola y la cantidad de trabajos
 * pendientes para mostrar un mensaje de error.
 */

public class NoListaException extends Exception {
    private String nombre;
    private Long cantidadTrabajos;

    public NoListaException(String nombre, Long trabajos) {
        this.nombre = nombre;
        this.cantidadTrabajos = trabajos;
    }

    @Override
    public String getMessage() {
        return "La Cola de Trabajo: " + nombre
                + " no está disponible. Cantidad de trabajos a procesar: "
                + cantidadTrabajos;
    }
}

