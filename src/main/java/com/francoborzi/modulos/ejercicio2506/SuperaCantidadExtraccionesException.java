package com.francoborzi.modulos.ejercicio2506;

public class SuperaCantidadExtraccionesException extends Exception {
    public SuperaCantidadExtraccionesException() {
        super("se supero la cantidad máxima de extracciones");
    }
}
