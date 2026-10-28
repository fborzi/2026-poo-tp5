package edu.programacion.ejercicio2504;

/**
 * Representa una tarea que puede estar
 * lista o pendiente para su ejecución.
 */
public class Tarea implements edu.programacion.ejercicio2504.TrabajoConEstado {

    private String nombre;
    private boolean listo;

    /**
     * Construye una tarea con su nombre y estado.
     *
     * @param nombre nombre de la tarea.
     * @param listo indica si está lista.
     */
    public Tarea(String nombre, boolean listo) {
        this.nombre = nombre;
        this.listo = listo;
    }

    /**
     * Ejecuta la tarea mostrando su nombre.
     */
    @Override
    public void ejecutar() {
        System.out.println("Ejecutando tarea: " + nombre);
    }

    /**
     * Consulta si la tarea está lista.
     *
     * @return true si está lista, false si no.
     */
    @Override
    public boolean estaListo() {
        return listo;
    }

    /**
     * Modifica el estado de la tarea.
     *
     * @param listo nuevo estado.
     */
    public void setListo(boolean listo) {
        this.listo = listo;
    }

    /**
     * Obtiene el nombre de la tarea.
     *
     * @return nombre de la tarea.
     */
    public String getNombre() {
        return nombre;
    }
}