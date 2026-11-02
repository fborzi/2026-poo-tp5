package edu.programacion.ejercicio2509;

import java.math.BigDecimal;

/**
 * Representa un artículo del inventario para el procesamiento por lotes.
 */
public class ArticuloStock {

    private String sku;
    private String descripcion;
    private BigDecimal precio;
    private int stock;

    /**
     * Construye un artículo del inventario.
     *
     * @param sku código único del artículo.
     * @param descripcion descripción del artículo.
     * @param precio precio unitario.
     * @param stock cantidad disponible.
     */
    public ArticuloStock(
            String sku,
            String descripcion,
            BigDecimal precio,
            int stock) {

        this.sku = sku;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    /**
     * Obtiene el código SKU.
     *
     * @return código del artículo.
     */
    public String getSku() {
        return sku;
    }

    /**
     * Obtiene la descripción.
     *
     * @return descripción del artículo.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Obtiene el precio unitario.
     *
     * @return precio del artículo.
     */
    public BigDecimal getPrecio() {
        return precio;
    }

    /**
     * Obtiene el stock disponible.
     *
     * @return cantidad disponible.
     */
    public int getStock() {
        return stock;
    }

    /**
     * Devuelve los datos del artículo.
     *
     * @return representación textual del artículo.
     */
    @Override
    public String toString() {
        return "ArticuloStock{" +
                "sku='" + sku + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }
}