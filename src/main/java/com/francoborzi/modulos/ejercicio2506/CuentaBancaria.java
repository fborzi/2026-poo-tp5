package com.francoborzi.modulos.ejercicio2506;

/**
 * Representa una clase abstracta que sirve como base
 * para los diferentes tipos de cuentas bancarias.
 * Almacena los datos del titular, saldo, limite minimo,
 * fecha de apertura y las transacciones realizadas.
 * Permite depositar dinero, consultar el saldo y registrar
 * transacciones.
 * Establece el metodo abstracto extraer() que deben
 * implementar las clases que heredan de ella.
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class CuentaBancaria {

    private Persona titular;
    protected double saldo;
    protected double limiteMinimo;
    private LocalDate fechaApertura;
    private List<Transaccion> transacciones;

    public CuentaBancaria(Persona titular, double saldo,
                          double limiteMinimo, LocalDate fechaApertura) {
        this.titular = titular;
        this.saldo = saldo;
        this.limiteMinimo = limiteMinimo;
        this.fechaApertura = fechaApertura;
        this.transacciones = new ArrayList<>();
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;

            Transaccion transaccion = new Transaccion(
                    LocalDate.now(), monto, "Deposito"
            );

            transacciones.add(transaccion);
        }
    }

    public double consultarSaldo() {
        return saldo;
    }

    public abstract void extraer(double monto)
            throws SuperaLimiteMinimoException,
            SuperaCantidadExtraccionesException;

    protected void registrarTransaccion(Transaccion transaccion) {
        transacciones.add(transaccion);
    }

    public void deposito(double monto) {
        if (monto > 0) {
            saldo += monto;

            Transaccion transaccion = new Transaccion(
                    LocalDate.now(), monto, "Depósito"
            );

            registrarTransaccion(transaccion);
        }
    }
}
