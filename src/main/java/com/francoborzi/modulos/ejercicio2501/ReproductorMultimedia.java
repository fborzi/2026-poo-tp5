package com.francoborzi.modulos.ejercicio2501;
/**
 * Administra la carga y el estado de un contenido multimedia.
 */
public class ReproductorMultimedia {

    /** Contenido actualmente cargado. */
    private Reproducible contenido;

    /** Estado actual del reproductor. */
    private String estado;

    /**
     * Construye un reproductor sin contenido cargado.
     */
    public ReproductorMultimedia() {
        contenido = null;
        estado = "SIN CONTENIDO";
    }

    /**
     * Carga un contenido multimedia.
     *
     * @param contenido contenido que se desea cargar
     */
    public void cargarContenido(Reproducible contenido) {
        if (contenido == null) {
            System.out.println("No se puede cargar un contenido nulo.");
            return;
        }

        if (this.contenido != null) {
            this.contenido.stop();
        }

        this.contenido = contenido;
        estado = "PAUSADO";

        System.out.println("Contenido cargado: " + obtenerTitulo());
    }

    /**
     * Inicia la reproducción del contenido cargado.
     */
    public void reproducir() {
        if (contenido == null) {
            System.out.println("No hay contenido cargado.");
            return;
        }

        contenido.play();
        estado = "REPRODUCIENDO";
    }

    /**
     * Activa o desactiva el modo bucle del contenido cargado.
     */
    public void bucle() {
        if (contenido == null) {
            System.out.println("No hay contenido cargado.");
            return;
        }

        contenido.bucle();
    }

    /**
     * Detiene la reproducción del contenido cargado.
     */
    public void detener() {
        if (contenido == null) {
            System.out.println("No hay contenido cargado.");
            return;
        }

        contenido.stop();
        estado = "DETENIDO";
    }

    /**
     * Registra una pausa en el estado del reproductor.
     *
     * La interfaz Reproducible no define un método de pausa real.
     */
    public void pausar() {
        if (contenido == null) {
            System.out.println("No hay contenido cargado.");
            return;
        }

        if ("REPRODUCIENDO".equals(estado)) {
            estado = "PAUSADO";
            System.out.println("Reproductor en pausa.");
        } else {
            System.out.println("El contenido no está reproduciéndose.");
        }
    }

    /**
     * Devuelve el título del contenido cargado.
     *
     * @return título del contenido o un mensaje si no hay contenido
     */
    private String obtenerTitulo() {
        if (contenido instanceof Video) {
            return ((Video) contenido).getTitulo();
        }
        if (contenido instanceof Cancion) {
            return ((Cancion) contenido).getTitulo();
        }
        if (contenido instanceof Pelicula) {
            return ((Pelicula) contenido).getTitulo();
        }
        return "Contenido multimedia";
    }

    /**
     * Devuelve el contenido cargado.
     *
     * @return contenido actual o null si no hay ninguno
     */
    public Reproducible getContenido() {
        return contenido;
    }

    /**
     * Devuelve el estado actual del reproductor.
     *
     * @return estado del reproductor
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Indica si hay contenido cargado.
     *
     * @return true si existe contenido; false en caso contrario
     */
    public boolean hayContenido() {
        return contenido != null;
    }
}