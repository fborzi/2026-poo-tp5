package com.francoborzi.modulos.ejercicio2506;

import java.time.LocalDateTime;

public class Transaccion {

    private LocalDateTime fecha;
    private double monto;
    private TipoTransaccion tipo;

    public Transaccion(double monto, TipoTransaccion tipo) {
        this.fecha = LocalDateTime.now();
        this.monto = monto;
        this.tipo = tipo;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public double getMonto() {
        return monto;
    }

    public TipoTransaccion getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Fecha: " + fecha
                + " | Tipo: " + tipo
                + " | Monto: $" + monto;
    }
}