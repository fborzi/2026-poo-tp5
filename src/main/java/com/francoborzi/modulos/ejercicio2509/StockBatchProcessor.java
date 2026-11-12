package com.francoborzi.modulos.ejercicio2509;

/**
 * Gestiona el procesamiento de lotes de datos relacionados
 * con el inventario de productos.
 * Permite importar productos desde archivos CSV hacia
 * la base de datos y exportar el inventario a archivos CSV.
 * Valida los datos importados, controla las operaciones
 * mediante transacciones y registra los errores
 * de importacion en un archivo de log.
 */

import com.francoborzi.modulos.ejercicio2508.ConexionBD;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class StockBatchProcessor {



    public void exportarInventario(LocalDate fecha) throws Exception {

        Path carpeta = Path.of("exports");
        Files.createDirectories(carpeta);

        String nombreArchivo =
                "inventario_consolidado_" + fecha + ".csv";

        Path archivo = carpeta.resolve(nombreArchivo);

        String sql = "SELECT codigo_sku, descripcion, precio_unitario, " +
                "stock_disponible FROM productos";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            List<String> lineas = new ArrayList<>();

            lineas.add("SKU,DESCRIPCION,PRECIO,STOCK");

            while (rs.next()) {

                String sku = rs.getString("codigo_sku");
                String descripcion = rs.getString("descripcion");
                String precio =
                        rs.getBigDecimal("precio_unitario").toString();
                int stock = rs.getInt("stock_disponible");

                lineas.add(
                        "\"" + sku + "\",\"" +
                                descripcion.replace("\"", "\"\"") + "\"," +
                                precio + "," + stock
                );
            }

            Files.write(archivo, lineas);

            System.out.println("Inventario exportado correctamente.");
            System.out.println("Archivo: " + archivo);
        }
    }


    public void importarLote(Path archivo)
            throws BatchProcessingException {

        int numeroLinea = 0;

        String sql = "INSERT INTO productos " +
                "(codigo_sku, descripcion, precio_unitario, stock_disponible) " +
                "VALUES (?, ?, ?, ?)";

        try (Connection con = ConexionBD.conectar()) {

            con.setAutoCommit(false);

            try {

                List<String> lineas = Files.readAllLines(archivo);

                for (String linea : lineas) {

                    numeroLinea++;

                    if (numeroLinea == 1 &&
                            linea.toUpperCase().startsWith("SKU")) {
                        continue;
                    }

                    String[] datos = linea.split(",", -1);

                    if (datos.length != 4) {
                        throw new BatchProcessingException(
                                "Cantidad incorrecta de columnas",
                                numeroLinea
                        );
                    }

                    String sku = datos[0].trim();
                    String descripcion = datos[1].trim();

                    java.math.BigDecimal precio;
                    int stock;

                    try {
                        precio = new java.math.BigDecimal(datos[2].trim());
                        stock = Integer.parseInt(datos[3].trim());

                    } catch (NumberFormatException e) {

                        throw new BatchProcessingException(
                                "Precio o stock con formato incorrecto",
                                numeroLinea
                        );
                    }

                    if (precio.signum() < 0 || stock < 0) {

                        throw new BatchProcessingException(
                                "El precio y el stock no pueden ser negativos",
                                numeroLinea
                        );
                    }

                    try (PreparedStatement ps =
                                 con.prepareStatement(sql)) {

                        ps.setString(1, sku);
                        ps.setString(2, descripcion);
                        ps.setBigDecimal(3, precio);
                        ps.setInt(4, stock);

                        ps.executeUpdate();
                    }
                }

                con.commit();

                System.out.println("Lote importado correctamente.");

            } catch (Exception e) {

                con.rollback();

                int lineaError = numeroLinea;
                String causa = e.getMessage();

                registrarFallo(lineaError, causa);

                if (e instanceof BatchProcessingException) {
                    throw (BatchProcessingException) e;
                }

                throw new BatchProcessingException(
                        causa, lineaError
                );
            }

        } catch (SQLException e) {

            registrarFallo(numeroLinea, e.getMessage());

            throw new BatchProcessingException(
                    e.getMessage(), numeroLinea
            );
        }
    }



    private void registrarFallo(int linea, String causa) {

        try {

            Path archivoLog = Path.of(
                    "var", "log", "fallos_importacion.log"
            );

            Files.createDirectories(archivoLog.getParent());

            String registro =
                    LocalDateTime.now().format(
                            DateTimeFormatter.ISO_LOCAL_DATE_TIME
                    )
                            + " | Linea: " + linea
                            + " | Causa: " + causa
                            + System.lineSeparator();

            Files.writeString(
                    archivoLog,
                    registro,
                    java.nio.file.StandardOpenOption.CREATE,
                    java.nio.file.StandardOpenOption.APPEND
            );

        } catch (IOException e) {

            System.out.println(
                    "No se pudo escribir el archivo de errores."
            );
        }
    }
}

