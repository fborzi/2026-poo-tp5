
package com.francoborzi.modulos.ejercicio2506;

import java.time.LocalDate;

/**
 * Ejecuta las pruebas de cuentas bancarias.
 */
public final class Main2506 {

    private Main2506() {
    }

    /**
     * Punto de entrada del ejercicio.
     *
     * @param args argumentos de ejecucion
     */
    public static void main(String[] args) {
        Persona titular = new Persona(
                "Lautaro", "Tamola", "12345678");

        CajaDeAhorro ahorro = new CajaDeAhorro(
                titular, LocalDate.now());

        CuentaCorriente corriente = new CuentaCorriente(
                titular, LocalDate.now());

        ahorro.depositar(10000);
        corriente.depositar(5000);

        System.out.println("=== Caja de ahorro ===");

        try {
            for (int indice = 0; indice < 5; indice++) {
                ahorro.extraer(1000);
            }

            System.out.println("Saldo: $" + ahorro.consultarSaldo());
            System.out.println("Extracciones: "
                    + ahorro.getExtraccionesRealizadas());

            ahorro.extraer(500);

        } catch (SuperaLimiteMinimoException
                 | SuperaCantidadExtraccionesException excepcion) {
            System.out.println(excepcion.getMessage());
        }

        ahorro.resetearExtracciones();

        System.out.println("Extracciones despues del reinicio: "
                + ahorro.getExtraccionesRealizadas());

        try {
            ahorro.extraer(6000);
        } catch (SuperaLimiteMinimoException
                 | SuperaCantidadExtraccionesException excepcion) {
            System.out.println(excepcion.getMessage());
        }

        System.out.println();
        System.out.println("=== Cuenta corriente ===");

        try {
            corriente.extraer(18000);
            System.out.println("Saldo: $" + corriente.consultarSaldo());

            corriente.extraer(3000);
        } catch (SuperaLimiteMinimoException
                 | SuperaCantidadExtraccionesException excepcion) {
            System.out.println(excepcion.getMessage());
        }

        System.out.println();
        System.out.println("=== Historial caja de ahorro ===");

        for (Transaccion transaccion : ahorro.getTransacciones()) {
            System.out.println(transaccion);
        }

        System.out.println();
        System.out.println("Total transacciones caja de ahorro: "
                + ahorro.getTransacciones().size());

        System.out.println("Total transacciones cuenta corriente: "
                + corriente.getTransacciones().size());
    }
}
