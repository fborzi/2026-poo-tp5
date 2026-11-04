
package com.francoborzi.modulos.ejercicio2509;

import com.francoborzi.modulos.ejercicio2509.exception.BatchProcessingException;
import com.francoborzi.modulos.ejercicio2509.service.StockBatchProcessor;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

public class Main2509 {

    public static void main(String[] args) {
        StockBatchProcessor procesador = new StockBatchProcessor();

        try {
            Files.createDirectories(Path.of("imports"));

            String identificador = UUID.randomUUID()
                    .toString().substring(0, 8);

            Path archivoCorrecto = Path.of(
                    "imports", "lote_ingresos.csv");

            String contenidoCorrecto =
                    "SKU,DESCRIPCION,PRECIO,STOCK\n"
                            + "ART-" + identificador + "-1,Mouse,15000.00,20\n"
                            + "ART-" + identificador + "-2,Monitor,120000.00,5\n";

            Files.writeString(archivoCorrecto,
                    contenidoCorrecto, StandardCharsets.UTF_8);

            System.out.println("=== IMPORTACION CORRECTA ===");

            int importados = procesador.importarLote();
            System.out.println("Articulos importados: " + importados);

            System.out.println("\n=== EXPORTACION CSV ===");

            Path exportado = procesador.exportarInventario();
            System.out.println("Archivo generado: " + exportado);

            Path archivoIncorrecto = Path.of(
                    "imports", "lote_invalido.csv");

            String contenidoIncorrecto =
                    "SKU,DESCRIPCION,PRECIO,STOCK\n"
                            + "ART-" + identificador + "-3,Teclado,30000.00,10\n"
                            + "ART-" + identificador + "-4,Auriculares,25000.00,-5\n";

            Files.writeString(archivoIncorrecto,
                    contenidoIncorrecto, StandardCharsets.UTF_8);

            System.out.println("\n=== IMPORTACION CON ERROR ===");

            try {
                procesador.importarLote(archivoIncorrecto);
            } catch (BatchProcessingException error) {
                System.out.println("Rollback realizado.");
                System.out.println("Linea rechazada: "
                        + error.getNumeroLinea());
                System.out.println("Motivo: " + error.getMessage());
            }

            System.out.println("\n=== FIN DE LA PRUEBA ===");

        } catch (IOException | BatchProcessingException error) {
            System.err.println("Error: " + error.getMessage());
        }
    }
}