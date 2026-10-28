package edu.programacion.ejercicio2503;

/**
 * Clase principal para probar la cooperativa de transporte,
 * la asignación de viajes y el kilometraje acumulado.
 */
public class Main2503 {

    /**
     * Ejecuta las pruebas de la cooperativa.
     *
     * @param args argumentos recibidos por consola
     */
    public static void main(String[] args) {

        edu.programacion.ejercicio2503.Colectivo colectivo1 = new edu.programacion.ejercicio2503.Colectivo("AB123CD", "Mercedes-Benz", 40);
        edu.programacion.ejercicio2503.Colectivo colectivo2 = new edu.programacion.ejercicio2503.Colectivo("EF456GH", "Scania", 60);
        edu.programacion.ejercicio2503.Colectivo colectivo3 = new edu.programacion.ejercicio2503.Colectivo("IJ789KL", "Agrale", 25);

        edu.programacion.ejercicio2503.Chofer chofer1 = new edu.programacion.ejercicio2503.Chofer("Juan", colectivo1);
        edu.programacion.ejercicio2503.Chofer chofer2 = new edu.programacion.ejercicio2503.Chofer("María", colectivo2);
        edu.programacion.ejercicio2503.Chofer chofer3 = new edu.programacion.ejercicio2503.Chofer("Pedro", colectivo3);

        edu.programacion.ejercicio2503.Cooperativa cooperativa = new edu.programacion.ejercicio2503.Cooperativa();

        cooperativa.agregarChofer(chofer1);
        cooperativa.agregarChofer(chofer2);
        cooperativa.agregarChofer(chofer3);

        edu.programacion.ejercicio2503.Chofer asignado = cooperativa.realizarViaje(50, 120);

        if (asignado != null) {
            System.out.println("Chofer asignado: " + asignado.getNombre());
            System.out.println("Colectivo: "
                    + asignado.getColectivo().getModelo());
        } else {
            System.out.println("No hay un colectivo con capacidad suficiente.");
        }

        edu.programacion.ejercicio2503.Chofer asignado2 = cooperativa.realizarViaje(30, 80);

        if (asignado2 != null) {
            System.out.println("Chofer asignado: " + asignado2.getNombre());
        }

        edu.programacion.ejercicio2503.Colectivo mayor =
                cooperativa.mostrarColectivoConMayorKilometraje();

        if (mayor != null) {
            System.out.println("Colectivo con mayor kilometraje: "
                    + mayor.getModelo());
            System.out.println("Kilometraje acumulado: "
                    + mayor.getKilometrajeAcumulado());
        }
    }
}