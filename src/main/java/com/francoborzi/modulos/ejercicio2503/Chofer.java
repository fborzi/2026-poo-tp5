package com.francoborzi.modulos.ejercicio2503;

public class Chofer {
    private String nombreCompleto;
    private Colectivo unidadAsignada;

    public Chofer(String nombreCompleto, Colectivo unidadAsignada) {
        this.nombreCompleto = nombreCompleto;
        this.unidadAsignada = unidadAsignada;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Colectivo getUnidadAsignada() {
        return unidadAsignada;
    }

    public void setUnidadAsignada(Colectivo unidadAsignada) {
        this.unidadAsignada = unidadAsignada;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Chofer{");
        sb.append("nombreCompleto='").append(nombreCompleto).append('\'');
        sb.append(", unidadAsignada=").append(unidadAsignada);
        sb.append('}');
        return sb.toString();
    }
}
