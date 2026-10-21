package com.francoborzi.modulos.ejercicio2504;

/**
 * Se lanza cuando la cola de trabajo no tiene trabajos para procesar.
 */
public class SinTrabajoEnColaException extends Exception {

    private String nombre;

    /**
     * Crea la excepción.
     *
     * @param nombre nombre de la cola
     */
    public SinTrabajoEnColaException(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getMessage() {
        return "La cola " + nombre + " no tiene trabajos para procesar.";
    }
}