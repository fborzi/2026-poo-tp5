package com.francoborzi.modulos.ejercicio2502;

public class Main {
    static void main() {
        final Perro perro = new Perro("Dana");
        final Gato gato = new Gato("Jack");
        final Lechuza lechuza = new Lechuza("Hedwig");

        System.out.println("--- hacerHablar (solo animales) ---");
        DrDolittle.hacerHablar(perro);
        DrDolittle.hacerHablar(gato);
        DrDolittle.hacerHablar(lechuza);

        System.out.println("--- hacerHablar2 (cualquier sonido) ---");
        final Hablador[] habladores = {
                perro,
                gato,
                lechuza,
                new Persona("Kenya"),
                new Alarma(),
                new RelojCucu()
        };
        for (final Hablador hablador : habladores) {
            DrDolittle.hacerHablar2(hablador);
        }
    }
}