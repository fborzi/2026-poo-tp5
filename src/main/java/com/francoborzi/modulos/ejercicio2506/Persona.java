package com.francoborzi.modulos.ejercicio2506;

import java.time.LocalDate;

/**
 * Persona titular de una cuenta bancaria.
 */
public class Persona {

    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fechaNacimiento;

    /**
     * Crea una persona.
     *
     * @param nombre nombre
     * @param apellido apellido
     * @param dni documento
     * @param fechaNacimiento fecha de nacimiento
     */
    public Persona(String nombre, String apellido, String dni,
                   LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return el nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return el apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @return el DNI
     */
    public String getDni() {
        return dni;
    }

    /**
     * @return la fecha de nacimiento
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " (DNI " + dni + ")";
    }
}