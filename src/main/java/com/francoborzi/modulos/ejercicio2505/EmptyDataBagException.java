package com.francoborzi.modulos.ejercicio2505;

/**
 * Se lanza cuando se intenta remover un elemento de una bolsa vacía.
 */
public class EmptyDataBagException extends Exception {

    @Override
    public String getMessage() {
        return "La bolsa está vacía. No hay elementos para remover.";
    }
}