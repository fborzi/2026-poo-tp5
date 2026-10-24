package com.francoborzi.modulos.ejercicio2506;

import java.time.LocalDate;

public class Main {
    static void main() {
        Persona ana = new Persona("Ana", "López", "30123456",
                LocalDate.of(1990, 3, 15));
        CajaDeAhorro caja = new CajaDeAhorro(ana, LocalDate.now());
        CuentaCorriente corriente = new CuentaCorriente(ana, LocalDate.now());

        System.out.println("--- Caja de ahorro: 6 extracciones de $1000 ---");
        caja.depositar(10000);
        try {
            for (int i = 1; i <= 6; i++) {
                caja.extraer(1000);
                System.out.println("Extracción " + i + " OK. Saldo: $"
                        + caja.consultarSaldo());
            }
        } catch (SuperaLimiteMinimoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (SuperaCantidadExtraccionesException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("--- Caja de ahorro: reseteo y extraigo más que el saldo ---");
        caja.resetearExtracciones();
        try {
            caja.extraer(8000);
        } catch (SuperaLimiteMinimoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (SuperaCantidadExtraccionesException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("--- Cuenta corriente: uso del descubierto ---");
        corriente.depositar(1000);
        try {
            corriente.extraer(15000);
            System.out.println("Extracción OK. Saldo: $" + corriente.consultarSaldo());
            corriente.extraer(2000);
        } catch (SuperaLimiteMinimoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (SuperaCantidadExtraccionesException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("--- Estado final ---");
        System.out.println(caja);
        for (Transaccion transaccion : caja.getTransacciones()) {
            System.out.println("  " + transaccion);
        }
        System.out.println(corriente);
        for (Transaccion transaccion : corriente.getTransacciones()) {
            System.out.println("  " + transaccion);
        }
    }
}