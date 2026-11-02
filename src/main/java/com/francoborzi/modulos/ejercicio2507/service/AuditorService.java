package com.francoborzi.modulos.ejercicio2507.service;

import com.francoborzi.modulos.ejercicio2507.model.AuditEvent;
import com.francoborzi.modulos.ejercicio2507.exception.AuditException;

public interface AuditorService {

    void registrarEvento(AuditEvent evento) throws AuditException;

}