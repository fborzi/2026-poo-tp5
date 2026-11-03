package com.francoborzi.modulos.ejercicio2503;

import java.util.ArrayList;

public class Cooperativa {

    private String nombre;
    private ArrayList<Chofer> choferes;

    public Cooperativa(String nombre) {
        this.nombre = nombre;
        this.choferes = new ArrayList<>();
    }

    // Agregar un chofer a la cooperativa
    public void agregarChofer(Chofer chofer) {
        choferes.add(chofer);
    }

    /*
     * Busca un chofer que pueda realizar el viaje
     * y registra los kilómetros recorridos.
     */
    public Chofer realizarViaje(Integer cantidadPasajeros,
                                Double cantidadKms) {

        if (cantidadPasajeros == null || cantidadPasajeros <= 0
                || cantidadKms == null || cantidadKms <= 0) {
            throw new IllegalArgumentException(
                    "La cantidad de pasajeros y kilómetros debe ser positiva."
            );
        }

        Chofer choferSeleccionado = null;

        for (Chofer chofer : choferes) {

            Colectivo colectivo = chofer.getColectivo();

            if (colectivo.getCapacidadPasajeros() >= cantidadPasajeros) {

                if (choferSeleccionado == null
                        || colectivo.getCapacidadPasajeros()
                        < choferSeleccionado.getColectivo()
                        .getCapacidadPasajeros()) {

                    choferSeleccionado = chofer;
                }
            }
        }

        if (choferSeleccionado != null) {

            choferSeleccionado.getColectivo()
                    .registrarKilometros(cantidadKms);
        }

        return choferSeleccionado;
    }

    /*
     * Devuelve el colectivo con mayor
     * kilometraje acumulado.
     */
    public Colectivo mostrarColectivoConMayorKilometraje() {

        if (choferes.isEmpty()) {
            return null;
        }

        Colectivo mayorKilometraje = choferes.get(0).getColectivo();

        for (Chofer chofer : choferes) {

            Colectivo colectivo = chofer.getColectivo();

            if (colectivo.getKilometrajeAcumulado()
                    > mayorKilometraje.getKilometrajeAcumulado()) {

                mayorKilometraje = colectivo;
            }
        }

        return mayorKilometraje;
    }
}