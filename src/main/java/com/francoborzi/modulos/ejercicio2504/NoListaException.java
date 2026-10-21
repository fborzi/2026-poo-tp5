package com.francoborzi.modulos.ejercicio2504;

/**
 * Se lanza cuando la cola de trabajo no está lista para entregar trabajos.
 */
public class NoListaException extends Exception {

    private String nombre;
    private Long cantidadTrabajos;

    /**
     * Crea la excepción.
     *
     * @param nombre nombre de la cola
     * @param trabajos cantidad de trabajos pendientes en la cola
     */
    public NoListaException(String nombre, Long trabajos) {
        this.nombre = nombre;
        this.cantidadTrabajos = trabajos;
    }

    @Override
    public String getMessage() {
        return "La Cola de Trabajo: " + nombre
                + " no está disponible. Cantidad de trabajos a procesar : "
                + cantidadTrabajos;
    }
}