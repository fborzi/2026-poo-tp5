package com.francoborzi.modulos.ejercicio2507.exception;

import java.nio.file.Path;

/**
 * Se lanza cuando no se puede crear el directorio de auditoría.
 */
public class DirectorioAuditoriaException extends AuditoriaException {

    /**
     * Crea la excepción.
     *
     * @param directorio directorio que no se pudo crear
     * @param causa excepción original de entrada/salida
     */
    public DirectorioAuditoriaException(Path directorio, Throwable causa) {
        super("No se pudo crear el directorio de auditoría: " + directorio, causa);
    }
}