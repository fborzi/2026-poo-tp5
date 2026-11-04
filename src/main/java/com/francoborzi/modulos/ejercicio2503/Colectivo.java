
package com.francoborzi.modulos.ejercicio2503;

/**
 * Representa un colectivo de la cooperativa.
 */
public class Colectivo {

    private final String patente;
    private final String modelo;
    private final int capacidadPasajeros;
    private double kilometrajeAcumulado;

    /**
     * Construye un colectivo.
     *
     * @param patente patente del vehiculo
     * @param modelo modelo del vehiculo
     * @param capacidadPasajeros capacidad maxima
     */
    public Colectivo(String patente, String modelo,
                     int capacidadPasajeros) {
        if (patente == null || patente.isBlank()
                || modelo == null || modelo.isBlank()
                || capacidadPasajeros <= 0) {
            throw new IllegalArgumentException(
                    "Los datos del colectivo son invalidos");
        }

        this.patente = patente;
        this.modelo = modelo;
        this.capacidadPasajeros = capacidadPasajeros;
        this.kilometrajeAcumulado = 0.0;
    }

    /**
     * Comprueba si el colectivo tiene capacidad suficiente.
     *
     * @param cantidadPasajeros pasajeros del viaje
     * @return true si tiene capacidad
     */
    public boolean puedeTransportar(int cantidadPasajeros) {
        return cantidadPasajeros > 0
                && cantidadPasajeros <= capacidadPasajeros;
    }

    /**
     * Registra los kilometros recorridos.
     *
     * @param cantidadKms kilometros del viaje
     */
    public void registrarViaje(double cantidadKms) {
        if (!Double.isFinite(cantidadKms)
                || cantidadKms <= 0) {
            throw new IllegalArgumentException(
                    "Los kilometros deben ser positivos y finitos");
        }

        kilometrajeAcumulado += cantidadKms;
    }

    /**
     * Obtiene la patente.
     *
     * @return patente del colectivo
     */
    public String getPatente() {
        return patente;
    }

    /**
     * Obtiene el modelo.
     *
     * @return modelo del colectivo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Obtiene la capacidad de pasajeros.
     *
     * @return capacidad maxima
     */
    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    /**
     * Obtiene el kilometraje acumulado.
     *
     * @return kilometraje del colectivo
     */
    public double getKilometrajeAcumulado() {
        return kilometrajeAcumulado;
    }

    /**
     * Devuelve una descripcion del colectivo.
     *
     * @return informacion del colectivo
     */
    @Override
    public String toString() {
        return modelo + " - " + patente
                + " - Capacidad: " + capacidadPasajeros
                + " - Kilometros: " + kilometrajeAcumulado;
    }
}