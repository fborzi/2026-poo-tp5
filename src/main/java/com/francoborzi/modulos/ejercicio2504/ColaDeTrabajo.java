
package com.francoborzi.modulos.ejercicio2504;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

/**
 * Administra una cola de trabajos pendientes.
 */
public class ColaDeTrabajo {

    private final String nombre;
    private boolean lista;
    private final Queue<Trabajo> trabajos;

    /**
     * Construye una cola de trabajo.
     *
     * @param nombre nombre de la cola
     */
    public ColaDeTrabajo(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException(
                    "El nombre de la cola es obligatorio");
        }

        this.nombre = nombre;
        this.lista = false;
        this.trabajos = new ArrayDeque<>();
    }

    /**
     * Agrega un trabajo al final de la cola.
     *
     * @param trabajo trabajo a agregar
     */
    public void encolar(Trabajo trabajo) {
        trabajos.add(Objects.requireNonNull(trabajo));
    }

    /**
     * Retira y devuelve el siguiente trabajo.
     *
     * @return siguiente trabajo pendiente
     * @throws NoListaException si la cola no esta lista
     * @throws SinTrabajoEnColaException si no hay trabajos
     */
    public Trabajo sacar()
            throws NoListaException, SinTrabajoEnColaException {

        if (!lista) {
            throw new NoListaException(
                    nombre, (long) trabajos.size());
        }

        if (trabajos.isEmpty()) {
            throw new SinTrabajoEnColaException(nombre);
        }

        return trabajos.remove();
    }

    /**
     * Cambia la disponibilidad de la cola.
     *
     * @param lista true si la cola esta lista
     */
    public void setLista(boolean lista) {
        this.lista = lista;
    }

    /**
     * Indica si la cola esta lista.
     *
     * @return true si esta disponible
     */
    public boolean isLista() {
        return lista;
    }

    /**
     * Obtiene el nombre de la cola.
     *
     * @return nombre de la cola
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la cantidad de trabajos pendientes.
     *
     * @return cantidad de trabajos
     */
    public int cantidadTrabajos() {
        return trabajos.size();
    }
}