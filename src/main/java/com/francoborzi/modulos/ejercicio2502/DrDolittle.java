
package com.francoborzi.modulos.ejercicio2502;

/**
 * Permite hacer hablar a distintos objetos.
 */
public final class DrDolittle {

    private DrDolittle() {
    }

    /**
     * Hace hablar exclusivamente a un animal.
     *
     * @param animal animal que emite el sonido
     */
    public static void hacerHablar(Animal animal) {
        animal.hacerSonido();
    }

    /**
     * Hace hablar a cualquier objeto que implemente Hablante.
     *
     * @param hablante objeto que emite el sonido
     */
    public static void hacerHablar2(Hablante hablante) {
        hablante.hacerSonido();
    }
}
