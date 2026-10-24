package com.francoborzi.modulos.ejercicio2508.model;

import java.math.BigDecimal;

/**
 * Entidad de dominio que representa una fila de la tabla productos.
 */
public class Producto {

    private Long id;
    private String codigoSku;
    private String descripcion;
    private BigDecimal precioUnitario;
    private Integer stockDisponible;

    /**
     * Crea un producto nuevo, todavía sin id (lo asigna la base al guardarlo).
     *
     * @param codigoSku código único de negocio
     * @param descripcion descripción del producto
     * @param precioUnitario precio por unidad
     * @param stockDisponible unidades en stock
     */
    public Producto(String codigoSku, String descripcion,
                    BigDecimal precioUnitario, Integer stockDisponible) {
        this.codigoSku = codigoSku;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.stockDisponible = stockDisponible;
    }

    /**
     * Crea un producto con id, usado al leerlo de la base.
     *
     * @param id clave primaria
     * @param codigoSku código único de negocio
     * @param descripcion descripción del producto
     * @param precioUnitario precio por unidad
     * @param stockDisponible unidades en stock
     */
    public Producto(Long id, String codigoSku, String descripcion,
                    BigDecimal precioUnitario, Integer stockDisponible) {
        this.id = id;
        this.codigoSku = codigoSku;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.stockDisponible = stockDisponible;
    }

    /**
     * @return la clave primaria, o null si todavía no se guardó
     */
    public Long getId() {
        return id;
    }

    /**
     * Asigna la clave primaria generada por la base al guardar.
     *
     * @param id clave primaria generada
     */
    public void setId(Long id) {
        this.id = id;
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
    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * @return el stock disponible
     */
    public Integer getStockDisponible() {
        return stockDisponible;
    }

    @Override
    public String toString() {
        return "Producto [id=" + id + ", sku=" + codigoSku
                + ", descripcion=" + descripcion
                + ", precio=$" + precioUnitario
                + ", stock=" + stockDisponible + "]";
    }
}