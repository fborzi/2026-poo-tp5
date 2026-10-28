package edu.programacion.ejercicio2502;

/**
 * Representa al Dr. Dolittle, capaz de hacer hablar
 * a cualquier objeto que implemente la interfaz Hablador.
 */
public class DrDolittle {

    /**
     * Hace hablar a un animal.
     *
     * @param animal animal que debe emitir su sonido
     */
    public void hacerHablar(edu.programacion.ejercicio2502.Animal animal) {
        animal.hacerSonido();
    }

    /**
     * Hace hablar a cualquier objeto que implemente Hablador.
     * Este método permite aplicar polimorfismo extensible.
     *
     * @param hablador objeto capaz de hablar
     */
    public void hacerHablar2(edu.programacion.ejercicio2502.Hablador hablador) {
        hablador.hablar();
    }
}