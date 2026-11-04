
package com.francoborzi.modulos.ejercicio2506;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Representa una cuenta corriente.
 */
public class CuentaCorriente extends CuentaBancaria {

    /**
     * Construye una cuenta corriente.
     *
     * @param titular titular de la cuenta
     * @param fechaApertura fecha de apertura
     */
    public CuentaCorriente(Persona titular, LocalDate fechaApertura) {
        super(titular, fechaApertura,
                BigDecimal.valueOf(-15000));
    }

    /**
     * Extrae dinero respetando el descubierto permitido.
     *
     * @param monto importe a extraer
     * @throws SuperaLimiteMinimoException si supera el descubierto
     * @throws SuperaCantidadExtraccionesException excepcion declarada
     */
    @Override
    public void extraer(double monto)
            throws SuperaLimiteMinimoException,
            SuperaCantidadExtraccionesException {

        BigDecimal importe = convertirMonto(monto);
        realizarExtraccion(importe);
    }

    /**
     * No modifica la cuenta porque no tiene limite de extracciones.
     */
    @Override
    public void resetearExtracciones() {
    }
}