package edu.programacion.ejercicio2502;

/**
 * Representa un reloj que puede emitir un sonido.
 * Implementa la interfaz Hablador.
 */
public class Reloj implements edu.programacion.ejercicio2502.Hablador {

    /**
     * Emite el sonido característico del reloj.
     */
    @Override
    public void hablar() {
        System.out.println("Tic tac, tic tac");
    }
}