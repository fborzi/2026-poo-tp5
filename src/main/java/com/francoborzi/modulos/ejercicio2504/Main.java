package com.francoborzi.modulos.ejercicio2504;

public class Main {
    static void main() {
        ColaDeTrabajo cola = new ColaDeTrabajo("Oficina");
        cola.encolar(new TrabajoImpresion("informe.pdf"));
        cola.encolar(new TrabajoEmail("borzi@unnoba.edu.ar"));

        System.out.println("--- Cola lista con 2 trabajos: saco 3 veces ---");
        for (int i = 0; i < 3; i++) {
            try {
                Trabajo trabajo = cola.sacar();
                trabajo.procesar();
            } catch (NoListaException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (SinTrabajoEnColaException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("--- Cola no lista con 1 trabajo ---");
        cola.encolar(new TrabajoImpresion("factura.pdf"));
        cola.setLista(false);
        try {
            Trabajo trabajo = cola.sacar();
            trabajo.procesar();
        } catch (NoListaException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (SinTrabajoEnColaException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
