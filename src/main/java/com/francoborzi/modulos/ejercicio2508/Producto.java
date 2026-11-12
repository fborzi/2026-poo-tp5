package com.francoborzi.modulos.ejercicio2508;

/**
 * Representa un producto mediante sus datos principales:
 * identificador, codigo SKU, descripcion, precio unitario
 * y stock disponible.
 * Permite crear productos, consultar y modificar sus datos,
 * y obtener una representacion en texto de su informacion.
 */

import java.math.BigDecimal;

public class Producto {

    private long id;
    private String codigoSku;
    private String descripcion;
    private BigDecimal precioUnitario;
    private int stockDisponible;

    public Producto(long id, String codigoSku, String descripcion,
                    BigDecimal precioUnitario, int stockDisponible) {
        this.id = id;
        this.codigoSku = codigoSku;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.stockDisponible = stockDisponible;
    }

    public Producto(String codigoSku, String descripcion,
                    BigDecimal precioUnitario, int stockDisponible) {
        this.codigoSku = codigoSku;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.stockDisponible = stockDisponible;
    }

    public long getId() {
        return id;
    }

    public String getCodigoSku() {
        return codigoSku;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public int getStockDisponible() {
        return stockDisponible;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCodigoSku(String codigoSku) {
        this.codigoSku = codigoSku;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public void setStockDisponible(int stockDisponible) {
        this.stockDisponible = stockDisponible;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", codigoSku='" + codigoSku + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precioUnitario=" + precioUnitario +
                ", stockDisponible=" + stockDisponible +
                '}';
    }
}

