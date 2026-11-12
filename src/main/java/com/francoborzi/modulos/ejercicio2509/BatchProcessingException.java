package com.francoborzi.modulos.ejercicio2509;

/**
 * Representa una excepcion personalizada que se produce
 * durante el procesamiento de un lote de datos.
 * Almacena el mensaje del error y el numero de linea
 * donde se produjo el problema.
 * Permite consultar la linea en la que ocurrio el error.
 */

public  class BatchProcessingException extends Exception {

    private int numeroLinea;

    public BatchProcessingException(String mensaje, int numeroLinea) {
        super(mensaje);
        this.numeroLinea = numeroLinea;
    }

    public int getNumeroLinea() {
        return numeroLinea;
    }
}
