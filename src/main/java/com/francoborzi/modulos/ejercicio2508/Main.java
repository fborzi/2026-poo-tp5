package edu.programacion.ejercicio2508;

import java.math.BigDecimal;
import java.util.List;

/**
 * Prueba las operaciones CRUD del módulo de productos.
 */
public class Main2508 {

    /**
     * Ejecuta las pruebas del acceso a datos.
     *
     * @param args argumentos de línea de comandos.
     */
    public static void main(String[] args) {

        edu.programacion.ejercicio2508.ProductoDAO dao = new edu.programacion.ejercicio2508.ProductoDAOImpl();

        try {
            // Crear un producto.
            edu.programacion.ejercicio2508.Producto producto = new edu.programacion.ejercicio2508.Producto(
                    "SKU-001",
                    "Teclado",
                    new BigDecimal("25000.00"),
                    10
            );

            dao.guardar(producto);
            System.out.println("Producto guardado: " + producto);

            // Buscar por ID.
            dao.buscarPorId(producto.getId())
                    .ifPresent(p -> System.out.println("Encontrado por ID: " + p));

            // Buscar por SKU.
            dao.buscarPorSku("SKU-001")
                    .ifPresent(p -> System.out.println("Encontrado por SKU: " + p));

            // Actualizar stock.
            dao.actualizarStock(producto.getId(), 20);
            System.out.println("Stock actualizado.");

            // Listar todos los productos.
            List<edu.programacion.ejercicio2508.Producto> productos = dao.listarTodos();

            System.out.println("\nLista de productos:");
            for (edu.programacion.ejercicio2508.Producto p : productos) {
                System.out.println(p);
            }

            // Eliminar el producto de prueba.
            dao.eliminar(producto.getId());
            System.out.println("Producto eliminado.");

        } catch (edu.programacion.ejercicio2508.DAOException e) {
            System.out.println("Error en el acceso a datos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}