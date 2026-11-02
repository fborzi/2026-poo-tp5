package com.francoborzi.modulos.ejercicio2509.model;

import java.math.BigDecimal;

public class ArticuloStock {

    private Long id;
    private String codigoSku;
    private String descripcion;
    private BigDecimal precio;
    private Integer stock;

    public ArticuloStock() {
    }

    public ArticuloStock(String codigoSku, String descripcion,
                         BigDecimal precio, Integer stock) {
        this.codigoSku = codigoSku;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
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

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}