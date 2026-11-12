package com.francoborzi.modulos.ejercicio2506;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Persona persona = new Persona("Genaro", "Lobosco", "12345678");

        CajaDeAhorro caja = new CajaDeAhorro(
                persona, 10000, 0, LocalDate.now()
        );

        CuentaCorriente cuenta = new CuentaCorriente(
                persona, 20000, LocalDate.now()
        );

        caja.depositar(5000);
        System.out.println("Saldo caja de ahorro: " + caja.consultarSaldo());

        try {
            caja.extraer(3000);
            System.out.println("Extraccion realizada.");
            System.out.println("Saldo caja de ahorro: " + caja.consultarSaldo());
        } catch (SuperaLimiteMinimoException |
                 SuperaCantidadExtraccionesException e) {
            System.out.println(e.getMessage());
        }

        try {
            cuenta.extraer(30000);
            System.out.println("Extraccion realizada en cuenta corriente.");
            System.out.println("Saldo cuenta corriente: " + cuenta.consultarSaldo());
        } catch (SuperaLimiteMinimoException |
                 SuperaCantidadExtraccionesException e) {
            System.out.println(e.getMessage());
        }
    }
}