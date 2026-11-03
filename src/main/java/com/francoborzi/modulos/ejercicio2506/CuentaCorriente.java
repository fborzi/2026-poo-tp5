package com.francoborzi.modulos.ejercicio2506;

public class CuentaCorriente extends CuentaBancaria {
    public CuentaCorriente(Persona titular, double saldoInicial) {
        super(titular, saldoInicial, -15000);
    }
}
