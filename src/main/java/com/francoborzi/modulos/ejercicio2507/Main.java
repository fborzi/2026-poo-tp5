package com.francoborzi.modulos.ejercicio2507;

import com.francoborzi.modulos.ejercicio2507.exception.AuditoriaException;
import com.francoborzi.modulos.ejercicio2507.model.EventoAuditoria;
import com.francoborzi.modulos.ejercicio2507.service.AuditorService;
import com.francoborzi.modulos.ejercicio2507.service.FileAuditorService;

public class Main {
    static void main() {
        AuditorService auditor = new FileAuditorService();

        EventoAuditoria login = new EventoAuditoria("sesion-001", "LOGIN",
                "Ingreso exitoso del usuario kcontreras");

        try {
            auditor.registrar(login);
            auditor.registrar("sesion-001", "UPDATE",
                    "Modificó el saldo de la cuenta 1234");
            auditor.registrar("sesion-002", "DELETE",
                    "Eliminó el cliente con DNI 30123456");
            System.out.println("Eventos registrados en var/log/auditoria_operaciones.log");
            System.out.println(login.formatear());
        } catch (AuditoriaException e) {
            System.out.println("Error de auditoría: " + e.getMessage());
            System.out.println("Causa original: " + e.getCause());
        }
    }
}