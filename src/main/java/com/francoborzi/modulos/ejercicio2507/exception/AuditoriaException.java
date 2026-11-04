package com.francoborzi.modulos.ejercicio2507.exception;

/**
 * Representa un error durante el registro de auditoria.
 */
public class AuditoriaException extends Exception {

    /**
     * Construye una excepcion de auditoria.
     *
     * @param mensaje descripcion del error
     * @param causa excepcion original
     */
    public AuditoriaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
