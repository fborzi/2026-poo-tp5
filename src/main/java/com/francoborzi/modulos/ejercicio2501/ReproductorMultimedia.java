package com.francoborzi.modulos.ejercicio2501;

/**
 * Administra la reproduccion de contenido multimedia.
 */
public class ReproductorMultimedia implements Reproducible {

    private ContenidoMultimedia contenido;
    private boolean reproduciendo;
    private boolean pausado;

    /**
     * Construye un reproductor sin contenido.
     */
    public ReproductorMultimedia() {
        this.contenido = null;
        this.reproduciendo = false;
        this.pausado = false;
    }

    /**
     * Carga un contenido en el reproductor.
     *
     * @param nuevoContenido contenido a cargar
     */
    public void cargarContenido(ContenidoMultimedia nuevoContenido) {
        if (nuevoContenido == null) {
            throw new IllegalArgumentException(
                    "El contenido no puede ser nulo");
        }

        this.contenido = nuevoContenido;
        this.reproduciendo = false;
        this.pausado = false;
    }

    /**
     * Inicia o reanuda la reproduccion.
     */
    @Override
    public void play() {
        if (contenido == null) {
            System.out.println("No hay contenido cargado.");
            return;
        }

        reproduciendo = true;
        pausado = false;
        System.out.println("Reproduciendo: " + contenido);
    }

    /**
     * Alterna entre reproduccion y pausa.
     */
    @Override
    public void bucle() {
        if (contenido == null) {
            System.out.println("No hay contenido cargado.");
            return;
        }

        if (reproduciendo) {
            reproduciendo = false;
            pausado = true;
            System.out.println("Contenido pausado.");
        } else {
            reproduciendo = true;
            pausado = false;
            System.out.println("Contenido reproduciendose.");
        }
    }

    /**
     * Detiene la reproduccion.
     */
    @Override
    public void stop() {
        reproduciendo = false;
        pausado = false;
        System.out.println("Reproduccion detenida.");
    }

    /**
     * Indica si el contenido se esta reproduciendo.
     *
     * @return true si esta reproduciendo
     */
    public boolean isReproduciendo() {
        return reproduciendo;
    }

    /**
     * Indica si el contenido esta pausado.
     *
     * @return true si esta pausado
     */
    public boolean isPausado() {
        return pausado;
    }

    /**
     * Obtiene el contenido cargado.
     *
     * @return contenido actual
     */
    public ContenidoMultimedia getContenido() {
        return contenido;
    }
}
