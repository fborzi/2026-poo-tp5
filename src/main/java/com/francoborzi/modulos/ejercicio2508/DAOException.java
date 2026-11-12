package com.francoborzi.modulos.ejercicio2508;

/**
 * Representa una excepcion personalizada para informar
 * errores durante las operaciones de acceso a datos.
 * Permite almacenar un mensaje de error y conservar
 * la causa original de la excepcion.
 */

public class DAOException extends Exception {

    public DAOException(String mensaje) {
        super(mensaje);
    }

    public DAOException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
