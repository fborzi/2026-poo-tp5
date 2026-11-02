
package com.francoborzi.modulos.ejercicio2508;

import com.francoborzi.modulos.ejercicio2508.dao.ProductoDAO;
import com.francoborzi.modulos.ejercicio2508.dao.ProductoDAOImpl;
import com.francoborzi.modulos.ejercicio2508.exception.DAOException;
import com.francoborzi.modulos.ejercicio2508.model.Producto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        ProductoDAO dao = new ProductoDAOImpl();

        try {

            // PASO 1: Crear un producto
            System.out.println("=== CREAR PRODUCTO ===");

            String sku = "SKU-" + System.currentTimeMillis();

            Producto producto = new Producto(
                    sku,
                    "Mouse Inalambrico",
                    new BigDecimal("45000.00"),
                    10
            );

            // PASO 2: Guardar el producto
            dao.guardar(producto);

            System.out.println("Producto guardado correctamente.");
            System.out.println("ID generado: " + producto.getId());


            // PASO 3: Buscar producto por ID
            System.out.println("\n=== BUSCAR POR ID ===");

            Optional<Producto> encontrado = dao.buscarPorId(producto.getId());

            if (encontrado.isPresent()) {
                mostrarProducto(encontrado.get());
            } else {
                System.out.println("No se encontró el producto.");
            }


            // PASO 4: Buscar producto por SKU
            System.out.println("\n=== BUSCAR POR SKU ===");

            Optional<Producto> porSku = dao.buscarPorSku(sku);

            if (porSku.isPresent()) {
                mostrarProducto(porSku.get());
            } else {
                System.out.println("No existe un producto con ese SKU.");
            }


            // PASO 5: Buscar un producto inexistente
            System.out.println("\n=== BUSCAR PRODUCTO INEXISTENTE ===");

            Optional<Producto> inexistente = dao.buscarPorId(-1L);

            if (inexistente.isEmpty()) {
                System.out.println("El producto no existe.");
            }


            // PASO 6: Actualizar el stock
            System.out.println("\n=== ACTUALIZAR STOCK ===");

            boolean actualizado = dao.actualizarStock(
                    producto.getId(), 25
            );

            if (actualizado) {
                System.out.println("Stock actualizado correctamente.");
            } else {
                System.out.println("No se pudo actualizar el stock.");
            }


            // PASO 7: Consultar nuevamente el producto
            System.out.println("\n=== VERIFICAR STOCK ===");

            Optional<Producto> actualizadoProducto =
                    dao.buscarPorId(producto.getId());

            actualizadoProducto.ifPresent(Main::mostrarProducto);


            // PASO 8: Listar todos los productos
            System.out.println("\n=== LISTADO DE PRODUCTOS ===");

            List<Producto> productos = dao.listarTodos();

            if (productos.isEmpty()) {
                System.out.println("No hay productos registrados.");
            } else {
                for (Producto p : productos) {
                    mostrarProducto(p);
                }
            }


            // PASO 9: Intentar guardar un SKU duplicado
            System.out.println("\n=== PROBAR SKU DUPLICADO ===");

            try {

                Producto duplicado = new Producto(
                        sku,
                        "Mouse gamer",
                        new BigDecimal("15000.00"),
                        5
                );

                dao.guardar(duplicado);

            } catch (DAOException e) {
                System.out.println("No se pudo guardar el producto.");
                System.out.println("Motivo: " + e.getMessage());
            }


            // PASO 10: Eliminar producto
            System.out.println("\n=== ELIMINAR PRODUCTO ===");

            boolean eliminado = dao.eliminar(producto.getId());

            if (eliminado) {
                System.out.println("Producto eliminado correctamente.");
            } else {
                System.out.println("No se encontró el producto para eliminar.");
            }


            // PASO 11: Verificar que fue eliminado
            System.out.println("\n=== VERIFICAR ELIMINACION ===");

            Optional<Producto> eliminadoBuscado =
                    dao.buscarPorId(producto.getId());

            if (eliminadoBuscado.isEmpty()) {
                System.out.println("El producto ya no existe en la base de datos.");
            }

            System.out.println("\n=== FIN DE LAS PRUEBAS ===");


        } catch (DAOException e) {

            System.out.println("Error al acceder a la base de datos.");
            System.out.println("Detalle: " + e.getMessage());

            e.printStackTrace();
        }
    }


    // Método auxiliar para mostrar productos
    public static void mostrarProducto(Producto producto) {

        System.out.println("-------------------------");
        System.out.println("ID: " + producto.getId());
        System.out.println("SKU: " + producto.getCodigoSku());
        System.out.println("Descripción: " + producto.getDescripcion());
        System.out.println("Precio: " + producto.getPrecioUnitario());
        System.out.println("Stock: " + producto.getStockDisponible());
        System.out.println("-------------------------");
    }
}
