package edu.programacion.ejercicio2507;

import java.nio.file.Path;

/**
 * Prueba el registro de eventos en la bitácora forense.
 */
public class Main2507 {

    /**
     * Ejecuta las pruebas del servicio de auditoría.
     *
     * @param args argumentos de línea de comandos.
     */
    public static void main(String[] args) {

        Path ruta = Path.of(
                "var",
                "log",
                "auditoria_operaciones.log"
        );

        edu.programacion.ejercicio2507.FileAuditorService auditoria = new edu.programacion.ejercicio2507.FileAuditorService(ruta);

        try {
            edu.programacion.ejercicio2507.EventoAuditoria evento1 = new edu.programacion.ejercicio2507.EventoAuditoria(
                    "USER_SESSION_01",
                    "LOGIN",
                    "Inicio de sesión correcto"
            );

            edu.programacion.ejercicio2507.EventoAuditoria evento2 = new edu.programacion.ejercicio2507.EventoAuditoria(
                    "USER_SESSION_01",
                    "CONSULTA",
                    "Consulta de información"
            );

            edu.programacion.ejercicio2507.EventoAuditoria evento3 = new edu.programacion.ejercicio2507.EventoAuditoria(
                    "USER_SESSION_01",
                    "LOGOUT",
                    "Cierre de sesión"
            );

            auditoria.registrarEvento(evento1);
            auditoria.registrarEvento(evento2);
            auditoria.registrarEvento(evento3);

            System.out.println("Eventos registrados correctamente.");
            System.out.println(
                    "Archivo: " + auditoria.getRutaArchivo().toAbsolutePath()
            );

        } catch (edu.programacion.ejercicio2507.AuditoriaException e) {
            System.out.println("Error de auditoría: " + e.getMessage());
            e.printStackTrace();
        }
    }
}