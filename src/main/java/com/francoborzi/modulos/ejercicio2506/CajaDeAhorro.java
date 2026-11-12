package com.francoborzi.modulos.ejercicio2506;

/**
 * Representa una caja de ahorro que hereda de la clase
 * abstracta CuentaBancaria.
 * Permite realizar extracciones controlando que no se supere
 * el limite minimo del saldo ni la cantidad maxima de cinco
 * extracciones permitidas.
 * Registra las operaciones realizadas y permite reiniciar
 * el contador de extracciones.
 */

import java.time.LocalDate;

public class CajaDeAhorro extends CuentaBancaria {

    private int cantidadExtracciones;

    public CajaDeAhorro(Persona titular, double saldo,
                        double limiteMinimo, LocalDate fechaApertura) {
        super(titular, saldo, limiteMinimo, fechaApertura);
        this.cantidadExtracciones = 0;
    }

    @Override
    public void extraer(double monto)
            throws SuperaLimiteMinimoException,
            SuperaCantidadExtraccionesException {

        if (cantidadExtracciones >= 5) {
            throw new SuperaCantidadExtraccionesException();
        }

        if (saldo - monto < limiteMinimo) {
            throw new SuperaLimiteMinimoException();
        }

        saldo -= monto;
        cantidadExtracciones++;

        Transaccion transaccion = new Transaccion(
                LocalDate.now(), monto, "Extraccion"
        );

        registrarTransaccion(transaccion);
    }
    public void resetearExtracciones() {
        cantidadExtracciones = 0;
    }
}

