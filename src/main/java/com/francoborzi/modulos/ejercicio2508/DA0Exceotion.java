package edu.programacion.ejercicio2508;

/**
 * Excepción personalizada para encapsular errores
 * producidos durante el acceso a la base de datos.
 */
public class DAOException extends Exception {

    /**
     * Construye una excepción con un mensaje.
     *
     * @param mensaje descripción del error.
     */
    public DAOException(String mensaje) {
        super(mensaje);
    }

    /**
     * Construye una excepción con un mensaje y su causa original.
     *
     * @param mensaje descripción del error.
     * @param causa excepción que originó el problema.
     */
    public DAOException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}