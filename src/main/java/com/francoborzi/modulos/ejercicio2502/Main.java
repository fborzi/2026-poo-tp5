package edu.programacion.ejercicio2502;

/**
 * Clase principal para probar el polimorfismo extensible
 * del ejercicio Dr. Dolittle.
 */
public class Main2502 {

    /**
     * Ejecuta las pruebas de los métodos de DrDolittle.
     *
     * @param args argumentos recibidos por consola
     */
    public static void main(String[] args) {

        edu.programacion.ejercicio2502.DrDolittle doctor = new edu.programacion.ejercicio2502.DrDolittle();

        System.out.println("=== Método hacerHablar ===");

        doctor.hacerHablar(new edu.programacion.ejercicio2502.Perro());
        doctor.hacerHablar(new edu.programacion.ejercicio2502.Gato());
        doctor.hacerHablar(new edu.programacion.ejercicio2502.Lechuza());

        System.out.println("\n=== Método hacerHablar2 ===");

        doctor.hacerHablar2(new edu.programacion.ejercicio2502.Perro());
        doctor.hacerHablar2(new edu.programacion.ejercicio2502.Gato());
        doctor.hacerHablar2(new edu.programacion.ejercicio2502.Lechuza());
        doctor.hacerHablar2(new edu.programacion.ejercicio2502.Persona("Ana"));
        doctor.hacerHablar2(new edu.programacion.ejercicio2502.Alarma());
        doctor.hacerHablar2(new edu.programacion.ejercicio2502.Reloj());
    }
}