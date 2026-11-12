package com.francoborzi.modulos.ejercicio2505;

/**
 * Representa una excepcion que se produce cuando se intenta
 * agregar un elemento a una bolsa que alcanzo su capacidad
 * maxima.
 * Proporciona un mensaje para informar que la bolsa esta llena.
 */

public class FullDataBagException extends Exception {

    public FullDataBagException() {
        super("la bolsa esta llena.");
    }
}
