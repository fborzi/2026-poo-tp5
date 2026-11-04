
package com.francoborzi.modulos.ejercicio2506;

/**
 * Indica que una extraccion supera el limite minimo de saldo.
 */
public class SuperaLimiteMinimoException extends Exception {

    /**
     * Construye la excepcion.
     */
    public SuperaLimiteMinimoException() {
        super("La extraccion supera el limite minimo de saldo permitido.");
    }
}
