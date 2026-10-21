package com.francoborzi.modulos.ejercicio2501;

/**
 * Representa una canción reproducible.
 *
 */
public class Cancion implements Reproducible {

    /** Título de la canción. */
    private String titulo;

    /** Indica si la canción está reproduciéndose. */
    private boolean reproduciendo;

    /** Indica si está activado el modo bucle. */
    private boolean modoBucle;

    /**
     * Construye una canción con el título indicado.
     *
     * @param titulo título de la canción
     */
    public Cancion(String titulo) {
        this.titulo = titulo;
        this.reproduciendo = false;
        this.modoBucle = false;
    }

    /**
     * Comienza a reproducir la canción.
     */
    @Override
    public void play() {
        reproduciendo = true;
        System.out.println("Reproduciendo canción: " + titulo);
    }

    /**
     * Activa o desactiva el modo bucle.
     */
    @Override
    public void bucle() {
        modoBucle = !modoBucle;
        System.out.println("Bucle de la canción " + titulo + ": "
                + (modoBucle ? "activado" : "desactivado"));
    }

    /**
     * Detiene la canción.
     */
    @Override
    public void stop() {
        reproduciendo = false;
        System.out.println("Canción detenida: " + titulo);
    }

    /**
     * Devuelve el título de la canción.
     *
     * @return título de la canción
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Indica si la canción se está reproduciendo.
     *
     * @return true si se reproduce; false en caso contrario
     */
    public boolean isReproduciendo() {
        return reproduciendo;
    }
}