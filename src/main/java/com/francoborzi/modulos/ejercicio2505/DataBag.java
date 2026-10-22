package com.francoborzi.modulos.ejercicio2505;

import java.util.ArrayList;
import java.util.List;

/**
 * Bolsa con un número máximo de elementos que almacena cualquier tipo de objeto.
 */
public class DataBag {

    private Integer maximo;
    private List<Object> elementos;

    /**
     * Crea una bolsa vacía.
     *
     * @param maximo cantidad máxima de elementos que admite
     */
    public DataBag(Integer maximo) {
        this.maximo = maximo;
        this.elementos = new ArrayList<>();
    }

    /**
     * @return la cantidad máxima de elementos
     */
    public Integer getMaximo() {
        return maximo;
    }

    /**
     * @return la cantidad actual de elementos
     */
    public Integer getCantidad() {
        return elementos.size();
    }

    /**
     * @return true si la bolsa alcanzó su máximo
     */
    public Boolean estaLlena() {
        return elementos.size() >= maximo;
    }

    /**
     * @return true si la bolsa no tiene elementos
     */
    public Boolean estaVacia() {
        return elementos.isEmpty();
    }

    /**
     * Agrega un elemento a la bolsa.
     *
     * @param elemento objeto a agregar
     * @throws FullDataBagException si la bolsa está llena
     */
    public void add(Object elemento) throws FullDataBagException {
        if (estaLlena()) {
            throw new FullDataBagException(maximo);
        }
        elementos.add(elemento);
    }

    /**
     * Remueve un elemento de la bolsa.
     *
     * @param elemento objeto a remover
     * @throws EmptyDataBagException si la bolsa está vacía
     */
    public void remove(Object elemento) throws EmptyDataBagException {
        if (estaVacia()) {
            throw new EmptyDataBagException();
        }
        elementos.remove(elemento);
    }

    @Override
    public String toString() {
        return "DataBag " + elementos + " (" + elementos.size() + "/" + maximo + ")";
    }
}