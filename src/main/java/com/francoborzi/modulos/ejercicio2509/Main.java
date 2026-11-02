package edu.programacion.ejercicio2509;

import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Ejecuta las pruebas de exportación e importación
 * por lotes del inventario.
 */
public class Main {

    /**
     * Ejecuta los procesos de exportación e importación.
     *
     * @param args argumentos de línea de comandos.
     */
    public static void main(String[] args) {

        edu.programacion.ejercicio2509.StockBatchProcessor procesador = new edu.programacion.ejercicio2509.StockBatchProcessor();

        // Flujo 1: exportar el inventario de la base de datos.
        try {
            Path archivo = procesador.exportarInventario();

            System.out.println("Exportación realizada correctamente.");
            System.out.println("Archivo generado: "
                    + archivo.toAbsolutePath());

        } catch (edu.programacion.ejercicio2509.BatchProcessingException e) {
            System.out.println("Error de exportación: "
                    + e.getMessage());
        }

        // Flujo 2: importar novedades desde el archivo CSV.
        Path archivoImportacion =
                Path.of("imports", "lote_ingresos.csv");

        if (Files.exists(archivoImportacion)) {
            try {
                procesador.importarLote();

                System.out.println(
                        "Importación realizada correctamente."
                );

            } catch (edu.programacion.ejercicio2509.BatchProcessingException e) {
                System.out.println(
                        "Error de importación: " + e.getMessage()
                );

                System.out.println(
                        "Línea del error: " + e.getNumeroLinea()
                );
            }
        } else {
            System.out.println(
                    "No se encontró imports/lote_ingresos.csv."
            );
            System.out.println(
                    "Creá el archivo para probar la importación."
            );
        }
    }
}