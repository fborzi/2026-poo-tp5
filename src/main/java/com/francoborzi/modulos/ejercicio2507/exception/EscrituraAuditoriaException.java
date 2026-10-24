package com.francoborzi.modulos.ejercicio2507.exception;

import java.nio.file.Path;

/**
 * Se lanza cuando no se puede escribir en el archivo de auditoría.
 */
public class EscrituraAuditoriaException extends AuditoriaException {

    /**
     * Crea la excepción.
     *
     * @param archivo archivo en el que no se pudo escribir
     * @param causa excepción original de entrada/salida
     */
    public EscrituraAuditoriaException(Path archivo, Throwable causa) {
        super("No se pudo escribir en el archivo de auditoría: " + archivo, causa);
    }
}