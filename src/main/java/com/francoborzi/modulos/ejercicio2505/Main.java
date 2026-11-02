package edu.programacion.ejercicio2505;

/**
 * Prueba la colección DataBag y sus excepciones chequeadas.
 */
public class Main2505 {

    /**
     * Ejecuta las pruebas de DataBag.
     *
     * @param args argumentos de línea de comandos.
     */
    public static void main(String[] args) {

        edu.programacion.ejercicio2505.DataBag bolsa = new edu.programacion.ejercicio2505.DataBag(2);

        try {
            bolsa.add("Libro");
            bolsa.add(25);

            System.out.println("Elementos agregados: " + bolsa.size());

            // Intentar agregar un elemento cuando está llena.
            bolsa.add("Cuaderno");

        } catch (edu.programacion.ejercicio2505.FullDataBagException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            System.out.println("Elemento eliminado: " + bolsa.remove("Libro"));
            System.out.println("Elemento eliminado: " + bolsa.remove(25));

            // Intentar eliminar un elemento con la bolsa vacía.
            bolsa.remove("Lápiz");

        } catch (edu.programacion.ejercicio2505.EmptyDataBagException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("¿La bolsa está vacía? " + bolsa.isEmpty());
    }
}