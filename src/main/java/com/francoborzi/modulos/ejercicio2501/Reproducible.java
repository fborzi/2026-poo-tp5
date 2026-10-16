package com.francoborzi.modulos.ejercicio2501;

/**
 * Comportamiento común de todo contenido que puede reproducirse.
 */
public interface Reproducible {

    /** Comienza la reproducción. */
    public void play();

    /** Inicia o detiene la reproducción en un bucle infinito. */
    public void bucle();

    /** Detiene la reproducción del contenido. */
    public void stop();
}