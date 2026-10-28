package edu.programacion.ejercicio2504;

/**
 * Define el comportamiento de un trabajo
 * que puede indicar si está listo para ejecutarse.
 */
public interface TrabajoConEstado extends edu.programacion.ejercicio2504.Trabajo {

    /**
     * Indica si el trabajo está listo para ejecutarse.
     *
     * @return true si está listo, false en caso contrario.
     */
    boolean estaListo();
}