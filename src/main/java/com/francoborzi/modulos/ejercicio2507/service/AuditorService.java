package com.francoborzi.modulos.ejercicio2507.service;

import com.francoborzi.modulos.ejercicio2507.exception.AuditoriaException;
import com.francoborzi.modulos.ejercicio2507.model.EventoAuditoria;

/**
 * Contrato para registrar las operaciones realizadas por los usuarios.
 */
public interface AuditorService {

    /**
     * Registra un evento de auditoría.
     *
     * @param evento evento a registrar
     * @throws AuditoriaException si falla el almacenamiento
     */
    void registrar(EventoAuditoria evento) throws AuditoriaException;

    /**
     * Crea y registra un evento de auditoría a partir de sus datos.
     *
     * @param sesionUsuario sesión del usuario
     * @param accion acción realizada
     * @param detalle detalle operativo
     * @throws AuditoriaException si falla el almacenamiento
     */
    void registrar(String sesionUsuario, String accion, String detalle)
            throws AuditoriaException;
}