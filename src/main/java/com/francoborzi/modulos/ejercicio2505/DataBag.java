
package edu.programacion.ejercicio2505;

/**
 * Colección que almacena objetos de cualquier tipo
 * y tiene una capacidad máxima de elementos.
 */
public class DataBag {

    private Object[] elementos;
    private int cantidad;

    /**
     * Construye una colección con capacidad máxima.
     *
     * @param capacidad cantidad máxima de elementos.
     */
    public DataBag(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException(
                    "La capacidad debe ser mayor que cero."
            );
        }

        elementos = new Object[capacidad];
        cantidad = 0;
    }

    /**
     * Agrega un objeto a la colección.
     *
     * @param elemento objeto que se desea agregar.
     * @throws edu.programacion.ejercicio2505.FullDataBagException si la colección está llena.
     */
    public void add(Object elemento) throws edu.programacion.ejercicio2505.FullDataBagException {
        if (cantidad == elementos.length) {
            throw new edu.programacion.ejercicio2505.FullDataBagException(
                    "La colección está llena."
            );
        }

        elementos[cantidad] = elemento;
        cantidad++;
    }

    /**
     * Elimina y devuelve el último objeto agregado.
     *
     * @return objeto eliminado.
     * @throws EmptyDataBagException si la colección está vacía.
     */
    public Object remove() throws edu.programacion.ejercicio2505.EmptyDataBagException {
        if (cantidad == 0) {
            throw new edu.programacion.ejercicio2505.EmptyDataBagException(
                    "La colección está vacía."
            );
        }

        cantidad--;
        Object elemento = elementos[cantidad];
        elementos[cantidad] = null;

        return elemento;
    }

    /**
     * Devuelve la cantidad actual de elementos.
     *
     * @return número de elementos almacenados.
     */
    public int size() {
        return cantidad;
    }

    /**
     * Indica si la colección está vacía.
     *
     * @return true si está vacía, false en caso contrario.
     */
    public boolean isEmpty() {
        return cantidad == 0;
    }

    /**
     * Devuelve la capacidad máxima de la colección.
     *
     * @return capacidad máxima.
     */
    public int capacity() {
        return elementos.length;
    }
}
