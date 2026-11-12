package com.francoborzi.modulos.ejercicio2501;

/**
 * Representa una pelicula que permite reproducirse,
 * repetirse en bucle y detenerse.
 * Implementa la interfaz Reproducible.
 * Recibe el nombre de la pelicula mediante el constructor
 * para crear una nueva pelíiula.
 */

public class Pelicula implements Reproducible {

    private String nombre;

    public Pelicula(String nombre) {
        this.nombre = nombre;
    }


    public void play() {
        System.out.println("Reproduciendo pelicula: " + nombre);
    }


    public void bucle() {
        System.out.println("Pelicula en bucle: " + nombre);
    }


    public void stop() {
        System.out.println("Pelicula detenida: " + nombre);
    }

    public String getNombre() {
        return nombre;
    }
}
