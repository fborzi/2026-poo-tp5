package com.francoborzi.modulos.ejercicio2501;

/**
 * Define una interfaz para los elementos que pueden
 * reproducirse, repetirse en bucle y detenerse.
 * Establece los metodos play(), bucle() y stop()
 * que deben implementar las clases que la utilicen,
 * como Cancion y Pelicula.
 */

public interface Reproducible {

    void play();

    void bucle();

    void stop();
}
