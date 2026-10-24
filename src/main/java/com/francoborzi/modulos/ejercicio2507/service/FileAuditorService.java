package com.francoborzi.modulos.ejercicio2507.service;

import com.francoborzi.modulos.ejercicio2507.exception.AuditoriaException;
import com.francoborzi.modulos.ejercicio2507.exception.DirectorioAuditoriaException;
import com.francoborzi.modulos.ejercicio2507.exception.EscrituraAuditoriaException;
import com.francoborzi.modulos.ejercicio2507.model.EventoAuditoria;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * Registra los eventos de auditoría en un archivo del disco local.
 */
public class FileAuditorService implements AuditorService {

    private Path directorio;
    private Path archivo;

    /**
     * Crea el servicio apuntando a var/log/auditoria_operaciones.log.
     */
    public FileAuditorService() {
        this.directorio = Path.of("var", "log");
        this.archivo = directorio.resolve("auditoria_operaciones.log");
    }

    @Override
    public void registrar(EventoAuditoria evento) throws AuditoriaException {
        verificarDirectorio();
        try (BufferedWriter writer = Files.newBufferedWriter(archivo,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            writer.write(evento.formatear());
            writer.newLine();
        } catch (IOException e) {
            throw new EscrituraAuditoriaException(archivo, e);
        }
    }

    @Override
    public void registrar(String sesionUsuario, String accion, String detalle)
            throws AuditoriaException {
        registrar(new EventoAuditoria(sesionUsuario, accion, detalle));
    }

    /**
     * Verifica que exista el directorio de auditoría y lo crea si no existe.
     *
     * @throws DirectorioAuditoriaException si no se puede crear
     */
    private void verificarDirectorio() throws DirectorioAuditoriaException {
        if (!Files.exists(directorio)) {
            try {
                Files.createDirectories(directorio);
            } catch (IOException e) {
                throw new DirectorioAuditoriaException(directorio, e);
            }
        }
    }
}