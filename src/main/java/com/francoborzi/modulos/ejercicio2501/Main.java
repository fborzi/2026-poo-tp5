package com.francoborzi.modulos.ejercicio2501;

public class Main {
    public static void main(String[] args) {

        ReproductorMultimedia reproductor =
                new ReproductorMultimedia();

        Cancion cancion = new Cancion("mi cancion favorita");

        reproductor.cargar(cancion);

        reproductor.mostrarContenido();

        reproductor.play();

        System.out.println("¿se esta reproduciendo? "
                + reproductor.estaReproduciendo());

        reproductor.bucle();

        reproductor.stop();

        System.out.println("¿se está reproduciendo? "
                + reproductor.estaReproduciendo());

        System.out.println("--------------------");

        Video video = new Video("video de prueba");

        reproductor.cargar(video);
        reproductor.play();
        reproductor.stop();

        System.out.println("--------------------");

        Pelicula pelicula = new Pelicula("mi pelicula");

        reproductor.cargar(pelicula);
        reproductor.play();
        reproductor.stop();
    }
}
