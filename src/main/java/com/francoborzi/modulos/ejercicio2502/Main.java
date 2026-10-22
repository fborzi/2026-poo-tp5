package com.francoborzi.modulos.ejercicio2502;

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
        Hablador[] habladores = {
                perro,
                gato,
                lechuza,
                new Persona("Kenya"),
                new Alarma(),
                new RelojCucu()
        };
        for (Hablador hablador : habladores) {
            doctor.hacerHablar2(hablador);
        }
    }
}