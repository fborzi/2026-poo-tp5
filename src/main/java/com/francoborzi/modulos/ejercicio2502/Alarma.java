package com.francoborzi.modulos.ejercicio2502;

/**
 * Representa una alarma que implementa la interfaz Hablador.
 * Permite emitir un sonido de aviso mediante el metodo hablar(),
 * mostrada  el mensaje "ring ring" en pantalla.
 */

public class Alarma implements Hablador {

    public void hablar() {
        System.out.println("ring ring ");
    }
}
