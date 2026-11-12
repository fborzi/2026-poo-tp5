package com.francoborzi.modulos.ejercicio2502;

/**
 * Representa una clase abstracta que sirve como base
 * para los diferentes tipos de animales.
 * Implementa la interfaz Hablador y establece el método
 * abstracto hacerSonido(), que debe ser definido por
 * las clases que heredan de ella.
 */

public abstract class Animal implements Hablador {

    public abstract void hacerSonido();

    public void hablar () {
        hacerSonido();
    }


}

