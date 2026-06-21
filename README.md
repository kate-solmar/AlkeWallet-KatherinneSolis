# Alke Wallet - Aplicacion de Billetera Digital

Este proyecto consiste en el desarrollo del nucleo logico para una aplicacion de billetera digital (Alke Wallet), desarrollado en Java 17 utilizando Maven para la gestion de dependencias y JUnit 5 (Jupiter) para la automatizacion de pruebas unitarias.

El objetivo principal es proveer una estructura robusta, segura y altamente mantenible para la gestion de cuentas financieras individuales, permitiendo transacciones esenciales mediante Programacion Orientada a Objetos (POO).

## Requerimientos del Negocio Implementados

La aplicacion implementa las reglas de negocio solicitadas en la pauta de evaluacion:
- Consulta de Saldo: Permite visualizar de forma segura el estado de fondos actual.
- Ingreso de Dinero (Deposito): Incrementa el saldo disponible, validando que el monto sea estrictamente mayor a cero.
- Egreso de Dinero (Retiro): Disminuye los fondos de la cuenta tras validar que existan fondos suficientes (previene saldos negativos).
- Conversion de Moneda: Aplica tasas de cambio flotantes para proyectar de forma exacta el saldo de la cuenta en divisas internacionales.

## Estructura y Arquitectura del Codigo

El diseño del software se rige bajo los principios de abstraccion, encapsulamiento y reutilizacion de codigo mediante los siguientes componentes en el paquete com.alkemy.wallet:

1. OperacionesBancarias.java (Interfaz): Define el contrato con los metodos obligatorios para cualquier tipo de cuenta financiera dentro del ecosistema de la billetera.
2. Cuenta.java (Clase Principal): Implementa la interfaz operativa. Cuenta con atributos completamente protegidos (private) y expone:
   - Constructor sin parametros: Inicializa la cuenta con valores base por defecto (0 y "Sin Titular").
   - Constructor con parametros: Permite la instanciacion dinamica con datos especificos (idCuenta, titular, saldoInicial).
   - Encapsulamiento: Metodos Getter y Setter estandar para la mutabilidad controlada de las propiedades.

## Pruebas Unitarias (JUnit 5)

Las pruebas estan alojadas en el directorio src/test/java dentro de la clase CuentaTest.java. Se aplico el enfoque estandar de la industria AAA (Arrange, Act, Assert) para garantizar la cobertura de codigo y la resiliencia ante fallos:

- deberiaInicializarConValoresPorDefectoUsandoConstructorSinParametros()
- deberiaInicializarCorrectamenteUsandoConstructorConParametros()
- deberiaAumentarElSaldoCuandoElIngresoEsExitoso()
- deberiaDisminuirElSaldoCuandoElRetiroEsExitoso()
- noDeberiaPermitirRetirosSiLosFondosSonInsuficientes()
- deberiaConvertirSaldoCorrectamenteSegunTasaDeCambio()

Estado de la Suite de Pruebas: Todos los casos de prueba se ejecutan de manera exitosa, logrando una barra verde (100% Pass Rate) sin errores ni fallos criticos.

## Tecnologias Utilizadas

- Lenguaje: Java 17 (JavaSE-17)
- Gestor de Proyectos: Apache Maven 4.0.0
- Framework de Pruebas: JUnit Jupiter API y Engine (v5.10.0)
- IDE: Eclipse IDE