package com.francoborzi.modulos.ejercicio2506;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class CuentaBancaria {

    protected Double saldo;
    protected Double limiteMinimo;
    protected Persona titular;
    protected LocalDate fechaApertura;
    protected List<Transaccion> transacciones;

    public CuentaBancaria(Double saldoInicial, Double limiteMinimo, Persona titular) {
        this.saldo = saldoInicial;
        this.limiteMinimo = limiteMinimo;
        this.titular = titular;
        this.fechaApertura = LocalDate.now();
        this.transacciones = new ArrayList<>();
    }

    public void depositar(Double monto) {
        this.saldo += monto;
        this.transacciones.add(new Transaccion(monto, "DEPOSITO"));
    }

    public Double consultarSaldo() {
        return this.saldo;
    }
    public List<Transaccion> getHistorial() {
        return this.transacciones;
    }
    public abstract void extraer(Double monto) throws superaLimiteMinimoException, superaCatntidadExtraccionesException;


    public Persona getTitular() {
        return titular;
    }

    public void setTitular(Persona titular) {
        this.titular = titular;
    }

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(LocalDate fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CuentaBancaria{");
        sb.append("saldo=").append(saldo);
        sb.append(", limiteMinimo=").append(limiteMinimo);
        sb.append(", titular=").append(titular);
        sb.append('}');
        return sb.toString();
    }
}

