
package edu.programacion.ejercicio2505;

/**
 * Excepción que se produce cuando se intenta
 * eliminar un elemento de una colección DataBag vacía.
 *
 * @author
 * @version 1.0
 */
public class EmptyDataBagException extends Exception {

    /**
     * Construye la excepción con un mensaje.
     *
     * @param mensaje descripción del error.
     */
    public EmptyDataBagException(String mensaje) {
        super(mensaje);
    }
}
