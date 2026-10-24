package com.francoborzi.modulos.ejercicio2506;

/**
 * Se lanza cuando una extracción dejaría el saldo por debajo del límite mínimo.
 */
public class SuperaLimiteMinimoException extends Exception {

    private double saldo;
    private double monto;
    private double limiteMinimo;

    /**
     * Crea la excepción.
     *
     * @param saldo saldo actual de la cuenta
     * @param monto monto que se intentó extraer
     * @param limiteMinimo límite mínimo de la cuenta
     */
    public SuperaLimiteMinimoException(double saldo, double monto,
                                       double limiteMinimo) {
        this.saldo = saldo;
        this.monto = monto;
        this.limiteMinimo = limiteMinimo;
    }

    @Override
    public String getMessage() {
        return "No se puede extraer $" + monto + ". Saldo actual: $" + saldo
                + ". Límite mínimo: $" + limiteMinimo;
    }
}