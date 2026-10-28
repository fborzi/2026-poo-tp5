package edu.programacion.ejercicio2504;

/**
 * Excepción que se produce cuando se intenta obtener o ejecutar
 * un trabajo y la cola está vacía.
 */
public class SinTrabajoEnColaException extends Exception {

    /**
     * Crea una excepción con un mensaje descriptivo.
     *
     * @param mensaje descripción del motivo de la excepción
     */
    public SinTrabajoEnColaException(String mensaje) {
        super(mensaje);
    }
}