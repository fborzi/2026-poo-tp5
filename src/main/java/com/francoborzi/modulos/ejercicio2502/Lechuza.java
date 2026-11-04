
package com.francoborzi.modulos.ejercicio2502;

/**
 * Representa una lechuza.
 */
public class Lechuza extends Animal {

    /**
     * Construye una lechuza.
     *
     * @param nombre nombre de la lechuza
     */
    public Lechuza(String nombre) {
        super(nombre);
    }

    /**
     * Emite el sonido de la lechuza.
     */
    @Override
    public void hacerSonido() {
        System.out.println(getNombre() + ": Uhu uhu");
    }
}