package com.francoborzi.modulos.ejercicio2508.exception;

public class DAOException extends RuntimeException {

    public DAOException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}