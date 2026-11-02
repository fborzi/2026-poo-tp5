package edu.programacion.ejercicio2509;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
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

/**
 * Procesa exportaciones e importaciones por lotes del inventario.
 * Utiliza JDBC y transacciones explícitas para importar datos.
 */
public class StockBatchProcessor {

    private static final Path CARPETA_EXPORTACION =
            Path.of("exports");

    private static final Path ARCHIVO_IMPORTACION =
            Path.of("imports", "lote_ingresos.csv");

    private static final Path ARCHIVO_LOG =
            Path.of("var", "log", "fallos_importacion.log");

    /**
     * Representa una fila validada del archivo CSV.
     *
     * @param sku código único del artículo.
     * @param descripcion descripción del artículo.
     * @param precio precio unitario.
     * @param stock cantidad disponible.
     */
    private record FilaCSV(
            String sku,
            String descripcion,
            BigDecimal precio,
            int stock) {
    }

    /**
     * Exporta el inventario completo a un archivo CSV.
     *
     * @return ruta del archivo generado.
     * @throws BatchProcessingException si ocurre un error de exportación.
     */
    public Path exportarInventario() throws edu.programacion.ejercicio2509.BatchProcessingException {

        String fecha = LocalDate.now().format(
                DateTimeFormatter.ISO_LOCAL_DATE
        );

        Path archivo = CARPETA_EXPORTACION.resolve(
                "inventario_consolidado_" + fecha + ".csv"
        );

        String sql = "SELECT codigo_sku, descripcion, "
                + "precio_unitario, stock_disponible "
                + "FROM producto ORDER BY codigo_sku";

        try {
            Files.createDirectories(CARPETA_EXPORTACION);

            try (Connection conexion = edu.programacion.ejercicio2509.ConexionBD.obtenerConexion();
                 PreparedStatement sentencia =
                         conexion.prepareStatement(sql);
                 ResultSet resultado = sentencia.executeQuery();
                 var escritor = Files.newBufferedWriter(
                         archivo,
                         StandardCharsets.UTF_8)) {

                escritor.write("SKU,DESCRIPCION,PRECIO,STOCK");
                escritor.newLine();

                while (resultado.next()) {
                    String sku = campoCSV(
                            resultado.getString("codigo_sku")
                    );

                    String descripcion = campoCSV(
                            resultado.getString("descripcion")
                    );

                    BigDecimal precio =
                            resultado.getBigDecimal("precio_unitario");

                    int stock = resultado.getInt("stock_disponible");

                    escritor.write(
                            sku + ","
                                    + descripcion + ","
                                    + precio.toPlainString() + ","
                                    + stock
                    );

                    escritor.newLine();
                }
            }

            return archivo;

        } catch (IOException | SQLException e) {
            throw new edu.programacion.ejercicio2509.BatchProcessingException(
                    "Error al exportar el inventario: " + e.getMessage(),
                    -1,
                    e
            );
        }
    }

    /**
     * Importa un lote de novedades desde el CSV.
     * Primero valida todas las filas y después inicia la transacción.
     *
     * @throws BatchProcessingException si hay errores de formato,
     * validación o base de datos.
     */
    public void importarLote() throws edu.programacion.ejercicio2509.BatchProcessingException {

        List<FilaCSV> filas = leerYValidarArchivo();

        if (filas.isEmpty()) {
            throw new edu.programacion.ejercicio2509.BatchProcessingException(
                    "El archivo no contiene registros para importar.",
                    -1
            );
        }

        String sql = "INSERT INTO producto "
                + "(codigo_sku, descripcion, precio_unitario, "
                + "stock_disponible) VALUES (?, ?, ?, ?) "
                + "ON DUPLICATE KEY UPDATE "
                + "descripcion = VALUES(descripcion), "
                + "precio_unitario = VALUES(precio_unitario), "
                + "stock_disponible = VALUES(stock_disponible)";

        try (Connection conexion = edu.programacion.ejercicio2509.ConexionBD.obtenerConexion()) {

            try {
                conexion.setAutoCommit(false);

                try (PreparedStatement sentencia =
                             conexion.prepareStatement(sql)) {

                    for (FilaCSV fila : filas) {
                        sentencia.setString(1, fila.sku());
                        sentencia.setString(2, fila.descripcion());
                        sentencia.setBigDecimal(3, fila.precio());
                        sentencia.setInt(4, fila.stock());

                        sentencia.addBatch();
                    }

                    sentencia.executeBatch();
                }

                conexion.commit();

            } catch (SQLException e) {
                try {
                    conexion.rollback();
                } catch (SQLException errorRollback) {
                    e.addSuppressed(errorRollback);
                }

                registrarFallo(-1, e.getMessage());

                throw new edu.programacion.ejercicio2509.BatchProcessingException(
                        "Falló la importación. Se intentó revertir "
                                + "la transacción: " + e.getMessage(),
                        -1,
                        e
                );

            } finally {
                try {
                    conexion.setAutoCommit(true);
                } catch (SQLException ignored) {
                    // La conexión se cerrará al salir del try-with-resources.
                }
            }

        } catch (SQLException e) {
            registrarFallo(-1, e.getMessage());

            throw new edu.programacion.ejercicio2509.BatchProcessingException(
                    "No se pudo conectar con la base de datos.",
                    -1,
                    e
            );
        }
    }

