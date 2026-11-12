package com.francoborzi.modulos.ejercicio2506;

/**
 * Representa una excepcion que se produce cuando una
 * extraccion supera el limite minimo de saldo permitido
 * en una cuenta bancaria.
 * Proporciona un mensaje para informar que la operacion
 * no puede realizarse.
 */

public class SuperaLimiteMinimoException extends Exception {

    public SuperaLimiteMinimoException() {
        super("la extraccion supera el limite minimo permitido.");
    }
}
