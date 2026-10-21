package com.francoborzi.modulos.ejercicio2504;

import java.util.ArrayList;
import java.util.List;

/**
 * Cola que permite encolar distintos tipos de trabajos y sacarlos en orden.
 */
public class ColaDeTrabajo {

    private String nombre;
    private Boolean lista;
    private List<Trabajo> trabajos;

    /**
     * Crea una cola vacía y lista para entregar trabajos.
     *
     * @param nombre nombre de la cola
     */
    public ColaDeTrabajo(String nombre) {
        this.nombre = nombre;
        this.lista = true;
        this.trabajos = new ArrayList<>();
    }

    /**
     * @return el nombre de la cola
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return true si la cola está lista para entregar trabajos
     */
    public Boolean isLista() {
        return lista;
    }

    /**
     * Indica si la cola está lista o no para entregar trabajos.
     *
     * @param lista true para habilitarla, false para deshabilitarla
     */
    public void setLista(Boolean lista) {
        this.lista = lista;
    }

    /**
     * Agrega un trabajo al final de la cola.
     *
     * @param trabajo trabajo a encolar
     */
    public void encolar(Trabajo trabajo) {
        trabajos.add(trabajo);
    }

    /**
     * Retorna y quita de la cola el próximo trabajo a procesar.
     *
     * @return el primer trabajo de la cola
     * @throws NoListaException si la cola no está lista
     * @throws SinTrabajoEnColaException si la cola no tiene trabajos
     */
    public Trabajo sacar() throws NoListaException, SinTrabajoEnColaException {
        if (!lista) {
            throw new NoListaException(nombre, Long.valueOf(trabajos.size()));
        }
        if (trabajos.isEmpty()) {
            throw new SinTrabajoEnColaException(nombre);
        }
        return trabajos.remove(0);
    }
}