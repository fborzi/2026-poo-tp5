package com.francoborzi.modulos.ejercicio2507;


package model;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

public class AuditEvent {

    private Instant timestamp;
    private String userSession;
    private String accion;
    private String detalle;

    public AuditEvent(String userSession, String accion, String detalle) {
        this.timestamp = Instant.now();
        this.userSession = userSession;
        this.accion = accion;
        this.detalle = detalle;
    }

    public String formatear() {
        String fecha = DateTimeFormatter.ISO_INSTANT.format(timestamp);

        return "[" + fecha + "] | "
                + "[" + userSession + "] | "
                + "[" + accion + "] | "
                + "[" + detalle + "]";
    }
}

