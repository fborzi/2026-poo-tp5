package com.francoborzi.modulos.ejercicio2501;

public class Cancion implements Reproducible {
    public String Titulo;
    public Double Duracion;
    public Integer TamanioEnMB;

    public Cancion(Double duracion, Integer tamanioEnMB, String titulo) {
        Duracion = duracion;
        TamanioEnMB = tamanioEnMB;
        Titulo = titulo;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public Double getDuracion() {
        return Duracion;
    }

    public void setDuracion(Double duracion) {
        Duracion = duracion;
    }

    public Integer getTamanioEnMB() {
        return TamanioEnMB;
    }

    public void setTamanioEnMB(Integer tamanioEnMB) {
        TamanioEnMB = tamanioEnMB;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cancion{");
        sb.append("Titulo='").append(Titulo).append('\'');
        sb.append(", Duracion=").append(Duracion);
        sb.append(", TamanioEnMB=").append(TamanioEnMB);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void play(){
        System.out.println("Se reproduce una cancion");
    }

    @Override
    public void bucle() {
        System.out.println("Se reproduce en bucle una cancion");
    }

    @Override
    public void stop() {
        System.out.println("Se detiene la cancion en reproduccion");
    }


}
