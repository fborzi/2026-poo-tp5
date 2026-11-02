package com.francoborzi.modulos.ejercicio2508.dao;

import com.francoborzi.modulos.ejercicio2508.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoDAO {

    void guardar(Producto producto);

    Optional<Producto> buscarPorId(Long id);

    Optional<Producto> buscarPorSku(String sku);

    List<Producto> listarTodos();

    boolean actualizarStock(Long id, Integer nuevoStock);

    boolean eliminar(Long id);
}