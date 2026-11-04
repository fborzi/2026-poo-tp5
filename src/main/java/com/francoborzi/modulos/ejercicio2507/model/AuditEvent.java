
package com.francoborzi.modulos.ejercicio2507.model;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Representa un evento de auditoria del sistema.
 */
public class AuditEvent {

    private final Instant momento;
    private final String sesionUsuario;
    private final String accion;
    private final String detalleOperacion;

    /**
     * Construye un evento con fecha y hora actual.
     *
     * @param sesionUsuario identificador de sesion
     * @param accion accion realizada
     * @param detalleOperacion descripcion de la operacion
     */
    public AuditEvent(String sesionUsuario, String accion,
                      String detalleOperacion) {
        this(Instant.now(), sesionUsuario, accion, detalleOperacion);
    }

    /**
     * Construye un evento con un momento especifico.
     *
     * @param momento instante del evento
     * @param sesionUsuario identificador de sesion
     * @param accion accion realizada
     * @param detalleOperacion descripcion de la operacion
     */
    public AuditEvent(Instant momento, String sesionUsuario,
                      String accion, String detalleOperacion) {
        this.momento = Objects.requireNonNull(momento);
        this.sesionUsuario = validarCampo(sesionUsuario);
        this.accion = validarCampo(accion);
        this.detalleOperacion = validarCampo(detalleOperacion);
    }

    private static String validarCampo(String valor) {
        Objects.requireNonNull(valor);

        if (valor.isBlank() || valor.contains("\n")
                || valor.contains("\r") || valor.contains("|")) {
            throw new IllegalArgumentException(
                    "El campo de auditoria es invalido");
        }

        return valor;
    }

    /**
     * Obtiene el momento del evento.
     *
     * @return instante del evento
     */
    public Instant getMomento() {
        return momento;
    }

    /**
     * Obtiene la sesion del usuario.
     *
     * @return identificador de sesion
     */
    public String getSesionUsuario() {
        return sesionUsuario;
    }

    /**
     * Obtiene la accion realizada.
     *
     * @return accion
     */
    public String getAccion() {
        return accion;
    }

    /**
     * Obtiene el detalle de la operacion.
     *
     * @return detalle
     */
    public String getDetalleOperacion() {
        return detalleOperacion;
    }

    /**
     * Genera una linea con el formato requerido.
     *
     * @return linea de auditoria
     */
    public String formatear() {
        return "[" + DateTimeFormatter.ISO_INSTANT.format(momento)
                + "] | [" + sesionUsuario
                + "] | [" + accion
                + "] | [" + detalleOperacion + "]";
    }

    /**
     * Devuelve la representacion del evento.
     *
     * @return evento formateado
     */
    @Override
    public String toString() {
        return formatear();
    }
}