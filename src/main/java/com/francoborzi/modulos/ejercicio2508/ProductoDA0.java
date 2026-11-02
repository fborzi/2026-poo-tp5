package edu.programacion.ejercicio2508;

import java.util.List;
import java.util.Optional;

/**
 * Define las operaciones de acceso a datos para productos.
 * Establece el contrato CRUD que implementará ProductoDAOImpl.
 */
public interface ProductoDAO {

    /**
     * Guarda un producto nuevo en la base de datos.
     *
     * @param producto producto que se desea guardar.
     * @return producto guardado con su identificador generado.
     * @throws DAOException si ocurre un error de acceso a datos.
     */
    edu.programacion.ejercicio2508.Producto guardar(edu.programacion.ejercicio2508.Producto producto) throws DAOException;

    /**
     * Busca un producto por su identificador.
     *
     * @param id identificador del producto.
     * @return Optional con el producto, o vacío si no existe.
     * @throws DAOException si ocurre un error de acceso a datos.
     */
    Optional<edu.programacion.ejercicio2508.Producto> buscarPorId(Long id) throws edu.programacion.ejercicio2508.DAOException;

    /**
     * Busca un producto por su código SKU.
     *
     * @param sku código SKU del producto.
     * @return Optional con el producto, o vacío si no existe.
     * @throws DAOException si ocurre un error de acceso a datos.
     */
    Optional<edu.programacion.ejercicio2508.Producto> buscarPorSku(String sku) throws edu.programacion.ejercicio2508.DAOException;

    /**
     * Recupera todos los productos registrados.
     *
     * @return lista de productos.
     * @throws DAOException si ocurre un error de acceso a datos.
     */
    List<edu.programacion.ejercicio2508.Producto> listarTodos() throws edu.programacion.ejercicio2508.DAOException;

    /**
     * Actualiza el stock de un producto.
     *
     * @param id identificador del producto.
     * @param nuevoStock nuevo valor del stock.
     * @throws DAOException si ocurre un error de acceso a datos.
     */
    void actualizarStock(Long id, Integer nuevoStock) throws edu.programacion.ejercicio2508.DAOException;

    /**
     * Elimina un producto por su identificador.
     *
     * @param id identificador del producto.
     * @throws DAOException si ocurre un error de acceso a datos.
     */
    void eliminar(Long id) throws edu.programacion.ejercicio2508.DAOException;
}