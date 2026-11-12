package com.francoborzi.modulos.ejercicio2505;

/**
 * Representa una excepcion que se produce cuando se intenta
 * eliminar un elemento de una bolsa que esta vacia.
 * Proporciona un mensaje para informar que no hay elementos
 * disponibles para eliminar.
 */

public class EmptyDataBagException extends Exception {

    public EmptyDataBagException() {
        super("la bolsa esta vacia.");
    }
}