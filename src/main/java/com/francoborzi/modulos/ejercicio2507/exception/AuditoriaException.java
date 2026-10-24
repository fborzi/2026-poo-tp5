package com.francoborzi.modulos.ejercicio2507.exception;

/**
 * Error general al registrar un evento de auditoría.
 */
public class AuditoriaException extends Exception {

    /**
     * Crea la excepción encapsulando el error original.
     *
     * @param mensaje descripción del problema
     * @param causa excepción original que provocó el fallo
     */
    public AuditoriaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}