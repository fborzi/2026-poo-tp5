
package com.francoborzi.modulos.ejercicio2508.exception;

/**
 * Encapsula errores de acceso a datos.
 */
public class DAOException extends Exception {

    /**
     * Construye una excepcion de persistencia.
     *
     * @param mensaje descripcion del problema
     * @param causa error original
     */
    public DAOException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
