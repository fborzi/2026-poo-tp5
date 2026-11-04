
package com.francoborzi.modulos.ejercicio2507;

import com.francoborzi.modulos.ejercicio2507.exception.AuditoriaException;
import com.francoborzi.modulos.ejercicio2507.model.AuditEvent;
import com.francoborzi.modulos.ejercicio2507.service.AuditorService;
import com.francoborzi.modulos.ejercicio2507.service.FileAuditorService;

/**
 * Ejecuta una demostracion del registro de auditoria.
 */
public final class Main2507 {

    private Main2507() {
    }

    /**
     * Punto de entrada del ejercicio.
     *
     * @param args argumentos de ejecucion
     */
    public static void main(String[] args) {
        FileAuditorService servicioArchivo = new FileAuditorService();
        AuditorService auditor = servicioArchivo;

        try {
            auditor.registrarEvento(new AuditEvent(
                    "usuario_001",
                    "LOGIN",
                    "Inicio de sesion exitoso"));

            auditor.registrarEvento(new AuditEvent(
                    "usuario_001",
                    "CONSULTA",
                    "Consulta de datos de clientes"));

            auditor.registrarEvento(new AuditEvent(
                    "admin_001",
                    "ACTUALIZACION",
                    "Modificacion de permisos de usuario"));

            System.out.println("Eventos registrados correctamente.");
            System.out.println("Archivo: "
                    + servicioArchivo.getRutaArchivo().toAbsolutePath());

        } catch (AuditoriaException excepcion) {
            System.err.println("Error: " + excepcion.getMessage());
            System.err.println("Causa: " + excepcion.getCause());
        }
    }
}
