
package com.francoborzi.modulos.ejercicio2506;

/**
 * Indica que se alcanzo el limite de extracciones.
 */
public class SuperaCantidadExtraccionesException extends Exception {

    /**
     * Construye la excepcion.
     */
    public SuperaCantidadExtraccionesException() {
        super("Se alcanzo la cantidad maxima de extracciones.");
    }
}
