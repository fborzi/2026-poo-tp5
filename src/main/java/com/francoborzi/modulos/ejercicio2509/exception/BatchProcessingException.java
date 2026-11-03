package com.francoborzi.modulos.ejercicio2509.exception;

/**
 * Error en el procesamiento por lotes. Indica la línea del archivo que lo originó.
 */
public class BatchProcessingException extends Exception {

    private int numeroLinea;

    /**
     * Crea la excepción para un error de validación.
     *
     * @param numeroLinea línea del archivo que originó el error (0 si no corresponde a una línea)
     * @param mensaje causa puntual de la falla
     */
    public BatchProcessingException(int numeroLinea, String mensaje) {
        super(mensaje);
        this.numeroLinea = numeroLinea;
    }

    /**
     * Crea la excepción encapsulando el error original.
     *
     * @param numeroLinea línea del archivo que originó el error (0 si no corresponde a una línea)
     * @param mensaje causa puntual de la falla
     * @param causa excepción original
     */
    public BatchProcessingException(int numeroLinea, String mensaje, Throwable causa) {
        super(mensaje, causa);
        this.numeroLinea = numeroLinea;
    }

    /**
     * @return el número de línea del archivo, o 0 si el error no proviene de una línea
     */
    public int getNumeroLinea() {
        return numeroLinea;
    }
}