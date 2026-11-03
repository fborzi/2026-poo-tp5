package com.francoborzi.modulos.ejercicio2501;

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

        System.out.println("contenido cargado correctamente");
        mostrarContenido();
    }

    public void reproducir() {
        if (contenido != null) {
            contenido.play();
            reproduciendo = true;
        } else {
            System.out.println("no hay contenido cargado");
        }
    }

    public void pausar() {
        if (contenido != null && reproduciendo) {
            reproduciendo = false;
            System.out.println("reproduccion en pausa");
        } else {
            System.out.println("no se esta reproduciendo");
        }
    }

    public void detener() {
        if (contenido != null) {
            contenido.stop();
            reproduciendo = false;
        } else {
            System.out.println("no hay contenido cargado");
        }
    }

    public void activarBucle() {
        if (contenido != null) {
            contenido.bucle();
        } else {
            System.out.println("no hay contenido cargado");
        }
    }

    public void mostrarContenido() {
        if (contenido != null) {
            System.out.println("cntenido actual: " + contenido);
        } else {
            System.out.println("no hay contenido cargado");
        }
    }

    public boolean estaReproduciendo() {
        return reproduciendo;
    }
}
