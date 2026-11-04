
package com.francoborzi.modulos.ejercicio2508.dao;

import com.francoborzi.modulos.ejercicio2508.exception.DAOException;
import com.francoborzi.modulos.ejercicio2508.model.Producto;
import java.util.List;
import java.util.Optional;

/**
 * Define las operaciones de persistencia de productos.
 */
public interface ProductoDAO {

    /**
     * Guarda un producto.
     *
     * @param producto producto a guardar
     * @throws DAOException si falla el registro
     */
    void guardar(Producto producto) throws DAOException;

    /**
     * Busca un producto por identificador.
     *
     * @param id identificador
     * @return producto encontrado o vacio
     * @throws DAOException si falla la consulta
     */
    Optional<Producto> buscarPorId(Long id) throws DAOException;

    /**
     * Busca un producto por codigo SKU.
     *
     * @param sku codigo SKU
     * @return producto encontrado o vacio
     * @throws DAOException si falla la consulta
     */
    Optional<Producto> buscarPorSku(String sku) throws DAOException;

    /**
     * Obtiene todos los productos.
     *
     * @return lista de productos
     * @throws DAOException si falla la consulta
     */
    List<Producto> listarTodos() throws DAOException;

    /**
     * Modifica el stock de un producto.
     *
     * @param id identificador
     * @param nuevoStock nuevo stock
     * @throws DAOException si falla la actualizacion
     */
    void actualizarStock(Long id, Integer nuevoStock)
            throws DAOException;

    /**
     * Elimina un producto.
     *
     * @param id identificador
     * @throws DAOException si falla la eliminacion
     */
    void eliminar(Long id) throws DAOException;
}
