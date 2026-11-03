package com.francoborzi.modulos.ejercicio2504;

public class TrabajoCorreo implements Trabajo {

    private String destinatario;

    public TrabajoCorreo(String destinatario) {
        this.destinatario = destinatario;
    }

    @Override
    public String toString() {
        return "Trabajo de correo: " + destinatario;
    }
}