package com.francoborzi.modulos.ejercicio2501;

/**
 * Película reproducible.
 */
public class Pelicula extends Contenido {

    private final String director;

    /**
     * crea una película
     *
     * @param titulo título de la película
     * @param duracionSegundos duración en segundos.
     * @param director director de la película
     */
    public Pelicula(final String titulo, final int duracionSegundos,
                    final String director) {
        super(titulo, duracionSegundos);
        this.director = director;
    }

    /**
     * @return el senior director
     */
    public String getDirector() {
        return director;
    }

    @Override
    public String getTipo() {
        return "Película";
    }

    @Override
    public String toString() {
        return super.toString() + " - Director: " + director;
    }
}