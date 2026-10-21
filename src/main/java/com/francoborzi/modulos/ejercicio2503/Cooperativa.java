package com.francoborzi.modulos.ejercicio2503;

import java.util.ArrayList;
import java.util.List;

/**
 * Cooperativa de transporte formada por socios choferes.
 */
public class Cooperativa {

    private String nombre;
    private List<Chofer> choferes;

    /**
     * Crea una cooperativa sin choferes.
     *
     * @param nombre nombre de la cooperativa
     */
    public Cooperativa(String nombre) {
        this.nombre = nombre;
        this.choferes = new ArrayList<>();
    }

    /**
     * @return el nombre de la cooperativa
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Suma un socio chofer a la cooperativa.
     *
     * @param chofer chofer a agregar
     */
    public void agregarChofer(Chofer chofer) {
        choferes.add(chofer);
    }

    /**
     * Devuelve el chofer que puede realizar el viaje para la cantidad de
     * pasajeros solicitada y registra el kilometraje del viaje.
     *
     * @param cantidadPasajeros pasajeros del viaje
     * @param cantidadKms kilómetros del viaje
     * @return el chofer asignado, o null si ningún colectivo tiene capacidad
     */
    public Chofer realizarViaje(Integer cantidadPasajeros, Double cantidadKms) {
        Chofer elegido = null;
        for (Chofer chofer : choferes) {
            if (elegido == null
                    && chofer.getColectivo().puedeLlevar(cantidadPasajeros)) {
                elegido = chofer;
            }
        }
        if (elegido != null) {
            elegido.getColectivo().registrarKilometros(cantidadKms);
        }
        return elegido;
    }

    /**
     * Devuelve el colectivo con mayor kilometraje acumulado.
     *
     * @return el colectivo con más kilómetros, o null si no hay choferes
     */
    public Colectivo mostrarColectivoConMayorKilometraje() {
        Colectivo mayor = null;
        for (Chofer chofer : choferes) {
            Colectivo actual = chofer.getColectivo();
            if (mayor == null || actual.getKilometrajeAcumulado()
                    > mayor.getKilometrajeAcumulado()) {
                mayor = actual;
            }
        }
        return mayor;
    }
}