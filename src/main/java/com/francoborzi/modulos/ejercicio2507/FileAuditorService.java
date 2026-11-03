package com.francoborzi.modulos.ejercicio2507;

package service;

import model.AuditEvent;
import exception.AuditException;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileAuditorService implements AuditorService {

    private final Path directorio;
    private final Path archivo;

    public FileAuditorService() {
        this.directorio = Paths.get("var", "log");
        this.archivo = directorio.resolve("auditoria_operaciones.log");
    }

    @Override
    public void registrarEvento(AuditEvent evento)
            throws AuditException {

        try {
            Files.createDirectories(directorio);

            try (BufferedWriter writer = Files.newBufferedWriter(
                    archivo,
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND)) {

                writer.write(evento.formatear());
                writer.newLine();
            }

        } catch (IOException e) {
            throw new AuditException(
                    "no se pudo registrar el evento de auditoria", e);
        }
    }

    @Override
    public void registrarOperacion(
            String userSession,
            String accion,
            String detalle
    ) throws AuditException {

        AuditEvent evento =
                new AuditEvent(userSession, accion, detalle);

        registrarEvento(evento);
    }
}
