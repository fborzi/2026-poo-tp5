
package com.francoborzi.modulos.ejercicio2503;

/**
 * Ejecuta el sistema de cooperativa de transporte.
 */
public final class Main2503 {

    private Main2503() {
    }

    /**
     * Punto de entrada del ejercicio.
     *
     * @param args argumentos de ejecucion
     */
    public static void main(String[] args) {
        Cooperativa cooperativa =
                new Cooperativa("Transporte Unido");

        Colectivo colectivo1 =
                new Colectivo("AA123BB", "Mercedes Benz", 30);
        Colectivo colectivo2 =
                new Colectivo("AC456DE", "Iveco", 45);
        Colectivo colectivo3 =
                new Colectivo("AE789FG", "Scania", 60);

        Chofer chofer1 =
                new Chofer("Juan Perez", "11111111", colectivo1);
        Chofer chofer2 =
                new Chofer("Pedro Gomez", "22222222", colectivo2);
        Chofer chofer3 =
                new Chofer("Luis Lopez", "33333333", colectivo3);

        cooperativa.agregarChofer(chofer1);
        cooperativa.agregarChofer(chofer2);
        cooperativa.agregarChofer(chofer3);

        System.out.println("Cooperativa: "
                + cooperativa.getNombre());

        Chofer viaje1 = cooperativa.realizarViaje(25, 100.0);
        System.out.println("Viaje 1: " + viaje1);

        Chofer viaje2 = cooperativa.realizarViaje(40, 250.0);
        System.out.println("Viaje 2: " + viaje2);

        Chofer viaje3 = cooperativa.realizarViaje(55, 400.0);
        System.out.println("Viaje 3: " + viaje3);

        Chofer viaje4 = cooperativa.realizarViaje(80, 100.0);
        System.out.println("Viaje 4: " + viaje4);

        System.out.println();

        System.out.println("Kilometrajes acumulados:");
        System.out.println(colectivo1);
        System.out.println(colectivo2);
        System.out.println(colectivo3);

        System.out.println();

        System.out.println("Colectivo con mayor kilometraje:");
        System.out.println(
                cooperativa.mostrarColectivoConMayorKilometraje());
    }
}
