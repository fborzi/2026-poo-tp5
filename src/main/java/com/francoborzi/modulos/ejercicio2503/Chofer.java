package com.francoborzi.modulos.ejercicio2503;

/**
 * Socio chofer de la cooperativa que maneja un colectivo.
 */
public class Chofer {

    private String nombre;
    private String dni;
    private Colectivo colectivo;

    /**
     * Crea un chofer con el colectivo que maneja.
     *
     * @param nombre nombre del chofer
     * @param dni documento del chofer
     * @param colectivo colectivo asignado
     */
    public Chofer(String nombre, String dni, Colectivo colectivo) {
        this.nombre = nombre;
        this.dni = dni;
        this.colectivo = colectivo;
    }

    /**
     * @return el nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return el DNI
     */
    public String getDni() {
        return dni;
    }

    /**
     * @return el colectivo que maneja
     */
    public Colectivo getColectivo() {
        return colectivo;
    }

    @Override
    public String toString() {
        return "Chofer " + nombre + " (DNI " + dni + ") - " + colectivo;
    }
}