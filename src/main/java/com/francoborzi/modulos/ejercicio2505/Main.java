package com.francoborzi.modulos.ejercicio2505;

public class Main {
    static void main() {
        DataBag bolsa = new DataBag(3);

        System.out.println("--- Agrego 4 elementos de distinto tipo en una bolsa de 3 ---");
        try {
            bolsa.add("Hola");
            bolsa.add(42);
            bolsa.add(3.14);
            System.out.println(bolsa);
            bolsa.add("Este no entra");
        } catch (FullDataBagException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("--- Remuevo 4 veces de una bolsa con 3 ---");
        try {
            bolsa.remove("Hola");
            bolsa.remove(42);
            bolsa.remove(3.14);
            System.out.println(bolsa);
            bolsa.remove("Hola");
        } catch (EmptyDataBagException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}