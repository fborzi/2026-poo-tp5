package com.francoborzi.modulos.ejercicio2502;

/**
 * Lechuza que ulula.
 */
public class Lechuza extends Animal {

    /**
     * Crea una lechuza.
     *
     * @param nombre nombre de la lechuza
     */
    public Lechuza(final String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido() {
        System.out.println(getNombre() + " dice: ¡Uhu uhu!");
    }
}