
package com.francoborzi.modulos.ejercicio2504;

import java.util.Objects;

/**
 * Representa un trabajo de impresion.
 */
public class TrabajoImpresion implements Trabajo {

    private final String documento;

    /**
     * Construye un trabajo de impresion.
     *
     * @param documento nombre del documento
     */
    public TrabajoImpresion(String documento) {
        this.documento = Objects.requireNonNull(documento);
    }

    /**
     * Ejecuta la impresion del documento.
     */
    @Override
    public void ejecutar() {
        System.out.println("Imprimiendo: " + documento);
    }

    /**
     * Devuelve la descripcion del trabajo.
     *
     * @return descripcion del trabajo
     */
    @Override
    public String toString() {
        return "Trabajo de impresion: " + documento;
    }
}
