package com.francoborzi.modulos.ejercicio2506;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class CuentaBancaria {

    protected double saldo;
    protected double limiteMinimo;
    protected Persona titular;
    protected LocalDate fechaApertura;
    protected ArrayList<Transaccion> transacciones;

    public CuentaBancaria(Persona titular,
                          double saldo,
                          double limiteMinimo) {

        this.titular = titular;
        this.saldo = saldo;
        this.limiteMinimo = limiteMinimo;
        this.fechaApertura = LocalDate.now();
        this.transacciones = new ArrayList<>();
    }

    // Depositar dinero
    public void depositar(double monto) {

        if (monto <= 0) {
            throw new IllegalArgumentException(
                    "El monto debe ser mayor a cero."
            );
        }

        saldo += monto;

        transacciones.add(
                new Transaccion(monto, TipoTransaccion.DEPOSITO)
        );

        System.out.println("Depósito realizado: $" + monto);
    }

    // Extraer dinero
    public void extraer(double monto)
            throws SuperaLimiteMinimoException,
            SuperaCantidadExtraccionesException {

        if (monto <= 0) {
            throw new IllegalArgumentException(
                    "El monto debe ser mayor a cero."
            );
        }

        if (saldo - monto < limiteMinimo) {
            throw new SuperaLimiteMinimoException(
                    "La extracción supera el límite mínimo permitido."
            );
        }

        validarCantidadExtracciones();

        saldo -= monto;

        transacciones.add(
                new Transaccion(monto, TipoTransaccion.EXTRACCION)
        );

        registrarExtraccionExitosa();

        System.out.println("Extracción realizada: $" + monto);
    }

    // Métodos que pueden redefinir las subclases
    protected void validarCantidadExtracciones()
            throws SuperaCantidadExtraccionesException {
    }

    protected void registrarExtraccionExitosa() {
    }

    // Consultar saldo
    public double consultarSaldo() {
        return saldo;
    }

    // Consultar titular
    public Persona getTitular() {
        return titular;
    }

    // Consultar fecha de apertura
    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    // Consultar historial de transacciones
    public ArrayList<Transaccion> getTransacciones() {
        return new ArrayList<>(transacciones);
    }

    public void mostrarTransacciones() {

        System.out.println("\nHistorial de transacciones:");

        for (Transaccion transaccion : transacciones) {
            System.out.println(transaccion);
        }
    }
}