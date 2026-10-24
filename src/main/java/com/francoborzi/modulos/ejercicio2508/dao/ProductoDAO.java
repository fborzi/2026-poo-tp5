package com.francoborzi.modulos.ejercicio2508.dao;

import com.francoborzi.modulos.ejercicio2508.exception.DAOException;
import com.francoborzi.modulos.ejercicio2508.model.Producto;

import java.util.List;
import java.util.Optional;

/**
 * Contrato de operaciones CRUD para la entidad Producto.
 */
public interface ProductoDAO {

    /**
     * Persiste el producto y le asigna la clave primaria generada.
     *
     * @param producto producto a guardar
     * @throws DAOException si falla la operación
     */
    void guardar(Producto producto) throws DAOException;

    /**
     * Busca un producto por su clave primaria.
     *
     * @param id clave primaria
     * @return el producto, o un Optional vacío si no existe
     * @throws DAOException si falla la operación
     */
    Optional<Producto> buscarPorId(Long id) throws DAOException;

    /**
     * Busca un producto por su código SKU.
     *
     * @param sku código único de negocio
     * @return el producto, o un Optional vacío si no existe
     * @throws DAOException si falla la operación
     */
    Optional<Producto> buscarPorSku(String sku) throws DAOException;

    /**
     * Recupera todos los productos del catálogo.
     *
     * @return la lista de productos (vacía si no hay ninguno)
     * @throws DAOException si falla la operación
     */
    List<Producto> listarTodos() throws DAOException;

    /**
     * Modifica el stock disponible de un producto.
     *
     * @param id clave primaria del producto
     * @param nuevoStock nuevo stock disponible
     * @return true si existía el producto y se actualizó
     * @throws DAOException si falla la operación
     */
    boolean actualizarStock(Long id, Integer nuevoStock) throws DAOException;

    /**
     * Elimina físicamente un producto.
     *
     * @param id clave primaria del producto
     * @return true si existía el producto y se eliminó
     * @throws DAOException si falla la operación
     */
    boolean eliminar(Long id) throws DAOException;
}