package com.alkemy.wallet;

/**
 * Clase que representa la cuenta financiera de Alke Wallet.
 * Implementa la interfaz OperacionesBancarias requerida por la pauta.
 */
public class Cuenta implements OperacionesBancarias {
    
    // Aquí empiezan tus atributos privados (Línea 9 en adelante)
    private int idCuenta;
    private double saldo;
    private String titular;

    // 1. CONSTRUCTOR SIN PARÁMETROS
    public Cuenta() {
        this.idCuenta = 0;
        this.titular = "Sin Titular";
        this.saldo = 0.0;
    }

    // 2. CONSTRUCTOR CON PARÁMETROS
    public Cuenta(int idCuenta, String titular, double saldoInicial) {
        this.idCuenta = idCuenta;
        this.titular = titular;
        if (saldoInicial >= 0) {
            this.saldo = saldoInicial;
        } else {
            this.saldo = 0.0;
        }
    }

    // ==========================================
    // REQUERIMIENTOS DEL NEGOCIO
    // ==========================================

    @Override
    public double getSaldo() {
        return this.saldo;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    @Override
    public boolean realizarIngreso(double monto) {
        if (monto > 0) {
            this.saldo += monto;
            return true;
        }
        return false;
    }

    @Override
    public boolean realizarRetiro(double monto) {
        if (monto > 0 && this.saldo >= monto) {
            this.saldo -= monto;
            return true;
        }
        return false;
    }

    @Override
    public double convertirMoneda(double tasaCambio) {
        if (tasaCambio > 0) {
            return this.saldo * tasaCambio;
        }
        return 0.0;
    }
}