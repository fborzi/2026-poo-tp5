
package edu.programacion.ejercicio2508;

import java.math.BigDecimal;

/**
 * Representa un producto almacenado en la base de datos.
 */
public class Producto {

    private Long id;
    private String codigoSku;
    private String descripcion;
    private BigDecimal precioUnitario;
    private Integer stockDisponible;

    /**
     * Crea un producto sin identificador.
     *
     * @param codigoSku código SKU único del producto.
     * @param descripcion descripción del producto.
     * @param precioUnitario precio unitario.
     * @param stockDisponible cantidad disponible en stock.
     */
    public Producto(
            String codigoSku,
            String descripcion,
            BigDecimal precioUnitario,
            Integer stockDisponible) {

        this.codigoSku = codigoSku;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.stockDisponible = stockDisponible;
    }

    /**
     * Crea un producto con identificador.
     *
     * @param id identificador del producto.
     * @param codigoSku código SKU del producto.
     * @param descripcion descripción del producto.
     * @param precioUnitario precio unitario.
     * @param stockDisponible cantidad disponible en stock.
     */
    public Producto(
            Long id,
            String codigoSku,
            String descripcion,
            BigDecimal precioUnitario,
            Integer stockDisponible) {

        this.id = id;
        this.codigoSku = codigoSku;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.stockDisponible = stockDisponible;
    }

    /**
     * Obtiene el identificador del producto.
     *
     * @return identificador o null si todavía no fue asignado.
     */
    public Long getId() {
        return id;
    }

    /**
     * Asigna el identificador del producto.
     *
     * @param id identificador generado por la base de datos.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el código SKU.
     *
     * @return código SKU.
     */
    public String getCodigoSku() {
        return codigoSku;
    }

    /**
     * Obtiene la descripción.
     *
     * @return descripción del producto.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Obtiene el precio unitario.
     *
     * @return precio unitario.
     */
    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * Obtiene el stock disponible.
     *
     * @return cantidad disponible.
     */
    public Integer getStockDisponible() {
        return stockDisponible;
    }

    /**
     * Actualiza el stock disponible.
     *
     * @param stockDisponible nueva cantidad disponible.
     */
    public void setStockDisponible(Integer stockDisponible) {
        this.stockDisponible = stockDisponible;
    }

    /**
     * Devuelve los datos principales del producto.
     *
     * @return representación textual del producto.
     */
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
