package com.francoborzi.modulos.ejercicio2501;

/**
 * Canción reproducible.
 */
public class Cancion extends Contenido {

    private final String artista;

    /**
     * Crea una canción.
     *
     * @param titulo título de la canción
     * @param duracionSegundos duración en segundos
     * @param artista artista que la interpreta
     */
    public Cancion(final String titulo, final int duracionSegundos,
                   final String artista) {
        super(titulo, duracionSegundos);
        this.artista = artista;
    }

    /**
     * @return el artista
     */
    public String getArtista() {
        return artista;
    }

    @Override
    public String getTipo() {
        return "Canción";
    }

    @Override
    public String toString() {
        return super.toString() + " - Artista: " + artista;
    }
}