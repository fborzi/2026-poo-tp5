package com.francoborzi.modulos.ejercicio2506;

public class CajaDeAhorro extends CuentaBancaria {
    private int extraccionesRestantes;

    public CajaDeAhorro(Persona titular, double saldoInicial) {
        super(titular, saldoInicial, 0);
        this.extraccionesRestantes = 5;
    }

    @Override
    public void extraer(double monto)
            throws SuperaLimiteMinimoException,
            SuperaCantidadExtraccionesException {

        if (extraccionesRestantes <= 0) {
            throw new SuperaCantidadExtraccionesException();
        }

        super.extraer(monto);
        extraccionesRestantes--;
    }

    public void resetearExtracciones() {
        extraccionesRestantes = 5;
    }
}
