package com.francoborzi.modulos.ejercicio2504;

/**
 * Trabajo de envío de un email.
 */
public class TrabajoEmail implements Trabajo {

    private String destinatario;

    /**
     * Crea un trabajo de envío de email.
     *
     * @param destinatario dirección del destinatario
     */
    public TrabajoEmail(String destinatario) {
        this.destinatario = destinatario;
    }

    @Override
    public void procesar() {
        System.out.println("Enviando email a: " + destinatario);
    }
}