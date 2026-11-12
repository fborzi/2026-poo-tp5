package com.francoborzi.modulos.ejercicio2501;

/**
 * Representa un video que permite reproducirse,
 * repetirse en bucle y detenerse.
 * Implementa la interfaz Reproducible.
 * Recibe el nombre del video mediante el constructor
 * para crear un nuevo video.
 */

public class Video implements Reproducible {

    private String nombre;

    public Video(String nombre) {
        this.nombre = nombre;
    }


    public void play() {
        System.out.println("Reproduciendo video: " + nombre);
    }


    public void bucle() {
        System.out.println("Video en bucle: " + nombre);
    }


    public void stop() {
        System.out.println("Video detenido: " + nombre);
    }

    public String getNombre() {
        return nombre;
    }
}