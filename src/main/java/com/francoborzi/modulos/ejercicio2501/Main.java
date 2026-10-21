package com.francoborzi.modulos.ejercicio2501;
/**
 * Ejecuta las pruebas del reproductor multimedia.
 */
public class Main {

    /**
     * Punto de entrada del programa.
     *
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {

        // Creamos el reproductor.
        ReproductorMultimedia reproductor =
                new ReproductorMultimedia();

        // Creamos un video y lo cargamos.
        Video video = new Video("Tutorial de Java");
        reproductor.cargarContenido(video);

        // Iniciamos la reproducción.
        reproductor.reproducir();

        // Mostramos el estado.
        System.out.println("Estado: " + reproductor.getEstado());

        // Activamos el modo bucle.
        reproductor.bucle();

        // Simulamos una pausa.
        reproductor.pausar();
        System.out.println("Estado: " + reproductor.getEstado());

        // Detenemos el contenido.
        reproductor.detener();
        System.out.println("Estado: " + reproductor.getEstado());

        // Cargamos una canción para comprobar el polimorfismo.
        Cancion cancion = new Cancion("Mi canción favorita");
        reproductor.cargarContenido(cancion);
        reproductor.reproducir();

        // Cargamos una película.
        Pelicula pelicula = new Pelicula("Mi película");
        reproductor.cargarContenido(pelicula);
        reproductor.reproducir();
        reproductor.detener();
    }
}