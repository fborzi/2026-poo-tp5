package com.francoborzi.modulos.ejercicio2507.model;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

public class AuditEvent {

    private Instant timestamp;
    private String userSession;
    private String action;
    private String detail;

    public AuditEvent(String userSession, String action, String detail) {
        this.timestamp = Instant.now();
        this.userSession = userSession;
        this.action = action;
        this.detail = detail;
    }

    public String formatearEvento() {
        return "[" + DateTimeFormatter.ISO_INSTANT.format(timestamp) + "] | ["
                + userSession + "] | [" + action + "] | [" + detail + "]";
    }
}
