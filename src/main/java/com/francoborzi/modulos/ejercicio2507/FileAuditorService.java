package com.francoborzi.modulos.ejercicio2507;

/**
 * Representa un servicio de auditoria que implementa
 * la interfaz AuditorService.
 * Permite registrar eventos en un archivo de texto,
 * creando los directorios necesarios y agregando cada
 * nuevo registro al final del archivo.
 * Controla los errores de entrada y salida mediante
 * AuditoriaException.
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileAuditorService implements AuditorService {

    @Override
    public void registrar(AuditEvent evento) throws AuditoriaException {

        Path ruta = Path.of("var", "log", "auditoria_operaciones.log");

        try {
            Files.createDirectories(ruta.getParent());

            Files.writeString(
                    ruta,
                    evento.toString() + System.lineSeparator(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );

        } catch (IOException e) {
            throw new AuditoriaException(
                    "Error al registrar la auditoraa", e
            );
        }
    }

}

