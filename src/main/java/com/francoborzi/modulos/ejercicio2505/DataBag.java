package com.francoborzi.modulos.ejercicio2505;

/**
 * Representa una bolsa de datos que permite almacenar
 * y eliminar elementos de diferentes tipos.
 * Tiene una capacidad maxima establecida mediante
 * el constructor y controla que no se agreguen elementos
 * cuando esta llena ni se eliminen cuando esta vacia.
 * Utiliza excepciones para informar estas situaciones.
 */

import java.util.ArrayList;
import java.util.List;

public class DataBag {
    private Integer capacidadMaxima;
    private List<Object> elementos;

    public DataBag(Integer capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.elementos = new ArrayList<>();
    }
    public void add(Object elemento) throws FullDataBagException {
        if (elementos.size() >= capacidadMaxima) {
            throw new FullDataBagException();
        }

        elementos.add(elemento);
    }
    public void remove(Object elemento) throws EmptyDataBagException {
        if (elementos.isEmpty()) {
            throw new EmptyDataBagException();
        }

        elementos.remove(elemento);
    }
}

