package com.francoborzi.modulos.ejercicio2504;

import java.util.ArrayList;

public class Main {
    static void main() {
        System.out.println("=== INICIANDO PRUEBAS DE COLA DE TRABAJO ===\n");

        Trabajo t1 = new TrabajoEmpleo("Imprimir Reporte Contable");
        Trabajo t2 = new TrabajoEmpleo("Optimizar Base de Datos");


        System.out.println("--- [Prueba 1: Intentar sacar de una cola vacía] ---");
        ColaDeTrabajo colaActiva = new ColaDeTrabajo(true, "Cola_Servidor");

        try {
            System.out.println("Intentando sacar un trabajo...");
            colaActiva.sacar();
        } catch (NoListaException e) {
            System.out.println("Bloque NoLista ejecutado por error.");
        } catch (SinTrabajoEnColaException e) {

            System.out.println("Capturada con éxito! Mensaje: " + e.getMessage());
        }

        System.out.println("\n--------------------------------------------------\n");


        System.out.println("--- [Prueba 2: Intentar sacar de una cola NO lista / desactivada] ---");

        ColaDeTrabajo colaBloqueada = new ColaDeTrabajo(false, "COLA_bloqueada" );


        colaBloqueada.encolar(t1);
        colaBloqueada.encolar(t2);

        try {
            System.out.println("Intentando sacar un trabajo de la cola bloqueada...");
            colaBloqueada.sacar();
        } catch (NoListaException e) {

            System.out.println("Capturada con éxito! Mensaje: " + e.getMessage());
        } catch (SinTrabajoEnColaException e) {
            System.out.println("Bloque SinTrabajo ejecutado por error.");
        }

        System.out.println("\n--------------------------------------------------\n");


        System.out.println("--- [Prueba 3: Flujo correcto sin excepciones] ---");
        ColaDeTrabajo colaPerfecta = new ColaDeTrabajo(true, "Cola_Produccion");
        colaPerfecta.encolar(t1);
        colaPerfecta.encolar(t2);

        try {
            System.out.println("Sacando primer trabajo...");
            Trabajo trabajo1 = colaPerfecta.sacar();
            trabajo1.ejecutar();

            System.out.println("Sacando segundo trabajo...");
            Trabajo trabajo2 = colaPerfecta.sacar();
            trabajo2.ejecutar();

            System.out.println("\n¡Todos los trabajos fueron procesados sin errores!");
        } catch (NoListaException | SinTrabajoEnColaException e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }

    }
}
