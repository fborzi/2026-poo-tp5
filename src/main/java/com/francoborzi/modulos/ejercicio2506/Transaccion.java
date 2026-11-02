package edu.programacion.ejercicio2506;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Registra una operación realizada en una cuenta bancaria.
 * Almacena la fecha, el monto y el tipo de transacción.
 */
public class Transaccion {

    private LocalDateTime fecha;
    private double monto;
    private String tipo;

    /**
     * Crea una transacción con la fecha y hora actuales.
     *
     * @param monto importe de la operación.
     * @param tipo tipo de transacción realizada.
     */
    public Transaccion(double monto, String tipo) {
        this.fecha = LocalDateTime.now();
        this.monto = monto;
        this.tipo = tipo;
    }

    /**
     * Obtiene la fecha y hora de la transacción.
     *
     * @return fecha y hora.
     */
    public LocalDateTime getFecha() {
        return fecha;
    }

    /**
     * Obtiene el monto de la transacción.
     *
     * @return importe de la operación.
     */
    public double getMonto() {
        return monto;
    }

    /**
     * Obtiene el tipo de transacción.
     *
     * @return tipo de operación.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Devuelve los datos de la transacción en formato de texto.
     *
     * @return descripción de la operación.
     */
    @Override
    public String toString() {
        DateTimeFormatter formato =
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        return "Fecha: " + fecha.format(formato)
                + " | Tipo: " + tipo
                + " | Monto: $" + monto;
    }
}