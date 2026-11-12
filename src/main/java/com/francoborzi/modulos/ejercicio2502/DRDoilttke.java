package com.francoborzi.modulos.ejercicio2502;

/**
 * Contiene metodos estáticos que permiten hacer hablar
 * a diferentes objetos mediante polimorfismo.
 * Permite trabajar tanto con objetos de tipo Animal
 * como con cualquier objeto que implemente la interfaz Hablador.
 */

public class DRDoilttke {

    public static void hacerHablar(Animal animal) {
        animal.hacerSonido();
    }

    public static void hacerHablar2(Hablador hablador) {
        hablador.hablar();
    }
}
