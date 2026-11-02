package com.francoborzi.modulos.ejercicio2506;

public class CajaDeAhorro extends CuentaBancaria {

    private int extraccionesDisponibles;

    public CajaDeAhorro(Persona titular, double saldo) {
        super(titular, saldo, 0);
        this.extraccionesDisponibles = 5;
    }

    @Override
    public void extraer(double monto)
            throws SuperaLimiteMinimoException,
            SuperaCantidadExtraccionesException {

        if (extraccionesDisponibles <= 0) {
            throw new SuperaCantidadExtraccionesException(
                    "Superó la cantidad de extracciones permitidas."
            );
        }

        if (monto <= 0 || saldo - monto < limiteMinimo) {
            throw new SuperaLimiteMinimoException(
                    "No puede realizar la extracción."
            );
        }

        saldo -= monto;
        extraccionesDisponibles--;

        transacciones.add(new Transaccion(monto, "Extracción"));
    }

    @Override
    public void resetearExtracciones() {
        extraccionesDisponibles = 5;
    }
}
