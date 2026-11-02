package com.francoborzi.modulos.ejercicio2505;


public class FullDataBagException extends Exception {

    public FullDataBagException() {
        super("La bolsa está llena. No se pueden agregar más elementos.");
    }
}
