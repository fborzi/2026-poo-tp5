
package com.francoborzi.modulos.ejercicio2508;

import com.francoborzi.modulos.ejercicio2508.config.DatabaseConfig;
import com.francoborzi.modulos.ejercicio2508.dao.ProductoDAO;
import com.francoborzi.modulos.ejercicio2508.dao.ProductoDAOImpl;
import com.francoborzi.modulos.ejercicio2508.exception.DAOException;
import com.francoborzi.modulos.ejercicio2508.model.Producto;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * Ejecuta las operaciones JDBC sobre productos.
 */
public final class Main2508 {

    private Main2508() {
    }

    /**
     * Punto de entrada del ejercicio.
     *
     * @param args argumentos de ejecucion
     */
    public static void main(String[] args) {
        try {
            DatabaseConfig.inicializar();

            ProductoDAO productoDAO = new ProductoDAOImpl();

            String codigoSku = "PROD-"
                    + UUID.randomUUID().toString().substring(0, 8);

            Producto producto = new Producto(
                    codigoSku,
                    "Teclado mecanico",
                    new BigDecimal("45000.00"),
                    10);

            System.out.println("=== GUARDAR ===");
            productoDAO.guardar(producto);
            System.out.println("ID generado: " + producto.getId());

            System.out.println();
            System.out.println("=== BUSCAR POR ID ===");
            System.out.println(
                    productoDAO.buscarPorId(producto.getId()));

            System.out.println();
            System.out.println("=== BUSCAR POR SKU ===");
            System.out.println(
                    productoDAO.buscarPorSku(codigoSku));

            System.out.println();
            System.out.println("=== ACTUALIZAR STOCK ===");
            productoDAO.actualizarStock(producto.getId(), 25);
            System.out.println(
                    productoDAO.buscarPorId(producto.getId()));

            System.out.println();
            System.out.println("=== LISTAR TODOS ===");
            for (Producto registrado : productoDAO.listarTodos()) {
                System.out.println(registrado);
            }

            System.out.println();
            System.out.println("=== ELIMINAR ===");
            productoDAO.eliminar(producto.getId());

            System.out.println("Producto eliminado: "
                    + productoDAO.buscarPorId(producto.getId())
                    .isEmpty());

        } catch (DAOException excepcion) {
            System.err.println("Error de persistencia: "
                    + excepcion.getMessage());

            if (excepcion.getCause() != null) {
                System.err.println("Causa: "
                        + excepcion.getCause().getMessage());
            }
        }
    }
}
