
package com.francoborzi.modulos.ejercicio2504;

/**
 * Indica que no existen trabajos pendientes en la cola.
 */
public class SinTrabajoEnColaException extends Exception {

    private final String nombre;

    /**
     * Construye la excepcion.
     *
     * @param nombre nombre de la cola
     */
    public SinTrabajoEnColaException(String nombre) {
        super();
        this.nombre = nombre;
    }

    /**
     * Obtiene el mensaje de error.
     *
     * @return descripcion de la excepcion
     */
    @Override
    public String getMessage() {
        return "La cola " + nombre
                + " no tiene trabajos para procesar.";
    }
}
