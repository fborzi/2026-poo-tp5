package com.francoborzi.modulos.ejercicio2501;
/**
 * Representa una canción que permite reproducirse,
 * repetirse en bucle y detenerse.
 * Implementa la interfaz Reproducible.
 * Recibe el nombre de la canción mediante el constructor
 * para crear una nueva canción.
 */
public class Cancion implements Reproducible {

    private String nombre;

    public Cancion(String nombre) {
        this.nombre = nombre;
    }


    public void play() {
        System.out.println("reproduciendo cancion: " + nombre);
    }


    public void bucle() {
        System.out.println("cancion en bucle: " + nombre);
    }


    public void stop() {
        System.out.println("cancion detenida: " + nombre);
    }

    public String getNombre() {
        return nombre;
    }
}