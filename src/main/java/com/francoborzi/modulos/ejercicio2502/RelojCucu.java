package com.francoborzi.modulos.ejercicio2502;

/**
 * Reloj cucú que canta la hora.
 */
public class RelojCucu implements Hablador {

    @Override
    public void hacerSonido() {
        System.out.println("Reloj cucú: Cucú, cucú..");
    }
}