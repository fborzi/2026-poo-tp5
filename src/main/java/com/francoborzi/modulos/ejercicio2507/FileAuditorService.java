package edu.programacion.ejercicio2507;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * Servicio encargado de registrar eventos de auditoría
 * en un archivo, conservando el historial existente.
 */
public class FileAuditorService {

    private final Path rutaArchivo;

    /**
     * Construye el servicio indicando la ruta del archivo de auditoría.
     *
     * @param rutaArchivo ruta del archivo de registro.
     */
    public FileAuditorService(Path rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    /**
     * Registra un evento al final del archivo de auditoría.
     *
     * @param evento evento que se desea registrar.
     * @throws AuditoriaException si ocurre un error al guardar el evento.
     */
    public void registrarEvento(edu.programacion.ejercicio2507.EventoAuditoria evento)
            throws edu.programacion.ejercicio2507.AuditoriaException {

        if (evento == null) {
            throw new edu.programacion.ejercicio2507.AuditoriaException(
                    "No se puede registrar un evento nulo."
            );
        }

        try {
            Path directorio = rutaArchivo.getParent();

            // Crear el directorio si todavía no existe.
            if (directorio != null) {
                Files.createDirectories(directorio);
            }

            // Crear el archivo si no existe y agregar la nueva línea al final.
            Files.writeString(
                    rutaArchivo,
                    evento.toString() + System.lineSeparator(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );

        } catch (IOException | SecurityException e) {
            throw new edu.programacion.ejercicio2507.AuditoriaException(
                    "No se pudo registrar el evento de auditoría.",
                    e
            );
        }
    }

    /**
     * Obtiene la ruta del archivo de auditoría.
     *
     * @return ruta del archivo.
     */
    public Path getRutaArchivo() {
        return rutaArchivo;
    }
}