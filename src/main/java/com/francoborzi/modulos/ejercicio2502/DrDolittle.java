package com.francoborzi.modulos.ejercicio2502;

/**
 * Hace "hablar" a animales y a cualquier objeto que sepa emitir un sonido.
 */
public class DrDolittle {

    /**
     * Hace hablar a un animal. Solo acepta animales.
     *
     * @param animal animal que va a hablar
     */
    public void hacerHablar(Animal animal) {
        animal.hacerSonido();
    }

    /**
     * Hace hablar a cualquier objeto Hablador: animales, personas,
     * alarmas, relojes o cualquier clase nueva que implemente la interfaz.
     *
     * @param hablador objeto que va a emitir su sonido
     */
    public void hacerHablar2(Hablador hablador) {
        hablador.hacerSonido();
    }
}