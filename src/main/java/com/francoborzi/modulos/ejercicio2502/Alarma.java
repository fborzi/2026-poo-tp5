package com.francoborzi.modulos.ejercicio2502;

/**
 * Alarma que suena.
 */
public class Alarma implements Hablador {

    @Override
    public void hacerSonido() {
        System.out.println("Alarma: Riiiing riiiing");
    }
}