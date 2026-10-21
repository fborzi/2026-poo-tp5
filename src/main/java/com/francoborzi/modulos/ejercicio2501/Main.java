package com.francoborzi.modulos.ejercicio2501;

public class Main {
    public static void main(String[] args) {
        ReproductorMultimedia reproductor = new ReproductorMultimedia();
        System.out.println("=== INICIO DE PRUEBAS DEL REPRODUCTOR ===");
        reproductor.comprobarEstado();
        System.out.println();

        Cancion miCancion = new Cancion(1.45, 255,"Cancion de Risa");
        Video miVideoShort = new Video(1.45, "Partido del Sabado",95);
        Pelicula miPelicula = new Pelicula("Guerra de nieve", 2.20,257);

        System.out.println("--- Prueba 1: Canción ---");
        reproductor.cargarContenido(miCancion);
        reproductor.comprobarEstado();

        reproductor.reproducir();
        reproductor.comprobarEstado();

        reproductor.detener();
        reproductor.comprobarEstado();
        System.out.println();

        System.out.println("--- Prueba 2: Video ---");
        reproductor.cargarContenido(miVideoShort);

        reproductor.activarBucle();
        reproductor.comprobarEstado();

        reproductor.detener();
        System.out.println();

        System.out.println("--- Prueba 3: Película ---");
        reproductor.cargarContenido(miPelicula);

        reproductor.reproducir();
        reproductor.detener();
        reproductor.comprobarEstado();

        reproductor.detener();
        System.out.println("-----------");
        reproductor.mostrarContenidoCargado();
        System.out.println("---[Prueba 4: Sin Contenido] ---");
        ReproductorMultimedia nuevoReproductor = new ReproductorMultimedia();
        nuevoReproductor.reproducir();
    }
}

