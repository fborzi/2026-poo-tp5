package com.francoborzi.modulos.ejercicio2504;

/**
 * Contiene el metodo principal del programa.
 * Crea una cola de trabajo, agrega diferentes trabajos
 * de impresion y ejecuta los trabajos disponibles.
 * Controla las excepciones que pueden producirse cuando
 * la cola no esta disponible o no tiene trabajos.
 */

public class Main {
    public static void main(String[] args) {

        ColaDeTrabajo cola = new ColaDeTrabajo("Cola Principal");

        Trabajo trabajo1 = new TrabajoImpresion("TP de Java");
        Trabajo trabajo2 = new TrabajoImpresion("Informe de Bases de Datos");

        cola.agregar(trabajo1);
        cola.agregar(trabajo2);

        try {
            Trabajo trabajo = cola.sacar();
            trabajo.ejecutar();

            Trabajo segundoTrabajo = cola.sacar();
            segundoTrabajo.ejecutar();

            Trabajo tercerTrabajo = cola.sacar();
            tercerTrabajo.ejecutar();

        } catch (NoListaException | SinTrabajoEnColaException e) {
            System.out.println(e.getMessage());
        }
    }
}
