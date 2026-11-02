package com.francoborzi.modulos.ejercicio2506;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class CuentaBancaria {

    protected double saldo;
    protected double limiteMinimo;
    protected Persona titular;
    protected LocalDate fechaApertura;
    protected ArrayList<Transaccion> transacciones;

    public CuentaBancaria(Persona titular, double saldo, double limiteMinimo) {
        this.titular = titular;
        this.saldo = saldo;
        this.limiteMinimo = limiteMinimo;
        this.fechaApertura = LocalDate.now();
        this.transacciones = new ArrayList<>();
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            transacciones.add(new Transaccion(monto, "Depósito"));
        }
    }

    public abstract void extraer(double monto)
            throws SuperaLimiteMinimoException,
            SuperaCantidadExtraccionesException;

    public double consultarSaldo() {
        return saldo;
    }

    public void resetearExtracciones() {
        // Se implementa en CajaDeAhorro.
    }
}
