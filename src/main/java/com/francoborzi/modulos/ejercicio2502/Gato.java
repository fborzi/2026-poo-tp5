
package com.francoborzi.modulos.ejercicio2502;

/**
 * Representa un gato.
 */
public class Gato extends Animal {

    /**
     * Construye un gato.
     *
     * @param nombre nombre del gato
     */
    public Gato(String nombre) {
        super(nombre);
    }

    /**
     * Emite el sonido del gato.
     */
    @Override
    public void hacerSonido() {
        System.out.println(getNombre() + ": Miau");
    }
}
