package com.francoborzi.modulos.ejercicio2503;

import java.util.ArrayList;
import java.util.List;

public class SistemaDeTransporte {
    private List<Chofer> choferes;


    public SistemaDeTransporte() {
        this.choferes= new ArrayList<>();
    }
    public Chofer realizarViaje(Integer cantidadPersonas, Double cantidadKms) {
        for (Chofer chofer : choferes) {
            Colectivo colectivo = chofer.getUnidadAsignada();

            if (colectivo.getCantidadDePersonas() >= cantidadPersonas) {
                Double kilometrajeActual = colectivo.getKilometraje();
                colectivo.setKilometraje(kilometrajeActual + cantidadKms);
                return chofer;
            }
        }
        System.out.println("No se encontró ningún colectivo con capacidad para " + cantidadPersonas + " pasajeros.");
        return null;
    }



    public List<Chofer> getChoferes() {
        return choferes;
    }

    public void setChoferes(Chofer chofer) {
        this.choferes.add(chofer);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SistemaDeTransporte{");
        sb.append("choferes=").append(choferes);
        sb.append('}');
        return sb.toString();
    }
}
