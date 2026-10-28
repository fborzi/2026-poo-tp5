package edu.programacion.ejercicio2503;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa una cooperativa de transporte formada por varios choferes.
 * Permite asignar viajes según la capacidad de los colectivos y consultar
 * el vehículo con mayor kilometraje acumulado.
 */
public class Cooperativa {

    private List<edu.programacion.ejercicio2503.Chofer> choferes;

    /**
     * Crea una cooperativa sin choferes registrados.
     */
    public Cooperativa() {
        this.choferes = new ArrayList<>();
    }

    /**
     * Agrega un chofer a la cooperativa.
     *
     * @param chofer chofer que se desea agregar
     */
    public void agregarChofer(edu.programacion.ejercicio2503.Chofer chofer) {
        if (chofer != null) {
            choferes.add(chofer);
        }
    }

    /**
     * Devuelve el chofer cuyo colectivo puede transportar la cantidad
     * de pasajeros solicitada y registra los kilómetros del viaje.
     *
     * @param cantidadPasajeros cantidad de pasajeros solicitada
     * @param cantidadKms kilómetros que se recorrerán
     * @return chofer seleccionado, o null si ninguno puede realizar el viaje
     */
    public edu.programacion.ejercicio2503.Chofer realizarViaje(int cantidadPasajeros, double cantidadKms) {
        if (cantidadPasajeros <= 0 || cantidadKms <= 0) {
            return null;
        }

        for (edu.programacion.ejercicio2503.Chofer chofer : choferes) {
            if (chofer.puedeRealizarViaje(cantidadPasajeros)) {
                chofer.registrarKilometros(cantidadKms);
                return chofer;
            }
        }

        return null;
    }

    /**
     * Devuelve el colectivo con mayor kilometraje acumulado.
     *
     * @return colectivo con mayor kilometraje, o null si no hay choferes
     */
    public edu.programacion.ejercicio2503.Colectivo mostrarColectivoConMayorKilometraje() {
        edu.programacion.ejercicio2503.Colectivo mayorKilometraje = null;

        for (edu.programacion.ejercicio2503.Chofer chofer : choferes) {
            edu.programacion.ejercicio2503.Colectivo colectivo = chofer.getColectivo();

            if (colectivo != null
                    && (mayorKilometraje == null
                    || colectivo.getKilometrajeAcumulado()
                    > mayorKilometraje.getKilometrajeAcumulado())) {
                mayorKilometraje = colectivo;
            }
        }
        return mayorKilometraje;
    }
}