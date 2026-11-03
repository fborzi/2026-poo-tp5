package com.francoborzi.modulos.ejercicio2509.config;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Suministra conexiones a la base de datos
 */
public interface ProveedorConexion {

    /**
     * Obtiene una nueva conexión a la base de datos.
     *
     * @return una conexión abierta
     * @throws SQLException para que pueda puede conectar
     */
    Connection obtenerConexion() throws SQLException;
}