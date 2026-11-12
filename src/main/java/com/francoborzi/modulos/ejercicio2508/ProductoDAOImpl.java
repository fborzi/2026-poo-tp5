package com.francoborzi.modulos.ejercicio2508;

/**
 * Implementa la interfaz ProductoDAO para realizar
 * operaciones sobre los productos almacenados en MySQL.
 * Permite insertar, listar, buscar, actualizar y eliminar
 * registros mediante consultas SQL.
 * Gestiona la conexion con la base de datos y controla
 * los errores mediante DAOException.
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOImpl implements ProductoDAO {

    @Override
    public void insertar(Producto producto) throws DAOException {

        String sql = "INSERT INTO productos " +
                "(codigo_sku, descripcion, precio_unitario, stock_disponible) " +
                "VALUES (?, ?, ?, ?)";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, producto.getCodigoSku());
            ps.setString(2, producto.getDescripcion());
            ps.setBigDecimal(3, producto.getPrecioUnitario());
            ps.setInt(4, producto.getStockDisponible());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Error al insertar producto", e);
        }
    }

    @Override
    public List<Producto> listarTodos() throws DAOException {

        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM productos";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Producto producto = new Producto(
                        rs.getLong("id"),
                        rs.getString("codigo_sku"),
                        rs.getString("descripcion"),
                        rs.getBigDecimal("precio_unitario"),
                        rs.getInt("stock_disponible")
                );

                productos.add(producto);
            }

        } catch (SQLException e) {
            throw new DAOException("Error al listar productos", e);
        }

        return productos;
    }

    @Override
    public Producto buscarPorId(long id) throws DAOException {

        String sql = "SELECT * FROM productos WHERE id = ?";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    return new Producto(
                            rs.getLong("id"),
                            rs.getString("codigo_sku"),
                            rs.getString("descripcion"),
                            rs.getBigDecimal("precio_unitario"),
                            rs.getInt("stock_disponible")
                    );
                }
            }

        } catch (SQLException e) {
            throw new DAOException("Error al buscar producto", e);
        }

        return null;
    }

    @Override
    public void actualizar(Producto producto) throws DAOException {

        String sql = "UPDATE productos SET " +
                "codigo_sku = ?, descripcion = ?, " +
                "precio_unitario = ?, stock_disponible = ? " +
                "WHERE id = ?";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, producto.getCodigoSku());
            ps.setString(2, producto.getDescripcion());
            ps.setBigDecimal(3, producto.getPrecioUnitario());
            ps.setInt(4, producto.getStockDisponible());
            ps.setLong(5, producto.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Error al actualizar producto", e);
        }
    }

    @Override
    public void eliminar(long id) throws DAOException {

        String sql = "DELETE FROM productos WHERE id = ?";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Error al eliminar producto", e);
        }
    }
}
