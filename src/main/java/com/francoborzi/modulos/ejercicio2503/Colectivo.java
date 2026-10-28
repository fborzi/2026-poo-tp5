package edu.programacion.ejercicio2503;

/**
 * Representa un colectivo perteneciente a una cooperativa de transporte.
 * Guarda su patente, modelo y capacidad de pasajeros.
 */
public class Colectivo {

    private String patente;
    private String modelo;
    private int capacidadPasajeros;
    private double kilometrajeAcumulado;

    /**
     * Crea un colectivo con sus datos principales.
     *
     * @param patente patente del vehículo
     * @param modelo modelo del vehículo
     * @param capacidadPasajeros cantidad máxima de pasajeros
     */
    public Colectivo(String patente, String modelo, int capacidadPasajeros) {
        this.patente = patente;
        this.modelo = modelo;
        this.capacidadPasajeros = capacidadPasajeros;
        this.kilometrajeAcumulado = 0;
    }

    /**
     * Obtiene la patente del colectivo.
     *
     * @return patente del vehículo
     */
    public String getPatente() {
        return patente;
    }

    /**
     * Obtiene el modelo del colectivo.
     *
     * @return modelo del vehículo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Obtiene la capacidad máxima de pasajeros.
     *
     * @return cantidad máxima de pasajeros
     */
    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    /**
     * Obtiene el kilometraje acumulado del colectivo.
     *
     * @return kilometraje acumulado
     */
    public double getKilometrajeAcumulado() {
        return kilometrajeAcumulado;
    }

    /**
     * Registra los kilómetros realizados en un viaje.
     *
     * @param kilometros kilómetros recorridos
     */
    public void registrarKilometros(double kilometros) {
        if (kilometros > 0) {
            kilometrajeAcumulado += kilometros;
        }
    }
}