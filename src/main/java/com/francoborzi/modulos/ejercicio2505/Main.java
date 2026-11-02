package com.francoborzi.modulos.ejercicio2505;


public class Main {

    public static void main(String[] args) {

        DataBag bolsa = new DataBag(3);

        System.out.println("=== PRUEBA 1: AGREGAR ELEMENTOS ===");

        try {
            bolsa.add("Hola");
            bolsa.add(25);
            bolsa.add(3.5);

            System.out.println("Elementos agregados: "
                    + bolsa.cantidadElementos());

        } catch (FullDataBagException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n=== PRUEBA 2: BOLSA LLENA ===");

        try {
            bolsa.add("Cuarto elemento");

        } catch (FullDataBagException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n=== PRUEBA 3: QUITAR UN ELEMENTO ===");

        try {
            bolsa.remove(25);

            System.out.println("Elemento eliminado.");
            System.out.println("Elementos restantes: "
                    + bolsa.cantidadElementos());

        } catch (EmptyDataBagException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n=== PRUEBA 4: BOLSA VACÍA ===");

        DataBag bolsaVacia = new DataBag(3);

        try {
            bolsaVacia.remove("Hola");

        } catch (EmptyDataBagException e) {
            System.out.println(e.getMessage());
        }
    }
}