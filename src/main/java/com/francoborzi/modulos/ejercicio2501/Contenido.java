package com.francoborzi.modulos.ejercicio2501;

/**
 * Contenido multimedia genérico que puede reproducirse.
 */
public abstract class Contenido implements Reproducible {

    private final String titulo;
    private final int duracionSegundos;

    /**
     * Crea un contenido.
     *
     * @param titulo título del contenido
     * @param duracionSegundos duración en segundos
     */
    protected Contenido(final String titulo, final int duracionSegundos) {
        this.titulo = titulo;
        this.duracionSegundos = duracionSegundos;
    }

    /**
     * @return el título del contenido
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @return la duración en segundos
     */
    public int getDuracionSegundos() {
        return duracionSegundos;
    }

    /**
     * @return el tipo de contenido (Canción, Video, Película)
     */
    public abstract String getTipo();

    @Override
    public void play() {
        System.out.println("Reproduciendo " + getTipo() + ": " + titulo);
    }

    @Override
    public void bucle() {
        System.out.println(getTipo() + " en bucle: " + titulo);
    }

    @Override
    public void stop() {
        System.out.println("Detenido " + getTipo() + ": " + titulo);
    }

    @Override
    public String toString() {
        return getTipo() + " - " + titulo + " (" + duracionSegundos + " s)";
    }
}