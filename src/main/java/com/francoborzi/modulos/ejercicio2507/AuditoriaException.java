package edu.programacion.ejercicio2507;

/**
 * Excepción personalizada para informar errores
 * durante el registro de operaciones de auditoría.
 */
public class AuditoriaException extends Exception {

    /**
     * Construye una excepción con un mensaje descriptivo.
     *
     * @param mensaje descripción del error.
     */
    public AuditoriaException(String mensaje) {
        super(mensaje);
    }

    /**
     * Construye una excepción con un mensaje y su causa original.
     *
     * @param mensaje descripción del error.
     * @param causa excepción que originó el problema.
     */
    public AuditoriaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
