package com.francoborzi.modulos.ejercicio2506;

public class CajaDeAhorro extends CuentaBancaria {

    private int cantidadExtracciones;
    private final int MAXIMO_EXTRACCIONES = 5;

    public CajaDeAhorro(Persona titular, double saldo) {

        super(titular, saldo, 0);

        this.cantidadExtracciones = 0;
    }

    @Override
    protected void validarCantidadExtracciones()
            throws SuperaCantidadExtraccionesException {

        if (cantidadExtracciones >= MAXIMO_EXTRACCIONES) {

            throw new SuperaCantidadExtraccionesException(
                    "Se superó el máximo de 5 extracciones."
            );
        }
    }

    @Override
    protected void registrarExtraccionExitosa() {
        cantidadExtracciones++;
    }

    // Reiniciar contador manualmente
    public void resetearExtracciones() {

        cantidadExtracciones = 0;

        System.out.println("Contador de extracciones reiniciado.");
    }

    public int getCantidadExtracciones() {
        return cantidadExtracciones;
    }
}