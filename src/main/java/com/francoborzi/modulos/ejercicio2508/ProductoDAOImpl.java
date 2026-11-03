package com.francoborzi.modulos.ejercicio2508;

package dao;

import config.ConnectionFactory;
import exception.DAOException;
import model.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductoDAOImpl implements ProductoDAO {

    private final ConnectionFactory connectionFactory;

    public ProductoDAOImpl(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Override
    public void guardar(Producto producto) throws DAOException {

        String sql = "INSERT INTO productos " +
                "(codigo_sku, descripcion, precio_unitario, stock_disponible) " +
                "VALUES (?, ?, ?, ?)";

        try (Connection con = connectionFactory.get();
             PreparedStatement ps = con.prepareStatement(
                     sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, producto.getCodigoSku());
            ps.setString(2, producto.getDescripcion());
            ps.setBigDecimal(3, producto.getPrecioUnitario());
            ps.setInt(4, producto.getStockDisponible());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    producto.setId(rs.getLong(1));
                } else {
                    throw new SQLException(
                            "no se generó el identificador del producto");
                }
            }

        } catch (SQLException | IllegalStateException e) {
            throw new DAOException("error al guardar el producto", e);
        }
    }

    @Override
    public Optional<Producto> buscarPorId(Long id)
            throws DAOException {

        String sql = "SELECT * FROM productos WHERE id = ?";

        try (Connection con = connectionFactory.get();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapearProducto(rs));
                }
                return Optional.empty();
            }

        } catch (SQLException | IllegalStateException e) {
            throw new DAOException("error al buscar por id", e);
        }
    }

    @Override
    public Optional<Producto> buscarPorSku(String sku)
            throws DAOException {

        String sql = "SELECT * FROM productos WHERE codigo_sku = ?";

        try (Connection con = connectionFactory.get();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, sku);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapearProducto(rs));
                }
                return Optional.empty();
            }

        } catch (SQLException | IllegalStateException e) {
            throw new DAOException("e al buscar por sku", e);
        }
    }

    @Override
    public List<Producto> listarTodos() throws DAOException {

        String sql = "SELECT * FROM productos";
        List<Producto> productos = new ArrayList<>();

        try (Connection con = connectionFactory.get();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                productos.add(mapearProducto(rs));
            }

            return productos;

        } catch (SQLException | IllegalStateException e) {
            throw new DAOException("error al listar los productos", e);
        }
    }

    @Override
    public void actualizarStock(Long id, Integer nuevoStock)
            throws DAOException {

        String sql =
                "UPDATE productos SET stock_disponible = ? WHERE id = ?";

        try (Connection con = connectionFactory.get();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, nuevoStock);
            ps.setLong(2, id);

            ps.executeUpdate();

        } catch (SQLException | IllegalStateException e) {
            throw new DAOException("error al actualizar el stock", e);
        }
    }

    @Override
    public void eliminar(Long id) throws DAOException {

        String sql = "DELETE FROM productos WHERE id = ?";

        try (Connection con = connectionFactory.get();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (SQLException | IllegalStateException e) {
            throw new DAOException("error al eliminar el producto", e);
        }
    }

    private Producto mapearProducto(ResultSet rs) throws SQLException {

        return new Producto(
                rs.getLong("id"),
                rs.getString("codigo_sku"),
                rs.getString("descripcion"),
                rs.getBigDecimal("precio_unitario"),
                rs.getInt("stock_disponible")
        );
    }
}

