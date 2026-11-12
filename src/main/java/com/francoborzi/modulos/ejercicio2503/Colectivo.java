package com.francoborzi.modulos.ejercicio2503;

/**
 * Representa un colectivo que almacena su patente, modelo,
 * cantidad de pasajeros y kilometraje acumulado.
 * Al crearse, inicializa el kilometraje en cero y permite
 * consultar la capacidad de pasajeros, obtener los kilometros
 * acumulados y registrar nuevos kilometros recorridos.
 */

public class Colectivo {

    private String patente;
    private String modelo;
    private Integer cantidadPasajeros;
    private Double kilometrajeAcumulado;

    public Colectivo(String patente, String modelo, Integer cantidadPasajeros) {
        this.patente = patente;
        this.modelo = modelo;
        this.cantidadPasajeros = cantidadPasajeros;
        this.kilometrajeAcumulado = 0.0;
    }

    public Integer getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public Double getKilometrajeAcumulado() {
        return kilometrajeAcumulado;
    }

    public void registrarKilometros(Double kilometros) {
        kilometrajeAcumulado += kilometros;
    }
}
