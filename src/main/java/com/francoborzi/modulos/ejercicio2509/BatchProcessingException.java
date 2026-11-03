package com.francoborzi.modulos.ejercicio2509;


package exception;

public class BatchProcessingException extends Exception {

    private final int numeroLinea;

    public BatchProcessingException(
            String mensaje, int numeroLinea, Throwable causa) {
        super(mensaje, causa);
        this.numeroLinea = numeroLinea;
    }

    public int getNumeroLinea() {
        return numeroLinea;
    }
}

