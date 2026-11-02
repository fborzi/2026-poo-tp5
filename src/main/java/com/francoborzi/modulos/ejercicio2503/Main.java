package com.francoborzi.modulos.ejercicio2503;

public class Main {

    public static void main(String[] args) {

        Colectivo c1 = new Colectivo("AB123CD", "Mercedes", 30);
        Colectivo c2 = new Colectivo("EF456GH", "Scania", 45);
        Colectivo c3 = new Colectivo("IJ789KL", "Volvo", 50);

        Chofer ch1 = new Chofer("Juan", c1);
        Chofer ch2 = new Chofer("Pedro", c2);
        Chofer ch3 = new Chofer("Maria", c3);

        Cooperativa cooperativa = new Cooperativa();

        cooperativa.agregarChofer(ch1);
        cooperativa.agregarChofer(ch2);
        cooperativa.agregarChofer(ch3);

        Chofer asignado = cooperativa.realizarViaje(40, 120.0);

        if (asignado != null) {
            System.out.println("Chofer asignado: "
                    + asignado.getNombre());
        } else {
            System.out.println("No hay colectivos disponibles "
                    + "con capacidad suficiente.");
        }

        Colectivo mayor =
                cooperativa.mostrarColectivoConMayorKilometraje();

        if (mayor != null) {
            System.out.println("Colectivo con mayor kilometraje: "
                    + mayor.getPatente());

            System.out.println("Kilometraje acumulado: "
                    + mayor.getKilometraje());
        }
    }
}
