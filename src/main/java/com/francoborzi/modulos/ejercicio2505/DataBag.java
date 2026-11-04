
package com.francoborzi.modulos.ejercicio2505;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa una bolsa de objetos con capacidad limitada.
 */
public class DataBag {

    private final int capacidadMaxima;
    private final List<Object> elementos;

    /**
     * Construye una bolsa con capacidad definida.
     *
     * @param capacidadMaxima cantidad maxima de elementos
     */
    public DataBag(int capacidadMaxima) {
        if (capacidadMaxima <= 0) {
            throw new IllegalArgumentException(
                    "La capacidad debe ser mayor que cero");
        }

        this.capacidadMaxima = capacidadMaxima;
        this.elementos = new ArrayList<>();
    }

    /**
     * Agrega un objeto a la bolsa.
     *
     * @param elemento objeto que se desea agregar
     * @throws FullDataBagException si la bolsa esta llena
     */
    public void add(Object elemento) throws FullDataBagException {
        if (elementos.size() >= capacidadMaxima) {
            throw new FullDataBagException();
        }

        elementos.add(elemento);
    }

    /**
     * Elimina un objeto de la bolsa.
     *
     * @param elemento objeto que se desea eliminar
     * @throws EmptyDataBagException si la bolsa esta vacia
     */
    public void remove(Object elemento) throws EmptyDataBagException {
        if (elementos.isEmpty()) {
            throw new EmptyDataBagException();
        }

        elementos.remove(elemento);
    }

    /**
     * Obtiene la cantidad actual de elementos.
     *
     * @return cantidad de elementos almacenados
     */
    public int size() {
        return elementos.size();
    }

    /**
     * Indica si la bolsa esta llena.
     *
     * @return true si alcanzo la capacidad maxima
     */
    public boolean isFull() {
        return elementos.size() == capacidadMaxima;
    }

    /**
     * Indica si la bolsa esta vacia.
     *
     * @return true si no contiene elementos
     */
    public boolean isEmpty() {
        return elementos.isEmpty();
    }

    /**
     * Obtiene la capacidad maxima.
     *
     * @return capacidad de la bolsa
     */
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    /**
     * Devuelve una copia de los elementos.
     *
     * @return elementos almacenados
     */
    public List<Object> getElementos() {
        return new ArrayList<>(elementos);
    }
}