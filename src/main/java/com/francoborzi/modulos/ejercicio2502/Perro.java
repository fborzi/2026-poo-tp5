
package com.francoborzi.modulos.ejercicio2502;

/**
 * Representa un perro.
 */
public class Perro extends Animal {

    /**
     * Construye un perro.
     *
     * @param nombre nombre del perro
     */
    public Perro(String nombre) {
        super(nombre);
    }

    /**
     * Emite el sonido del perro.
     */
    @Override
    public void hacerSonido() {
        System.out.println(getNombre() + ": Guau guau");
    }
}
