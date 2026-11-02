package edu.programacion.ejercicio2506;
/**
 * Representa una caja de ahorro con un máximo de cinco
 * extracciones antes de necesitar un reinicio.
 */
public class CajaDeAhorro extends edu.programacion.ejercicio2506.CuentaBancaria {

    private static final int MAX_EXTRACCIONES = 5;
    private int cantidadExtracciones;

    /**
     * Crea una caja de ahorro.
     *
     * @param titular titular de la cuenta.
     * @param saldo saldo inicial.
     * @param limiteMinimo saldo mínimo permitido.
     */
    public CajaDeAhorro(
            edu.programacion.ejercicio2506.Persona titular,
            double saldo,
            double limiteMinimo) {

        super(titular, saldo, limiteMinimo);
        this.cantidadExtracciones = 0;
    }

    /**
     * Extrae dinero si no se superó el máximo permitido.
     *
     * @param monto cantidad que se desea extraer.
     * @throws SuperaLimiteMinimoException si se supera el límite mínimo.
     * @throws SuperaCantidadExtraccionesException si se superan
     * las cinco extracciones permitidas.
     */
    @Override
    public void extraer(double monto)
            throws edu.programacion.ejercicio2506.SuperaLimiteMinimoException,
            edu.programacion.ejercicio2506.SuperaCantidadExtraccionesException {

        if (cantidadExtracciones >= MAX_EXTRACCIONES) {
            throw new edu.programacion.ejercicio2506.SuperaCantidadExtraccionesException(
                    "Se alcanzó el máximo de cinco extracciones."
            );
        }

        validarExtraccion(monto);
        registrarExtraccion(monto);
        cantidadExtracciones++;
    }

    private void registrarExtraccion(double monto) {
    }

    private void validarExtraccion(double monto) {
    }

    /**
     * Reinicia el contador de extracciones.
     */
    public void resetearExtracciones() {
        cantidadExtracciones = 0;
    }

    /**
     * Obtiene la cantidad de extracciones realizadas.
     *
     * @return cantidad de extracciones.
     */
    public int getCantidadExtracciones() {
        return cantidadExtracciones;
    }

    public String consultarSaldo() {
    }
}