package edu.programacion.ejercicio2508;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Administra las conexiones JDBC con la base de datos.
 * Los parámetros de conexión pueden configurarse mediante
 * propiedades del sistema.
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
     * Abre una conexión con la base de datos.
     *
     * @return conexión JDBC abierta.
     * @throws DAOException si no se puede establecer la conexión.
     */
    public static Connection obtenerConexion() throws edu.programacion.ejercicio2508.DAOException {
        try {
            return DriverManager.getConnection(URL, USUARIO, CLAVE);
        } catch (SQLException e) {
            throw new edu.programacion.ejercicio2508.DAOException(
                    "No se pudo conectar con la base de datos.",
                    e
            );
        }
    }
}