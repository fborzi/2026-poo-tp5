
package com.francoborzi.modulos.ejercicio2509.service;

import com.francoborzi.modulos.ejercicio2509.exception.BatchProcessingException;
import com.francoborzi.modulos.ejercicio2509.model.ArticuloStock;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class StockBatchProcessor {

    private static final String URL = "jdbc:h2:file:./var/data/productos";
    private static final String USUARIO = "sa";
    private static final String CLAVE = "";

    private static final Path IMPORTS = Path.of("imports");
    private static final Path EXPORTS = Path.of("exports");
    private static final Path LOG = Path.of("var", "log",
            "fallos_importacion.log");

    private static final String INSERT_SQL =
            "INSERT INTO productos "
                    + "(codigo_sku, descripcion, precio_unitario, stock_disponible) "
                    + "VALUES (?, ?, ?, ?)";

    public Path exportarInventario() throws BatchProcessingException {
        List<ArticuloStock> articulos = new ArrayList<>();

        String sql = "SELECT codigo_sku, descripcion, "
                + "precio_unitario, stock_disponible "
                + "FROM productos ORDER BY codigo_sku";

        try (Connection conexion = obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql);
             ResultSet resultado = sentencia.executeQuery()) {

            while (resultado.next()) {
                articulos.add(new ArticuloStock(
                        resultado.getString("codigo_sku"),
                        resultado.getString("descripcion"),
                        resultado.getBigDecimal("precio_unitario"),
                        resultado.getInt("stock_disponible")
                ));
            }

            Files.createDirectories(EXPORTS);

            String fecha = LocalDate.now().format(
                    DateTimeFormatter.BASIC_ISO_DATE);

            Path archivo = EXPORTS.resolve(
                    "inventario_consolidado_" + fecha + ".csv");

            try (BufferedWriter escritor = Files.newBufferedWriter(
                    archivo, StandardCharsets.UTF_8)) {

                escritor.write("SKU,DESCRIPCION,PRECIO,STOCK");
                escritor.newLine();

                for (ArticuloStock articulo : articulos) {
                    escritor.write(escaparCsv(articulo.getSku()) + ","
                            + escaparCsv(articulo.getDescripcion()) + ","
                            + articulo.getPrecio().toPlainString() + ","
                            + articulo.getStock());
                    escritor.newLine();
                }
            }

            return archivo;

        } catch (SQLException | IOException error) {
            throw new BatchProcessingException(
                    "No se pudo exportar el inventario",
                    0, error);
        }
    }

    public int importarLote() throws BatchProcessingException {
        return importarLote(IMPORTS.resolve("lote_ingresos.csv"));
    }

    public int importarLote(Path archivo)
            throws BatchProcessingException {

        int numeroLinea = 0;
        int cantidad = 0;

        try (Connection conexion = obtenerConexion()) {
            conexion.setAutoCommit(false);

            try (BufferedReader lector = Files.newBufferedReader(
                    archivo, StandardCharsets.UTF_8);
                 PreparedStatement sentencia =
                         conexion.prepareStatement(INSERT_SQL)) {

                String linea = lector.readLine();
                numeroLinea = 1;

                if (linea == null
                        || !linea.equals("SKU,DESCRIPCION,PRECIO,STOCK")) {
                    throw new IllegalArgumentException(
                            "Encabezado CSV incorrecto");
                }

                while ((linea = lector.readLine()) != null) {
                    numeroLinea++;

                    ArticuloStock articulo = interpretarLinea(linea);

                    sentencia.setString(1, articulo.getSku());
                    sentencia.setString(2, articulo.getDescripcion());
                    sentencia.setBigDecimal(3, articulo.getPrecio());
                    sentencia.setInt(4, articulo.getStock());

                    sentencia.executeUpdate();
                    cantidad++;
                }

                conexion.commit();
                return cantidad;

            } catch (SQLException | IOException
                     | IllegalArgumentException error) {

                try {
                    conexion.rollback();
                } catch (SQLException errorRollback) {
                    error.addSuppressed(errorRollback);
                }

                registrarFallo(numeroLinea, error);

                throw new BatchProcessingException(
                        "Importacion rechazada en linea " + numeroLinea
                                + ": " + error.getMessage(),
                        numeroLinea, error);
            }

        } catch (SQLException error) {
            registrarFallo(numeroLinea, error);

            throw new BatchProcessingException(
                    "Error de conexion o transaccion",
                    numeroLinea, error);
        }
    }

    private Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CLAVE);
    }

    private ArticuloStock interpretarLinea(String linea) {
        List<String> campos = separarCsv(linea);

        if (campos.size() != 4) {
            throw new IllegalArgumentException(
                    "Cantidad incorrecta de columnas");
        }

        String sku = campos.get(0).trim();
        String descripcion = campos.get(1).trim();

        if (sku.isEmpty() || descripcion.isEmpty()) {
            throw new IllegalArgumentException(
                    "SKU y descripcion son obligatorios");
        }

        BigDecimal precio = new BigDecimal(campos.get(2).trim());
        int stock = Integer.parseInt(campos.get(3).trim());

        if (precio.signum() < 0 || stock < 0) {
            throw new IllegalArgumentException(
                    "Precio y stock no pueden ser negativos");
        }

        return new ArticuloStock(sku, descripcion, precio, stock);
    }

    private List<String> separarCsv(String linea) {
        List<String> campos = new ArrayList<>();
        StringBuilder actual = new StringBuilder();
        boolean entreComillas = false;

        for (int i = 0; i < linea.length(); i++) {
            char caracter = linea.charAt(i);

            if (caracter == '"') {
                if (entreComillas
                        && i + 1 < linea.length()
                        && linea.charAt(i + 1) == '"') {
                    actual.append('"');
                    i++;
                } else {
                    entreComillas = !entreComillas;
                }
            } else if (caracter == ',' && !entreComillas) {
                campos.add(actual.toString());
                actual.setLength(0);
            } else {
                actual.append(caracter);
            }
        }

        if (entreComillas) {
            throw new IllegalArgumentException(
                    "Comillas CSV sin cerrar");
        }

        campos.add(actual.toString());
        return campos;
    }

    private String escaparCsv(String valor) {
        if (valor.contains(",") || valor.contains("\"")
                || valor.contains("\n") || valor.contains("\r")) {
            return "\"" + valor.replace("\"", "\"\"") + "\"";
        }
        return valor;
    }

    private void registrarFallo(int numeroLinea, Exception error) {
        try {
            Files.createDirectories(LOG.getParent());

            String registro = LocalDateTime.now()
                    + " | Linea: " + numeroLinea
                    + " | Error: " + error.getMessage()
                    + System.lineSeparator();

            Files.writeString(LOG, registro,
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);

        } catch (IOException errorLog) {
            System.err.println(
                    "No se pudo registrar el fallo: "
                            + errorLog.getMessage());
        }
    }
}