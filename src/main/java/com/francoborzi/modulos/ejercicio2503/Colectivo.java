package com.francoborzi.modulos.ejercicio2503;

/**
 * Colectivo de la cooperativa con su capacidad y kilometraje acumulado.
 */
public class Colectivo {

    private String patente;
    private String modelo;
    private Integer capacidadPasajeros;
    private Double kilometrajeAcumulado;

    /**
     * Crea un colectivo sin kilómetros registrados.
     *
     * @param patente patente del vehículo
     * @param modelo modelo del vehículo
     * @param capacidadPasajeros cantidad máxima de pasajeros
     */
    public Colectivo(String patente, String modelo, Integer capacidadPasajeros) {
        this.patente = patente;
        this.modelo = modelo;
        this.capacidadPasajeros = capacidadPasajeros;
        this.kilometrajeAcumulado = 0.0;
    }

    /**
     * @return la patente
     */
    public String getPatente() {
        return patente;
    }

    /**
     * @return el modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @return la capacidad máxima de pasajeros
     */
    public Integer getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    /**
     * @return los kilómetros acumulados en viajes
     */
    public Double getKilometrajeAcumulado() {
        return kilometrajeAcumulado;
    }

    /**
     * Indica si el colectivo tiene capacidad para la cantidad pedida.
     *
     * @param cantidad cantidad de pasajeros del viaje
     * @return true si entran todos los pasajeros
     */
    public Boolean puedeLlevar(Integer cantidad) {
        return cantidad <= capacidadPasajeros;
    }

    /**
     * Suma los kilómetros de un viaje al acumulado.
     *
     * @param kms kilómetros recorridos en el viaje
     */
    public void registrarKilometros(Double kms) {
        kilometrajeAcumulado = kilometrajeAcumulado + kms;
    }

    @Override
    public String toString() {
        return "Colectivo " + patente + " (" + modelo + ") - "
                + capacidadPasajeros + " pasajeros - "
                + kilometrajeAcumulado + " km";
    }
}