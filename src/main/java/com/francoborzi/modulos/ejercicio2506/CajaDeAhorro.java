
package com.francoborzi.modulos.ejercicio2506;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Representa una caja de ahorro.
 */
public class CajaDeAhorro extends CuentaBancaria {

    private static final int MAXIMO_EXTRACCIONES = 5;

    private int extraccionesRealizadas;

    /**
     * Construye una caja de ahorro.
     *
     * @param titular titular de la cuenta
     * @param fechaApertura fecha de apertura
     */
    public CajaDeAhorro(Persona titular, LocalDate fechaApertura) {
        super(titular, fechaApertura, BigDecimal.ZERO);
        this.extraccionesRealizadas = 0;
    }

    /**
     * Extrae dinero controlando el saldo y el cupo.
     *
     * @param monto importe a extraer
     * @throws SuperaLimiteMinimoException si no alcanza el saldo
     * @throws SuperaCantidadExtraccionesException si se supera el cupo
     */
    @Override
    public void extraer(double monto)
            throws SuperaLimiteMinimoException,
            SuperaCantidadExtraccionesException {

        BigDecimal importe = convertirMonto(monto);

        if (extraccionesRealizadas >= MAXIMO_EXTRACCIONES) {
            throw new SuperaCantidadExtraccionesException();
        }

        realizarExtraccion(importe);
        extraccionesRealizadas++;
    }

    /**
     * Reinicia manualmente el contador de extracciones.
     */
    @Override
    public void resetearExtracciones() {
        extraccionesRealizadas = 0;
    }

    /**
     * Obtiene las extracciones realizadas.
     *
     * @return cantidad de extracciones
     */
    public int getExtraccionesRealizadas() {
        return extraccionesRealizadas;
    }
}