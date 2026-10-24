package com.francoborzi.modulos.ejercicio2508.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Crea conexiones con DriverManager a partir de credenciales configurables.
 */
public class ProveedorConexionDriverManager implements ProveedorConexion {

    private String url;
    private String usuario;
    private String clave;

    /**
     * Crea el proveedor con los datos de conexión.
     *
     * @param url URL JDBC de la base de datos
     * @param usuario usuario de la base
     * @param clave contraseña del usuario
     */
    public ProveedorConexionDriverManager(String url, String usuario, String clave) {
        this.url = url;
        this.usuario = usuario;
        this.clave = clave;
    }

    @Override
    public Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(url, usuario, clave);
    }
}