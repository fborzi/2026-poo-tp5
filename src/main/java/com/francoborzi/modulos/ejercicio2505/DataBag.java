package com.francoborzi.modulos.ejercicio2505;

import java.util.ArrayList;

public class DataBag {

    private int capacidadMaxima;
    private ArrayList<Object> elementos;

    public DataBag(int capacidadMaxima) {
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

    public int cantidadElementos() {
        return elementos.size();
    }
}
