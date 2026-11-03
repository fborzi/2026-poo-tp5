package com.francoborzi.modulos.ejercicio2501;

public class Pelicula implements Reproducible {

    private String titulo;
    private int duracion;

    public Pelicula(String titulo, int duracion) {
        this.titulo = titulo;
        this.duracion = duracion;
    }

    @Override
    public void play() {
        System.out.println("Reproduciendo película: " + titulo);
    }

    @Override
    public void bucle() {
        System.out.println("Película en modo bucle: " + titulo);
    }

    @Override
    public void stop() {
        System.out.println("Película detenida: " + titulo);
    }

    public String getTitulo() {
        return titulo;
    }

    public int getDuracion() {
        return duracion;
    }
}