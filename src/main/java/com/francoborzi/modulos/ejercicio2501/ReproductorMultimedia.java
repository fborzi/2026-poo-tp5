package com.francoborzi.modulos.ejercicio2501;

/**
 * Reproductor que carga y controla un contenido reproducible.
 */
public class ReproductorMultimedia {

    private Reproducible contenido;
    private EstadoReproduccion estado = EstadoReproduccion.DETENIDO;
    private boolean enBucle;

    /**
     * Carga un contenido. Si había otro reproduciéndose, lo detiene.
     *
     * @param nuevoContenido contenido a cargar
     */
    public void cargar(final Reproducible nuevoContenido) {
        if (contenido != null && estado != EstadoReproduccion.DETENIDO) {
            stop();
        }
        this.contenido = nuevoContenido;
        this.estado = EstadoReproduccion.DETENIDO;
        this.enBucle = false;
        System.out.println("Cargado: " + mostrarContenido());
    }

    /** Comienza o reanuda la reproducción. */
    public void play() {
        if (contenido == null) {
            System.out.println("No hay contenido cargado.");
            return;
        }
        contenido.play();
        estado = EstadoReproduccion.REPRODUCIENDO;
    }

    /** Pausa la reproducción conservando el contenido cargado. */
    public void pausa() {
        if (estado == EstadoReproduccion.REPRODUCIENDO) {
            contenido.stop();
            estado = EstadoReproduccion.PAUSADO;
            System.out.println("En pausa.");
        }
    }

    /** Detiene la reproducción y desactiva el bucle. */
    public void stop() {
        if (contenido == null) {
            System.out.println("No hay contenido cargado.");
            return;
        }
        contenido.stop();
        estado = EstadoReproduccion.DETENIDO;
        enBucle = false;
    }

    /** Activa o desactiva la reproducción en bucle. */
    public void bucle() {
        if (contenido == null) {
            System.out.println("No hay contenido cargado.");
            return;
        }
        contenido.bucle();
        enBucle = !enBucle;
    }

    /**
     * @return true si el contenido se está reproduciendo
     */
    public boolean estaReproduciendo() {
        return estado == EstadoReproduccion.REPRODUCIENDO;
    }

    /**
     * @return true si el contenido está en pausa
     */
    public boolean estaEnPausa() {
        return estado == EstadoReproduccion.PAUSADO;
    }

    /**
     * @return true si el bucle está activado
     */
    public boolean estaEnBucle() {
        return enBucle;
    }

    /**
     * @return el estado actual del reproductor
     */
    public EstadoReproduccion getEstado() {
        return estado;
    }

    /**
     * @return descripción del contenido cargado
     */
    public String mostrarContenido() {
        if (contenido == null) {
            return "Sin contenido cargado";
        }
        return contenido.toString();
    }

    @Override
    public String toString() {
        return "Reproductor [" + mostrarContenido()
                + " | Estado: " + estado
                + " | Bucle: " + (enBucle ? "activado" : "desactivado") + "]";
    }
}