package com.francoborzi.modulos.ejercicio2509.config;

import com.francoborzi.modulos.ejercicio2509.exception.BatchProcessingException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Crea la tabla de artículos necesaria para el procesamiento por lotes.
 */
public class InicializadorTablaArticulos {

    private ProveedorConexion proveedorConexion;

    /**
     * Crea el inicializador.
     *
     * @param proveedorConexion proveedor de conexiones a la base
     */
    public InicializadorTablaArticulos(ProveedorConexion proveedorConexion) {
        this.proveedorConexion = proveedorConexion;
    }

    /**
     * Crea la tabla productos si no existe.
     *
     * @throws BatchProcessingException si falla la creación
     */
    public void crearTabla() throws BatchProcessingException {
        String sql = "CREATE TABLE IF NOT EXISTS productos ("
                + "id BIGINT AUTO_INCREMENT PRIMARY KEY, "
                + "codigo_sku VARCHAR(50) NOT NULL UNIQUE, "
                + "descripcion VARCHAR(255) NOT NULL, "
                + "precio_unitario DECIMAL(12, 2) NOT NULL, "
                + "stock_disponible INT NOT NULL)";
        try (Connection conexion = proveedorConexion.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.executeUpdate();
        } catch (SQLException e) {
            throw new BatchProcessingException(0, "No se pudo crear la tabla productos", e);
        }
    }
}