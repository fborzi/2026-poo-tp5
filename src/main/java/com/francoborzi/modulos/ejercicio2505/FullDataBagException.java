package com.francoborzi.modulos.ejercicio2505;

/**
 * Se lanza cuando se intenta agregar un elemento a una bolsa llena.
 */
public class FullDataBagException extends Exception {

    private Integer maximo;

    /**
     * Crea la excepción.
     *
     * @param maximo cantidad máxima de elementos de la bolsa
     */
    public FullDataBagException(Integer maximo) {
        this.maximo = maximo;
    }

    @Override
    public String getMessage() {
        return "La bolsa está llena. Máximo de elementos: " + maximo;
    }
}