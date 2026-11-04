package com.francoborzi.modulos.ejercicio2501;

/**
 * Define las operaciones de reproduccion multimedia.
 */
public interface Reproducible {

    /**
     * Comienza la reproduccion.
     */
    void play();

    /**
     * Inicia o pausa la reproduccion.
     */
    void bucle();

    /**
     * Detiene la reproduccion.
     */
    void stop();
}
