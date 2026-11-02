package edu.programacion.ejercicio2509;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Administra la conexión con la base de datos del inventario.
 */
public final class ConexionBD {

    private static final String URL =
            System.getProperty(
                    "db.url",
                    "jdbc:mysql://localhost:3306/inventario"
            );

    private static final String USUARIO =
            System.getProperty("db.usuario", "root");

    private static final String CLAVE =
            System.getProperty("db.clave", "");

    /**
     * Constructor privado para impedir la creación de objetos.
     */
    private ConexionBD() {
    }

    /**
     * Establece una conexión con la base de datos.
     *
     * @return conexión JDBC abierta.
     * @throws SQLException si no se puede establecer la conexión.
     */
    public static Connection obtenerConexion() throws SQLException {
        Connection conexion = DriverManager.getConnection(
                URL,
                USUARIO,
                CLAVE
        );

        // Desactiva el autocommit para controlar las transacciones.
        conexion.setAutoCommit(false);

        return conexion;
    }
}