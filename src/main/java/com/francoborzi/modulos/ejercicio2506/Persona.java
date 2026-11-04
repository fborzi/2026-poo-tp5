
package com.francoborzi.modulos.ejercicio2506;

import java.util.Objects;

/**
 * Representa al titular de una cuenta bancaria.
 */
public class Persona {

    private final String nombre;
    private final String apellido;
    private final String dni;

    /**
     * Construye una persona.
     *
     * @param nombre nombre
     * @param apellido apellido
     * @param dni documento
     */
    public Persona(String nombre, String apellido, String dni) {
        this.nombre = Objects.requireNonNull(nombre);
        this.apellido = Objects.requireNonNull(apellido);
        this.dni = Objects.requireNonNull(dni);
    }

    /**
     * Obtiene el nombre.
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el apellido.
     *
     * @return apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Obtiene el documento.
     *
     * @return documento
     */
    public String getDni() {
        return dni;
    }

    /**
     * Devuelve el nombre completo.
     *
     * @return nombre y apellido
     */
    @Override
    public String toString() {
        return nombre + " " + apellido;
    }
}