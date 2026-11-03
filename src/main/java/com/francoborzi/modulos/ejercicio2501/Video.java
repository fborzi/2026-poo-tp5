package com.francoborzi.modulos.ejercicio2501;

public class Video implements Reproducible {

    private String titulo;

    public Video(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public void play() {
        System.out.println("Reproduciendo video: " + titulo);
    }

    @Override
    public void bucle() {
        System.out.println("Video en modo bucle: " + titulo);
    }

    @Override
    public void stop() {
        System.out.println("Video detenido: " + titulo);
    }

    public String getTitulo() {
        return titulo;
    }
}