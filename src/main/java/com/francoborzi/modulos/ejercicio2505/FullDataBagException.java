
package com.francoborzi.modulos.ejercicio2505;

/**
 * Excepcion lanzada cuando la bolsa esta llena.
 */
public class FullDataBagException extends Exception {

    /**
     * Construye la excepcion de bolsa llena.
     */
    public FullDataBagException() {
        super("La bolsa esta llena. No se pueden agregar mas elementos.");
    }
}
