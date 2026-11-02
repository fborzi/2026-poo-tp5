package edu.programacion.ejercicio2506;

/**
 * Representa a una persona titular de una cuenta bancaria.
 */
public class Persona {

    private String nombre;
    private String apellido;
    private String documento;

    /**
     * Crea una persona con sus datos personales.
     *
     * @param nombre nombre de la persona.
     * @param apellido apellido de la persona.
     * @param documento número de documento.
     */
    public Persona(String nombre, String apellido, String documento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
    }

    /**
     * Obtiene el nombre.
     *
     * @return nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el apellido.
     *
     * @return apellido de la persona.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Obtiene el documento.
     *
     * @return número de documento.
     */
    public String getDocumento() {
        return documento;
    }

    /**
     * Devuelve el nombre completo de la persona.
     *
     * @return nombre y apellido.
     */
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
}