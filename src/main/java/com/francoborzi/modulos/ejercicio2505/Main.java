package com.francoborzi.modulos.ejercicio2505;

public class Main {
    static void main(String[] args) {

        DataBag bolsa = new DataBag(2);

        try {
            bolsa.add("Java");
            bolsa.add(25);

            bolsa.add("Python");

        } catch (FullDataBagException e) {
            System.out.println(e.getMessage());
        }

        try {
            bolsa.remove("Java");
            bolsa.remove(25);

            bolsa.remove("Python");

        } catch (EmptyDataBagException e) {
            System.out.println(e.getMessage());
        }
    }
}

