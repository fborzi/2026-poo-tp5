package com.francoborzi.modulos.ejercicio2503;

public class Colectivo {
    private String patente;
    private String modelo;
    private Integer cantidadDePersonas;
    private Double kilometraje;

    public Colectivo(String patente, Integer cantidadDePersonas, String modelo,Double kilometraje) {
        this.patente = patente;
        this.cantidadDePersonas = cantidadDePersonas;
        this.modelo = modelo;
        this.kilometraje=kilometraje;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getCantidadDePersonas() {
        return cantidadDePersonas;
    }

    public void setCantidadDePersonas(Integer cantidadDePersonas) {
        this.cantidadDePersonas = cantidadDePersonas;
    }

    public Double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(Double kilometraje) {
        this.kilometraje = kilometraje;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Colectivo{");
        sb.append("patente='").append(patente).append('\'');
        sb.append(", modelo='").append(modelo).append('\'');
        sb.append(", cantidadDePersonas=").append(cantidadDePersonas);
        sb.append('}');
        return sb.toString();
    }
}
