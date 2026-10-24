package com.francoborzi.modulos.ejercicio2506;

import java.time.LocalDate;

/**
 * Movimiento realizado sobre una cuenta bancaria.
 */
public class Transaccion {

    private LocalDate fecha;
    private double monto;
    private TipoTransaccion tipo;

    /**
     * Crea una transacción.
     *
     * @param fecha fecha en que se realizó
     * @param monto monto de la transacción
     * @param tipo tipo de transacción
     */
    public Transaccion(LocalDate fecha, double monto, TipoTransaccion tipo) {
        this.fecha = fecha;
        this.monto = monto;
        this.tipo = tipo;
    }

    /**
     * @return la fecha de la transacción
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * @return el monto de la transacción
     */
    public double getMonto() {
        return monto;
    }

    /**
     * @return el tipo de transacción
     */
    public TipoTransaccion getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return fecha + " - " + tipo + " - $" + monto;
    }
}