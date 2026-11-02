package com.francoborzi.modulos.ejercicio2504;

public class Main {

    public static void main(String[] args) {

        // PRUEBA 1: ejecutar varios trabajos
        System.out.println("=== PRUEBA 1: TRABAJOS ===");

        ColaDeTrabajo cola =
                new ColaDeTrabajo("Cola principal", true);

        cola.agregarTrabajo(new MiTrabajo());
        cola.agregarTrabajo(new TrabajoImpresion());
        cola.agregarTrabajo(new TrabajoDescarga());

        try {
            Trabajo trabajo1 = cola.sacar();
            trabajo1.ejecutar();

            Trabajo trabajo2 = cola.sacar();
            trabajo2.ejecutar();

            Trabajo trabajo3 = cola.sacar();
            trabajo3.ejecutar();

        } catch (NoListaException e) {
            System.out.println(e.getMessage());

        } catch (SinTrabajoEnColaException e) {
            System.out.println(e.getMessage());
        }

        // PRUEBA 2: intentar sacar de una cola vacía
        System.out.println("\n=== PRUEBA 2: COLA VACÍA ===");

        try {
            Trabajo trabajo = cola.sacar();
            trabajo.ejecutar();

        } catch (NoListaException e) {
            System.out.println(e.getMessage());

        } catch (SinTrabajoEnColaException e) {
            System.out.println(e.getMessage());
        }

        // PRUEBA 3: intentar sacar de una cola no lista
        System.out.println("\n=== PRUEBA 3: COLA NO LISTA ===");

        ColaDeTrabajo colaNoLista =
                new ColaDeTrabajo("Cola secundaria", false);

        colaNoLista.agregarTrabajo(new MiTrabajo());

        try {
            Trabajo trabajo = colaNoLista.sacar();
            trabajo.ejecutar();

        } catch (NoListaException e) {
            System.out.println(e.getMessage());

        } catch (SinTrabajoEnColaException e) {
            System.out.println(e.getMessage());
        }
    }
}
