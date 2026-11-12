package com.francoborzi.modulos.ejercicio2507;

/**
 * Representa una excepcion personalizada relacionada con
 * los errores que pueden producirse durante el proceso
 * de auditoria.
 * Permite informar un mensaje de error y conservar
 * la causa original de la excepcion.
 */

public class AuditoriaException extends Exception {

    public AuditoriaException(String mensaje) {
        super(mensaje);
    }

    public AuditoriaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}