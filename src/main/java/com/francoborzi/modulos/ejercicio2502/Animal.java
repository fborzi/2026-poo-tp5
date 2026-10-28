package edu.programacion.ejercicio2502;

/**
 * Clase abstracta que representa un animal.
 * Todo animal puede hacer su sonido y hablar.
 */
public abstract class Animal implements edu.programacion.ejercicio2502.Hablador {

    /**
     * Hace el sonido característico del animal.
     */
    public abstract void hacerSonido();

    /**
     * Permite que el animal hable utilizando su sonido característico.
     */
    @Override
    public void hablar() {
        hacerSonido();
    }
}