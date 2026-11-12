package com.francoborzi.modulos.ejercicio2503;

/**
 * Representa una cooperativa que administra una lista de choferes
 * y sus respectivos colectivos.
 * Permite agregar choferes, asignar viajes segun la cantidad
 * de pasajeros solicitada y registrar los kilometros recorridos.
 * Tambien permite identificar el colectivo que tiene
 * el mayor kilometraje acumulado.
 */

import java.util.ArrayList;
import java.util.List;

public class Cooperativa {
    private List<Chofer> choferes;

    public Cooperativa() {
        choferes = new ArrayList<>();
    }

    public Chofer realizarViaje(Integer cantidadPasajeros, Double cantidadKms) {
        for (Chofer chofer : choferes) {
            if (chofer.getColectivo().getCantidadPasajeros() >= cantidadPasajeros) {
                chofer.getColectivo().registrarKilometros(cantidadKms);
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
            if (chofer.getColectivo().getKilometrajeAcumulado()
                    > mayor.getKilometrajeAcumulado()) {
                mayor = chofer.getColectivo();
            }
        }

        return mayor;
    }

    public void agregarChofer(Chofer chofer) {
        choferes.add(chofer);
    }
}
