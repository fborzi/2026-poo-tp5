package com.francoborzi.modulos.ejercicio2502;

public class Lechuza extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("Shhhhh Shhhh");
    }
    @Override
    public void hablar(){
        System.out.println("SHHHH mediante interfaz");
    }
}
