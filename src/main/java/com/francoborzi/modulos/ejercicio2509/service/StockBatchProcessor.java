package com.francoborzi.modulos.ejercicio2509.service;

import com.francoborzi.modulos.ejercicio2509.config.ProveedorConexion;
import com.francoborzi.modulos.ejercicio2509.exception.BatchProcessingException;
import com.francoborzi.modulos.ejercicio2509.model.ArticuloStock;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Puente de integración entre los archivos del servidor y la base de datos.
 */
public class StockBatchProcessor {

    private ProveedorConexion proveedorConexion;
    private Path carpetaExportacion;
    private Path archivoImportacion;
    private Path archivoFallos;

    /**
     * Crea el procesador con las rutas definidas por la empresa.
     *
     * @param proveedorConexion proveedor de conexiones a la base
     */
    public StockBatchProcessor(ProveedorConexion proveedorConexion) {
        this.proveedorConexion = proveedorConexion;
        this.carpetaExportacion = Path.of("exports");
        this.archivoImportacion = Path.of("imports", "lote_ingresos.csv");
        this.archivoFallos = Path.of("var", "log", "fallos_importacion.log");
    }

    /**
     * Exporta el inventario con la fecha actual.
     *
     * @return la ruta del archivo generado
     * @throws BatchProcessingException si falla la lectura o la escritura
     */
    public Path exportarInventario() throws BatchProcessingException {
        return exportarInventario(LocalDate.now());
    }

