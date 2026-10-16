package com.francoborzi.modulos.ejercicio2501;

public class Main {
    static void main() {
        final ReproductorMultimedia reproductor = new ReproductorMultimedia();

        reproductor.cargar(new Cancion("Bohemian Rhapsody", 354, "Queen"));
        reproductor.play();
        System.out.println("¿Reproduciendo? " + reproductor.estaReproduciendo());
        reproductor.pausa();
        System.out.println("¿En pausa? " + reproductor.estaEnPausa());

        reproductor.cargar(new Pelicula("Me Be For You", 7320, "Ni idea"));
        reproductor.play();
        reproductor.bucle();
        reproductor.stop();

        reproductor.cargar(new Video("let Her Go", 600, "Passenger"));
        reproductor.play();
        System.out.println("Estado: " + reproductor.getEstado());

        System.out.println(reproductor);
    }
}