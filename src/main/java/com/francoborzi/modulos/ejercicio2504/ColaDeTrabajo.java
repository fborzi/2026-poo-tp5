package com.francoborzi.modulos.ejercicio2504;

/// Representa una cola de trabajo que permite almacenar,
/// agregar y retirar trabajos para su procesamiento.
/// Utiliza una lista para mantener los trabajos en orden
/// y controla si la cola esta disponible y si contiene
/// trabajos para procesar.
import java.util.ArrayList;
import java.util.List;

public class ColaDeTrabajo {
    private String nombre;
    private List<Trabajo> trabajos;
    private boolean lista;

    public ColaDeTrabajo(String nombre) {
        this.nombre = nombre;
        this.trabajos = new ArrayList<>();
        this.lista = true;
    }
    public void agregar(Trabajo trabajo) {
        trabajos.add(trabajo);
    }
    public Trabajo sacar() throws NoListaException, SinTrabajoEnColaException {
        if (!lista) {
            throw new NoListaException(nombre, (long) trabajos.size());
        }

        if (trabajos.isEmpty()) {
            throw new SinTrabajoEnColaException(nombre);
        }

        return trabajos.remove(0);
    }
}
