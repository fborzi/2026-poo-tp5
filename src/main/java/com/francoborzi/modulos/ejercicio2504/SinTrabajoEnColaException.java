
package com.francoborzi.modulos.ejercicio2504;

/**
 * Representa una excepcion que se produce cuando una cola
 * de trabajo no contiene elementos para procesar.
 * Almacena el nombre de la cola y proporciona un mensaje
 * que informa que no hay trabajos disponibles.
 */

public class SinTrabajoEnColaException extends Exception {
    private String nombre;

    public SinTrabajoEnColaException(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getMessage() {
        return "La cola " + nombre + " no tiene trabajos para procesar.";
    }
}
