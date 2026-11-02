package com.francoborzi.modulos.ejercicio2505;

import java.util.ArrayList;

public class DataBag {
    private Integer maximo;
    private ArrayList<Elementos>elementos;

    public DataBag(Integer maximo) {
        this.maximo = maximo;
        elementos = new ArrayList<>();
    }

    public void add(Elementos e)throws FullDataBagException{
        if (elementos.size() >= maximo) {
            throw new FullDataBagException("La bolsa está llena");
        }
        elementos.add(e);
    }

    public void remove(Elementos e) throws EmptyDataBagExcepcion {
        if(elementos.size()== 0){
            throw new EmptyDataBagExcepcion("La bolsa esta vacia");
        }
        elementos.remove(e);
    }
    public Integer getMaximo() {
        return maximo;
    }

    public void setMaximo(Integer maximo) {
        this.maximo = maximo;
    }

    public ArrayList<Elementos> getElementos() {
        return elementos;
    }

    public void setElementos(ArrayList<Elementos> elementos) {
        this.elementos = elementos;
    }
}
