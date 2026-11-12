package com.francoborzi.modulos.ejercicio2506;

/**
 * Representa una transaccion bancaria y almacena
 * la fecha en que se realiza, el monto y el tipo
 * de operacion.
 * Permite consultar los datos de cada transaccion
 * mediante sus metodos correspondientes.
 */

import java.time.LocalDate;

public class Transaccion {
    private LocalDate fecha;
    private double monto;
    private String tipo;

    public Transaccion(LocalDate fecha, double monto, String tipo) {
        this.fecha = fecha;
        this.monto = monto;
        this.tipo = tipo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public double getMonto() {
        return monto;
    }

    public String getTipo() {
        return tipo;
    }
}

