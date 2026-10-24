package com.francoborzi.modulos.ejercicio2508.exception;

/**
 * Error en la capa de acceso a datos. Encapsula la SQLException original.
 */
public class DAOException extends Exception {

    /**
     * Crea la excepción encapsulando el error original.
     *
     * @param mensaje descripción del problema
     * @param causa excepción original de la base de datos
     */
    public DAOException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}