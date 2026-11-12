package com.francoborzi.modulos.ejercicio2508;

/**
 * Define una interfaz para las operaciones de acceso
 * a los datos de los productos.
 * Establece los metodos necesarios para insertar,
 * listar, buscar, actualizar y eliminar productos.
 * Permite informar errores mediante DAOException.
 */

import java.util.List;

public interface ProductoDAO {

    void insertar(Producto producto) throws DAOException;

    List<Producto> listarTodos() throws DAOException;

    Producto buscarPorId(long id) throws DAOException;

    void actualizar(Producto producto) throws DAOException;

    void eliminar(long id) throws DAOException;
}


