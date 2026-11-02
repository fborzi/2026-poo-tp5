package com.francoborzi.modulos.ejercicio2506;

public class CuentaCorriente extends CuentaBancaria {

    public CuentaCorriente(Persona titular, double saldo) {
        super(titular, saldo, -15000);
    }

    @Override
    public void extraer(double monto)
            throws SuperaLimiteMinimoException,
            SuperaCantidadExtraccionesException {

        if (monto <= 0 || saldo - monto < limiteMinimo) {
            throw new SuperaLimiteMinimoException(
                    "Supera el límite mínimo permitido."
            );
        }

        saldo -= monto;

        transacciones.add(new Transaccion(monto, "Extracción"));
    }
}
