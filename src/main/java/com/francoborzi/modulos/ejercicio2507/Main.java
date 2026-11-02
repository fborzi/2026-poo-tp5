package com.francoborzi.modulos.ejercicio2507;

import com.francoborzi.modulos.ejercicio2507.model.AuditEvent;
import com.francoborzi.modulos.ejercicio2507.service.AuditorService;
import com.francoborzi.modulos.ejercicio2507.service.FileAuditorService;
import com.francoborzi.modulos.ejercicio2507.exception.AuditException;

public class Main {

    public static void main(String[] args) {

        // Creamos el servicio
        AuditorService auditor = new FileAuditorService();

        try {

            // Evento 1: inicio de sesión
            AuditEvent evento1 = new AuditEvent(
                    "Usuario01",
                    "LOGIN",
                    "Inicio de sesión exitoso"
            );

            auditor.registrarEvento(evento1);

            // Evento 2: consulta
            AuditEvent evento2 = new AuditEvent(
                    "Usuario01",
                    "CONSULTA",
                    "Consultó el listado de clientes"
            );

            auditor.registrarEvento(evento2);

            // Evento 3: modificación
            AuditEvent evento3 = new AuditEvent(
                    "Usuario02",
                    "MODIFICACION",
                    "Modificó los datos de un cliente"
            );

            auditor.registrarEvento(evento3);

            // Evento 4: eliminación
            AuditEvent evento4 = new AuditEvent(
                    "Usuario02",
                    "ELIMINACION",
                    "Eliminó un registro"
            );

            auditor.registrarEvento(evento4);

            // Evento 5: cierre de sesión
            AuditEvent evento5 = new AuditEvent(
                    "Usuario01",
                    "LOGOUT",
                    "Cerró sesión"
            );

            auditor.registrarEvento(evento5);

            System.out.println("Todas las operaciones fueron registradas correctamente.");

        } catch (AuditException e) {

            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}