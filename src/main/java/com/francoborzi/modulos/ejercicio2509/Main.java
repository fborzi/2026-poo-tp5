package com.francoborzi.modulos.ejercicio2509;

import com.francoborzi.modulos.ejercicio2509.config.InicializadorTablaArticulos;
import com.francoborzi.modulos.ejercicio2509.config.ProveedorConexion;
import com.francoborzi.modulos.ejercicio2509.config.ProveedorConexionDriverManager;
import com.francoborzi.modulos.ejercicio2509.exception.BatchProcessingException;
import com.francoborzi.modulos.ejercicio2509.service.StockBatchProcessor;

import java.nio.file.Path;
import java.time.LocalDate;

public class Main {
    static void main() {
        ProveedorConexion proveedor = new ProveedorConexionDriverManager(
                "jdbc:h2:mem:stockdb;DB_CLOSE_DELAY=-1", "sa", "");
        InicializadorTablaArticulos inicializador = new InicializadorTablaArticulos(proveedor);
        StockBatchProcessor procesador = new StockBatchProcessor(proveedor);

        try {
            inicializador.crearTabla();
        } catch (BatchProcessingException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("--- Primera importación del lote ---");
        try {
            int cantidad = procesador.importarLote();
            System.out.println("Lote confirmado (commit): " + cantidad + " artículos");
        } catch (BatchProcessingException e) {
            System.out.println("Lote revertido (rollback) en la línea "
                    + e.getNumeroLinea() + ": " + e.getMessage());
        }

        System.out.println("--- Segunda importación del mismo lote (SKU duplicados) ---");
        try {
            int cantidad = procesador.importarLote();
            System.out.println("Lote confirmado (commit): " + cantidad + " artículos");
        } catch (BatchProcessingException e) {
            System.out.println("Lote revertido (rollback) en la línea "
                    + e.getNumeroLinea() + ": " + e.getMessage());
        }

        System.out.println("--- Exportación con fecha actual ---");
        try {
            Path archivo = procesador.exportarInventario();
            System.out.println("Inventario exportado en " + archivo);
        } catch (BatchProcessingException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("--- Exportación con fecha provista ---");
        try {
            Path archivo = procesador.exportarInventario(LocalDate.of(2026, 12, 31));
            System.out.println("Inventario exportado en " + archivo);
        } catch (BatchProcessingException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}