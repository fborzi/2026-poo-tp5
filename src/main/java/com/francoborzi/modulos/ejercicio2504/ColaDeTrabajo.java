package com.francoborzi.modulos.ejercicio2504;

import java.util.Queue;
import java.util.LinkedList;

public class ColaDeTrabajo {

    private String nombre;
    private boolean lista;
    private Queue<Trabajo> trabajos;

    public ColaDeTrabajo(String nombre, boolean lista) {
        this.nombre = nombre;
        this.lista = lista;
        this.trabajos = new LinkedList<>();
    }

    public void agregar(Trabajo trabajo) {
        trabajos.add(trabajo);
    }

    public Trabajo sacar()
            throws NoListaException, SinTrabajoEnColaException {

        if (!lista) {
            throw new NoListaException(nombre, (long) trabajos.size());
        }

        if (trabajos.isEmpty()) {
            throw new SinTrabajoEnColaException(nombre);
        }

        return trabajos.poll();
    }

    public void setLista(boolean lista) {
        this.lista = lista;
    }
}