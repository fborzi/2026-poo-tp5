package com.francoborzi.modulos.ejercicio2506;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Cuenta bancaria genérica con titular, saldo, límite mínimo y transacciones.
 */
public abstract class CuentaBancaria {

    private Persona titular;
    private LocalDate fechaApertura;
    private double saldo;
    private double limiteMinimo;
    private List<Transaccion> transacciones;

    /**
     * Crea una cuenta con saldo cero y sin transacciones.
     *
     * @param titular persona titular de la cuenta
     * @param fechaApertura fecha de apertura
     * @param limiteMinimo saldo mínimo permitido luego de una extracción
     */
    protected CuentaBancaria(Persona titular, LocalDate fechaApertura,
                             double limiteMinimo) {
        this.titular = titular;
        this.fechaApertura = fechaApertura;
        this.limiteMinimo = limiteMinimo;
        this.saldo = 0.0;
        this.transacciones = new ArrayList<>();
    }

    /**
     * Deposita dinero en la cuenta y registra la transacción.
     *
     * @param monto monto a depositar
     */
    public void depositar(double monto) {
        saldo = saldo + monto;
        registrarTransaccion(monto, TipoTransaccion.DEPOSITO);
    }

    /**
     * Extrae dinero de la cuenta y registra la transacción.
     *
     * @param monto monto a extraer
     * @throws SuperaLimiteMinimoException si el saldo quedaría debajo del límite
     * @throws SuperaCantidadExtraccionesException si se superan las extracciones
     *         permitidas (lo usan las subclases que tienen ese máximo)
     */
    public void extraer(double monto)
            throws SuperaLimiteMinimoException, SuperaCantidadExtraccionesException {
        if (saldo - monto < limiteMinimo) {
            throw new SuperaLimiteMinimoException(saldo, monto, limiteMinimo);
        }
        saldo = saldo - monto;
        registrarTransaccion(monto, TipoTransaccion.EXTRACCION);
    }

    /**
     * @return el saldo actual
     */
    public double consultarSaldo() {
        return saldo;
    }

    /**
     * @return el titular de la cuenta
     */
    public Persona getTitular() {
        return titular;
    }

    /**
     * @return la fecha de apertura
     */
    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    /**
     * @return el límite mínimo de extracción
     */
    public double getLimiteMinimo() {
        return limiteMinimo;
    }

    /**
     * @return las transacciones realizadas
     */
    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    /**
     * Guarda una transacción con la fecha actual.
     *
     * @param monto monto de la transacción
     * @param tipo tipo de transacción
     */
    private void registrarTransaccion(double monto, TipoTransaccion tipo) {
        transacciones.add(new Transaccion(LocalDate.now(), monto, tipo));
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " de " + titular
                + " - Saldo: $" + saldo;
    }
}