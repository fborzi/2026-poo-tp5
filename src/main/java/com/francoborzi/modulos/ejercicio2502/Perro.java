package edu.programacion.ejercicio2502;

/**
 * Representa un perro, que es un tipo de animal.
 */
public class Perro extends edu.programacion.ejercicio2502.Animal {

    /**
     * Hace el sonido característico del perro.
     */
    @Override
    public void hacerSonido() {
        System.out.println("Guau guau");
    }
}