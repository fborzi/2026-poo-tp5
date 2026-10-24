package com.francoborzi.modulos.ejercicio2506;

import java.time.LocalDate;

/**
 * Caja de ahorro con límite mínimo 0 y máximo de extracciones.
 */
public class CajaDeAhorro extends CuentaBancaria {

    private int maximoExtracciones;
    private int extraccionesRealizadas;

    /**
     * Crea una caja de ahorro con límite mínimo 0 y máximo de 5 extracciones.
     *
     * @param titular persona titular
     * @param fechaApertura fecha de apertura
     */
    public CajaDeAhorro(Persona titular, LocalDate fechaApertura) {
        super(titular, fechaApertura, 0.0);
        this.maximoExtracciones = 5;
        this.extraccionesRealizadas = 0;
    }

    /**
     * Extrae dinero controlando el máximo de extracciones.
     *
     * @param monto monto a extraer
     * @throws SuperaLimiteMinimoException si el saldo quedaría debajo de 0
     * @throws SuperaCantidadExtraccionesException si ya se hicieron 5 extracciones
     */
    @Override
    public void extraer(double monto)
            throws SuperaLimiteMinimoException, SuperaCantidadExtraccionesException {
        if (extraccionesRealizadas >= maximoExtracciones) {
            throw new SuperaCantidadExtraccionesException(maximoExtracciones);
        }
        super.extraer(monto);
        extraccionesRealizadas++;
    }

    /** Vuelve a habilitar las extracciones (se hace una vez al mes). */
    public void resetearExtracciones() {
        extraccionesRealizadas = 0;
    }

    /**
     * @return el máximo de extracciones permitidas
     */
    public int getMaximoExtracciones() {
        return maximoExtracciones;
    }

    /**
     * @return las extracciones realizadas desde el último reseteo
     */
    public int getExtraccionesRealizadas() {
        return extraccionesRealizadas;
    }
}