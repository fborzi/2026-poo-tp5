
package com.francoborzi.modulos.ejercicio2508.model;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Representa un producto del catalogo.
 */
public class Producto {

    private Long id;
    private String codigoSku;
    private String descripcion;
    private BigDecimal precioUnitario;
    private Integer stockDisponible;

    /**
     * Construye un producto sin identificador.
     *
     * @param codigoSku codigo unico del producto
     * @param descripcion descripcion del producto
     * @param precioUnitario precio del producto
     * @param stockDisponible stock disponible
     */
    public Producto(String codigoSku, String descripcion,
                    BigDecimal precioUnitario, Integer stockDisponible) {
        this(null, codigoSku, descripcion, precioUnitario,
                stockDisponible);
    }

    /**
     * Construye un producto con identificador.
     *
     * @param id identificador
     * @param codigoSku codigo unico
     * @param descripcion descripcion
     * @param precioUnitario precio
     * @param stockDisponible stock
     */
    public Producto(Long id, String codigoSku, String descripcion,
                    BigDecimal precioUnitario, Integer stockDisponible) {
        this.id = id;
        this.codigoSku = Objects.requireNonNull(codigoSku);
        this.descripcion = Objects.requireNonNull(descripcion);
        this.precioUnitario = Objects.requireNonNull(precioUnitario);
        this.stockDisponible = Objects.requireNonNull(stockDisponible);

        if (codigoSku.isBlank() || descripcion.isBlank()
                || precioUnitario.signum() < 0
                || stockDisponible < 0) {
            throw new IllegalArgumentException(
                    "Los datos del producto son invalidos");
        }
    }

    /**
     * Obtiene el identificador.
     *
     * @return identificador
     */
    public Long getId() {
        return id;
    }

    /**
     * Asigna el identificador generado.
     *
     * @param id identificador
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el codigo SKU.
     *
     * @return codigo
     */
    public String getCodigoSku() {
        return codigoSku;
    }

    /**
     * Obtiene la descripcion.
     *
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Obtiene el precio.
     *
     * @return precio
     */
    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * Obtiene el stock.
     *
     * @return stock disponible
     */
    public Integer getStockDisponible() {
        return stockDisponible;
    }

    /**
     * Actualiza el stock del producto.
     *
     * @param nuevoStock nuevo stock
     */
    public void setStockDisponible(Integer nuevoStock) {
        if (nuevoStock == null || nuevoStock < 0) {
            throw new IllegalArgumentException("Stock invalido");
        }

        this.stockDisponible = nuevoStock;
    }

    /**
     * Devuelve una descripcion del producto.
     *
     * @return datos del producto
     */
    @Override
    public String toString() {
        return "Producto{id=" + id
                + ", sku='" + codigoSku
                + "', descripcion='" + descripcion
                + "', precio=" + precioUnitario
                + ", stock=" + stockDisponible + "}";
    }
}
