package com.francoborzi.modulos.ejercicio2503;

public class Main {
    static void main() {



        Colectivo colectivo1 = new Colectivo("ABC123", "Mercedes", 20);
        Colectivo colectivo2 = new Colectivo("DEF456", "Scania", 40);
        Colectivo colectivo3 = new Colectivo("GHI789", "Volvo", 30);

        Chofer chofer1 = new Chofer("Juan", colectivo1);
        Chofer chofer2 = new Chofer("Pedro", colectivo2);
        Chofer chofer3 = new Chofer("Maria", colectivo3);

        Cooperativa cooperativa = new Cooperativa();

        cooperativa.agregarChofer(chofer1);
        cooperativa.agregarChofer(chofer2);
        cooperativa.agregarChofer(chofer3);

        Chofer choferAsignado = cooperativa.realizarViaje(25, 100.0);

        if (choferAsignado != null) {
            System.out.println("Chofer asignado: " + choferAsignado.getNombre());
        } else {
            System.out.println("No hay colectivo disponible.");
        }

        Colectivo colectivoMayor =
                cooperativa.mostrarColectivoConMayorKilometraje();

        if (colectivoMayor != null) {
            System.out.println("Colectivo con mayor kilometraje: "
                    + colectivoMayor.getKilometrajeAcumulado());
        }
    }
}
