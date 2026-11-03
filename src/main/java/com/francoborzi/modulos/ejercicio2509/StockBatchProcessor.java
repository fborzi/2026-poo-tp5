package com.francoborzi.modulos.ejercicio2509;



package service;

import config.ConnectionFactory;
import exception.BatchProcessingException;
import model.ArticuloStock;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;

public class StockBatchProcessor {

    private final ConnectionFactory connectionFactory;

    public StockBatchProcessor(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }



    public Path exportarInventario() throws BatchProcessingException {
        String fecha = LocalDate.now().toString();

        Path directorio = Paths.get("exports");
        Path archivo = directorio.resolve(
                "inventario_consolidado_" + fecha + ".csv");

        String sql = "SELECT codigo_sku, descripcion, precio_unitario, "
                + "stock_disponible FROM productos";

        try {
            Files.createDirectories(directorio);

            try (Connection conn = connectionFactory.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery();
                 BufferedWriter writer = Files.newBufferedWriter(
                         archivo,
                         StandardCharsets.UTF_8,
                         StandardOpenOption.CREATE,
                         StandardOpenOption.TRUNCATE_EXISTING)) {

                writer.write("SKU,DESCRIPCION,PRECIO,STOCK");
                writer.newLine();

                while (rs.next()) {
                    writer.write(
                            csv(rs.getString("codigo_sku")) + ","
                                    + csv(rs.getString("descripcion")) + ","
                                    + rs.getBigDecimal("precio_unitario") + ","
                                    + rs.getInt("stock_disponible"));

                    writer.newLine();
                }
            }

            return archivo;

        } catch (SQLException | IOException e) {
            throw new BatchProcessingException(
                    "Error al exportar el inventario.",
                    0, e);
        }
    }



    public void importarNovedades() throws BatchProcessingException {
        Path archivo = Paths.get("imports", "lote_ingresos.csv");

        String sql = "INSERT INTO productos "
                + "(codigo_sku, descripcion, precio_unitario, stock_disponible) "
                + "VALUES (?, ?, ?, ?)";

        int lineaActual = 0;
        Connection conn = null;
        boolean transaccionIniciada = false;

        try {
            conn = connectionFactory.getConnection();
            conn.setAutoCommit(false);
            transaccionIniciada = true;

            try (BufferedReader reader = Files.newBufferedReader(
                    archivo, StandardCharsets.UTF_8);
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                String linea;

                while ((linea = reader.readLine()) != null) {
                    lineaActual++;

                    if (lineaActual == 1) {
                        if (!linea.equals(
                                "SKU,DESCRIPCION,PRECIO,STOCK")) {
                            throw new BatchProcessingException(
                                    "Encabezado CSV inválido.",
                                    lineaActual, null);
                        }
                        continue;
                    }

                    ArticuloStock articulo = parsear(linea, lineaActual);

                    ps.setString(1, articulo.getSku());
                    ps.setString(2, articulo.getDescripcion());
                    ps.setBigDecimal(3, articulo.getPrecio());
                    ps.setInt(4, articulo.getStock());

                    ps.executeUpdate();
                }
            }

            conn.commit();
            transaccionIniciada = false;

        } catch (BatchProcessingException e) {
            rollback(conn, transaccionIniciada, e);
            registrarFallo(lineaActual, e.getMessage());
            throw e;

        } catch (SQLException | IOException e) {
            BatchProcessingException error =
                    new BatchProcessingException(
                            "Error de base de datos o de lectura: "
                                    + e.getMessage(),
                            lineaActual, e);

            rollback(conn, transaccionIniciada, error);
            registrarFallo(lineaActual, error.getMessage());
            throw error;

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.err.println(
                            "No se pudo cerrar la conexión: "
                                    + e.getMessage());
                }
            }
        }
    }


    private ArticuloStock parsear(String linea, int numeroLinea)
            throws BatchProcessingException {

        String[] campos = linea.split(",", -1);

        if (campos.length != 4) {
            throw new BatchProcessingException(
                    "La fila debe tener 4 columnas.",
                    numeroLinea, null);
        }

        try {
            String sku = campos[0].trim();
            String descripcion = campos[1].trim();
            BigDecimal precio = new BigDecimal(campos[2].trim());
            int stock = Integer.parseInt(campos[3].trim());

            if (sku.isEmpty() || descripcion.isEmpty()) {
                throw new IllegalArgumentException(
                        "SKU y descripción no pueden estar vacíos.");
            }

            if (precio.signum() < 0 || stock < 0) {
                throw new IllegalArgumentException(
                        "Precio y stock no pueden ser negativos.");
            }

            return new ArticuloStock(
                    sku, descripcion, precio, stock);

        } catch (IllegalArgumentException e) {
            throw new BatchProcessingException(
                    "Datos inválidos en la línea: " + e.getMessage(),
                    numeroLinea, e);
        }
    }



    private void rollback(Connection conn, boolean iniciado,
                          Exception error) {
        if (conn != null && iniciado) {
            try {
                conn.rollback();
            } catch (SQLException e) {
                error.addSuppressed(e);
            }
        }
    }



    private void registrarFallo(int linea, String causa)
            throws BatchProcessingException {

        Path archivoLog = Paths.get(
                "var", "log", "fallos_importacion.log");

        try {
            Files.createDirectories(archivoLog.getParent());

            try (BufferedWriter writer = Files.newBufferedWriter(
                    archivoLog,
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND)) {

                writer.write(
                        "[" + Instant.now() + "] | Línea: "
                                + linea + " | Causa: " + causa);

                writer.newLine();
            }

        } catch (IOException e) {
            throw new BatchProcessingException(
                    "Falló la importación y no se pudo escribir "
                            + "la bitácora.",
                    linea, e);
        }
    }



    private String csv(String valor) {
        if (valor == null) {
            return "";
        }

        return "\"" + valor.replace("\"", "\"\"") + "\"";
    }
}


