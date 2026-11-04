
package com.francoborzi.modulos.ejercicio2503;

import java.util.Objects;

/**
 * Representa un socio chofer de la cooperativa.
 */
public class Chofer {

    private final String nombre;
    private final String dni;
    private final Colectivo colectivo;

    /**
     * Construye un chofer.
     *
     * @param nombre nombre del chofer
     * @param dni documento del chofer
     * @param colectivo colectivo asignado
     */
    public Chofer(String nombre, String dni,
                  Colectivo colectivo) {
        this.nombre = Objects.requireNonNull(nombre);
        this.dni = Objects.requireNonNull(dni);
        this.colectivo = Objects.requireNonNull(colectivo);
    }

    /**
     * Obtiene el nombre.
     *
     * @return nombre del chofer
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el documento.
     *
     * @return documento del chofer
     */
    public String getDni() {
        return dni;
    }

    /**
     * Obtiene el colectivo asignado.
     *
     * @return colectivo del chofer
     */
    public Colectivo getColectivo() {
        return colectivo;
    }

    /**
     * Devuelve la descripcion del chofer.
     *
     * @return nombre y documento
     */
    @Override
    public String toString() {
        return nombre + " - DNI: " + dni;
    }
}
