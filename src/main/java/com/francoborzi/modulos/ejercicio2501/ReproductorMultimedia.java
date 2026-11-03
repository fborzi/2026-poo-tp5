package com.francoborzi.modulos.ejercicio2501;

public class ReproductorMultimedia {

    private Reproducible contenido;

    private Estado estado;


    private enum Estado {
        REPRODUCIENDO,
        PAUSADO,
        DETENIDO
    }

    public ReproductorMultimedia() {
        this.contenido = null;
        this.estado = Estado.DETENIDO;
    }


    public void cargar(Reproducible contenido) {

        this.contenido = contenido;
        this.estado = Estado.DETENIDO;

        System.out.println("Contenido cargado correctamente");
    }


    public void reproducir() {

        if (contenido == null) {
            System.out.println("No hay contenido cargado");
            return;
        }

        contenido.play();
        estado = Estado.REPRODUCIENDO;
    }


    public void pausar() {

        if (estado == Estado.REPRODUCIENDO) {
            estado = Estado.PAUSADO;
            System.out.println("Reproducción pausada");
        } else {
            System.out.println("No hay contenido reproduciéndose");
        }
    }


    public void bucle() {

        if (contenido == null) {
            System.out.println("No hay contenido cargado");
            return;
        }

        contenido.bucle();
    }


    public void detener() {

        if (contenido != null) {
            contenido.stop();
        }

        estado = Estado.DETENIDO;
    }


    public void mostrarEstado() {
        System.out.println("Estado actual: " + estado);
    }

    public void mostrarContenido() {

        if (contenido == null) {
            System.out.println("No hay contenido cargado");
        } else {
            System.out.println("Hay un contenido cargado");
        }
    }

}
