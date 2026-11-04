package com.francoborzi.modulos.ejercicio2501;

/**
 * Ejecuta pruebas del reproductor multimedia.
 */
public final class Main2501 {

    private Main2501() {
    }

    /**
     * Punto de entrada del programa.
     *
     * @param args argumentos de ejecucion
     */
    public static void main(String[] args) {
        ReproductorMultimedia reproductor =
                new ReproductorMultimedia();

        ContenidoMultimedia cancion =
                new ContenidoMultimedia("Mi cancion", "Cancion");

        ContenidoMultimedia pelicula =
                new ContenidoMultimedia("Matrix", "Pelicula");

        reproductor.play();

        reproductor.cargarContenido(cancion);
        System.out.println("Contenido: "
                + reproductor.getContenido());

        reproductor.play();
        System.out.println("Reproduciendo: "
                + reproductor.isReproduciendo());

        reproductor.bucle();
        System.out.println("Pausado: "
                + reproductor.isPausado());

        reproductor.bucle();
        System.out.println("Reproduciendo: "
                + reproductor.isReproduciendo());

        reproductor.stop();

        reproductor.cargarContenido(pelicula);
        reproductor.play();
        reproductor.stop();
    }
}
