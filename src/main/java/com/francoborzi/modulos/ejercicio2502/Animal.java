
package com.francoborzi.modulos.ejercicio2502;

/**
 * Representa un animal capaz de emitir sonidos.
 */
public abstract class Animal implements Hablante {

    private final String nombre;

    /**
     * Construye un animal.
     *
     * @param nombre nombre del animal
     */
    protected Animal(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el nombre del animal.
     *
     * @return nombre del animal
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el sonido particular de cada animal.
     */
    @Override
    public abstract void hacerSonido();
}
