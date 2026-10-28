package edu.programacion.ejercicio2504;

/**
 * Prueba el funcionamiento de la cola de trabajo
 * y el manejo de excepciones personalizadas.
 */
public class Main2504 {

    /**
     * Ejecuta las pruebas del ejercicio.
     *
     * @param args argumentos de línea de comandos.
     */
    public static void main(String[] args) {

        edu.programacion.ejercicio2504.ColaDeTrabajo cola = new edu.programacion.ejercicio2504.ColaDeTrabajo();

        // Prueba 1: intentar ejecutar una cola vacía.
        try {
            cola.ejecutarSiguiente();
        } catch (edu.programacion.ejercicio2504.SinTrabajoEnColaException | edu.programacion.ejercicio2504.NoListaException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Agregar una tarea que todavía no está lista.
        edu.programacion.ejercicio2504.Tarea tarea1 = new edu.programacion.ejercicio2504.Tarea("Preparar informe", false);
        cola.agregarTrabajo(tarea1);

        // Prueba 2: intentar ejecutar una tarea no lista.
        try {
            cola.ejecutarSiguiente();
        } catch (edu.programacion.ejercicio2504.SinTrabajoEnColaException | edu.programacion.ejercicio2504.NoListaException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Marcar la tarea como lista.
        tarea1.setListo(true);

        // Agregar otra tarea lista.
        edu.programacion.ejercicio2504.Tarea tarea2 = new edu.programacion.ejercicio2504.Tarea("Generar reporte", true);
        cola.agregarTrabajo(tarea2);

        // Prueba 3: ejecutar los trabajos.
        try {
            cola.ejecutarSiguiente();
            cola.ejecutarSiguiente();
        } catch (edu.programacion.ejercicio2504.SinTrabajoEnColaException | edu.programacion.ejercicio2504.NoListaException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println(
                "Cantidad de trabajos pendientes: "
                        + cola.cantidadTrabajos()
        );
    }
}