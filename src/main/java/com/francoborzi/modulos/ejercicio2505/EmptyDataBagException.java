
package com.francoborzi.modulos.ejercicio2505;

/**
 * Excepcion lanzada cuando la bolsa esta vacia.
 */
public class EmptyDataBagException extends Exception {

    /**
     * Construye la excepcion de bolsa vacia.
     */
    public EmptyDataBagException() {
        super("La bolsa esta vacia. No se pueden eliminar elementos.");
    }
}