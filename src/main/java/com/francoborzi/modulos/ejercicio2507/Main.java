package com.francoborzi.modulos.ejercicio2507;

public class Main {

    void main(String[] args) {

        AuditorService auditor = new FileAuditorService();

        AuditEvent evento = new AuditEvent(
                "usuario1",
                "LOGIN",
                "Inicio de sesion"
        );

        try {
            auditor.registrar(evento);
            System.out.println("Evento registrado correctamente");

        } catch (AuditoriaException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
