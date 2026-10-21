package com.francoborzi.modulos.ejercicio2503;

public class Main {
    static void main() {
        Cooperativa cooperativa = new Cooperativa("Coop. Rojas Unida");

        cooperativa.agregarChofer(new Chofer("Gisela Acosta", "30111222",
                new Colectivo("AB123CD", "Mercedes-Benz OF 1418", 20)));
        cooperativa.agregarChofer(new Chofer("Brisa Morales", "32444555",
                new Colectivo("AC456EF", "Agrale MT 15", 40)));
        cooperativa.agregarChofer(new Chofer("Kenya Contreras", "28777888",
                new Colectivo("AD789GH", "Volvo B270F", 60)));

        System.out.println("Viaje 15 pasajeros, 100 km -> "
                + cooperativa.realizarViaje(15, 100.0));
        System.out.println("Viaje 35 pasajeros, 250 km -> "
                + cooperativa.realizarViaje(35, 250.0));
        System.out.println("Viaje 55 pasajeros, 80 km -> "
                + cooperativa.realizarViaje(55, 80.0));
        System.out.println("Viaje 10 pasajeros, 50 km -> "
                + cooperativa.realizarViaje(10, 50.0));
        System.out.println("Viaje 70 pasajeros, 30 km -> "
                + cooperativa.realizarViaje(70, 30.0));

        System.out.println("Mayor kilometraje: "
                + cooperativa.mostrarColectivoConMayorKilometraje());
    }
}