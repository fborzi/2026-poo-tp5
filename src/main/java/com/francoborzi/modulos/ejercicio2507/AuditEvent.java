package com.francoborzi.modulos.ejercicio2507;

/**
 * Representa un evento de auditoria que almacena la fecha y hora,
 * la sesion del usuario, la accion realizada y el detalle
 * de la operacion.
 * Permite registrar la informacion del evento y obtener
 * una representacion en texto de sus datos.
 */

import java.time.Instant;

public class AuditEvent {

    private Instant timestamp;
    private String userSession;
    private String accion;
    private String detalleOperacion;

    public AuditEvent(String userSession, String accion, String detalleOperacion) {
        this.timestamp = Instant.now();
        this.userSession = userSession;
        this.accion = accion;
        this.detalleOperacion = detalleOperacion;
    }

    @Override
    public String toString() {
        return timestamp + " | "
                + userSession + " | "
                + accion + " | "
                + detalleOperacion;
    }
}
