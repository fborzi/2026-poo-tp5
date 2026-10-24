package com.francoborzi.modulos.ejercicio2508.config;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Suministra conexiones a la base de datos de forma desacoplada.
 */
public interface ProveedorConexion {

    /**
     * Obtiene una nueva conexión a la base de datos.
     *
     * @return una conexión abierta
     * @throws SQLException si no se puede conectar
     */
    Connection obtenerConexion() throws SQLException;
}