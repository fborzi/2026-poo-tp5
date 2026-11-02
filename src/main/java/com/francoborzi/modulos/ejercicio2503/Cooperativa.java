package com.francoborzi.modulos.ejercicio2503;

import java.util.ArrayList;
import java.util.List;

public class Cooperativa {

    private List<Chofer> choferes;

    public Cooperativa() {
        choferes = new ArrayList<>();
    }

    public void agregarChofer(Chofer chofer) {
        choferes.add(chofer);
    }

    public Chofer realizarViaje(Integer cantidadPasajeros, Double cantidadKms) {

        for (Chofer chofer : choferes) {

            Colectivo colectivo = chofer.getColectivo();

            if (colectivo.getCapacidadPasajeros()
                    >= cantidadPasajeros) {

                colectivo.registrarKilometros(cantidadKms);

                return chofer;
            }
        }

        return null;
    }

    public Colectivo mostrarColectivoConMayorKilometraje() {

        if (choferes.isEmpty()) {
            return null;
        }

        Colectivo mayor = choferes.get(0).getColectivo();

        for (Chofer chofer : choferes) {

            Colectivo colectivo = chofer.getColectivo();

            if (colectivo.getKilometraje()
                    > mayor.getKilometraje()) {

                mayor = colectivo;
            }
        }

        return mayor;
    }
}
