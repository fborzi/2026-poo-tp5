package com.francoborzi.modulos.ejercicio2506;

import java.time.LocalDateTime;

public class Transaccion {
    private LocalDateTime fecha;
    private double monto;
    private String tipo;

    public Transaccion(double monto, String tipo) {
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

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "fecha: " + fecha
                + ", monto: " + monto
                + ", tipo: " + tipo;
    }
}
