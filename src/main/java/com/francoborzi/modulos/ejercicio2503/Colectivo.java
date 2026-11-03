package com.francoborzi.modulos.ejercicio2503;

public class Colectivo {

    private String patente;
    private String modelo;
    private Integer capacidadPasajeros;
    private Double kilometrajeAcumulado;

    public Colectivo(String patente, String modelo,
                     Integer capacidadPasajeros) {

        this.patente = patente;
        this.modelo = modelo;
        this.capacidadPasajeros = capacidadPasajeros;
        this.kilometrajeAcumulado = 0.0;
    }

    public void registrarKilometros(Double kilometros) {
        kilometrajeAcumulado += kilometros;
    }

    public String getPatente() {
        return patente;
    }

    public String getModelo() {
        return modelo;
    }

    public Integer getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public Double getKilometrajeAcumulado() {
        return kilometrajeAcumulado;
    }

    @Override
    public String toString() {
        return "Patente: " + patente
                + " | Modelo: " + modelo
                + " | Capacidad: " + capacidadPasajeros
                + " | Kilómetros: " + kilometrajeAcumulado;
    }
}