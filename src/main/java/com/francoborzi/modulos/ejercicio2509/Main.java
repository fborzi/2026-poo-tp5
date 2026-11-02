package com.francoborzi.modulos.ejercicio2509;

import com.francoborzi.modulos.ejercicio2509.conf.ConnectionFactory;
import com.francoborzi.modulos.ejercicio2509.exception.BatchProcessingException;
import com.francoborzi.modulos.ejercicio2509.service.StockBatchProcessor;

public class Main {

    public static void main(String[] args) {

        // Obtener usuario y contraseña desde variables de entorno
        String usuario = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");

        // Verificar que las variables estén configuradas
        if (usuario == null || password == null) {
            System.out.println("Faltan configurar las variables de entorno DB_USER y DB_PASSWORD.");
            return;
        }

        // Crear la conexión a MySQL
        ConnectionFactory fabrica = new ConnectionFactory(
                "jdbc:mysql://localhost:3306/ejercicio2509",
                usuario,
                password
        );

        // Crear el procesador
        StockBatchProcessor procesador = new StockBatchProcessor(fabrica);

        try {
            procesador.importarLote();
            procesador.exportarInventario();

            System.out.println("Proceso finalizado correctamente.");

        } catch (BatchProcessingException e) {

            System.out.println("Error durante el procesamiento:");
            System.out.println(e.getMessage());
            System.out.println("Línea del archivo: " + e.getNumeroLinea());
            System.out.println("Causa del error:");
            e.printStackTrace();
        }
    }
}
