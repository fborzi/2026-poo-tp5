package com.francoborzi.modulos.ejercicio2508;

package dao;

import exception.DAOException;
import model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoDAO {

    void guardar(Producto producto) throws DAOException;

    Optional<Producto> buscarPorId(Long id) throws DAOException;

    Optional<Producto> buscarPorSku(String sku) throws DAOException;

    List<Producto> listarTodos() throws DAOException;

    void actualizarStock(Long id, Integer nuevoStock)
            throws DAOException;

    void eliminar(Long id) throws DAOException;
}
