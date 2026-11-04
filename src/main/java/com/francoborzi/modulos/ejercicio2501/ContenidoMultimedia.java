package com.francoborzi.modulos.ejercicio2501;

import java.util.Objects;

/**
 * Representa un contenido multimedia.
 */
public class ContenidoMultimedia {

    private final String titulo;
    private final String tipo;

    /**
     * Construye un contenido multimedia.
     *
     * @param titulo titulo del contenido
     * @param tipo tipo de contenido
     */
    public ContenidoMultimedia(String titulo, String tipo) {
        this.titulo = Objects.requireNonNull(titulo);
        this.tipo = Objects.requireNonNull(tipo);
    }

    /**
     * Obtiene el titulo.
     *
     * @return titulo del contenido
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Obtiene el tipo.
     *
     * @return tipo de contenido
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Devuelve la descripcion del contenido.
     *
     * @return descripcion del contenido
     */
    @Override
    public String toString() {
        return tipo + ": " + titulo;
    }
}