    /**
     * Lee y valida todas las filas del archivo antes de insertarlas.
     *
     * @return filas validadas.
     * @throws BatchProcessingException si una fila es inválida.
     */
    private List<FilaCSV> leerYValidarArchivo()
            throws edu.programacion.ejercicio2509.BatchProcessingException {

        List<FilaCSV> filas = new ArrayList<>();

        if (!Files.exists(ARCHIVO_IMPORTACION)) {
            throw new edu.programacion.ejercicio2509.BatchProcessingException(
                    "No existe el archivo: "
                            + ARCHIVO_IMPORTACION.toAbsolutePath(),
                    -1
            );
        }

        try (BufferedReader lector = Files.newBufferedReader(
                ARCHIVO_IMPORTACION,
                StandardCharsets.UTF_8)) {

            String encabezado = lector.readLine();

            if (encabezado == null
                    || !encabezado.trim().equalsIgnoreCase(
                    "SKU,DESCRIPCION,PRECIO,STOCK")) {

                throw new edu.programacion.ejercicio2509.BatchProcessingException(
                        "El encabezado CSV no es válido.",
                        1
                );
            }

            String linea;
            int numeroLinea = 1;

            while ((linea = lector.readLine()) != null) {
                numeroLinea++;

                if (linea.isBlank()) {
                    continue;
                }

                String[] campos = linea.split(",", -1);

                if (campos.length != 4) {
                    registrarFallo(
                            numeroLinea,
                            "La fila debe contener cuatro columnas."
                    );

                    throw new edu.programacion.ejercicio2509.BatchProcessingException(
                            "Cantidad incorrecta de columnas.",
                            numeroLinea
                    );
                }

                try {
                    String sku = campos[0].trim();
                    String descripcion = campos[1].trim();
                    BigDecimal precio =
                            new BigDecimal(campos[2].trim());
                    int stock = Integer.parseInt(campos[3].trim());

                    if (sku.isEmpty() || descripcion.isEmpty()) {
                        throw new IllegalArgumentException(
                                "El SKU y la descripción son obligatorios."
                        );
                    }

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

                    filas.add(new FilaCSV(
                            sku,
                            descripcion,
                            precio,
                            stock
                    ));

                } catch (IllegalArgumentException e) {

                    registrarFallo(numeroLinea, e.getMessage());

                    throw new edu.programacion.ejercicio2509.BatchProcessingException(
                            "Fila inválida: " + e.getMessage(),
                            numeroLinea,
                            e
                    );
                }
            }

            return filas;

        } catch (IOException e) {
            registrarFallo(-1, e.getMessage());

            throw new edu.programacion.ejercicio2509.BatchProcessingException(
                    "No se pudo leer el archivo CSV.",
                    -1,
                    e
            );
        }
    }

    /**
     * Escapa comas y comillas para generar un campo CSV válido.
     *
     * @param valor texto que se va a escribir.
     * @return texto escapado para CSV.
     */
    private String campoCSV(String valor) {
        if (valor == null) {
            return "";
        }

        return "\"" + valor.replace("\"", "\"\"") + "\"";
    }

    /**
     * Registra un fallo de importación en el archivo de auditoría.
     *
     * @param numeroLinea línea del archivo donde ocurrió el error.
     * @param causa descripción del fallo.
     */
    private void registrarFallo(int numeroLinea, String causa) {
        try {
            Files.createDirectories(ARCHIVO_LOG.getParent());

            String registro = LocalDateTime.now()
                    .format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                    + " | Línea: " + numeroLinea
                    + " | Causa: " + causa
                    .replace("\n", " ")
                    .replace("\r", " ");

            Files.writeString(
                    ARCHIVO_LOG,
                    registro + System.lineSeparator(),
                    StandardCharsets.UTF_8,
                    java.nio.file.StandardOpenOption.CREATE,
                    java.nio.file.StandardOpenOption.APPEND
            );

        } catch (IOException e) {
            System.err.println(
                    "No se pudo escribir el log de fallos: "
                            + e.getMessage()
            );
        }
    }
}