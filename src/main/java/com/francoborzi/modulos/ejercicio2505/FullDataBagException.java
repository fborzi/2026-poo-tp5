
package edu.programacion.ejercicio2505;

/**
 * Excepción que se produce cuando la colección DataBag
 * está llena y no permite agregar más elementos.
 */
public class FullDataBagException extends Exception {

    /**
     * Construye la excepción con un mensaje.
     *
     * @param mensaje descripción del error.
     */
    public FullDataBagException(String mensaje) {
        super(mensaje);
    }
}
