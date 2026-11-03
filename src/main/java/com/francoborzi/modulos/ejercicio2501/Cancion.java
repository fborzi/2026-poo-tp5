package com.francoborzi.modulos.ejercicio2501;


public class Cancion implements Reproducible {
    private String titulo;
    public Cancion(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public void play() {
        System.out.println("Reproduciendo canción: " + titulo);
    }

    @Override
    public void bucle() {
        System.out.println("Canción en bucle: " + titulo);
    }

    @Override
    public void stop() {
        System.out.println("Canción detenida: " + titulo);
    }

    @Override
    public String toString() {
        return "Canción: " + titulo;
    }
}
