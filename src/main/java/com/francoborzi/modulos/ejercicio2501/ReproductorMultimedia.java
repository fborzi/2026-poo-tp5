package com.francoborzi.modulos.ejercicio2501;

public class ReproductorMultimedia {

    private Reproducible contenidoCargado;
    private boolean enReproduccion;

    public ReproductorMultimedia() {
        this.contenidoCargado = null;
        this.enReproduccion = false;
    }

    public void cargarContenido(Reproducible contenido) {
        this.contenidoCargado = contenido;
        this.enReproduccion = false;
        System.out.println("Contenido cargado con éxito.");
        mostrarContenidoCargado();
    }

    public void mostrarContenidoCargado() {
        if (contenidoCargado != null) {
            System.out.println("Contenido actual: " + contenidoCargado);
        } else {
            System.out.println("No hay ningún contenido cargado.");
        }
    }
    public void reproducir() {
        if (contenidoCargado != null) {
            contenidoCargado.play();
            this.enReproduccion = true;
        } else {
            System.out.println("Error: No hay contenido cargado para reproducir.");
        }
    }

    public void detener() {
        if (contenidoCargado != null) {
            contenidoCargado.stop();
            this.enReproduccion = false;
            System.out.println("El reproductor se ha detenido.");
        } else {
            System.out.println("No hay nada reproduciéndose.");
        }
    }
        public void activarBucle() {
            if (contenidoCargado != null) {
                contenidoCargado.bucle();
                this.enReproduccion = true;
                System.out.println("Modo bucle activado en el reproductor.");
            } else {
                System.out.println("Error: No hay contenido cargado para poner en bucle.");
            }
        }

    public void comprobarEstado() {
        if (enReproduccion) {
            System.out.println("Estado actual: Se está reproduciendo.");
        } else {
            System.out.println("Estado actual: Está en pausa o detenido.");
        }
    }
}

