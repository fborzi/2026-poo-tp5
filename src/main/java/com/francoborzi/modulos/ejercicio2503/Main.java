package com.francoborzi.modulos.ejercicio2503;

import java.util.List;

public class Main {
    static void main() {
        SistemaDeTransporte Cooperativa = new SistemaDeTransporte();

        Colectivo colectivo1 = new Colectivo("PHS123",30,"Dukati 98",25.00);
        Colectivo colectivo2 = new Colectivo("PJR223",25,"Suzukii 88",10.00);
        Colectivo colectivo3 = new Colectivo("LLS165",15,"Kati 918",10.0);

        Chofer chofer1 = new Chofer("Gaston Baldomir", colectivo3);
        Chofer chofer2 = new Chofer("Jose Nieto", colectivo1);
        Chofer chofer3 = new Chofer("Sofia Bolmeni", colectivo2);

        Cooperativa.setChoferes(chofer1);
        Cooperativa.setChoferes(chofer2);
        Cooperativa.setChoferes(chofer3);

        System.out.println(Cooperativa.realizarViaje(22, 250.25));
    }
}
