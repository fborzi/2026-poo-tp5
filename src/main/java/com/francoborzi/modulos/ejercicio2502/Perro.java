package com.francoborzi.modulos.ejercicio2502;

public class Perro extends Animal{
    @Override
    public void hacerSonido() {
        System.out.println("Guaaaauu Guaaauuu");
    }

    @Override
    public void hablar() {
        System.out.println("Guuaa mediante interfaz");
    }
}
