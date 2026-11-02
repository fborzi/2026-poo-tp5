package edu.programacion.ejercicio2506;

/**
 * Excepción que se produce cuando se supera
 * la cantidad máxima de extracciones permitidas.
 */
public class SuperaCantidadExtraccionesException extends Exception {

    /**
     * Construye la excepción con un mensaje descriptivo.
     *
     * @param mensaje descripción del error.
     */
    public SuperaCantidadExtraccionesException(String mensaje) {
        super(mensaje);
    }
}