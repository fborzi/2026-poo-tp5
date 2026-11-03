package com.francoborzi.modulos.ejercicio2506;

import java.time.LocalDateTime;

public class Main {
    static void main()  {
        Persona persona1 = new Persona("Gaston Baldomir","38103651", LocalDateTime.now());
        Persona persona2 = new Persona("Nazareno Bomdir","35103651", LocalDateTime.now());

        CuentaBancaria  cuenta1 = new CuentaCorriente(50000.00, persona1);
        CajaDeAhorro cuenta2 = new CajaDeAhorro(150000.00, persona1);

        try {
            cuenta2.extraer(10000.00);
            cuenta2.depositar(10000.00);
            cuenta2.extraer(10000.00);
            cuenta2.extraer(10000.00);
            cuenta2.extraer(10000.00);

            cuenta2.resetearExtraccionesMensuales();
            cuenta2.extraer(1500.00);

        }catch (superaLimiteMinimoException |superaCatntidadExtraccionesException e){
            System.out.println(e.getMessage());
        }
        System.out.println(cuenta1.consultarSaldo());
        System.out.println(cuenta2.consultarSaldo());
        System.out.println(cuenta2.getHistorial());
    }
}
