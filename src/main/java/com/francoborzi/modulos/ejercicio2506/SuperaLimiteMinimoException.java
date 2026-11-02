
package edu.programacion.ejercicio2506;

/**
 * Excepción que se produce cuando una extracción
 * deja el saldo por debajo del límite mínimo permitido.
 */
public class SuperaLimiteMinimoException extends Exception {

    /**
     * Construye la excepción con un mensaje descriptivo.
     *
     * @param mensaje descripción del error.
     */
    public SuperaLimiteMinimoException(String mensaje) {
        super(mensaje);
    }
}
