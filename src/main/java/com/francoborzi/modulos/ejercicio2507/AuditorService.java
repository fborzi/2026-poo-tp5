package com.francoborzi.modulos.ejercicio2507;


package service;

import model.AuditEvent;
import exception.AuditException;

public interface AuditorService {

    void registrarEvento(AuditEvent evento) throws AuditException;

    void registrarOperacion(
            String userSession,
            String accion,
            String detalle
    ) throws AuditException;
}

