package com.francoborzi.modulos.ejercicio2506;

import java.time.LocalDate;

public class Transaccion {

    private LocalDate fecha;
    private double monto;
    private String tipo;

    public Transaccion(double monto, String tipo) {
        this.fecha = LocalDate.now();
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