package edu.programacion.ejercicio2503;

/**
 * Representa a un chofer que trabaja en una cooperativa de transporte.
 * Cada chofer maneja un colectivo diferente.
 */
public class Chofer {

    private String nombre;
    private edu.programacion.ejercicio2503.Colectivo colectivo;

    /**
     * Crea un chofer con su nombre y el colectivo que maneja.
     *
     * @param nombre nombre del chofer
     * @param colectivo colectivo asignado al chofer
     */
    public Chofer(String nombre, edu.programacion.ejercicio2503.Colectivo colectivo) {
        this.nombre = nombre;
        this.colectivo = colectivo;
    }

    /**
     * Obtiene el nombre del chofer.
     *
     * @return nombre del chofer
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el colectivo que maneja el chofer.
     *
     * @return colectivo asignado
     */
    public edu.programacion.ejercicio2503.Colectivo getColectivo() {
        return colectivo;
    }

    /**
     * Indica si el colectivo del chofer tiene capacidad para la cantidad
     * de pasajeros solicitada.
     *
     * @param cantidadPasajeros cantidad de pasajeros del viaje
     * @return true si el colectivo tiene capacidad suficiente
     */
    public boolean puedeRealizarViaje(int cantidadPasajeros) {
        return cantidadPasajeros > 0
                && cantidadPasajeros <= colectivo.getCapacidadPasajeros();
    }

    /**
     * Registra los kilómetros realizados por el colectivo del chofer.
     *
     * @param kilometros kilómetros recorridos
     */
    public void registrarKilometros(double kilometros) {
        colectivo.registrarKilometros(kilometros);
    }
}