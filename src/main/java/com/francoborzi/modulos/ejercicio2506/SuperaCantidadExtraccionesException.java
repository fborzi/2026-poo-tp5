package com.francoborzi.modulos.ejercicio2506;

/**
 * Se lanza cuando se supera la cantidad máxima de extracciones permitidas.
 */
public class SuperaCantidadExtraccionesException extends Exception {

    private int maximoExtracciones;

    /**
     * Crea la excepción.
     *
     * @param maximoExtracciones cantidad máxima de extracciones permitidas
     */
    public SuperaCantidadExtraccionesException(int maximoExtracciones) {
        this.maximoExtracciones = maximoExtracciones;
    }

    @Override
    public String getMessage() {
        return "Se alcanzó el máximo de " + maximoExtracciones
                + " extracciones. Debe resetearse para volver a extraer.";
    }
}