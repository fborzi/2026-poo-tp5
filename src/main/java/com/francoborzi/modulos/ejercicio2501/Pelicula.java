package com.francoborzi.modulos.ejercicio2501;


public class Pelicula implements Reproducible {
    private String titulo;

    public Pelicula(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public void play() {
        System.out.println("Reproduciendo película: " + titulo);
    }

    @Override
    public void bucle() {
        System.out.println("Película en bucle: " + titulo);
    }

    @Override
    public void stop() {
        System.out.println("Película detenida: " + titulo);
    }

    @Override
    public String toString() {
        return "Película: " + titulo;
    }
}

