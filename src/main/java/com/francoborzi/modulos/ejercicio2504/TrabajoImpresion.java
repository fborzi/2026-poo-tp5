package com.francoborzi.modulos.ejercicio2504;

/**
 * Trabajo de impresión de un documento.
 */
public class TrabajoImpresion implements Trabajo {

    private String documento;

    /**
     * Crea un trabajo de impresión.
     *
     * @param documento nombre del documento a imprimir
     */
    public TrabajoImpresion(String documento) {
        this.documento = documento;
    }

    @Override
    public void procesar() {
        System.out.println("Imprimiendo documento: " + documento);
    }
}