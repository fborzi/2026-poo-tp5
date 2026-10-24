package com.francoborzi.modulos.ejercicio2508;

import com.francoborzi.modulos.ejercicio2508.config.InicializadorBaseDatos;
import com.francoborzi.modulos.ejercicio2508.config.ProveedorConexion;
import com.francoborzi.modulos.ejercicio2508.config.ProveedorConexionDriverManager;
import com.francoborzi.modulos.ejercicio2508.dao.ProductoDAO;
import com.francoborzi.modulos.ejercicio2508.dao.ProductoDAOImpl;
import com.francoborzi.modulos.ejercicio2508.exception.DAOException;
import com.francoborzi.modulos.ejercicio2508.model.Producto;

import java.math.BigDecimal;
import java.util.Optional;

public class Main {
    static void main() {
        ProveedorConexion proveedor = new ProveedorConexionDriverManager(
                "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1", "sa", "");
        InicializadorBaseDatos inicializador = new InicializadorBaseDatos(proveedor);
        ProductoDAO dao = new ProductoDAOImpl(proveedor);

        try {
            inicializador.crearTablaProductos();

            System.out.println("--- guardar ---");
            Producto mouse = new Producto("SKU-001", "Mouse inalámbrico",
                    new BigDecimal("15999.90"), 25);
            Producto teclado = new Producto("SKU-002", "Teclado mecánico",
                    new BigDecimal("48500.00"), 10);
            Producto monitor = new Producto("SKU-003", "Monitor 24 pulgadas",
                    new BigDecimal("289999.99"), 5);
            dao.guardar(mouse);
            dao.guardar(teclado);
            dao.guardar(monitor);
            System.out.println("Guardado: " + mouse);
            System.out.println("Guardado: " + teclado);
            System.out.println("Guardado: " + monitor);

            System.out.println("--- listarTodos ---");
            for (Producto producto : dao.listarTodos()) {
                System.out.println(producto);
            }

            System.out.println("--- buscarPorId(2) ---");
            Optional<Producto> porId = dao.buscarPorId(2L);
            if (porId.isPresent()) {
                System.out.println(porId.get());
            } else {
                System.out.println("No existe un producto con id 2");
            }

            System.out.println("--- buscarPorId(99) ---");
            Optional<Producto> inexistente = dao.buscarPorId(99L);
            if (inexistente.isPresent()) {
                System.out.println(inexistente.get());
            } else {
                System.out.println("No existe un producto con id 99");
            }

            System.out.println("--- buscarPorSku(SKU-003) ---");
            Optional<Producto> porSku = dao.buscarPorSku("SKU-003");
            if (porSku.isPresent()) {
                System.out.println(porSku.get());
            } else {
                System.out.println("No existe un producto con SKU-003");
            }

            System.out.println("--- actualizarStock(1, 40) ---");
            System.out.println("Actualizado: " + dao.actualizarStock(1L, 40));
            Optional<Producto> actualizado = dao.buscarPorId(1L);
            if (actualizado.isPresent()) {
                System.out.println(actualizado.get());
            } else {
                System.out.println("No existe un producto con id 1");
            }

            System.out.println("--- eliminar(3) ---");
            System.out.println("Eliminado: " + dao.eliminar(3L));
            System.out.println("Eliminado otra vez: " + dao.eliminar(3L));
            for (Producto producto : dao.listarTodos()) {
                System.out.println(producto);
            }

            System.out.println("--- guardar SKU duplicado ---");
            dao.guardar(new Producto("SKU-001", "Mouse repetido",
                    new BigDecimal("1000.00"), 1));
        } catch (DAOException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Causa: " + e.getCause().getMessage());
        }
    }
}