package com.francoborzi.modulos.ejercicio2506;

import java.time.LocalDate;

/**
 * Cuenta corriente con límite mínimo de -15000 y sin máximo de extracciones.
 */
public class CuentaCorriente extends CuentaBancaria {

    /**
     * Crea una cuenta corriente con límite mínimo de -15000.
     *
     * @param titular persona titular
     * @param fechaApertura fecha de apertura
     */
    public CuentaCorriente(Persona titular, LocalDate fechaApertura) {
        super(titular, fechaApertura, -15000.0);
    }
}