package com.francoborzi.modulos.ejercicio2505;


public class EmptyDataBagException extends Exception {

  public EmptyDataBagException() {
    super("La bolsa está vacía. No hay elementos para quitar.");
  }
}
