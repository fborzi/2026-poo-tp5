package com.francoborzi.modulos.ejercicio2505;

public class Main {
    static void main() {
        DataBag bolsa = new DataBag(2);

        Elementos elem1 = new Elementos("Martillo");
        Elementos elem2 = new Elementos("Llave");
        Elementos elem3 = new Elementos("Pinza");

        try {
            bolsa.add(elem1);
            bolsa.add(elem2);
            bolsa.add(elem3);

        } catch (FullDataBagException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try{
            bolsa.remove(elem1);
            bolsa.remove(elem2);
            bolsa.remove(elem3);
        }catch (EmptyDataBagExcepcion e){
            System.out.println("Error" + e.getMessage());
        }
    }
}
