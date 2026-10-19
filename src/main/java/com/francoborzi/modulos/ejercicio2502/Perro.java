package com.francoborzi.modulos.ejercicio2502;

/**
 * Perro que ladra.
 */
public class Perro extends Animal {

    /**
     * Crea un perro.
     *
     * @param nombre nombre del perro
     */
    public Perro(final String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido() {
        System.out.println(getNombre() + " dice: grrr !");
    }
}