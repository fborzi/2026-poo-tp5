package com.francoborzi.modulos.ejercicio2506;

public class Main {

    public static void main(String[] args) {

        // Creamos una persona
        Persona persona = new Persona("Sofia", "Bolmeni", 12345678, 39);

        // Creamos las dos cuentas
        CajaDeAhorro caja = new CajaDeAhorro(persona, 20000);

        CuentaCorriente corriente =
                new CuentaCorriente(persona, 10000);

        System.out.println("===== CAJA DE AHORRO =====");

        // Consultamos saldo inicial
        System.out.println("Saldo inicial: " + caja.consultarSaldo());

        // Realizamos un depósito
        caja.depositar(5000);
        System.out.println("Después de depositar $5000: "
                + caja.consultarSaldo());

        try {

            // Realizamos extracciones
            caja.extraer(2000);
            System.out.println("Después de extraer $2000: "
                    + caja.consultarSaldo());

            caja.extraer(3000);
            System.out.println("Después de extraer $3000: "
                    + caja.consultarSaldo());

            caja.extraer(1000);
            System.out.println("Después de extraer $1000: "
                    + caja.consultarSaldo());

            caja.extraer(500);
            System.out.println("Después de extraer $500: "
                    + caja.consultarSaldo());

            caja.extraer(500);
            System.out.println("Después de extraer $500: "
                    + caja.consultarSaldo());

            // Sexta extracción: debe lanzar excepción
            caja.extraer(100);

        } catch (SuperaLimiteMinimoException |
                 SuperaCantidadExtraccionesException e) {

            System.out.println("ERROR: " + e.getMessage());
        }

        // Reseteamos las extracciones
        System.out.println("\nReseteando extracciones...");
        caja.resetearExtracciones();

        try {
            caja.extraer(1000);
            System.out.println("Extracción después del reseteo: "
                    + caja.consultarSaldo());

        } catch (SuperaLimiteMinimoException |
                 SuperaCantidadExtraccionesException e) {

            System.out.println("ERROR: " + e.getMessage());
        }

        // Probamos superar el límite mínimo de la caja
        try {
            caja.extraer(50000);

        } catch (SuperaLimiteMinimoException |
                 SuperaCantidadExtraccionesException e) {

            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("\n===== CUENTA CORRIENTE =====");

        System.out.println("Saldo inicial: "
                + corriente.consultarSaldo());

        // Depositamos dinero
        corriente.depositar(5000);
        System.out.println("Después de depositar $5000: "
                + corriente.consultarSaldo());

        try {

            // Permitimos que el saldo quede negativo
            corriente.extraer(12000);
            System.out.println("Después de extraer $12000: "
                    + corriente.consultarSaldo());

            corriente.extraer(20000);

        } catch (SuperaLimiteMinimoException |
                 SuperaCantidadExtraccionesException e) {

            System.out.println("ERROR: " + e.getMessage());
        }

        // Probamos consultar nuevamente
        System.out.println("\nSaldo final caja de ahorro: "
                + caja.consultarSaldo());

        System.out.println("Saldo final cuenta corriente: "
                + corriente.consultarSaldo());

    }
}