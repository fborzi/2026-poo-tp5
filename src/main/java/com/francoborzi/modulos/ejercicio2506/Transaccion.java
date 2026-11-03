package com.francoborzi.modulos.ejercicio2506;

import java.time.LocalDate;

public class Transaccion {

    private LocalDate fecha;
    private Double monto;
    private String tipo;


    public Transaccion(Double monto, String tipo) {
        this.fecha = LocalDate.now();
        this.monto = monto;
        this.tipo = tipo;
    }

    public LocalDate getFecha() { return fecha; }
    public Double getMonto() { return monto; }
    public String getTipo() { return tipo; }


    @Override
    public String toString() {
        return "[" + fecha + "] " + tipo + ": $" + monto;
    }
}
