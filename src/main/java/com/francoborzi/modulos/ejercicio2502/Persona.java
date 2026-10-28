package edu.programacion.ejercicio2502;

/**
 * Representa una persona que puede hablar.
 * Implementa la interfaz Hablador.
 */
public class Persona implements edu.programacion.ejercicio2502.Hablador {

    private String nombre;

    /**
     * Crea una persona con el nombre indicado.
     *
     * @param nombre nombre de la persona
     */
    public Persona(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el nombre de la persona.
     *
     * @return nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Emite un mensaje como si la persona estuviera hablando.
     */
    @Override
    public void hablar() {
        System.out.println("Hola, soy " + nombre);
    }
}