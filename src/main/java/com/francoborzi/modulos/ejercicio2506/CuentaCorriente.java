package com.francoborzi.modulos.ejercicio2506;

public class CuentaCorriente extends CuentaBancaria {

    public CuentaCorriente(Persona titular, double saldo) {

        super(titular, saldo, -15000);
    }
}