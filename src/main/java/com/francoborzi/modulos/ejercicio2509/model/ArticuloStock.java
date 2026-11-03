package com.francoborzi.modulos.ejercicio2509.model;

import java.math.BigDecimal;

/**
 * Registro de artículo que viaja en los lotes de importación y exportación.
 */
public class ArticuloStock {

    private String codigoSku;
    private String descripcion;
    private BigDecimal precio;
    private Integer stock;

    /**
     * Crea un artículo.
     *
     * @param codigoSku código único de negocio
     * @param descripcion descripción del artículo
     * @param precio precio unitario
     * @param stock unidades disponibles
     */
    public ArticuloStock(String codigoSku, String descripcion,
                         BigDecimal precio, Integer stock) {
        this.codigoSku = codigoSku;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    /**
     * @return el código SKU
     */
    public String getCodigoSku() {
        return codigoSku;
    }

    /**
     * @return la descripción
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @return el precio unitario
     */
    public BigDecimal getPrecio() {
        return precio;
    }

    /**
     * @return el stock disponible
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * Convierte el artículo en una línea CSV: SKU,DESCRIPCION,PRECIO,STOCK.
     *
     * @return la línea CSV del artículo
     */
    public String aLineaCsv() {
        return codigoSku + "," + descripcion + "," + precio.toPlainString() + "," + stock;
    }

    @Override
    public String toString() {
        return "ArticuloStock [sku=" + codigoSku + ", descripcion=" + descripcion
                + ", precio=$" + precio + ", stock=" + stock + "]";
    }
}