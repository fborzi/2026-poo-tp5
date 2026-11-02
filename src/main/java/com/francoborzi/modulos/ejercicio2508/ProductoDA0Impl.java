package edu.programacion.ejercicio2508;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Implementación de ProductoDAO utilizando JDBC puro.
 */
public class ProductoDAOImpl implements edu.programacion.ejercicio2508.ProductoDAO {

    /**
     * Guarda un producto y recupera su identificador generado.
     *
     * @param producto producto que se desea guardar.
     * @return producto guardado con su identificador.
     * @throws DAOException si ocurre un error SQL.
     */
    @Override
    public edu.programacion.ejercicio2508.Producto guardar(edu.programacion.ejercicio2508.Producto producto) throws DAOException {
        String sql = "INSERT INTO producto "
                + "(codigo_sku, descripcion, precio_unitario, stock_disponible) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection conexion = edu.programacion.ejercicio2508.ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(
                     sql, Statement.RETURN_GENERATED_KEYS)) {

            sentencia.setString(1, producto.getCodigoSku());
            sentencia.setString(2, producto.getDescripcion());
            sentencia.setBigDecimal(3, producto.getPrecioUnitario());
            sentencia.setInt(4, producto.getStockDisponible());

            int filas = sentencia.executeUpdate();

            if (filas == 0) {
                throw new edu.programacion.ejercicio2508.DAOException("No se pudo guardar el producto.");
            }

            try (ResultSet claves = sentencia.getGeneratedKeys()) {
                if (claves.next()) {
                    producto.setId(claves.getLong(1));
                } else {
                    throw new edu.programacion.ejercicio2508.DAOException(
                            "No se recibió el identificador generado."
                    );
                }
            }

            return producto;

        } catch (SQLException e) {
            throw new edu.programacion.ejercicio2508.DAOException("Error al guardar el producto.", e);
        }
    }

    /**
     * Busca un producto por su identificador.
     *
     * @param id identificador del producto.
     * @return producto encontrado o Optional vacío.
     * @throws DAOException si ocurre un error SQL.
     */
    @Override
    public Optional<edu.programacion.ejercicio2508.Producto> buscarPorId(Long id) throws edu.programacion.ejercicio2508.DAOException {
        String sql = "SELECT id, codigo_sku, descripcion, "
                + "precio_unitario, stock_disponible "
                + "FROM producto WHERE id = ?";

        try (Connection conexion = edu.programacion.ejercicio2508.ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setLong(1, id);

            try (ResultSet resultado = sentencia.executeQuery()) {
                if (resultado.next()) {
                    return Optional.of(mapearProducto(resultado));
                }
                return Optional.empty();
            }

        } catch (SQLException e) {
            throw new edu.programacion.ejercicio2508.DAOException("Error al buscar el producto por ID.", e);
        }
    }

    /**
     * Busca un producto por su código SKU.
     *
     * @param sku código SKU.
     * @return producto encontrado o Optional vacío.
     * @throws DAOException si ocurre un error SQL.
     */
    @Override
    public Optional<edu.programacion.ejercicio2508.Producto> buscarPorSku(String sku) throws edu.programacion.ejercicio2508.DAOException {
        String sql = "SELECT id, codigo_sku, descripcion, "
                + "precio_unitario, stock_disponible "
                + "FROM producto WHERE codigo_sku = ?";

        try (Connection conexion = edu.programacion.ejercicio2508.ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, sku);

            try (ResultSet resultado = sentencia.executeQuery()) {
                if (resultado.next()) {
                    return Optional.of(mapearProducto(resultado));
                }
                return Optional.empty();
            }

        } catch (SQLException e) {
            throw new edu.programacion.ejercicio2508.DAOException("Error al buscar el producto por SKU.", e);
        }
    }

    /**
     * Recupera todos los productos registrados.
     *
     * @return lista de productos.
     * @throws DAOException si ocurre un error SQL.
     */
    @Override
    public List<edu.programacion.ejercicio2508.Producto> listarTodos() throws edu.programacion.ejercicio2508.DAOException {
        String sql = "SELECT id, codigo_sku, descripcion, "
                + "precio_unitario, stock_disponible FROM producto";

        List<edu.programacion.ejercicio2508.Producto> productos = new ArrayList<>();

        try (Connection conexion = edu.programacion.ejercicio2508.ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql);
             ResultSet resultado = sentencia.executeQuery()) {

            while (resultado.next()) {
                productos.add(mapearProducto(resultado));
            }

            return productos;

        } catch (SQLException e) {
            throw new edu.programacion.ejercicio2508.DAOException("Error al listar los productos.", e);
        }
    }

    /**
     * Actualiza el stock de un producto.
     *
     * @param id identificador del producto.
     * @param nuevoStock nuevo stock disponible.
     * @throws DAOException si ocurre un error SQL o el producto no existe.
     */
    @Override
    public void actualizarStock(Long id, Integer nuevoStock)
            throws edu.programacion.ejercicio2508.DAOException {

        String sql = "UPDATE producto SET stock_disponible = ? WHERE id = ?";

        try (Connection conexion = edu.programacion.ejercicio2508.ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setInt(1, nuevoStock);
            sentencia.setLong(2, id);

            if (sentencia.executeUpdate() == 0) {
                throw new edu.programacion.ejercicio2508.DAOException(
                        "No existe un producto con el ID indicado."
                );
            }

        } catch (SQLException e) {
            throw new edu.programacion.ejercicio2508.DAOException("Error al actualizar el stock.", e);
        }
    }

    /**
     * Elimina un producto por su identificador.
     *
     * @param id identificador del producto.
     * @throws DAOException si ocurre un error SQL o el producto no existe.
     */
    @Override
    public void eliminar(Long id) throws edu.programacion.ejercicio2508.DAOException {
        String sql = "DELETE FROM producto WHERE id = ?";

        try (Connection conexion = edu.programacion.ejercicio2508.ConexionBD.obtenerConexion();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setLong(1, id);

            if (sentencia.executeUpdate() == 0) {
                throw new edu.programacion.ejercicio2508.DAOException(
                        "No existe un producto con el ID indicado."
                );
            }

        } catch (SQLException e) {
            throw new edu.programacion.ejercicio2508.DAOException("Error al eliminar el producto.", e);
        }
    }

    /**
     * Convierte una fila del ResultSet en un objeto Producto.
     *
     * @param resultado fila obtenida de la base de datos.
     * @return producto creado a partir de la fila.
     * @throws SQLException si ocurre un error al leer los datos.
     */
    private edu.programacion.ejercicio2508.Producto mapearProducto(ResultSet resultado)
            throws SQLException {

        return new edu.programacion.ejercicio2508.Producto(
                resultado.getLong("id"),
                resultado.getString("codigo_sku"),
                resultado.getString("descripcion"),
                resultado.getBigDecimal("precio_unitario"),
                resultado.getInt("stock_disponible")
        );
    }
}