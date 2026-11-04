
package com.francoborzi.modulos.ejercicio2504;

/**
 * Indica que una cola no esta disponible para procesar trabajos.
 */
public class NoListaException extends Exception {

    private final String nombre;
    private final Long cantidadTrabajos;

    /**
     * Construye la excepcion.
     *
     * @param nombre nombre de la cola
     * @param trabajos cantidad de trabajos pendientes
     */
    public NoListaException(String nombre, Long trabajos) {
        super();
        this.nombre = nombre;
        this.cantidadTrabajos = trabajos;
    }

    /**
     * Obtiene el mensaje de error.
     *
     * @return descripcion de la excepcion
     */
    @Override
    public String getMessage() {
        return "La Cola de Trabajo: " + nombre
                + " no está disponible. Cantidad de trabajos a procesar : "
                + cantidadTrabajos;
    }
}