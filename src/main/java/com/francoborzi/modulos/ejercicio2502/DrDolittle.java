package com.francoborzi.modulos.ejercicio2502;

/**
 * Hace "hablar" a animales y a cualquier objeto que sepa emitir un sonido.
 */
public final class DrDolittle {

    private DrDolittle() {
    }

    /**
     * Hace hablar a un animal. Solo acepta animales.
     *
     * @param animal animal que va a hablar
     */
    public static void hacerHablar(final Animal animal) {
        animal.hacerSonido();
    }

    /**
     * Hace hablar a cualquier objeto Sonoro: animales, personas,
     * alarmas, relojes o cualquier clase nueva que implemente la interfaz.
     *
     * @param hablador objeto que va a emitir su sonido
     */
    public static void hacerHablar2(final Hablador hablador) {
        hablador.hacerSonido();
    }
}