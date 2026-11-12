package com.francoborzi.modulos.ejercicio2508;

import java.math.BigDecimal;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ProductoDAO dao = new ProductoDAOImpl();

        try {

            Producto producto = new Producto(
                    0,
                    "SKU004",
                    "Teclado mecanico",
                    new BigDecimal("25000.00"),
                    10
            );

            dao.insertar(producto);

            System.out.println("Producto insertado correctamente.");

            List<Producto> productos = dao.listarTodos();

            System.out.println("\nLISTADO DE PRODUCTOS:");

            for (Producto p : productos) {
                System.out.println(
                        p.getId() + " - " +
                                p.getCodigoSku() + " - " +
                                p.getDescripcion() + " - " +
                                p.getPrecioUnitario() + " - " +
                                p.getStockDisponible()
                );
            }

        } catch (DAOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
