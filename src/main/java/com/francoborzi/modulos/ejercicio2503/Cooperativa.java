package com.francoborzi.modulos.ejercicio2503;

import java.util.ArrayList;
import java.util.List;

public class Cooperativa {
    private List<Socio> socios;

    public Cooperativa() {
        socios = new ArrayList<>();
    }

    public void agregarSocio(Socio socio) {
        socios.add(socio);
    }

    public Chofer realizarViaje(Integer cantidadPasajeros,
                                Double cantidadKms) {

        for (Socio socio : socios) {
            Chofer chofer = socio.getChofer();
            Colectivo colectivo = chofer.getColectivo();

            if (colectivo.getCapacidadPasajeros()
                    >= cantidadPasajeros) {

                colectivo.registrarViaje(cantidadKms);

                return chofer;
            }
        }

        return null;
    }

    public Colectivo mostrarColectivoConMayorKilometraje() {

        Colectivo mayor = null;

        for (Socio socio : socios) {
            Colectivo colectivo =
                    socio.getChofer().getColectivo();

            if (mayor == null ||
                    colectivo.getKilometraje() >
                            mayor.getKilometraje()) {

                mayor = colectivo;
            }
        }

        return mayor;
    }
}
