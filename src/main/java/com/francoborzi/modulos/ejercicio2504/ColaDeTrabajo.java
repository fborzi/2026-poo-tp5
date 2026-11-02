package com.francoborzi.modulos.ejercicio2504;

import java.util.ArrayList;

public class ColaDeTrabajo {
    private boolean lista;
    private String nombre;
    private ArrayList<Trabajo> trabajos;

    public ColaDeTrabajo(boolean lista, String nombre) {
        this.lista = lista;
        this.nombre = nombre;
        this.trabajos= new ArrayList<>();
    }

    public void encolar(Trabajo trabajo) {
        this.trabajos.add(trabajo);
    }

    public Trabajo sacar() throws NoListaException, SinTrabajoEnColaException {

        if (!this.lista) {
            Long cantidad = (long) trabajos.size();
            throw new NoListaException(this.nombre, cantidad);
        }
        if (trabajos.isEmpty()) {
            throw  new SinTrabajoEnColaException(this.nombre);
        }
        return trabajos.remove(0);
    }


    public boolean isLista() {
        return lista;
    }

    public void setLista(boolean lista) {
        this.lista = lista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
