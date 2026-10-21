package com.francoborzi.modulos.ejercicio2501;

/**
 * Define las operaciones que debe ofrecer un contenido reproducible.
 */
public interface Reproducible {

    /**
     * Comienza la reproducción del contenido.
     */
    void play();

    /**
     * Inicia o detiene el modo de reproducción en bucle.
     */
    void bucle();

    /**
     * Detiene la reproducción del contenido.
     */
    void stop();
}