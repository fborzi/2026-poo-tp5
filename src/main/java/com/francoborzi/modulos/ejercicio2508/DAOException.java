package com.francoborzi.modulos.ejercicio2508;

package exception;

public class DAOException extends Exception {

    public DAOException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
