package com.francoborzi.modulos.ejercicio2506;

/**
 * Representa una cuenta corriente que hereda de la clase
 * CuentaBancaria.
 * Establece un limite minimo de saldo de -15000 y permite
 * realizar extracciones siempre que no se supere dicho limite.
 * Registra cada extraccion realizada como una transaccion.
 */

import java.time.LocalDate;

public class CuentaCorriente extends CuentaBancaria {

    public CuentaCorriente(Persona titular, double saldo,
                           LocalDate fechaApertura) {
        super(titular, saldo, -15000, fechaApertura);
    }

    @Override
    public void extraer(double monto)
            throws SuperaLimiteMinimoException,
            SuperaCantidadExtraccionesException {

        if (saldo - monto < limiteMinimo) {
            throw new SuperaLimiteMinimoException();
        }

        saldo -= monto;

        Transaccion transaccion = new Transaccion(
                LocalDate.now(), monto, "Extracción"
        );

        registrarTransaccion(transaccion);
    }
}
