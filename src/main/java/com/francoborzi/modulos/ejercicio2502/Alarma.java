
package com.francoborzi.modulos.ejercicio2502;

/**
 * Representa una alarma sonora.
 */
public class Alarma implements Hablante {

    /**
     * Emite el sonido de una alarma.
     */
    @Override
    public void hacerSonido() {
        System.out.println("Alarma: Ring ring ring");
    }
}