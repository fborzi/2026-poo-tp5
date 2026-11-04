
package com.francoborzi.modulos.ejercicio2507.service;

import com.francoborzi.modulos.ejercicio2507.exception.AuditoriaException;
import com.francoborzi.modulos.ejercicio2507.model.AuditEvent;

/**
 * Define el contrato de registro de auditoria.
 */
public interface AuditorService {

    /**
     * Registra un evento de auditoria.
     *
     * @param evento evento que debe registrarse
     * @throws AuditoriaException si ocurre un error de registro
     */
    void registrarEvento(AuditEvent evento) throws AuditoriaException;
}
