package com.francoborzi.modulos.ejercicio2509;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        StockBatchProcessor procesador = new StockBatchProcessor();

        try {
            procesador.exportarInventario(LocalDate.now());

            Path archivo = Path.of("imports", "lote_ingresos.csv");

            if (Files.exists(archivo)) {
                procesador.importarLote(archivo);
            } else {
                System.out.println("No se encontro el archivo de importacion.");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
