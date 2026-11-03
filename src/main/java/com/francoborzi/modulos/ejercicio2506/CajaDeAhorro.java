package com.francoborzi.modulos.ejercicio2506;

public class CajaDeAhorro extends CuentaBancaria {

    private Integer extraccionesDisponibles;

    public CajaDeAhorro(Double saldoInicial, Persona titular) {
        super(saldoInicial, 0.0, titular);
        this.extraccionesDisponibles = 5;
    }

    @Override
    public void extraer(Double monto) throws superaLimiteMinimoException,superaCatntidadExtraccionesException{
        if (extraccionesDisponibles <= 0) {
           throw new superaCatntidadExtraccionesException("Se supero el maximo de extracciones permitidas");
        }

        if (this.saldo - monto >= this.limiteMinimo) {
            this.saldo = saldo - monto;
            this.extraccionesDisponibles= extraccionesDisponibles - 1;
            this.transacciones.add(new Transaccion(monto, "RETIRO"));
            System.out.println("Retirado de Caja de Ahorro. Quedan " + extraccionesDisponibles + " extracciones.");
        } else {
            throw new superaLimiteMinimoException("Error: Saldo insuficiente. El saldo no puede ser menor a " + this.limiteMinimo);
        }
    }

    public void resetearExtraccionesMensuales() {
        this.extraccionesDisponibles = 5;
        System.out.println("Se han reseteado las extracciones mensuales a 5.");
    }


}


