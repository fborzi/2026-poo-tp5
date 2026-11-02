package edu.programacion.ejercicio2509;

/**
 * Excepción que informa errores durante el procesamiento
 * de un lote de artículos del inventario.
 */
public class BatchProcessingException extends Exception {

    private final int numeroLinea;

    /**
     * Construye una excepción con mensaje y número de línea.
     *
     * @param mensaje descripción del error.
     * @param numeroLinea línea del archivo donde ocurrió el error.
     */
    public BatchProcessingException(String mensaje, int numeroLinea) {
        super(mensaje);
        this.numeroLinea = numeroLinea;
    }

    /**
     * Construye una excepción conservando la causa original.
     *
     * @param mensaje descripción del error.
     * @param numeroLinea línea donde ocurrió el error.
     * @param causa excepción que originó el problema.
     */
    public BatchProcessingException(
            String mensaje,
            int numeroLinea,
            Throwable causa) {

        super(mensaje, causa);
        this.numeroLinea = numeroLinea;
    }

    /**
     * Obtiene el número de línea del error.
     *
     * @return número de línea, o -1 si no corresponde a una línea concreta.
     */
    public int getNumeroLinea() {
        return numeroLinea;
    }
}