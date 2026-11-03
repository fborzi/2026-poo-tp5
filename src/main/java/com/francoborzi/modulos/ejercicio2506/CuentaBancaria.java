package com.francoborzi.modulos.ejercicio2506;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class CuentaBancaria {
    private double saldo;
    private double limiteMinimo;
    private Persona titular;
    private LocalDate fechaApertura;
    private List<Transaccion> transacciones;

    public CuentaBancaria(Persona titular, double saldoInicial,
                          double limiteMinimo) {
        this.titular = titular;
        this.saldo = saldoInicial;
        this.limiteMinimo = limiteMinimo;
        this.fechaApertura = LocalDate.now();
        this.transacciones = new ArrayList<>();
    }

    public void depositar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException(
                    "el monto debe ser mayor que cero");
        }

        saldo += monto;
        transacciones.add(new Transaccion(monto, "deposito"));
    }

    public void extraer(double monto)
            throws SuperaLimiteMinimoException,
            SuperaCantidadExtraccionesException {

        if (monto <= 0) {
            throw new IllegalArgumentException(
                    "el monto debe ser mayor que cero");
        }

        if (saldo - monto < limiteMinimo) {
            throw new SuperaLimiteMinimoException();
        }

        saldo -= monto;
        transacciones.add(new Transaccion(monto, "extracción"));
    }

    public double consultarSaldo() {
        return saldo;
    }

    public Persona getTitular() {
        return titular;
    }

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    public List<Transaccion> getTransacciones() {
        return new ArrayList<>(transacciones);
    }
}
