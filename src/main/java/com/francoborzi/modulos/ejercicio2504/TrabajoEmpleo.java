package com.francoborzi.modulos.ejercicio2504;

public class TrabajoEmpleo implements Trabajo{
    private String descripcion;

    public TrabajoEmpleo(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public void ejecutar() {
        System.out.println("-> Ejecutando: " + this.descripcion);
    }
}
