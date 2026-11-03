package com.francoborzi.modulos.ejercicio2506;

public class SuperaLimiteMinimoException extends Exception {
    public SuperaLimiteMinimoException() {
        super("La extracción supera el límite mínimo permitido.");
    }
}
