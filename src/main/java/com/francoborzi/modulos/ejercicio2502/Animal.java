package com.francoborzi.modulos.ejercicio2502;

/**
 * Animal genérico que sabe hacer un sonido en su propio idioma.
 */
public abstract class Animal implements Hablador {

    private final String nombre;

    /**
     * Crea un animal.
     *
     * @param nombre nombre del animal
     */
    protected Animal(final String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return el nombre del animal
     */
    public String getNombre() {
        return nombre;
    }

    @Override
    public abstract void hacerSonido();

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + nombre;
    }
}