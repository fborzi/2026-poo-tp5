package com.francoborzi.modulos.ejercicio2507.exception;

public class AuditException extends Exception {

    public AuditException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}