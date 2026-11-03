package com.francoborzi.modulos.ejercicio2504;

public class TrabajoImpresion implements Trabajo {

    private String documento;

    public TrabajoImpresion(String documento) {
        this.documento = documento;
    }

    @Override
    public String toString() {
        return "Trabajo de impresión: " + documento;
    }
}