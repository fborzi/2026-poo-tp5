package edu.programacion.ejercicio2506;

/**
 * Prueba las cuentas bancarias, las excepciones
 * y el registro de transacciones.
 */
public class Main2506 {

    /**
     * Ejecuta las pruebas del ejercicio.
     *
     * @param args argumentos de línea de comandos.
     */
    public static void main(String[] args) {

        edu.programacion.ejercicio2506.Persona persona = new edu.programacion.ejercicio2506.Persona(
                "Gisela",
                "Acosta",
                "12345678"
        );

        edu.programacion.ejercicio2506.CajaDeAhorro caja = new edu.programacion.ejercicio2506.CajaDeAhorro(
                persona,
                10000,
                0
        );

        edu.programacion.ejercicio2506.CuentaCorriente corriente = new edu.programacion.ejercicio2506.CuentaCorriente(
                persona,
                5000,
                -2000
        );

        System.out.println("Titular: " + persona.getNombreCompleto());

        // Prueba de depósitos y extracciones en la caja de ahorro.
        caja.depositar(2000);

        try {
            for (int i = 1; i <= 6; i++) {
                caja.extraer(500);
                System.out.println(
                        "Extracción " + i + " realizada correctamente."
                );
            }
        } catch (SuperaLimiteMinimoException
                 | edu.programacion.ejercicio2506.SuperaCantidadExtraccionesException e) {
            System.out.println("Error en caja de ahorro: " + e.getMessage());
        }

        System.out.println(
                "Saldo de caja de ahorro: $" + caja.consultarSaldo()
        );

        // Reiniciar el contador de extracciones.
        caja.resetearExtracciones();
        System.out.println("Contador de extracciones reiniciado.");

        // Prueba de la cuenta corriente.
        try {
            corriente.extraer(6000);
            System.out.println("Extracción en cuenta corriente realizada.");
        } catch (SuperaLimiteMinimoException
                 | SuperaCantidadExtraccionesException e) {
            System.out.println("Error en cuenta corriente: " + e.getMessage());
        }

        System.out.println(
                "Saldo de cuenta corriente: $" + corriente.consultarSaldo()
        );

        // Mostrar el historial de la caja de ahorro.
        System.out.println("\nTransacciones de la caja de ahorro:");

        for (Transaccion transaccion : caja.getTransacciones()) {
            System.out.println(transaccion);
        }

        System.out.println("\nTransacciones de la cuenta corriente:");

        for (Transaccion transaccion : corriente.getTransacciones()) {
            System.out.println(transaccion);
        }
    }
}