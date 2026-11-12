package com.francoborzi.modulos.ejercicio2509;

/**
 * Representa un articulo del inventario mediante su SKU,
 * descripcion, precio y cantidad de unidades disponibles.
 * Recibe estos datos mediante el constructor y permite
 * consultar la informacion del articulo.
 */

import java.math.BigDecimal;

public class ArticuloStock {

    private String sku;
    private String descripcion;
    private BigDecimal precio;
    private int stock;

    public ArticuloStock(String sku, String descripcion,
                         BigDecimal precio, int stock) {
        this.sku = sku;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    public String getSku() {
        return sku;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }
}


