package com.alkemy.wallet;

/**
 * Interfaz que define las operaciones obligatorias para las cuentas de Alke Wallet.
 */
public interface OperacionesBancarias {
    double getSaldo(); // <-- Agregamos esto para que no dé error
    boolean realizarIngreso(double monto);
    boolean realizarRetiro(double monto);
    double convertirMoneda(double tasaCambio);
}