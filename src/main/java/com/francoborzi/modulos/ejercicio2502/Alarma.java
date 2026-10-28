package edu.programacion.ejercicio2502;

/**
 * Representa una alarma que puede emitir un sonido.
 * Implementa la interfaz Hablador.
 */
public class Alarma implements Hablador {

    /**
     * Emite el sonido de la alarma.
     */
    @Override
    public void hablar() {
        System.out.println("¡Ring ring! ¡Alarma activada!");
    }
}