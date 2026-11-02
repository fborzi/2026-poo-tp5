
package edu.programacion.ejercicio2507;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

/**
 * Representa un evento que debe registrarse en la bitácora
 * forense de operaciones.
 */
public class EventoAuditoria {

    private final String usuarioSesion;
    private final String accion;
    private final String detalleOperacion;
    private final Instant fechaHora;

    /**
     * Construye un evento de auditoría.
     *
     * @param usuarioSesion usuario o sesión que realiza la operación.
     * @param accion acción realizada.
     * @param detalleOperacion detalle de la operación.
     */
    public EventoAuditoria(
            String usuarioSesion,
            String accion,
            String detalleOperacion) {

        this.usuarioSesion = usuarioSesion;
        this.accion = accion;
        this.detalleOperacion = detalleOperacion;
        this.fechaHora = Instant.now();
    }

    /**
     * Obtiene el usuario o sesión.
     *
     * @return usuario o sesión.
     */
    public String getUsuarioSesion() {
        return usuarioSesion;
    }

    /**
     * Obtiene la acción realizada.
     *
     * @return acción realizada.
     */
    public String getAccion() {
        return accion;
    }

    /**
     * Obtiene el detalle de la operación.
     *
     * @return detalle de la operación.
     */
    public String getDetalleOperacion() {
        return detalleOperacion;
    }

    /**
     * Obtiene la fecha y hora del evento.
     *
     * @return instante en que se creó el evento.
     */
    public Instant getFechaHora() {
        return fechaHora;
    }

    /**
     * Convierte el evento al formato requerido para la bitácora.
     *
     * @return línea de auditoría con fecha, sesión, acción y detalle.
     */
    @Override
    public String toString() {
        return "[" + DateTimeFormatter.ISO_INSTANT.format(fechaHora) + "]"
                + " | [" + usuarioSesion + "]"
                + " | [" + accion + "]"
                + " | [" + detalleOperacion + "]";
    }
}
