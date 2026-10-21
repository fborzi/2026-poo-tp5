package com.francoborzi.modulos.ejercicio2501;
/**
 * Representa un video que puede reproducirse.
 *
 */
public class Video implements Reproducible {

    /** Título del video. */
    private String titulo;

    /** Indica si el video está reproduciéndose. */
    private boolean reproduciendo;

    /** Indica si está activado el modo bucle. */
    private boolean modoBucle;

    /**
     * Construye un video con el título indicado.
     *
     * @param titulo título del video
     */
    public Video(String titulo) {
        this.titulo = titulo;
        this.reproduciendo = false;
        this.modoBucle = false;
    }

    /**
     * Inicia la reproducción del video.
     */
    @Override
    public void play() {
        reproduciendo = true;
        System.out.println("Reproduciendo video: " + titulo);
    }

    /**
     * Activa o desactiva el modo bucle.
     */
    @Override
    public void bucle() {
        modoBucle = !modoBucle;
        System.out.println("Bucle del video " + titulo + ": "
                + (modoBucle ? "activado" : "desactivado"));
    }

    /**
     * Detiene la reproducción del video.
     */
    @Override
    public void stop() {
        reproduciendo = false;
        System.out.println("Video detenido: " + titulo);
    }

    /**
     * Devuelve el título del video.
     *
     * @return título del video
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Indica si el video se está reproduciendo.
     *
     * @return true si se reproduce; false en caso contrario
     */
    public boolean isReproduciendo() {
        return reproduciendo;
    }
}