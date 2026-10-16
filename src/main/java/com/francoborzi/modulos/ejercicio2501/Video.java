package com.francoborzi.modulos.ejercicio2501;

/**
 * Video reproducible.
 */
public class Video extends Contenido {

    private final String autor;

    /**
     * Crea un video.
     *
     * @param titulo título del video
     * @param duracionSegundos duración en segundos
     * @param autor autor o canal del video
     */
    public Video(final String titulo, final int duracionSegundos,
                 final String autor) {
        super(titulo, duracionSegundos);
        this.autor = autor;
    }

    /**
     * @return el autor del video
     */
    public String getAutor() {
        return autor;
    }

    @Override
    public String getTipo() {
        return "Video";
    }

    @Override
    public String toString() {
        return super.toString() + " - Autor: " + autor;
    }
}