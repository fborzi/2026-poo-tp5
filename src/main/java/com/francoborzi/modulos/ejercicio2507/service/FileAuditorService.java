
package com.francoborzi.modulos.ejercicio2507.service;

import com.francoborzi.modulos.ejercicio2507.exception.AuditoriaException;
import com.francoborzi.modulos.ejercicio2507.model.AuditEvent;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Objects;

/**
 * Registra eventos de auditoria en un archivo local.
 */
public class FileAuditorService implements AuditorService {

    private final Path rutaDirectorio;
    private final Path rutaArchivo;

    /**
     * Construye el servicio con la ruta predeterminada.
     */
    public FileAuditorService() {
        this(Path.of("var", "log"));
    }

    /**
     * Construye el servicio con un directorio configurable.
     *
     * @param rutaDirectorio directorio de almacenamiento
     */
    public FileAuditorService(Path rutaDirectorio) {
        this.rutaDirectorio = Objects.requireNonNull(rutaDirectorio);
        this.rutaArchivo = rutaDirectorio.resolve(
                "auditoria_operaciones.log");
    }

    /**
     * Registra un evento sin sobrescribir el historial.
     *
     * @param evento evento que debe almacenarse
     * @throws AuditoriaException si falla la escritura
     */
    @Override
    public synchronized void registrarEvento(AuditEvent evento)
            throws AuditoriaException {

        Objects.requireNonNull(evento);

        try {
            Files.createDirectories(rutaDirectorio);

            try (BufferedWriter escritor = Files.newBufferedWriter(
                    rutaArchivo,
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND)) {

                escritor.write(evento.formatear());
                escritor.newLine();
            }

        } catch (IOException excepcion) {
            throw new AuditoriaException(
                    "No se pudo registrar el evento de auditoria",
                    excepcion);
        }
    }

    /**
     * Obtiene la ruta del archivo de auditoria.
     *
     * @return ruta del archivo
     */
    public Path getRutaArchivo() {
        return rutaArchivo;
    }
}
