package com.francoborzi.modulos.ejercicio2502;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {
        DrDolittle doctor = new DrDolittle();

        Perro perro = new Perro("Dana");
        Gato gato = new Gato("Jack");
        Lechuza lechuza = new Lechuza("Hedwig");

        System.out.println("--- hacerHablar (solo animales) ---");
        doctor.hacerHablar(perro);
        doctor.hacerHablar(gato);
        doctor.hacerHablar(lechuza);

        System.out.println("--- hacerHablar2 (cualquier sonido) ---");

        /* Version anterior con array, reemplazada por ArrayList:
        Hablador[] habladores = {
                perro,
                gato,
                lechuza,
                new Persona("Kenya"),
                new Alarma(),
                new RelojCucu()
        };
        */

        List<Hablador> habladores = new ArrayList<>();
        habladores.add(lechuza);
        habladores.add(perro);
        habladores.add(gato);
        habladores.add(new Persona("Kenya"));
        habladores.add(new Alarma());
        habladores.add(new RelojCucu());

        for (Hablador hablador : habladores) {
            doctor.hacerHablar2(hablador);
        }
    }
}