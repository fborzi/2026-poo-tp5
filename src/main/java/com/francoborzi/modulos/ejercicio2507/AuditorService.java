package com.francoborzi.modulos.ejercicio2507;

/**
 * Define una interfaz para los servicios encargados
 * de registrar eventos de auditoria.
 * Establece el metodo registrar(), que recibe un evento
 * y permite informar errores mediante AuditoriaException.
 */

public interface AuditorService {

    void registrar(AuditEvent evento) throws AuditoriaException;

}
