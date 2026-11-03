package com.francoborzi.modulos.ejercicio2506;

import java.time.LocalDateTime;
import java.util.Date;

public class Persona {
    private String nombreCompleto;
    private String dni;
    private LocalDateTime fechaApertura;

    public Persona(String nombreCompleto, String dni, LocalDateTime fechaApertura) {
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.fechaApertura = fechaApertura;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDateTime getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(LocalDateTime fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Persona{");
        sb.append("nombreCompleto='").append(nombreCompleto).append('\'');
        sb.append(", dni='").append(dni).append('\'');
        sb.append(", fechaApertura=").append(fechaApertura);
        sb.append('}');
        return sb.toString();
    }
}
