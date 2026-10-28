package edu.programacion.ejercicio2504;

/**
 * Excepción que se produce cuando se intenta ejecutar
 * un trabajo que todavía no está listo.
 */
public class NoListaException extends Exception {

    /**
     * Crea una excepción con un mensaje descriptivo.
     *
     * @param mensaje descripción del motivo de la excepción
     */
    public NoListaException(String mensaje) {
        super(mensaje);
    }
}