package com.francoborzi.modulos.ejercicio2506;

/**
 * Representa una excepcion que se produce cuando se supera
 * la cantidad maxima de extracciones permitidas en una
 * caja de ahorro.
 * Proporciona un mensaje para informar que se alcanzo
 * el limite de extracciones.
 */

public class SuperaCantidadExtraccionesException extends Exception {

    public SuperaCantidadExtraccionesException() {
        super("Se supero la cantidad maxima de extracciones permitidas.");
    }
}
