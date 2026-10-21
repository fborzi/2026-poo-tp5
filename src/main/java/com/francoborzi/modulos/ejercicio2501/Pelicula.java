package com.francoborzi.modulos.ejercicio2501;
/**
 * Representa una película reproducible.
 *
 */
public class Pelicula implements Reproducible {

    /** Título de la película. */
    private String titulo;

    /** Indica si la película está reproduciéndose. */
    private boolean reproduciendo;

    /** Indica si está activado el modo bucle. */
    private boolean modoBucle;

    /**
     * Construye una película con el título indicado.
     *
     * @param titulo título de la película
     */
    public Pelicula(String titulo) {
        this.titulo = titulo;
        this.reproduciendo = false;
        this.modoBucle = false;
    }

    /**
     * Comienza a reproducir la película.
     */
    @Override
    public void play() {
        reproduciendo = true;
        System.out.println("Reproduciendo película: " + titulo);
    }

    /**
     * Activa o desactiva el modo bucle.
     */
    @Override
    public void bucle() {
        modoBucle = !modoBucle;
        System.out.println("Bucle de la película " + titulo + ": "
                + (modoBucle ? "activado" : "desactivado"));
    }

    /**
     * Detiene la película.
     */
    @Override
    public void stop() {
        reproduciendo = false;
        System.out.println("Película detenida: " + titulo);
    }

    /**
     * Devuelve el título de la película.
     *
     * @return título de la película
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Indica si la película se está reproduciendo.
     *
     * @return true si se reproduce; false en caso contrario
     */
    public boolean isReproduciendo() {
        return reproduciendo;
    }
}