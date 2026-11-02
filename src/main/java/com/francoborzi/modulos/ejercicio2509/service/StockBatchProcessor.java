package com.francoborzi.modulos.ejercicio2509.service;

import com.francoborzi.modulos.ejercicio2509.conf.ConnectionFactory;
import com.francoborzi.modulos.ejercicio2509.exception.BatchProcessingException;
import com.francoborzi.modulos.ejercicio2509.model.ArticuloStock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class StockBatchProcessor {

    private final ConnectionFactory connectionFactory;

    public StockBatchProcessor(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }
    public void exportarInventario() {

        // Crear la carpeta exports si no existe
        Path carpeta = Paths.get("exports");

        try {
            Files.createDirectories(carpeta);

            // Obtener la fecha actual
            String fecha = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMM-dd"));

            // Crear el nombre del archivo
            Path archivo = carpeta.resolve(
                    "inventario_consolidado_" + fecha + ".csv"
            );

            // Consultar los artículos de la base de datos
            String sql = "SELECT codigo_sku, descripcion, precio, stock FROM articulos";

            try (Connection conn = connectionFactory.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery();
                 BufferedWriter writer = Files.newBufferedWriter(archivo)) {

                // Escribir encabezado
                writer.write("SKU,DESCRIPCION,PRECIO,STOCK");
                writer.newLine();

                // Recorrer los resultados
                while (rs.next()) {

                    String sku = rs.getString("codigo_sku");
                    String descripcion = rs.getString("descripcion");
                    BigDecimal precio = rs.getBigDecimal("precio");
                    int stock = rs.getInt("stock");

                    writer.write(
                            sku + "," +
                                    "\"" + descripcion.replace("\"", "\"\"") + "\"," +
                                    precio + "," +
                                    stock
                    );

                    writer.newLine();
                }
            }

            System.out.println("Inventario exportado correctamente: " + archivo);

        } catch (SQLException | IOException e) {
            throw new BatchProcessingException(
                    "Error al exportar el inventario",
                    0,
                    e
            );
        }
    }
    public void importarLote() {

        Path archivo = Paths.get("imports/lote_ingresos.csv");

        int numeroLinea = 0;

        try {
            // Abrir la conexión
            try (Connection conn = connectionFactory.getConnection();
                 BufferedReader reader = Files.newBufferedReader(archivo)) {

                // Desactivar el autocommit
                conn.setAutoCommit(false);

                try {
                    String linea;

                    // Leer encabezado
                    reader.readLine();
                    numeroLinea++;

                    // Leer los registros
                    while ((linea = reader.readLine()) != null) {
                        numeroLinea++;

                        ArticuloStock articulo = procesarLinea(linea, numeroLinea);

                        insertarArticulo(conn, articulo, numeroLinea);
                    }

                    // Confirmar todos los cambios
                    conn.commit();

                    System.out.println("Lote importado correctamente.");

                } catch (Exception e) {

                    // Revertir todos los cambios
                    conn.rollback();

                    // Registrar el error en el archivo de log
                    if (e instanceof BatchProcessingException) {
                        BatchProcessingException error = (BatchProcessingException) e;

                        registrarError(error.getNumeroLinea(), error.getCause());

                        throw error;
                    }

                    registrarError(numeroLinea, e);

                    throw new BatchProcessingException(
                            "Error al importar el archivo CSV",
                            numeroLinea,
                            e
                    );
                }

            }

        } catch (SQLException | IOException e) {

            registrarError(numeroLinea, e);

            throw new BatchProcessingException(
                    "Error al acceder al archivo o a la base de datos",
                    numeroLinea,
                    e
            );
        }
    }
    private ArticuloStock procesarLinea(String linea, int numeroLinea) {

        try {
            // Separar los datos usando las comas
            String[] datos = linea.split(",", -1);

            // Verificar que haya exactamente 4 columnas
            if (datos.length != 4) {
                throw new IllegalArgumentException(
                        "La línea debe contener exactamente 4 columnas."
                );
            }

            String sku = datos[0].trim();
            String descripcion = datos[1].trim();
            BigDecimal precio = new BigDecimal(datos[2].trim());
            int stock = Integer.parseInt(datos[3].trim());

            // Validar campos obligatorios
            if (sku.isEmpty() || descripcion.isEmpty()) {
                throw new IllegalArgumentException(
                        "El SKU y la descripción no pueden estar vacíos."
                );
            }

            // Validar precio y stock
            if (precio.compareTo(BigDecimal.ZERO) < 0) {
                throw new IllegalArgumentException(
                        "El precio no puede ser negativo."
                );
            }

            if (stock < 0) {
                throw new IllegalArgumentException(
                        "El stock no puede ser negativo."
                );
            }

            return new ArticuloStock(sku, descripcion, precio, stock);

        } catch (NumberFormatException e) {
            throw new BatchProcessingException(
                    "Error numérico en la línea " + numeroLinea,
                    numeroLinea,
                    e
            );

        } catch (IllegalArgumentException e) {
            throw new BatchProcessingException(
                    e.getMessage(),
                    numeroLinea,
                    e
            );
        }
    }
    private void insertarArticulo(Connection conn, ArticuloStock articulo,
                                  int numeroLinea) {

        String sql = "INSERT INTO articulos " +
                "(codigo_sku, descripcion, precio, stock) " +
                "VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, articulo.getCodigoSku());
            ps.setString(2, articulo.getDescripcion());
            ps.setBigDecimal(3, articulo.getPrecio());
            ps.setInt(4, articulo.getStock());

            ps.executeUpdate();

        } catch (SQLException e) {

            throw new BatchProcessingException(
                    "Error al insertar el artículo con SKU: "
                            + articulo.getCodigoSku(),
                    numeroLinea,
                    e
            );
        }
    }
    private void registrarError(int numeroLinea, Throwable causa) {

        Path archivoLog = Paths.get("var/log/fallos_importacion.log");

        try {
            // Crear las carpetas si no existen
            Files.createDirectories(archivoLog.getParent());

            // Obtener fecha y hora
            String fecha = LocalDateTime.now().format(
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            );

            // Preparar el mensaje de error
            String mensaje = fecha
                    + " | Línea: " + numeroLinea
                    + " | Causa: " + causa.getMessage()
                    + System.lineSeparator();

            // Escribir el error al final del archivo
            Files.writeString(
                    archivoLog,
                    mensaje,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );

        } catch (IOException e) {
            System.err.println("No se pudo registrar el error: " + e.getMessage());
        }
    }
}
