
package com.francoborzi.modulos.ejercicio2502;

/**
 * Ejecuta el ejercicio de polimorfismo extensible.
 */
public final class Main2502 {

    private Main2502() {
    }

    /**
     * Punto de entrada del programa.
     *
     * @param args argumentos de ejecucion
     */
    public static void main(String[] args) {
        Animal perro = new Perro("Firulais");
        Animal gato = new Gato("Michi");
        Animal lechuza = new Lechuza("Hedwig");

        Hablante persona = new Persona("Lautaro");
        Hablante alarma = new Alarma();
        Hablante reloj = new RelojCucu();

        System.out.println("=== Metodo hacerHablar ===");
        DrDolittle.hacerHablar(perro);
        DrDolittle.hacerHablar(gato);
        DrDolittle.hacerHablar(lechuza);

        System.out.println();

        System.out.println("=== Metodo hacerHablar2 ===");
        DrDolittle.hacerHablar2(perro);
        DrDolittle.hacerHablar2(gato);
        DrDolittle.hacerHablar2(lechuza);
        DrDolittle.hacerHablar2(persona);
        DrDolittle.hacerHablar2(alarma);
        DrDolittle.hacerHablar2(reloj);
    }
}