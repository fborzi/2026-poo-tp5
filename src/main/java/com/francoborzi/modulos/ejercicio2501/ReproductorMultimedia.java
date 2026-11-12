package com.francoborzi.modulos.ejercicio2501;

/**
 * Representa un reproductor multimedia que permite cargar
 * contenido reproducible, iniciar su reproduccion,
 * repetirlo en bucle, detenerlo y mostrar el contenido cargado.
 * Utiliza la interfaz Reproducible para trabajar con diferentes
 * tipos de contenido, como canciones y peliculas.
 * Mantiene un estado para indicar si el contenido
 * se encuentra reproduciendose.
 */

public class ReproductorMultimedia {
    private Reproducible contenido;
    private boolean reproduciendo;

    public ReproductorMultimedia() {
        this.contenido = null;
        this.reproduciendo = false;
    }

    public void cargar(Reproducible contenido) {
        this.contenido = contenido;
        this.reproduciendo = false;

        System.out.println("Contenido cargado.");
    }

    public void play() {
        if (contenido != null) {
            contenido.play();
            reproduciendo = true;
        } else {
            System.out.println("no hay contenido cargado.");
        }
    }

    public void bucle() {
        if (contenido != null) {
            contenido.bucle();
            reproduciendo = true;
        } else {
            System.out.println("no hay contenido cargado.");
        }
    }

    public void stop() {
        if (contenido != null) {
            contenido.stop();
            reproduciendo = false;
        } else {
            System.out.println("no hay contenido cargado.");
        }
    }

    public void mostrarContenido() {
        if (contenido != null) {
            System.out.println("contenido cargado correctamente.");
        } else {
            System.out.println("no hay contenido cargado.");
        }
    }
    public boolean estaReproduciendo() {
        return reproduciendo;
    }
}
