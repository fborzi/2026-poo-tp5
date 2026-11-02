package com.francoborzi.modulos.ejercicio2508.dao;

import com.francoborzi.modulos.ejercicio2508.conf.ConnectionFactory;
import com.francoborzi.modulos.ejercicio2508.exception.DAOException;
import com.francoborzi.modulos.ejercicio2508.model.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public class ProductoDAOImpl implements ProductoDAO {

    @Override
    public void guardar(Producto producto) {

        String sql = "INSERT INTO productos " +
                "(codigo_sku, descripcion, precio_unitario, stock_disponible) " +
                "VALUES (?, ?, ?, ?)";

        try (Connection conexion = ConnectionFactory.getConnection();
             PreparedStatement ps = conexion.prepareStatement(
                     sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, producto.getCodigoSku());
            ps.setString(2, producto.getDescripcion());
            ps.setBigDecimal(3, producto.getPrecioUnitario());
            ps.setInt(4, producto.getStockDisponible());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    producto.setId(rs.getLong(1));
                }
            }

        } catch (SQLException e) {
            throw new DAOException("Error al guardar el producto", e);
        }
    }

    @Override
    public Optional<Producto> buscarPorId(Long id) {

        String sql = "SELECT * FROM productos WHERE id = ?";

        try (Connection conexion = ConnectionFactory.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapearProducto(rs));
                }
            }

            return Optional.empty();

        } catch (SQLException e) {
            throw new DAOException("Error al buscar producto por ID", e);
        }
    }

    @Override
    public Optional<Producto> buscarPorSku(String sku) {

        String sql = "SELECT * FROM productos WHERE codigo_sku = ?";

        try (Connection conexion = ConnectionFactory.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, sku);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapearProducto(rs));
                }
            }

            return Optional.empty();

        } catch (SQLException e) {
            throw new DAOException("Error al buscar producto por SKU", e);
        }
    }

    @Override
    public List<Producto> listarTodos() {

        String sql = "SELECT * FROM productos";

        List<Producto> productos = new java.util.ArrayList<>();

        try (Connection conexion = ConnectionFactory.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                productos.add(mapearProducto(rs));
            }

            return productos;

        } catch (SQLException e) {
            throw new DAOException("Error al listar los productos", e);
        }
    }

    @Override
    public boolean actualizarStock(Long id, Integer nuevoStock) {

        String sql = "UPDATE productos SET stock_disponible = ? WHERE id = ?";

        try (Connection conexion = ConnectionFactory.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, nuevoStock);
            ps.setLong(2, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new DAOException("Error al actualizar el stock", e);
        }
    }

    @Override
    public boolean eliminar(Long id) {

        String sql = "DELETE FROM productos WHERE id = ?";

        try (Connection conexion = ConnectionFactory.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setLong(1, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new DAOException("Error al eliminar el producto", e);
        }
    }

    // Método auxiliar para convertir una fila de MySQL en un objeto Producto

    private Producto mapearProducto(ResultSet rs) throws SQLException {

        Producto producto = new Producto();

        producto.setId(rs.getLong("id"));
        producto.setCodigoSku(rs.getString("codigo_sku"));
        producto.setDescripcion(rs.getString("descripcion"));
        producto.setPrecioUnitario(rs.getBigDecimal("precio_unitario"));
        producto.setStockDisponible(rs.getInt("stock_disponible"));

        return producto;
    }

}