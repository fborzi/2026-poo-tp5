package com.francoborzi.modulos.ejercicio2506;

public class CuentaCorriente extends CuentaBancaria {

    public CuentaCorriente(Double saldoInicial, Persona titular) {
        super(saldoInicial, -15000.0, titular);
    }

    @Override
    public void extraer(Double monto) {
        if (this.saldo - monto >= this.limiteMinimo) {
            this.saldo = saldo - monto;
            System.out.println("Retirado de Cuenta Corriente. Saldo actual: " + this.saldo);
        } else {
            System.out.println("Error: Operación rechazada. Supera el límite de descubierto de " + this.limiteMinimo);
        }
    }


}

