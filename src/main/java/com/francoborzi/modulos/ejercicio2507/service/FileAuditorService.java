package com.francoborzi.modulos.ejercicio2507.service;

import com.francoborzi.modulos.ejercicio2507.model.AuditEvent;
import com.francoborzi.modulos.ejercicio2507.exception.AuditException;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileAuditorService implements AuditorService {

    private static final Path DIRECTORIO = Path.of("var", "log");

    private static final Path ARCHIVO =
            DIRECTORIO.resolve("auditoria_operaciones.log");

    @Override
    public void registrarEvento(AuditEvent evento) throws AuditException {

        try {

            Files.createDirectories(DIRECTORIO);

            try (BufferedWriter escritor = Files.newBufferedWriter(
                    ARCHIVO,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND)) {

                escritor.write(evento.formatearEvento());
                escritor.newLine();
            }

        } catch (IOException e) {

            throw new AuditException(
                    "Error al registrar el evento de auditoría.", e
            );
        }
    }
}