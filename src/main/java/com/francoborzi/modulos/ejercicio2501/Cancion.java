package com.francoborzi.modulos.ejercicio2501;

public class Cancion implements Reproducible {

    private String titulo;
    private String artista;

    public Cancion(String titulo, String artista) {
        this.titulo = titulo;
        this.artista = artista;
    }

    @Override
    public void play() {
        System.out.println("Reproduciendo canción: " + titulo);
    }

    @Override
    public void bucle() {
        System.out.println("Canción en modo bucle: " + titulo);
    }

    @Override
    public void stop() {
        System.out.println("Canción detenida: " + titulo);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }
}