package com.francoborzi.modulos.ejercicio2503;

public class Colectivo {

    private String patente;
    private String modelo;
    private Integer capacidadPasajeros;
    private Double kilometraje;

    public Colectivo(String patente, String modelo, Integer capacidadPasajeros) {
        this.patente = patente;
        this.modelo = modelo;
        this.capacidadPasajeros = capacidadPasajeros;
        this.kilometraje = 0.0;
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

    public Double getKilometraje() {
        return kilometraje;
    }

    public void registrarKilometros(Double kms) {
        kilometraje += kms;
    }
}