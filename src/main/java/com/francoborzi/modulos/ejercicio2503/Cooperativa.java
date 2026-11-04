
package com.francoborzi.modulos.ejercicio2503;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Administra choferes, colectivos y viajes.
 */
public class Cooperativa {

    private final String nombre;
    private final List<Chofer> choferes;

    /**
     * Construye una cooperativa.
     *
     * @param nombre nombre de la cooperativa
     */
    public Cooperativa(String nombre) {
        this.nombre = Objects.requireNonNull(nombre);
        this.choferes = new ArrayList<>();
    }

    /**
     * Registra un chofer en la cooperativa.
     *
     * @param chofer chofer a registrar
     */
    public void agregarChofer(Chofer chofer) {
        Objects.requireNonNull(chofer);

        for (Chofer existente : choferes) {
            if (existente.getDni().equals(chofer.getDni())) {
                throw new IllegalArgumentException(
                        "El chofer ya esta registrado");
            }

            if (existente.getColectivo().getPatente()
                    .equals(chofer.getColectivo().getPatente())) {
                throw new IllegalArgumentException(
                        "El colectivo ya tiene un chofer");
            }
        }

        choferes.add(chofer);
    }

    /**
     * Asigna un viaje y registra los kilometros recorridos.
     *
     * @param cantidadPasajeros cantidad de pasajeros
     * @param cantidadKms kilometros del viaje
     * @return chofer asignado o null si no existe uno disponible
     */
    public Chofer realizarViaje(Integer cantidadPasajeros,
                                Double cantidadKms) {
        if (cantidadPasajeros == null
                || cantidadPasajeros <= 0
                || cantidadKms == null
                || !Double.isFinite(cantidadKms)
                || cantidadKms <= 0) {
            throw new IllegalArgumentException(
                    "Los datos del viaje son invalidos");
        }

        for (Chofer chofer : choferes) {
            Colectivo colectivo = chofer.getColectivo();

            if (colectivo.puedeTransportar(cantidadPasajeros)) {
                colectivo.registrarViaje(cantidadKms);
                return chofer;
            }
        }

        return null;
    }

    /**
     * Busca el colectivo con mayor kilometraje acumulado.
     *
     * @return colectivo con mayor kilometraje o null si no hay
     */
    public Colectivo mostrarColectivoConMayorKilometraje() {
        Colectivo mayor = null;

        for (Chofer chofer : choferes) {
            Colectivo actual = chofer.getColectivo();

            if (mayor == null
                    || actual.getKilometrajeAcumulado()
                    > mayor.getKilometrajeAcumulado()) {
                mayor = actual;
            }
        }

        return mayor;
    }

    /**
     * Obtiene el nombre de la cooperativa.
     *
     * @return nombre de la cooperativa
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene una copia de la lista de choferes.
     *
     * @return lista de choferes
     */
    public List<Chofer> getChoferes() {
        return new ArrayList<>(choferes);
    }
}
