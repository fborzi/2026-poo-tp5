
package com.francoborzi.modulos.ejercicio2508.dao;

import com.francoborzi.modulos.ejercicio2508.config.DatabaseConfig;
import com.francoborzi.modulos.ejercicio2508.exception.DAOException;
import com.francoborzi.modulos.ejercicio2508.model.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Implementa el acceso a productos mediante JDBC puro.
 */
public class ProductoDAOImpl implements ProductoDAO {

    /**
     * Guarda un producto y recupera su identificador.
     *
     * @param producto producto a guardar
     * @throws DAOException si ocurre un error
     */
    @Override
    public void guardar(Producto producto) throws DAOException {
        Objects.requireNonNull(producto);

        if (producto.getId() != null) {
            throw new IllegalArgumentException(
                    "El producto ya tiene identificador");
        }

        String sql = """
                INSERT INTO productos
                (codigo_sku, descripcion, precio_unitario,
                 stock_disponible)
                VALUES (?, ?, ?, ?)
                """;

        try (Connection conexion = DatabaseConfig.getConnection();
             PreparedStatement sentencia = conexion.prepareStatement(
                     sql, Statement.RETURN_GENERATED_KEYS)) {

            sentencia.setString(1, producto.getCodigoSku());
            sentencia.setString(2, producto.getDescripcion());
            sentencia.setBigDecimal(3, producto.getPrecioUnitario());
            sentencia.setInt(4, producto.getStockDisponible());

            sentencia.executeUpdate();

            try (ResultSet claves = sentencia.getGeneratedKeys()) {
                if (claves.next()) {
                    producto.setId(claves.getLong(1));
                } else {
                    throw new SQLException(
                            "No se genero el identificador");
                }
            }

        } catch (SQLException excepcion) {
            throw new DAOException(
                    "No se pudo guardar el producto", excepcion);
        }
    }

    /**
     * Busca un producto por identificador.
     *
     * @param id identificador
     * @return producto encontrado o vacio
     * @throws DAOException si ocurre un error
     */
    @Override
    public Optional<Producto> buscarPorId(Long id)
            throws DAOException {

        Objects.requireNonNull(id);

        String sql = "SELECT * FROM productos WHERE id = ?";

        try (Connection conexion = DatabaseConfig.getConnection();
             PreparedStatement sentencia =
                     conexion.prepareStatement(sql)) {

            sentencia.setLong(1, id);

            try (ResultSet resultado = sentencia.executeQuery()) {
                if (resultado.next()) {
                    return Optional.of(mapearProducto(resultado));
                }
            }

            return Optional.empty();

        } catch (SQLException excepcion) {
            throw new DAOException(
                    "No se pudo buscar el producto por ID",
                    excepcion);
        }
    }

    /**
     * Busca un producto por codigo SKU.
     *
     * @param sku codigo del producto
     * @return producto encontrado o vacio
     * @throws DAOException si ocurre un error
     */
    @Override
    public Optional<Producto> buscarPorSku(String sku)
            throws DAOException {

        Objects.requireNonNull(sku);

        String sql = "SELECT * FROM productos WHERE codigo_sku = ?";

        try (Connection conexion = DatabaseConfig.getConnection();
             PreparedStatement sentencia =
                     conexion.prepareStatement(sql)) {

            sentencia.setString(1, sku);

            try (ResultSet resultado = sentencia.executeQuery()) {
                if (resultado.next()) {
                    return Optional.of(mapearProducto(resultado));
                }
            }

            return Optional.empty();

        } catch (SQLException excepcion) {
            throw new DAOException(
                    "No se pudo buscar el producto por SKU",
                    excepcion);
        }
    }

    /**
     * Obtiene todos los productos.
     *
     * @return lista de productos
     * @throws DAOException si ocurre un error
     */
    @Override
    public List<Producto> listarTodos() throws DAOException {
        String sql = "SELECT * FROM productos ORDER BY id";
        List<Producto> productos = new ArrayList<>();

        try (Connection conexion = DatabaseConfig.getConnection();
             PreparedStatement sentencia =
                     conexion.prepareStatement(sql);
             ResultSet resultado = sentencia.executeQuery()) {

            while (resultado.next()) {
                productos.add(mapearProducto(resultado));
            }

            return productos;

        } catch (SQLException excepcion) {
            throw new DAOException(
                    "No se pudieron listar los productos",
                    excepcion);
        }
    }

    /**
     * Actualiza el stock de un producto.
     *
     * @param id identificador
     * @param nuevoStock stock actualizado
     * @throws DAOException si ocurre un error
     */
    @Override
    public void actualizarStock(Long id, Integer nuevoStock)
            throws DAOException {

        Objects.requireNonNull(id);
        Objects.requireNonNull(nuevoStock);

        if (nuevoStock < 0) {
            throw new IllegalArgumentException(
                    "El stock no puede ser negativo");
        }

        String sql = """
                UPDATE productos
                SET stock_disponible = ?
                WHERE id = ?
                """;

        try (Connection conexion = DatabaseConfig.getConnection();
             PreparedStatement sentencia =
                     conexion.prepareStatement(sql)) {

            sentencia.setInt(1, nuevoStock);
            sentencia.setLong(2, id);
            sentencia.executeUpdate();

        } catch (SQLException excepcion) {
            throw new DAOException(
                    "No se pudo actualizar el stock",
                    excepcion);
        }
    }

    /**
     * Elimina un producto por identificador.
     *
     * @param id identificador
     * @throws DAOException si ocurre un error
     */
    @Override
    public void eliminar(Long id) throws DAOException {
        Objects.requireNonNull(id);

        String sql = "DELETE FROM productos WHERE id = ?";

        try (Connection conexion = DatabaseConfig.getConnection();
             PreparedStatement sentencia =
                     conexion.prepareStatement(sql)) {

            sentencia.setLong(1, id);
            sentencia.executeUpdate();

        } catch (SQLException excepcion) {
            throw new DAOException(
                    "No se pudo eliminar el producto",
                    excepcion);
        }
    }

    private Producto mapearProducto(ResultSet resultado)
            throws SQLException {

        return new Producto(
                resultado.getLong("id"),
                resultado.getString("codigo_sku"),
                resultado.getString("descripcion"),
                resultado.getBigDecimal("precio_unitario"),
                resultado.getInt("stock_disponible"));
    }
}
