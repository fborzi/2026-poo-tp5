
package com.francoborzi.modulos.ejercicio2504;

/**
 * Ejecuta pruebas de la cola de trabajo.
 */
public final class Main2504 {

    private Main2504() {
    }

    /**
     * Punto de entrada del ejercicio.
     *
     * @param args argumentos de ejecucion
     */
    public static void main(String[] args) {
        ColaDeTrabajo cola = new ColaDeTrabajo("Impresora");

        cola.encolar(new TrabajoImpresion("Factura.pdf"));
        cola.encolar(new TrabajoImpresion("Informe.pdf"));
        cola.encolar(new TrabajoImpresion("Contrato.pdf"));

        System.out.println("=== Cola no disponible ===");

        try {
            cola.sacar();
        } catch (NoListaException
                 | SinTrabajoEnColaException excepcion) {
            System.out.println(excepcion.getMessage());
        }

        cola.setLista(true);

        System.out.println();
        System.out.println("=== Procesamiento de trabajos ===");

        while (cola.cantidadTrabajos() > 0) {
            try {
                Trabajo trabajo = cola.sacar();
                trabajo.ejecutar();
            } catch (NoListaException
                     | SinTrabajoEnColaException excepcion) {
                System.out.println(excepcion.getMessage());
            }
        }

        System.out.println();
        System.out.println("=== Cola vacia ===");

        try {
            cola.sacar();
        } catch (NoListaException
                 | SinTrabajoEnColaException excepcion) {
            System.out.println(excepcion.getMessage());
        }

        System.out.println();
        System.out.println("Trabajos pendientes: "
                + cola.cantidadTrabajos());
    }
}
