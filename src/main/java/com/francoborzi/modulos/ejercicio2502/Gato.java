package com.francoborzi.modulos.ejercicio2502;

public class Gato extends Animal{
    @Override
    public void hacerSonido() {
        System.out.println("Miauu");
    }
    @Override
    public void hablar() {
        System.out.println("Miiiauuu mediante interfaz");
    }
}