    /**
     * Exporta el inventario a exports/inventario_consolidado_[FECHA].csv.
     *
     * @param fecha fecha que se usa en el nombre del archivo
     * @return la ruta del archivo generado
     * @throws BatchProcessingException si falla la lectura o la escritura
     */
    public Path exportarInventario(LocalDate fecha) throws BatchProcessingException {
        String nombre = "inventario_consolidado_"
                + fecha.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + ".csv";
        Path archivo = carpetaExportacion.resolve(nombre);
        String sql = "SELECT codigo_sku, descripcion, precio_unitario, stock_disponible "
                + "FROM productos ORDER BY codigo_sku";

        try {
            if (!Files.exists(carpetaExportacion)) {
                Files.createDirectories(carpetaExportacion);
            }
        } catch (IOException e) {
            throw new BatchProcessingException(0,
                    "No se pudo crear la carpeta " + carpetaExportacion, e);
        }

        try (Connection conexion = proveedorConexion.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql);
             BufferedWriter escritor = Files.newBufferedWriter(archivo)) {
            escritor.write("SKU,DESCRIPCION,PRECIO,STOCK");
            escritor.newLine();
            try (ResultSet filas = sentencia.executeQuery()) {
                while (filas.next()) {
                    ArticuloStock articulo = new ArticuloStock(
                            filas.getString("codigo_sku"),
                            filas.getString("descripcion"),
                            filas.getBigDecimal("precio_unitario"),
                            filas.getInt("stock_disponible"));
                    escritor.write(articulo.aLineaCsv());
                    escritor.newLine();
                }
            }
        } catch (SQLException e) {
            throw new BatchProcessingException(0,
                    "No se pudo leer el inventario de la base de datos", e);
        } catch (IOException e) {
            throw new BatchProcessingException(0,
                    "No se pudo escribir el archivo " + archivo, e);
        }
        return archivo;
    }

    /**
     * Importa el lote imports/lote_ingresos.csv en una sola transacción:
     * se guardan todas las filas o ninguna.
     *
     * @return la cantidad de artículos importados
     * @throws BatchProcessingException si alguna línea es inválida o falla la base
     */
    public int importarLote() throws BatchProcessingException {
        String sql = "INSERT INTO productos "
                + "(codigo_sku, descripcion, precio_unitario, stock_disponible) "
                + "VALUES (?, ?, ?, ?)";
        int importados = 0;
        int numeroLinea = 0;

        try (Connection conexion = proveedorConexion.obtenerConexion();
             BufferedReader lector = Files.newBufferedReader(archivoImportacion)) {
            conexion.setAutoCommit(false);
            try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
                lector.readLine();
                numeroLinea = 1;
                String linea = lector.readLine();
                while (linea != null) {
                    numeroLinea++;
                    ArticuloStock articulo = parsearLinea(linea, numeroLinea);
                    sentencia.setString(1, articulo.getCodigoSku());
                    sentencia.setString(2, articulo.getDescripcion());
                    sentencia.setBigDecimal(3, articulo.getPrecio());
                    sentencia.setInt(4, articulo.getStock());
                    sentencia.executeUpdate();
                    importados++;
                    linea = lector.readLine();
                }
                conexion.commit();
            } catch (BatchProcessingException e) {
                conexion.rollback();
                registrarFallo(e);
                throw e;
            } catch (SQLException e) {
                conexion.rollback();
                BatchProcessingException error = new BatchProcessingException(numeroLinea,
                        "Conflicto de base de datos: " + e.getMessage(), e);
                registrarFallo(error);
                throw error;
            } catch (IOException e) {
                conexion.rollback();
                BatchProcessingException error = new BatchProcessingException(numeroLinea,
                        "Error al leer el archivo: " + e.getMessage(), e);
                registrarFallo(error);
                throw error;
            }
        } catch (SQLException e) {
            throw new BatchProcessingException(numeroLinea,
                    "Error de conexión con la base de datos", e);
        } catch (IOException e) {
            throw new BatchProcessingException(0,
                    "No se pudo abrir el archivo " + archivoImportacion, e);
        }
        return importados;
    }

    /**
     * Valida una línea del CSV y la convierte en un artículo.
     *
     * @param linea texto de la línea
     * @param numeroLinea número de línea en el archivo
     * @return el artículo leído
     * @throws BatchProcessingException si la línea tiene formato o valores inválidos
     */
    private ArticuloStock parsearLinea(String linea, int numeroLinea)
            throws BatchProcessingException {
        String[] columnas = linea.split(",", -1);
        if (columnas.length != 4) {
            throw new BatchProcessingException(numeroLinea,
                    "Cantidad de columnas incorrecta: se esperaban 4 y hay " + columnas.length);
        }
        String sku = columnas[0].trim();
        String descripcion = columnas[1].trim();
        if (sku.isEmpty() || descripcion.isEmpty()) {
            throw new BatchProcessingException(numeroLinea, "SKU o descripción vacíos");
        }

        BigDecimal precio;
        Integer stock;
        try {
            precio = new BigDecimal(columnas[2].trim());
            stock = Integer.parseInt(columnas[3].trim());
        } catch (NumberFormatException e) {
            throw new BatchProcessingException(numeroLinea,
                    "Formato numérico inválido en precio o stock", e);
        }
        if (precio.compareTo(BigDecimal.ZERO) < 0 || stock < 0) {
            throw new BatchProcessingException(numeroLinea, "Precio o stock negativo");
        }
        return new ArticuloStock(sku, descripcion, precio, stock);
    }

    /**
     * Registra el rechazo del lote en var/log/fallos_importacion.log.
     * No lanza excepciones para no ocultar el error original.
     *
     * @param error error que provocó el rollback
     */
    private void registrarFallo(BatchProcessingException error) {
        String entrada = "[" + DateTimeFormatter.ISO_INSTANT.format(Instant.now()) + "] | "
                + "[LINEA " + error.getNumeroLinea() + "] | "
                + "[" + error.getMessage() + "]";
        Path carpeta = archivoFallos.getParent();
        try {
            if (!Files.exists(carpeta)) {
                Files.createDirectories(carpeta);
            }
            try (BufferedWriter escritor = Files.newBufferedWriter(archivoFallos,
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
                escritor.write(entrada);
                escritor.newLine();
            }
        } catch (IOException e) {
            System.out.println("No se pudo registrar el fallo en " + archivoFallos
                    + ": " + e.getMessage());
        }
    }
}