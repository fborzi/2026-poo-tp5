package com.francoborzi.modulos.ejercicio2502;

public class Main {
    static void main() {
        Gato gato1 = new Gato();
        gato1.hacerSonido();
        Perro perro1 = new Perro();
        perro1.hacerSonido();
        Alarma alarma1 = new Alarma();
        RelojCucu cucu1 = new RelojCucu();

        DrDolittle dolittle = new DrDolittle();
        dolittle.hacerHablar(perro1);

        dolittle.hacerHablar2(gato1);
        dolittle.hacerHablar2(alarma1);
        dolittle.hacerHablar2(perro1);
        dolittle.hacerHablar2(cucu1);
    }
}
