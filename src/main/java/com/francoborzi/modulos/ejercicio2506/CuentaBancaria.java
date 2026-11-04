
package com.francoborzi.modulos.ejercicio2506;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Representa una cuenta bancaria.
 */
public abstract class CuentaBancaria {

    private final Persona titular;
    private final LocalDate fechaApertura;
    private final BigDecimal limiteMinimo;
    private final List<Transaccion> transacciones;
    private BigDecimal saldo;

    /**
     * Construye una cuenta bancaria.
     *
     * @param titular titular de la cuenta
     * @param fechaApertura fecha de apertura
     * @param limiteMinimo saldo minimo permitido
     */
    protected CuentaBancaria(Persona titular,
                             LocalDate fechaApertura,
                             BigDecimal limiteMinimo) {
        this.titular = Objects.requireNonNull(titular);
        this.fechaApertura = Objects.requireNonNull(fechaApertura);
        this.limiteMinimo = Objects.requireNonNull(limiteMinimo);
        this.saldo = BigDecimal.ZERO;
        this.transacciones = new ArrayList<>();
    }

    /**
     * Convierte un importe double a BigDecimal.
     *
     * @param monto importe
     * @return importe convertido
     */
    protected static BigDecimal convertirMonto(double monto) {
        if (!Double.isFinite(monto) || monto <= 0) {
            throw new IllegalArgumentException(
                    "El monto debe ser positivo y finito");
        }

        return BigDecimal.valueOf(monto);
    }

    /**
     * Deposita dinero y registra la transaccion.
     *
     * @param monto importe a depositar
     */
    public void depositar(double monto) {
        BigDecimal importe = convertirMonto(monto);
        saldo = saldo.add(importe);
        registrarTransaccion(importe, "DEPOSITO");
    }

    /**
     * Extrae dinero respetando las restricciones de la cuenta.
     *
     * @param monto importe a extraer
     * @throws SuperaLimiteMinimoException si se supera el saldo minimo
     * @throws SuperaCantidadExtraccionesException si se supera el cupo
     */
    public abstract void extraer(double monto)
            throws SuperaLimiteMinimoException,
            SuperaCantidadExtraccionesException;

    /**
     * Comprueba y realiza una extraccion.
     *
     * @param importe importe validado
     * @throws SuperaLimiteMinimoException si se supera el limite
     */
    protected void realizarExtraccion(BigDecimal importe)
            throws SuperaLimiteMinimoException {
        BigDecimal nuevoSaldo = saldo.subtract(importe);

        if (nuevoSaldo.compareTo(limiteMinimo) < 0) {
            throw new SuperaLimiteMinimoException();
        }

        saldo = nuevoSaldo;
        registrarTransaccion(importe, "EXTRACCION");
    }

    /**
     * Registra una operacion.
     *
     * @param importe monto de la operacion
     * @param tipo tipo de operacion
     */
    private void registrarTransaccion(BigDecimal importe, String tipo) {
        transacciones.add(new Transaccion(
                LocalDateTime.now(), importe, tipo));
    }

    /**
     * Consulta el saldo.
     *
     * @return saldo actual
     */
    public BigDecimal consultarSaldo() {
        return saldo;
    }

    /**
     * Obtiene el titular.
     *
     * @return titular
     */
    public Persona getTitular() {
        return titular;
    }

    /**
     * Obtiene la fecha de apertura.
     *
     * @return fecha de apertura
     */
    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    /**
     * Obtiene el limite minimo.
     *
     * @return limite permitido
     */
    public BigDecimal getLimiteMinimo() {
        return limiteMinimo;
    }

    /**
     * Obtiene el historial de transacciones.
     *
     * @return copia del historial
     */
    public List<Transaccion> getTransacciones() {
        return new ArrayList<>(transacciones);
    }

    /**
     * Reinicia el contador de extracciones si corresponde.
     */
    public abstract void resetearExtracciones();
}