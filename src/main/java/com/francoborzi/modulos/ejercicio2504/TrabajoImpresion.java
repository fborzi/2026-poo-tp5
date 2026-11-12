package com.francoborzi.modulos.ejercicio2504;

/**
 * Representa un trabajo de impresion que implementa
 * la interfaz Trabajo.
 * Recibe el nombre del documento mediante el constructor
 * y permite ejecutar la impresion mostrando su nombre
 * en pantalla.
 */

public class TrabajoImpresion implements Trabajo {

    private String documento;

    public TrabajoImpresion(String documento) {
        this.documento = documento;
    }

    @Override
    public void ejecutar() {
        System.out.println("Imprimiendo: " + documento);
    }
}