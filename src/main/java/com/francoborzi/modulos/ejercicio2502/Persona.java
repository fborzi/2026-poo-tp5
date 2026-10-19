package com.francoborzi.modulos.ejercicio2502;

/**
 * Persona que habla.
 */
public class Persona implements Hablador {

    private final String nombre;

    /**
     * Crea una persona.
     *
     * @param nombre nombre de la persona
     */
    public Persona(final String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return el nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }

    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: jelouuuu");
    }

    @Override
    public String toString() {
        return "Persona " + nombre;
    }
}