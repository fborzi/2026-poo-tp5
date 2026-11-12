package com.francoborzi.modulos.ejercicio2506;

/**
 * Representa una persona mediante sus datos personales:
 * nombre, apellido y DNI.
 * Recibe estos datos mediante el constructor y permite
 * consultarlos a traves de sus metodos correspondientes.
 */

public class Persona {

    private String nombre;
    private String apellido;
    private String dni;

    public Persona(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }
}
