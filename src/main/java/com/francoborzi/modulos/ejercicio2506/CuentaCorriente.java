package edu.programacion.ejercicio2506;

/**
 * Representa una cuenta corriente que permite realizar
 * extracciones respetando el saldo mínimo establecido.
 */
public class CuentaCorriente extends edu.programacion.ejercicio2506.CuentaBancaria {

    /**
     * Crea una cuenta corriente.
     *
     * @param titular titular de la cuenta.
     * @param saldo saldo inicial.
     * @param limiteMinimo saldo mínimo permitido.
     */
    public CuentaCorriente(
            edu.programacion.ejercicio2506.Persona titular,
            double saldo,
            double limiteMinimo) {

        super(titular, saldo, limiteMinimo);
    }

    /**
     * Extrae dinero si se respeta el límite mínimo.
     *
     * @param monto cantidad que se desea extraer.
     * @throws SuperaLimiteMinimoException si se supera el límite mínimo.
     * @throws SuperaCantidadExtraccionesException no se utiliza
     * en esta clase, ya que no tiene un máximo de extracciones.
     */
    @Override
    public void extraer(double monto)
            throws edu.programacion.ejercicio2506.SuperaLimiteMinimoException,
            edu.programacion.ejercicio2506.SuperaCantidadExtraccionesException {

        validarExtraccion(monto);
        registrarExtraccion(monto);
    }
}