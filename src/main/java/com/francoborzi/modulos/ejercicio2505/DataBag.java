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

        System.out.println("Elemento agregado: " + elemento);
    }

    public void remove(Object elemento) throws EmptyDataBagException {

        if (elementos.isEmpty()) {
            throw new EmptyDataBagException("La bolsa está vacía");
        }

        if (elementos.remove(elemento)) {
            System.out.println("Elemento eliminado: " + elemento);
        } else {
            System.out.println("El elemento no se encuentra en la bolsa");
        }
    }


    public void mostrarElementos() {
        System.out.println("Elementos de la bolsa: " + elementos);
    }
}