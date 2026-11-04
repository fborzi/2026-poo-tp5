
package com.francoborzi.modulos.ejercicio2506;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Representa una transaccion bancaria.
 */
public class Transaccion {

    private final LocalDateTime fecha;
    private final BigDecimal monto;
    private final String tipo;

    /**
     * Construye una transaccion.
     *
     * @param fecha fecha de la operacion
     * @param monto importe de la operacion
     * @param tipo tipo de operacion
     */
    public Transaccion(LocalDateTime fecha, BigDecimal monto,
                       String tipo) {
        this.fecha = Objects.requireNonNull(fecha);
        this.monto = Objects.requireNonNull(monto);
        this.tipo = Objects.requireNonNull(tipo);
    }

    /**
     * Obtiene la fecha.
     *
     * @return fecha de la operacion
     */
    public LocalDateTime getFecha() {
        return fecha;
    }

    /**
     * Obtiene el monto.
     *
     * @return importe
     */
    public BigDecimal getMonto() {
        return monto;
    }

    /**
     * Obtiene el tipo.
     *
     * @return tipo de transaccion
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Devuelve una descripcion de la transaccion.
     *
     * @return datos de la operacion
     */
    @Override
    public String toString() {
        return fecha + " - " + tipo + ": $" + monto;
    }
}