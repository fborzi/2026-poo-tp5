
package com.francoborzi.modulos.ejercicio2505;

/**
 * Ejecuta pruebas de la coleccion DataBag.
 */
public final class Main2505 {

    private Main2505() {
    }

    /**
     * Punto de entrada del ejercicio.
     *
     * @param args argumentos de ejecucion
     */
    public static void main(String[] args) {
        DataBag bolsa = new DataBag(3);

        try {
            bolsa.add("Hola");
            bolsa.add(100);
            bolsa.add(25.5);

            System.out.println("Elementos: " + bolsa.getElementos());
            System.out.println("Cantidad: " + bolsa.size());
            System.out.println("Bolsa llena: " + bolsa.isFull());

            bolsa.add("Elemento extra");

        } catch (FullDataBagException excepcion) {
            System.out.println(excepcion.getMessage());
        }

        System.out.println();

        try {
            bolsa.remove("Hola");
            bolsa.remove(100);
            bolsa.remove(25.5);

            System.out.println("Elementos: " + bolsa.getElementos());
            System.out.println("Bolsa vacia: " + bolsa.isEmpty());

            bolsa.remove("Otro elemento");

        } catch (EmptyDataBagException excepcion) {
            System.out.println(excepcion.getMessage());
        }
    }
}
