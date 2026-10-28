package edu.programacion.ejercicio2502;

/**
 * Representa un gato, que es un tipo de animal.
 */
public class Gato extends Animal {

    /**
     * Hace el sonido característico del gato.
     */
    @Override
    public void hacerSonido() {
        System.out.println("Miau");
    }
}