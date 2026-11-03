package com.francoborzi.modulos.ejercicio2505;

public class EmptyDataBagException extends Exception {
    public EmptyDataBagException() {
        super("la bolsa está vacía.");
    }
}