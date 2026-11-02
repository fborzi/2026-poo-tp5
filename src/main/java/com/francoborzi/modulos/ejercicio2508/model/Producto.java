package com.francoborzi.modulos.ejercicio2508.model;

import java.math.BigDecimal;

public class Producto {

    private Long id;
    private String codigoSku;
    private String descripcion;
    private BigDecimal precioUnitario;
    private Integer stockDisponible;

    public Producto() {
    }

    public Producto(String codigoSku, String descripcion,
                    BigDecimal precioUnitario, Integer stockDisponible) {
        this.codigoSku = codigoSku;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.stockDisponible = stockDisponible;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoSku() {
        return codigoSku;
    }

    public void setCodigoSku(String codigoSku) {
        this.codigoSku = codigoSku;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Integer getStockDisponible() {
        return stockDisponible;
    }

    public void setStockDisponible(Integer stockDisponible) {
        this.stockDisponible = stockDisponible;
    }
}