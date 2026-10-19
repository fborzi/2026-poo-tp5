package com.francoborzi.modulos.ejercicio2502;

/**
 * Gato que maúlla.
 */
public class Gato extends Animal {

    /**
     * Crea un gato.
     *
     * @param nombre nombre del gato
     */
    public Gato(final String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido() {
        System.out.println(getNombre() + " dice: Miau dame de comer ");
    }
}