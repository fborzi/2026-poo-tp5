package com.francoborzi.modulos.ejercicio2508.dao;

import com.francoborzi.modulos.ejercicio2508.config.ProveedorConexion;
import com.francoborzi.modulos.ejercicio2508.exception.DAOException;
import com.francoborzi.modulos.ejercicio2508.model.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Implementación de ProductoDAO con JDBC puro.
 */
public class ProductoDAOImpl implements ProductoDAO {

    private ProveedorConexion proveedorConexion;

    /**
     * Crea el DAO.
     *
     * @param proveedorConexion proveedor de conexiones a la base
     */
    public ProductoDAOImpl(ProveedorConexion proveedorConexion) {
        this.proveedorConexion = proveedorConexion;
    }

    @Override
    public void guardar(Producto producto) throws DAOException {
        String sql = "INSERT INTO productos "
                + "(codigo_sku, descripcion, precio_unitario, stock_disponible) "
                + "VALUES (?, ?, ?, ?)";
        try (Connection conexion = proveedorConexion.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql,
                     PreparedStatement.RETURN_GENERATED_KEYS)) {
            sentencia.setString(1, producto.getCodigoSku());
            sentencia.setString(2, producto.getDescripcion());
            sentencia.setBigDecimal(3, producto.getPrecioUnitario());
            sentencia.setInt(4, producto.getStockDisponible());
            sentencia.executeUpdate();
            try (ResultSet claves = sentencia.getGeneratedKeys()) {
                if (claves.next()) {
                    producto.setId(claves.getLong(1));
                }
            }
        } catch (SQLException e) {
            throw new DAOException("No se pudo guardar el producto "
                    + producto.getCodigoSku(), e);
        }
    }

    @Override
    public Optional<Producto> buscarPorId(Long id) throws DAOException {
        String sql = "SELECT id, codigo_sku, descripcion, precio_unitario, "
                + "stock_disponible FROM productos WHERE id = ?";
        Optional<Producto> resultado = Optional.empty();
        try (Connection conexion = proveedorConexion.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setLong(1, id);
            try (ResultSet filas = sentencia.executeQuery()) {
                if (filas.next()) {
                    resultado = Optional.of(mapearProducto(filas));
                }
            }
        } catch (SQLException e) {
            throw new DAOException("No se pudo buscar el producto con id " + id, e);
        }
        return resultado;
    }

    @Override
    public Optional<Producto> buscarPorSku(String sku) throws DAOException {
        String sql = "SELECT id, codigo_sku, descripcion, precio_unitario, "
                + "stock_disponible FROM productos WHERE codigo_sku = ?";
        Optional<Producto> resultado = Optional.empty();
        try (Connection conexion = proveedorConexion.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setString(1, sku);
            try (ResultSet filas = sentencia.executeQuery()) {
                if (filas.next()) {
                    resultado = Optional.of(mapearProducto(filas));
                }
            }
        } catch (SQLException e) {
            throw new DAOException("No se pudo buscar el producto con SKU " + sku, e);
        }
        return resultado;
    }

    @Override
    public List<Producto> listarTodos() throws DAOException {
        String sql = "SELECT id, codigo_sku, descripcion, precio_unitario, "
                + "stock_disponible FROM productos ORDER BY id";
        List<Producto> productos = new ArrayList<>();
        try (Connection conexion = proveedorConexion.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql);
             ResultSet filas = sentencia.executeQuery()) {
            while (filas.next()) {
                productos.add(mapearProducto(filas));
            }
        } catch (SQLException e) {
            throw new DAOException("No se pudo listar los productos", e);
        }
        return productos;
    }

    @Override
    public boolean actualizarStock(Long id, Integer nuevoStock) throws DAOException {
        String sql = "UPDATE productos SET stock_disponible = ? WHERE id = ?";
        boolean actualizado;
        try (Connection conexion = proveedorConexion.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setInt(1, nuevoStock);
            sentencia.setLong(2, id);
            actualizado = sentencia.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DAOException("No se pudo actualizar el stock del producto con id "
                    + id, e);
        }
        return actualizado;
    }

    @Override
    public boolean eliminar(Long id) throws DAOException {
        String sql = "DELETE FROM productos WHERE id = ?";
        boolean eliminado;
        try (Connection conexion = proveedorConexion.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setLong(1, id);
            eliminado = sentencia.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DAOException("No se pudo eliminar el producto con id " + id, e);
        }
        return eliminado;
    }

    /**
     * Convierte la fila actual del ResultSet en un Producto (mapeo ORM manual).
     *
     * @param fila ResultSet posicionado en la fila a convertir
     * @return el producto con los datos de la fila
     * @throws SQLException si falla la lectura de una columna
     */
    private Producto mapearProducto(ResultSet fila) throws SQLException {
        return new Producto(
                fila.getLong("id"),
                fila.getString("codigo_sku"),
                fila.getString("descripcion"),
                fila.getBigDecimal("precio_unitario"),
                fila.getInt("stock_disponible"));
    }
}