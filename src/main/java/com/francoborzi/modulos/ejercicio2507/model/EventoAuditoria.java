package com.francoborzi.modulos.ejercicio2507.model;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

/**
 * Evento crítico del sistema que debe quedar registrado en la bitácora.
 */
public class EventoAuditoria {

    private Instant momento;
    private String sesionUsuario;
    private String accion;
    private String detalle;

    /**
     * Crea un evento con el momento actual.
     *
     * @param sesionUsuario sesión del usuario que realizó la acción
     * @param accion acción realizada
     * @param detalle detalle operativo de la acción
     */
    public EventoAuditoria(String sesionUsuario, String accion, String detalle) {
        this.momento = Instant.now();
        this.sesionUsuario = sesionUsuario;
        this.accion = accion;
        this.detalle = detalle;
    }

    /**
     * @return el momento exacto del hecho
     */
    public Instant getMomento() {
        return momento;
    }

    /**
     * @return la sesión del usuario
     */
    public String getSesionUsuario() {
        return sesionUsuario;
    }

    /**
     * @return la acción realizada
     */
    public String getAccion() {
        return accion;
    }

    /**
     * @return el detalle operativo
     */
    public String getDetalle() {
        return detalle;
    }

    /**
     * Formatea el evento según el formato exigido por la empresa:
     * [TIMESTAMP_ISO_8601] | [USER_SESSION] | [ACCION] | [DETALLE_OPERACION].
     *
     * @return la línea de log del evento
     */
    public String formatear() {
        return "[" + DateTimeFormatter.ISO_INSTANT.format(momento) + "] | "
                + "[" + sesionUsuario + "] | "
                + "[" + accion + "] | "
                + "[" + detalle + "]";
    }
}