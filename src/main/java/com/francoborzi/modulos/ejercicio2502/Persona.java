
package com.francoborzi.modulos.ejercicio2502;

/**
 * Representa una persona capaz de hablar.
 */
public class Persona implements Hablante {

    private final String nombre;

    /**
     * Construye una persona.
     *
     * @param nombre nombre de la persona
     */
    public Persona(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Emite una frase.
     */
    @Override
    public void hacerSonido() {
        System.out.println(nombre + ": Hola, buen dia");
    }
}
