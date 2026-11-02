package com.francoborzi.modulos.ejercicio2501;

public abstract class ContenidoMultimedia
        implements Reproducible {

    protected String titulo;
    protected boolean enBucle;

    public ContenidoMultimedia(String titulo) {
        this.titulo = titulo;
        this.enBucle = false;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public void play() {
        System.out.println("Reproduciendo: " + titulo);
    }

    @Override
    public void bucle() {
        enBucle = !enBucle;
        System.out.println("Bucle: " + enBucle);
    }

    @Override
    public void stop() {
        System.out.println("Contenido detenido: " + titulo);
    }
}
