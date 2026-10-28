package edu.programacion.ejercicio2504;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Administra una cola de trabajos pendientes.
 * Los trabajos se procesan en orden FIFO:
 * primero en entrar, primero en salir.
 *
 * @author
 * @version 1.0
 */
public class ColaDeTrabajo {

    private Queue<edu.programacion.ejercicio2504.Trabajo> trabajos;

    /**
     * Crea una cola de trabajo vacía.
     */
    public ColaDeTrabajo() {
        trabajos = new LinkedList<>();
    }

    /**
     * Agrega un trabajo al final de la cola.
     *
     * @param trabajo trabajo que se desea agregar
     */
    public void agregarTrabajo(edu.programacion.ejercicio2504.Trabajo trabajo) {
        if (trabajo != null) {
            trabajos.offer(trabajo);
        }
    }

    /**
     * Obtiene y ejecuta el siguiente trabajo de la cola.
     *
     * @throws edu.programacion.ejercicio2504.SinTrabajoEnColaException si la cola está vacía
     * @throws edu.programacion.ejercicio2504.NoListaException si el trabajo no está listo
     */
    public void ejecutarSiguiente()
            throws edu.programacion.ejercicio2504.SinTrabajoEnColaException, edu.programacion.ejercicio2504.NoListaException {

        if (trabajos.isEmpty()) {
            throw new edu.programacion.ejercicio2504.SinTrabajoEnColaException(
                    "No hay trabajos pendientes en la cola.");
        }

        edu.programacion.ejercicio2504.Trabajo trabajo = trabajos.peek();

        if (trabajo instanceof edu.programacion.ejercicio2504.TrabajoConEstado
                && !((TrabajoConEstado) trabajo).estaListo()) {
            throw new edu.programacion.ejercicio2504.NoListaException(
                    "El trabajo todavía no está listo para ejecutarse.");
        }

        trabajos.poll();
        trabajo.ejecutar();
    }

    /**
     * Indica si la cola no contiene trabajos.
     *
     * @return true si la cola está vacía; false en caso contrario
     */
    public boolean estaVacia() {
        return trabajos.isEmpty();
    }

    /**
     * Obtiene la cantidad de trabajos pendientes.
     *
     * @return cantidad de trabajos en la cola
     */
    public int cantidadTrabajos() {
        return trabajos.size();
    }
}