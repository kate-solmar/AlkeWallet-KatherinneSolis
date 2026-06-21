package com.alkemy.wallet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CuentaTest {

    // ========================================================
    // 1. PRUEBAS DE CONSTRUCTORES (Con y Sin Parámetros)
    // ========================================================

    @Test
    public void deberiaInicializarConValoresPorDefectoUsandoConstructorSinParametros() {
        // Act - Creamos la cuenta usando el constructor vacío
        Cuenta cuentaVacia = new Cuenta();

        // Assert - Verificamos que los valores iniciales sean los correctos por defecto
        Assertions.assertEquals(0, cuentaVacia.getIdCuenta());
        Assertions.assertEquals("Sin Titular", cuentaVacia.getTitular());
        Assertions.assertEquals(0.0, cuentaVacia.getSaldo());
    }

    @Test
    public void deberiaInicializarCorrectamenteUsandoConstructorConParametros() {
        // Act - Creamos la cuenta con datos específicos
        Cuenta cuenta = new Cuenta(101, "Katherinne Solis", 5000.0);

        // Assert - Verificamos que guarde los datos entregados
        Assertions.assertEquals(101, cuenta.getIdCuenta());
        Assertions.assertEquals("Katherinne Solis", cuenta.getTitular());
        Assertions.assertEquals(5000.0, cuenta.getSaldo());
    }

    // ========================================================
    // 2. PRUEBAS DE REQUERIMIENTOS DE NEGOCIO (Ingresos y Retiros)
    // ========================================================

    @Test
    public void deberiaAumentarElSaldoCuandoElIngresoEsExitoso() {
        // Arrange - Cuenta con saldo inicial de $1000
        Cuenta cuenta = new Cuenta(1, "Juan Perez", 1000.0);

        // Act - Depositamos $500
        boolean resultado = cuenta.realizarIngreso(500.0);

        // Assert - El saldo debe ser $1500 y el método retornar true
        Assertions.assertTrue(resultado);
        Assertions.assertEquals(1500.0, cuenta.getSaldo());
    }

    @Test
    public void deberiaDisminuirElSaldoCuandoElRetiroEsExitoso() {
        // Arrange - Cuenta con saldo inicial de $2000
        Cuenta cuenta = new Cuenta(2, "Maria Soto", 2000.0);

        // Act - Retiramos $800
        boolean resultado = cuenta.realizarRetiro(800.0);

        // Assert - El saldo debe quedar en $1200 y retornar true
        Assertions.assertTrue(resultado);
        Assertions.assertEquals(1200.0, cuenta.getSaldo());
    }

    @Test
    public void noDeberiaPermitirRetirosSiLosFondosSonInsuficientes() {
        // Arrange - Cuenta con solo $300 de saldo
        Cuenta cuenta = new Cuenta(3, "Carlos Ruiz", 300.0);

        // Act - Intentamos retirar $500 (más de lo que hay)
        boolean resultado = cuenta.realizarRetiro(500.0);

        // Assert - Debe rechazar la transacción (false) y mantener el saldo intacto ($300)
        Assertions.assertFalse(resultado);
        Assertions.assertEquals(300.0, cuenta.getSaldo());
    }

    // ========================================================
    // 3. PRUEBA DE CONVERSIÓN DE MONEDA
    // ========================================================

    @Test
    public void deberiaConvertirSaldoCorrectamenteSegunTasaDeCambio() {
        // Arrange - Cuenta con saldo de $100 (ej. 100 Dólares)
        Cuenta cuenta = new Cuenta(4, "Ana Lopez", 100.0);
        double tasaAClp = 950.0; // 1 USD = 950 CLP

        // Act - Calculamos la conversión
        double saldoEnClp = cuenta.convertirMoneda(tasaAClp);

        // Assert - 100 * 950 debería dar $95000
        Assertions.assertEquals(95000.0, saldoEnClp);
    }
}