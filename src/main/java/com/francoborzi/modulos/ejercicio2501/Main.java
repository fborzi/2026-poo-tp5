package com.francoborzi.modulos.ejercicio2501;

public class Main {

    public static void main(String[] args) {

        ReproductorMultimedia reproductor =
                new ReproductorMultimedia();

        // Cargar y reproducir una canción
        Cancion cancion =
                new Cancion("La leyenda del hada y el mago");

        reproductor.cargar(cancion);
        reproductor.play();
        reproductor.mostrarContenido();
        reproductor.pausar();
        reproductor.stop();

        System.out.println("--------------------");

        // Cargar y reproducir un video
        Video video = new Video("Video de prueba");

        reproductor.cargar(video);
        reproductor.play();
        reproductor.mostrarContenido();
        reproductor.pausar();
        reproductor.stop();

        System.out.println("--------------------");

        // Cargar y reproducir una película
        Pelicula pelicula = new Pelicula("Dracula");

        reproductor.cargar(pelicula);
        reproductor.play();
        reproductor.mostrarContenido();
        reproductor.pausar();
        reproductor.stop();
    }
}