package com.francoborzi.modulos.ejercicio2501;

public class ReproductorMultimedia {

    private Reproducible contenido;
    private boolean reproduciendo;

    public void cargar(Reproducible contenido) {
        this.contenido = contenido;
        reproduciendo = false;

        System.out.println("Contenido cargado: "
                + ((ContenidoMultimedia) contenido).getTitulo());
    }

    public void play() {
        if (contenido != null) {
            contenido.play();
            reproduciendo = true;
        } else {
            System.out.println("No hay contenido cargado.");
        }
    }

    public void pausar() {
        if (contenido != null && reproduciendo) {
            reproduciendo = false;
            System.out.println("En pausa.");
        } else {
            System.out.println("No hay reproducción activa.");
        }
    }

    public void stop() {
        if (contenido != null) {
            contenido.stop();
            reproduciendo = false;
        }
    }

    public void bucle() {
        if (contenido != null) {
            contenido.bucle();
        }
    }

    public void mostrarContenido() {
        if (contenido == null) {
            System.out.println("No hay contenido cargado.");
        } else {
            System.out.println("Contenido actual: "
                    + ((ContenidoMultimedia) contenido).getTitulo());

            System.out.println(reproduciendo
                    ? "Estado: reproduciendo."
                    : "Estado: en pausa.");
        }
    }
}
